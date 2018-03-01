package com.fm.control.server.msg;

/**
 * 流动放映终端请求激活报文-0x01号<br>
 * 接收到监管平台或监管数据采集管理平台的自我声明报文后，如果流动放映终端处于未激活状态时发送本报文。<br>
 * 报文类型:流动放映终端报文;
 */
public class BodyX01Bean implements MsgBodyBase {
	public static final byte BODY_TAG = 0x01;
	public static final byte BODY_LENGTH = 41;

	private byte fcFlag;// 设备厂商标识码 1 byte
	private byte[] fingerprint; // 流动放映终端硬件指纹 16 bytes 加密内容,密钥为随机认证密钥
	private byte[] consoleSerialNo; // 流动放映终端序列号 16 bytes
	private byte[] challengeCode;// 挑战码 8 bytes

	public BodyX01Bean(byte fcFlag, byte[] fingerprint, byte[] consoleSerialNo, byte[] challengeCode) {
		this.fcFlag = fcFlag;
		this.fingerprint = fingerprint;
		this.consoleSerialNo = consoleSerialNo;
		this.challengeCode = challengeCode;
	}

	public byte getFcFlag() {
		return fcFlag;
	}

	public void setFcFlag(byte fcFlag) {
		this.fcFlag = fcFlag;
	}

	public byte[] getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(byte[] fingerprint) {
		this.fingerprint = fingerprint;
	}

	public byte[] getConsoleSerialNo() {
		return consoleSerialNo;
	}

	public void setConsoleSerialNo(byte[] consoleSerialNo) {
		this.consoleSerialNo = consoleSerialNo;
	}

	public byte[] getChallengeCode() {
		return challengeCode;
	}

	public void setChallengeCode(byte[] challengeCode) {
		this.challengeCode = challengeCode;
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
