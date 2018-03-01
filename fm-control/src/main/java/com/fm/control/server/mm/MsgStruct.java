package com.fm.control.server.mm;

import java.util.Arrays;

public class MsgStruct {

	private Byte sync; // 同步头，长度1个字节，主要用于在数据包结构出现错误时，快速识别下一个正确数据 包的起始位置，值是0x5A。
	private Byte tag; // 报文的类型，长度1个字节，值见6.7规定。
	private Byte length; // Body的字节长度，长度1个字节。
	private Byte flag; // 标志，长度1个字节，本字段保留。
	private Short checksum; // 校验和，2个字节，校验前Body的内容已经被加密过，校验前Checksum字段的初始值为
	// 0x0000，校验时计算从Sync Tag到End Code的所有字节。算法参见5.9校验算法。
	private byte[] body; // 报文内容，可变长度，最大长度255字节。
	private Byte serialNum; // 报文序列号，1个字节，由报文发送端生成，值从0x00开始到0xff，每发一条指令Serial加0x01，重发报文Serial保持原值不变，当到达0xff后值循环变成0x00。
	private Byte platformLinkID; // 平台连接序号标识码，长度1个字节，用于标识同时连接的不同平台。
	private Byte endCode; // 结束符，1 个字节，值为0x77。

	public Byte getSync() {
		return sync;
	}

	public void setSync(Byte sync) {
		this.sync = sync;
	}

	public Byte getTag() {
		return tag;
	}

	public void setTag(Byte tag) {
		this.tag = tag;
	}

	public Byte getLength() {
		return length;
	}

	public void setLength(Byte length) {
		this.length = length;
	}

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

	public Short getChecksum() {
		return checksum;
	}

	public void setChecksum(Short checksum) {
		this.checksum = checksum;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

	public Byte getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Byte serialNum) {
		this.serialNum = serialNum;
	}

	public Byte getPlatformLinkID() {
		return platformLinkID;
	}

	public void setPlatformLinkID(Byte platformLinkID) {
		this.platformLinkID = platformLinkID;
	}

	public Byte getEndCode() {
		return endCode;
	}

	public void setEndCode(Byte endCode) {
		this.endCode = endCode;
	}

	@Override
	public String toString() {
		return "MsgStruct [sync=" + sync + ", tag=" + tag + ", length=" + length + ", flag=" + flag + ", checksum="
				+ checksum + ", body=" + Arrays.toString(body) + ", serialNum=" + serialNum + ", platformLinkID="
				+ platformLinkID + ", endCode=" + endCode + "]";
	}

}
