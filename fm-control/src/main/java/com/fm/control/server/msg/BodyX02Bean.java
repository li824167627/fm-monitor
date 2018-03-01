package com.fm.control.server.msg;

/**
 * 平台发送激活信息报文-0x02号<br>
 * 监管平台或监管数据采集管理平台将获得的设备厂商标识码和流动放映终端序列号，检索数据库中
 * 流动放映终端信息，如果属于管辖的流动放映终端则进行激活，否则不激活并返回原因。 <br>
 * 报文类型:平台报文;<br>
 * Tag:0x02; Length:13 bytes;
 */
public class BodyX02Bean implements MsgBodyBase {
	public static final byte BODY_TAG = 0x02;
	public static final byte BODY_LENGTH = 13;

	private byte activityStatus; // 激活状态 1 byte 0x00，激活成功 0x01，未找到对应流动放映终端记录 0x02，流动放映终端处于不能激活状态
									// 0x03，流动放映终端已经激活，不允许重复激活
	private byte[] activeCode; // 激活码 8 bytes 当激活状态码为 0x00 时，本字段的内容为加密后的激活码， 密钥为流动放映终端硬件指纹，要求流动放映终端在接收
								// 到激活码后持久保存激活码。身份认证时要求回传此激活 码
	private byte[] retain;// 保留 4 bytes

	public BodyX02Bean(byte activityStatus, byte[] activeCode, byte[] retain) {
		this.activityStatus = activityStatus;
		this.activeCode = activeCode;
		this.retain = retain;
	}

	public byte getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(byte activityStatus) {
		this.activityStatus = activityStatus;
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
