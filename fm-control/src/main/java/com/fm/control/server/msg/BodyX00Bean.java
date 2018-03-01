package com.fm.control.server.msg;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 平台自我声明报文-0x00号<br>
 * 在流动放映终端与监管平台或监管数据采集管理平台的TCP连接建立后，由监管平台或监管数据采
 * 集管理平台发送本报文。流动放映终端接收到本报文后，应当保存本报文的内容。<br>
 * 报文类型:平台报文;
 */
public class BodyX00Bean implements MsgBodyBase {
	public static final byte BODY_TAG = 0x00;
	public static final byte BODY_LENGTH = 9;

	private byte[] challengeCode = new byte[8]; // 挑战码 8 bytes
	private byte retain;// 保留 1 byte

	public BodyX00Bean(byte[] challengeCode) {
		this.challengeCode = challengeCode;
		this.retain = 0x00;
	}

	public byte[] getChallengeCode() {
		return challengeCode;
	}

	public void setChallengeCode(byte[] challengeCode) {
		this.challengeCode = challengeCode;
	}

	public byte getRetain() {
		return retain;
	}

	public void setRetain(byte retain) {
		this.retain = retain;
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
		return ArrayUtils.addAll(challengeCode, retain);
	}

}
