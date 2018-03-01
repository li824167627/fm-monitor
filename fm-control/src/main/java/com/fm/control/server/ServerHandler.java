package com.fm.control.server;

import org.springframework.stereotype.Component;

import com.fm.control.server.mm.MsgStruct;
import com.fm.control.server.msg.BodyX06Bean;
import com.fm.control.server.msg.MsgBean;
import com.fm.control.server.msg.MsgFooterBean;
import com.fm.control.server.msg.MsgHeaderBean;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Sharable
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		ChannelSession.getInstance().setChannel(channel.id().asShortText(), channel);
		// ChannelSession.getInstance().printSession();

		// BodyX00Bean bodyX00Bean = new BodyX00Bean("abcdefgh".getBytes());
		// MsgHeaderBean msgHeaderBean = new MsgHeaderBean(BodyX00Bean.BODY_TAG,
		// BodyX00Bean.BODY_LENGTH);
		// MsgFooterBean footerBean = new MsgFooterBean((byte) 0x01);
		// MsgBean msgBean = new MsgBean(msgHeaderBean, bodyX00Bean, footerBean);

		BodyX06Bean bodyX06Bean = new BodyX06Bean((byte) 0x00);
		MsgHeaderBean msgHeaderBean = new MsgHeaderBean();
		MsgFooterBean footerBean = new MsgFooterBean((byte) 0x01);
		MsgBean msgBean = new MsgBean(msgHeaderBean, bodyX06Bean, footerBean);

		channel.writeAndFlush(msgBean);
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		// channel.isRegistered();
		// System.out.println("---------server channel channelInactive channelID:" +
		// ctx.channel().id().asShortText());
		// ChannelSession.getInstance().removeChannel(ctx.channel().id().asShortText());
		// ChannelSession.getInstance().printSession();
		super.channelInactive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("receive client:" + msg);
		if (msg instanceof MsgStruct) {
			MsgStruct msgBean = (MsgStruct) msg;
			switch (msgBean.getTag()) {
			case 0x00:
				System.out.println("-----0x00");
				break;
			case 0x01:
				System.out.println("-----0x01");
				break;
			case 0x02:
				System.out.println("-----0x02");
				break;
			case 0x04:
				System.out.println("-----0x04");
				break;
			case 0x05:
				System.out.println("-----0x05");
				break;
			case 0x06:
				System.out.println("-----0x06");
				break;
			case 0x61:
				System.out.println("-----0x61");
				break;
			case 0x62:
				System.out.println("-----0x62");
				break;
			case 0x63:
				System.out.println("-----0x63");
				break;
			case 0x64:
				System.out.println("-----0x64");
				break;
			case 0x65:
				System.out.println("-----0x65");
				break;
			case 0x67:
				System.out.println("-----0x67");
				break;
			case 0x68:
				System.out.println("-----0x68");
				break;
			case 0x69:
				System.out.println("-----0x69");
				break;
			case 0x6A:
				System.out.println("-----0x6A");
				break;
			case 0x6B:
				System.out.println("-----0x6B");
				break;
			case 0x6C:
				System.out.println("-----0x6C");
				break;
			case 0x6D:
				System.out.println("-----0x6D");
				break;
			case 0x6E:
				System.out.println("-----0x6E");
				break;
			case 0x70:
				System.out.println("-----0x70");
				break;
			case 0x71:
				System.out.println("-----0x71");
				break;
			case 0x73:
				System.out.println("-----0x73");
				break;
			case 0x74:
				System.out.println("-----0x74");
				break;
			case 0x75:
				System.out.println("-----0x75");
				break;
			case 0x76:
				System.out.println("-----0x76");
				break;
			case 0x77:
				System.out.println("-----0x77");
				break;
			default:
				break;
			}
		}

		ctx.channel().writeAndFlush("has received");

		// ChannelFuture cf = ctx.writeAndFlush("has received");
		// cf.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
		// if (cf.isCancelled()) {
		// // Connection attempt cancelled by user
		// } else if (!cf.isSuccess()) {
		// cf.cause().printStackTrace();
		// } else {
		// // Connection established successfully
		// // System.out.println("----cf: established");
		// }
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();

		ChannelSession.getInstance().removeChannel(ctx.channel().id().asShortText());
		// ChannelSession.getInstance().printSession();
		ctx.close();
	}

}
