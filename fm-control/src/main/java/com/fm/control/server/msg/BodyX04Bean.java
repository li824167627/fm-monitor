package com.fm.control.server.msg;

/**
 * 流动放映终端身份认证请求报文-0x04号<br>
 * 接收到监管平台或监管数据采集管理平台的自我声明报文后，如果流动放映终端处于激活状态时发
 * 送本报文请求，监管平台或监管数据采集管理平台对流动放映终端身份进行认证。<br>
 * 报文类型:流动放映终端报文;<br>
 * Tag:0x04; Length:54 bytes;
 */
public class BodyX04Bean implements MsgBodyBase {

	public static final byte BODY_TAG = 0x04;
	public static final byte BODY_LENGTH = 54;

	private byte[] currentTime;// 流动放映终端当前时间 4 bytes 用于计算流动放映终端时钟误差
	private byte[] versionNum;// 流动放映终端软件版本号 4 bytes
	private byte fcFlag;// 设备厂商标识码 1 byte
	private byte[] activeCode;// 激活码 8 bytes 加密内容，密钥为随机认证密钥
	private byte retain[];// 保留 37 bytes

	public BodyX04Bean(byte[] currentTime, byte[] versionNum, byte fcFlag, byte[] activeCode, byte[] retain) {
		this.currentTime = currentTime;
		this.versionNum = versionNum;
		this.fcFlag = fcFlag;
		this.activeCode = activeCode;
		this.retain = retain;
	}

	public byte[] getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(byte[] currentTime) {
		this.currentTime = currentTime;
	}

	public byte[] getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(byte[] versionNum) {
		this.versionNum = versionNum;
	}

	public byte getFcFlag() {
		return fcFlag;
	}

	public void setFcFlag(byte fcFlag) {
		this.fcFlag = fcFlag;
	}

	public byte[] getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(byte[] activeCode) {
		this.activeCode = activeCode;
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
