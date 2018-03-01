package com.fm.control.server.msg;

public class MsgFooterBean {

	private byte serialNum; // 报文序列号，1个字节，由报文发送端生成，值从0x00开始到0xff，每发一条指令Serial加0x01，重发报文Serial保持原值不变，当到达0xff后值循环变成0x00。
	private byte platformLinkID; // 平台连接序号标识码，长度1个字节，用于标识同时连接的不同平台。
	private byte endCode; // 结束符，1 个字节，值为0x77。

	public MsgFooterBean(byte serialNum) {
		this.serialNum = serialNum;
		this.platformLinkID = 0x05;
		this.endCode = 0x77;
	}

	public MsgFooterBean(byte serialNum, byte platformLinkID) {
		this.serialNum = serialNum;
		this.platformLinkID = platformLinkID;
		this.endCode = 0x77;
	}

	public MsgFooterBean(byte serialNum, byte platformLinkID, byte endCode) {
		this.serialNum = serialNum;
		this.platformLinkID = platformLinkID;
		this.endCode = endCode;
	}

	public byte getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(byte serialNum) {
		this.serialNum = serialNum;
	}

	public byte getPlatformLinkID() {
		return platformLinkID;
	}

	public void setPlatformLinkID(byte platformLinkID) {
		this.platformLinkID = platformLinkID;
	}

	public byte getEndCode() {
		return endCode;
	}

	public void setEndCode(byte endCode) {
		this.endCode = endCode;
	}

	public byte[] getBytes() {
		return new byte[] { serialNum, platformLinkID, endCode };
	}

}
