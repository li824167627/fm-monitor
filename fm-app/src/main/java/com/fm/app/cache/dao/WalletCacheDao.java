package com.fm.app.cache.dao;

public interface WalletCacheDao {

	/**
	 * 设置支付回调 订单号标识位
	 * 
	 * @param out_trade_no
	 *            商家内部订单号 唯一
	 * @return
	 */
	boolean setPayCallbackFlag(String out_trade_no);

	/**
	 * 查询是否存在支付处理标识位，返回不为空表示这个订单正在处理，不可在处理
	 * 
	 * @param out_trade_no
	 * @return
	 */
	String getPayCallbackFlag(String out_trade_no);

	/**
	 * 清空处理标识位
	 * 
	 * @return
	 */
	boolean clearPayCallbackFlag(String out_trade_no);

}
