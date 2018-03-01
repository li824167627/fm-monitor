package com.fm.control.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fm.control.server.mm.MsgStruct;
import com.fm.control.server.msg.MsgBean;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

public class NettyServer {

	@Autowired
	ServerHandler serverHandler;

	private int port = 8999;

	public void start(int port) {
		this.port = port;
		this.run();
	}

	private void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup);
		b.channel(NioServerSocketChannel.class);
		b.option(ChannelOption.SO_BACKLOG, 128);
		b.option(ChannelOption.SO_KEEPALIVE, true);
		b.option(ChannelOption.SO_RCVBUF, 1024 * 64);
		b.option(ChannelOption.SO_SNDBUF, 1024 * 64);
		b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
		b.handler(new LoggingHandler(LogLevel.INFO));
		b.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline pipeline = ch.pipeline();
				// 读操作空闲秒数 写操作的空闲秒数 读写空闲秒数
				// pipeline.addLast(new IdleStateHandler(0, 0, 5, TimeUnit.SECONDS));
				// pipeline.addLast(new HeartbeatHandler());
				pipeline.addLast(new LengthFieldBasedFrameDecoder(64 * 1024, 2, 1, 6, 0));
				pipeline.addLast(new ServerDecoder());
				pipeline.addLast(new ServerEncoder());
				pipeline.addLast(serverHandler);
			}
		});
		try {
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("shutdown netty........");
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static final class ServerDecoder extends ByteToMessageDecoder {

		@Override
		protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
			MsgStruct msgBean = new MsgStruct();
			msgBean.setSync(msg.readByte());
			msgBean.setTag(msg.readByte());
			msgBean.setLength(msg.readByte());
			msgBean.setFlag(msg.readByte());
			msgBean.setChecksum(msg.readShort());

			byte[] body = new byte[(int) msgBean.getLength()];
			msg.readBytes(body);
			msgBean.setBody(body);

			msgBean.setSerialNum(msg.readByte());
			msgBean.setPlatformLinkID(msg.readByte());
			msgBean.setEndCode(msg.readByte());

			if (msgBean.getSync() == (byte) 0x5A && msgBean.getEndCode() == (byte) 0x77) {
				out.add(msgBean);
			}
		}
	}

	public static final class ServerEncoder extends MessageToByteEncoder<MsgBean> {
		@Override
		protected void encode(ChannelHandlerContext ctx, MsgBean msg, ByteBuf out) throws Exception {
			out.writeBytes(msg.getBytes());
		}
	}

	// public static final class ServerEncoder extends
	// MessageToByteEncoder<MsgStruct> {
	// @Override
	// protected void encode(ChannelHandlerContext ctx, MsgStruct msg, ByteBuf out)
	// throws Exception {
	//
	//
	// out.writeByte(msg.getSync());
	// out.writeByte(msg.getTag());
	// out.writeByte(msg.getLength());
	// out.writeByte(msg.getFlag());
	// out.writeShort(msg.getChecksum());
	//
	// out.writeBytes(msg.getBody());
	//
	// out.writeByte(msg.getSerialNum());
	// out.writeByte(msg.getPlatformLinkID());
	// out.writeByte(msg.getEndCode());
	// }
	// }

	public static final class HeartbeatHandler extends ChannelInboundHandlerAdapter {
		private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled
				.unreleasableBuffer(Unpooled.copiedBuffer("server heartbeat", CharsetUtil.UTF_8));

		@Override
		public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
			if (evt instanceof IdleStateEvent) {
				IdleStateEvent event = (IdleStateEvent) evt;

				if (event.state().equals(IdleStateEvent.READER_IDLE_STATE_EVENT)) {// 未读操作状态
					// // 超时关闭channel，移除会话
					// ChannelSession.getInstance().removeChannel(ctx.channel().id().asShortText());
					// ctx.close();
				} else if (event.state().equals(IdleStateEvent.WRITER_IDLE_STATE_EVENT)) {// 未写操作状态

				} else if (IdleStateEvent.ALL_IDLE_STATE_EVENT.equals(event.state())) {

				}
				System.out.println("server heart beat------asLongText:" + ctx.channel().id().asLongText() + " -------:"
						+ event.state());
				ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
			} else {
				super.userEventTriggered(ctx, evt);
			}
		}
	}

}
