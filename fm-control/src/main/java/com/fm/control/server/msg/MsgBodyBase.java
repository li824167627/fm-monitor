package com.fm.control.server.msg;

public interface MsgBodyBase {

	/**
	 * 获取报文类型
	 * 
	 * @return
	 */
	byte getBodyTag();

	/**
	 * 获取报文长度
	 * 
	 * @return
	 */
	byte getBodyLength();

	/**
	 * 获取报文字节数组
	 * 
	 * @return
	 */
	byte[] getBytes();

}
