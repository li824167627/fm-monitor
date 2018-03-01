package com.fm.control.server.msg;

/**
 * 平台响应身份认证报文-0x05号<br>
 * 接收到流动放映终端身份认证请求报文后，平台将本报文中的激活码和流动放映终端序列号与平台
 * 存储的与流动放映终端相对应的激活码进行对比，根据对比结果发送本报文。超过3次连续登录失败最
 * 大尝试次数的，此时平台端应关闭该连接。超过9次累计连续登录失败最大尝试次数的，此时平台端应
 * 关闭该连接，并将该流动放映终端列入限制登录黑名单，拒绝登录。<br>
 * 报文类型:平台报文;<br>
 * Tag:0x05; Length:18 bytes;
 */
public class BodyX05Bean implements MsgBodyBase {
	public static final byte BODY_TAG = 0x05;
	public static final byte BODY_LENGTH = 18;

	private byte auth;// 认证结果
	// 0x00，认证通过; 0x01，未找到激活码或激活码不匹配; 0x03，该流动放映终端被列入黑名单; 0x04，该流动放映终端不允许登录;
	// 0x06，平台要求该流动放映终端重新激活

	private byte[] challengeCode; // 挑战码 8 bytes 加密内容，密钥为流动放映终端硬件指纹
	private byte[] serverTime; // 平台时间 4 bytes 用于同步流动放映终端时间
	private byte[] retain;// 保留 5 bytes

	public BodyX05Bean(byte auth, byte[] challengeCode, byte[] serverTime, byte[] retain) {
		this.auth = auth;
		this.challengeCode = challengeCode;
		this.serverTime = serverTime;
		this.retain = retain;
	}

	public byte getAuth() {
		return auth;
	}

	public void setAuth(byte auth) {
		this.auth = auth;
	}

	public byte[] getChallengeCode() {
		return challengeCode;
	}

	public void setChallengeCode(byte[] challengeCode) {
		this.challengeCode = challengeCode;
	}

	public byte[] getServerTime() {
		return serverTime;
	}

	public void setServerTime(byte[] serverTime) {
		this.serverTime = serverTime;
	}

	public byte[] getRetain() {
		return retain;
	}

	public void setRetain(byte[] retain) {
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
		return new byte[] {};
	}
}
