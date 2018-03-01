package com.fm.control.server.msg;

/**
 * 流动放映终端确认接收到认证信息报文-0x06号<br>
 * 流动放映终端确认接收到监管平台或监管数据采集管理平台发送的身份认证报文。<br>
 * 报文类型:流动放映终端报文;<br>
 * Tag:0x06; Length:1 byte;
 */
public class BodyX06Bean implements MsgBodyBase {
	public static final byte BODY_TAG = 0x06;
	public static final byte BODY_LENGTH = 0x01;

	private byte auth; // 认证结果; 0x00，互认证通过; 0x01，平台端认证失败

	public BodyX06Bean(byte auth) {
		this.auth = auth;
	}

	public byte getAuth() {
		return auth;
	}

	public void setAuth(byte auth) {
		this.auth = auth;
	}

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
		return new byte[] { auth };
	}

}
