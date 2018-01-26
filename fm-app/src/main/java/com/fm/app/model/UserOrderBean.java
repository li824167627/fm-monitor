package com.fm.app.model;

import java.sql.Timestamp;

public class UserOrderBean {

	private Integer id; //
	private String userId; //
	private Integer type; // 工单类型 1门禁 2快递
	private Integer sType; // 1请求门禁 2发放门禁 3第三方分享门禁
	private String content; // 内容
	private String checkContact;
	// type=1 门禁信息
	// {
	// "visitTime":"2017-12-20", // 拜访时间
	// "addrId":11222, //业主地址
	// "carInfo":["京AB123"], // 车辆信息
	// "remark":""//备注
	// }
	private Integer plotId; // 小区id
	private String extAddr; // 最新的地址信息,业主地址 记录日志
	private String orderNo; // 门禁 MJ开头 快递KD开头
	private Timestamp createTime;
	private Timestamp expireTime; // 有效时间
	private Integer isExpire; // 是否过期

	private Integer isView; // 是否查看0未看1已看
	private Timestamp viewTime; // 查看时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getsType() {
		return sType;
	}

	public void setsType(Integer sType) {
		this.sType = sType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPlotId() {
		return plotId;
	}

	public void setPlotId(Integer plotId) {
		this.plotId = plotId;
	}

	public String getExtAddr() {
		return extAddr;
	}

	public void setExtAddr(String extAddr) {
		this.extAddr = extAddr;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(Integer isExpire) {
		this.isExpire = isExpire;
	}

	public String getCheckContact() {
		return checkContact;
	}

	public void setCheckContact(String checkContact) {
		this.checkContact = checkContact;
	}

	public Integer getIsView() {
		return isView;
	}

	public void setIsView(Integer isView) {
		this.isView = isView;
	}

	public Timestamp getViewTime() {
		return viewTime;
	}

	public void setViewTime(Timestamp viewTime) {
		this.viewTime = viewTime;
	}

}
