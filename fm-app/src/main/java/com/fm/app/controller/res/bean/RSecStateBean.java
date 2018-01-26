package com.fm.app.controller.res.bean;


/**
 * 保安状态信息
 **/
public class RSecStateBean {
	private String userId; // 用户uid
	private Integer state; // 0提交 1审核通过  2审核未通过
	private String reason; // 驳回原因

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

	public void setState(Integer state) {
 		this.state = state;
	}

	public Integer getState() {
 		return state;
	}

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
	}

}
