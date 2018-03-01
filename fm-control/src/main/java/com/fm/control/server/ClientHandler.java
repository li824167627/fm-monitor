package com.fm.control.server;

import java.util.logging.Logger;

import com.fm.control.server.mm.MsgStruct;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// 5A 06 01 00 0D92 00 01 05 77
		// PortalMsg msg = new PortalMsg();
		// msg.setSync(new Byte((byte) 0x5A));
		// msg.setTag(new Byte((byte) 0x06));
		// msg.setLength(new Byte((byte) 0x01));
		// msg.setFlag(new Byte((byte) 00));
		// msg.setChecksum(new Short((short) 0x0D92));
		// msg.setBody(new byte[] { (byte) 0x01 });
		// msg.setSerialNum(new Byte((byte) 0x01));
		// msg.setPlatformLinkID(new Byte((byte) 0x05));
		// msg.setEndCode(new Byte((byte) 0x77));

		// 5A 61 09 00 C744 00B8FFEC0655BD6202 19 05 77
		// PortalMsg msg = new PortalMsg();
		// msg.setSync((byte) 0x5A);
		// msg.setTag((byte) 0x61);
		// msg.setLength((byte) 0x09);
		// msg.setFlag((byte) 0x00);
		// msg.setChecksum(new Short((short) 0xC744));
		//
		// byte[] body = new byte[] { (byte) 0x00, (byte) 0xB8, (byte) 0xFF, (byte)
		// 0xEC, (byte) 0x06, (byte) 0x55,
		// (byte) 0xBD, (byte) 0x62, (byte) 0x02 };
		// msg.setBody(body);
		//
		// msg.setSerialNum((byte) 0x19);
		// msg.setPlatformLinkID((byte) 0x05);
		// msg.setEndCode((byte) 0x77);

		// 5A 69 22 00 9212
		// 9A20965ACB20965AB59E828302203943E6365D3E785547C80001B8FFEC0655BD6202 05 05 77
		// MsgStruct msg = new MsgStruct();
		// msg.setSync((byte) 0x5A);
		// msg.setTag((byte) 0x69);
		// msg.setLength((byte) 0x22);
		// msg.setFlag((byte) 0x00);
		// msg.setChecksum(new Short((short) 0x9212));
		// msg.setBody(toBytes("9A20965ACB20965AB59E828302203943E6365D3E785547C80001B8FFEC0655BD6202"));
		// msg.setSerialNum((byte) 0x05);
		// msg.setPlatformLinkID((byte) 0x05);
		// msg.setEndCode((byte) 0x77);

		// 5A 04 36 00 7635
		// 6617965A40096621097274722BE728A25C38393836303243393938313643313339313734343836393434393032303431373438300004
		// 00 05 77
		// MsgStruct msg1 = new MsgStruct();
		// msg1.setSync((byte) 0x5A);
		// msg1.setTag((byte) 0x04);
		// msg1.setLength((byte) 0x36);
		// msg1.setFlag((byte) 0x00);
		// msg1.setChecksum(new Short((short) 0x7635));
		// msg1.setBody(toBytes(
		// "6617965A40096621097274722BE728A25C38393836303243393938313643313339313734343836393434393032303431373438300004"));
		// msg1.setSerialNum((byte) 0x00);
		// msg1.setPlatformLinkID((byte) 0x05);
		// msg1.setEndCode((byte) 0x77);

		// 5A 6E 0B 00 A84A 0000000000000000020000 02 05 77
		// PortalMsg msg = new PortalMsg();
		// msg.setSync((byte) 0x5A);
		// msg.setTag((byte) 0x6E);
		// msg.setLength((byte) 0x0B);
		// msg.setFlag((byte) 0x00);
		// msg.setChecksum(new Short((short) 0xA84A));
		// msg.setBody(toBytes("0000000000000000020000"));
		// msg.setSerialNum((byte) 0x02);
		// msg.setPlatformLinkID((byte) 0x05);
		// msg.setEndCode((byte) 0x77);

		// for (int i = 0; i < 10000; i++) {
		// ctx.writeAndFlush(msg);
		// ctx.writeAndFlush(msg1);
		// }
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof MsgStruct) {
			MsgStruct msgBean = (MsgStruct) msg;
			System.out.println("receive server:" + msgBean.toString());
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.warning("Unexpected excetion from downstream: " + cause.getMessage());
		ctx.close();
		cause.printStackTrace();
	}

	public static byte[] toBytes(String str) {
		if (str == null || str.trim().equals("")) {
			return new byte[0];
		}

		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}
		return bytes;
	}

}
