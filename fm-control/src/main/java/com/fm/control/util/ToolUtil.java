package com.fm.control.util;

import java.util.UUID;

/**
 * App工具
 * 
 * @author candy-it
 *
 */
public class ToolUtil {

	/**
	 * 8 bytes length
	 * 
	 * @return
	 */
	public static String getChallengeCode() {
		return "abcdefgh";
	}

	/**
	 * 获取数据库关键字，Guuid
	 * 
	 * @return
	 */
	public static String getPrimaryKey() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}

	/**
	 * 获取token
	 * 
	 * @return
	 */
	public static String getToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
