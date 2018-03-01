package com.fm.control.server.msg;

/**
 * 流动放映终端确认接收到激活信息报文-0x03号<br>
 * 用于流动放映终端确认收到激活信息。<br>
 * 报文类型:流动放映终端报文;<br>
 * Tag:0x03; Length:0 byte; 8 Body:无
 */
public class BodyX03Bean implements MsgBodyBase {
	public static final byte BODY_TAG = 0x03;
	public static final byte BODY_LENGTH = 0;

	@Override
	public byte getBodyTag() {
		return BODY_TAG;
	}

	@Override
	public byte getBodyLength() {
		return BODY_LENGTH;
	}

	@Override
	public byte[] getBytes() {
		return new byte[] {};
	}
}
