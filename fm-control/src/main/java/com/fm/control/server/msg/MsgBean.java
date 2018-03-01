package com.fm.control.server.msg;

public class MsgBean {

	private MsgHeaderBean header;
	private MsgBodyBase body;
	private MsgFooterBean footer;

	public MsgBean(MsgHeaderBean header, MsgBodyBase body, MsgFooterBean footer) {
		this.header = header;
		this.body = body;
		this.footer = footer;
		header.setFlag(body.getBodyTag());
		header.setLength(body.getBodyLength());
	}

	public byte[] getBytes() {
		byte[] header = this.header.getBytes();
		byte[] body = this.body.getBytes();
		byte[] footer = this.footer.getBytes();
		int length = 0;
		length += header.length;
		length += body.length;
		length += footer.length;
		final byte[] joinedArray = new byte[length];
		System.arraycopy(header, 0, joinedArray, 0, header.length);
		System.arraycopy(body, 0, joinedArray, header.length, body.length);
		System.arraycopy(footer, 0, joinedArray, header.length + body.length, footer.length);
		this.header.setChecksum(getCRC(joinedArray));
		header = this.header.getBytes();
		System.arraycopy(header, 0, joinedArray, 0, header.length);
		return joinedArray;
	}

	/**
	 * 计算CRC16校验码
	 *
	 * @param bytes
	 *            字节数组
	 * @return {@link String} 校验码
	 * @since 1.0
	 */
	public static short getCRC(byte[] bytes) {
		short CRC = (short) 0xffff;
		short POLYNOMIAL = (short) 0xA001;
		int i, j;
		for (i = 0; i < bytes.length; i++) {
			CRC ^= ((int) bytes[i] & 0x000000ff);
			for (j = 0; j < 8; j++) {
				if ((CRC & 0x00000001) != 0) {
					CRC >>= 1;
					CRC ^= POLYNOMIAL;
				} else {
					CRC >>= 1;
				}
			}
		}
		return CRC;
	}

}
