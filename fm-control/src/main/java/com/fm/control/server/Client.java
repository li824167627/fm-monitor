package com.fm.control.server;

import java.util.List;

import com.fm.control.server.mm.MsgStruct;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.string.StringDecoder;

public class Client {

	public static void main(String[] args) {
		int port = 8081;
		if (args != null && args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		new Client().connect(port, "127.0.0.1");
	}

	private void connect(int port, String host) {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_BACKLOG, 128);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.option(ChannelOption.SO_RCVBUF, 1024 * 64);
			b.option(ChannelOption.SO_SNDBUF, 1024 * 64);
			b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast(new LengthFieldBasedFrameDecoder(64 * 1024, 2, 1, 6, 0));
					pipeline.addLast(new ClientDecoder());
					pipeline.addLast(new ClientEncoder());
					pipeline.addLast(new ClientHandler());
				}
			});
			ChannelFuture f = b.connect(host, port);
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			group.shutdownGracefully();
		}
	}

	public static final class ClientDecoder extends ByteToMessageDecoder {

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

	public static final class ClientEncoder extends MessageToByteEncoder<MsgStruct> {

		@Override
		protected void encode(ChannelHandlerContext ctx, MsgStruct msg, ByteBuf out) throws Exception {
			out.writeByte(msg.getSync());
			out.writeByte(msg.getTag());
			out.writeByte(msg.getLength());
			out.writeByte(msg.getFlag());
			out.writeShort(msg.getChecksum());
			out.writeBytes(msg.getBody());
			out.writeByte(msg.getSerialNum());
			out.writeByte(msg.getPlatformLinkID());
			out.writeByte(msg.getEndCode());
		}

	}
}
