package com.fm.control.server.msg;

import com.fm.control.util.ByteUtil;

/**
 * 报文头结构
 */
public class MsgHeaderBean {

	private byte sync; // 同步头，长度1个字节，主要用于在数据包结构出现错误时，快速识别下一个正确数据 包的起始位置，值是0x5A。
	private byte tag; // 报文的类型，长度1个字节，值见6.7规定。
	private byte length; // Body的字节长度，长度1个字节。
	private byte flag; // 标志，长度1个字节，本字段保留。
	private short checksum; // 校验和，2个字节，校验前Body的内容已经被加密过，校验前Checksum字段的初始值为

	public MsgHeaderBean() {
		this.sync = 0x5A;
		this.tag = 0x00;
		this.length = 0x00;
		this.flag = 0x00;
		this.checksum = 0x0000;
	}

	public byte getSync() {
		return sync;
	}

	public void setSync(byte sync) {
		this.sync = sync;
	}

	public byte getTag() {
		return tag;
	}

	public void setTag(byte tag) {
		this.tag = tag;
	}

	public byte getLength() {
		return length;
	}

	public void setLength(byte length) {
		this.length = length;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public short getChecksum() {
		return checksum;
	}

	public void setChecksum(short checksum) {
		this.checksum = checksum;
	}

	public byte[] getBytes() {
		byte[] checkSum = ByteUtil.shortToBytes(checksum);
		byte[] bytes = new byte[] { sync, tag, length, flag, checkSum[0], checkSum[1] };
		return bytes;
	}

}
