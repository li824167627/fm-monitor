package com.fm.portal.model;

import java.sql.Timestamp;

public class UserOrderVisitBean {

	private String id; //
	private Integer orderId; //
	private String orderNo; //
	private String userId; //
	private String toUserId;// 发送给谁
	private Integer state; // 门禁审核状态：0 提交 1同意 2不同意
	private Integer isView; // 是否查看
	private Timestamp viewTime; // 查看时间
	private Timestamp actionTime; // 审核时间
	private Timestamp createTime; // 创建时间
	private Timestamp visitTime; // 拜访时间
	private Timestamp authTime; // 保安验证时间
	private String authSecId; // 保安id
	private String reason;// 拒绝理由
	private Integer visitNum;// 来访次数

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public Timestamp getActionTime() {
		return actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public Timestamp getAuthTime() {
		return authTime;
	}

	public void setAuthTime(Timestamp authTime) {
		this.authTime = authTime;
	}

	public String getAuthSecId() {
		return authSecId;
	}

	public void setAuthSecId(String authSecId) {
		this.authSecId = authSecId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

}
