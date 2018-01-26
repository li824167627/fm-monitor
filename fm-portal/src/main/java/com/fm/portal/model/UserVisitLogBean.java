package com.fm.portal.model;

import java.sql.Timestamp;

public class UserVisitLogBean {

	private Integer id;
	private String visitId;
	private Integer orderId;
	private String orderNo;
	private String authUid;
	private String authSecName;
	private String plotName;
	private String plotBoxName;
	private Timestamp authTime;
	private String content;
	private String extAddr;
	private Integer state;
	private String reason;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
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

	public String getAuthUid() {
		return authUid;
	}

	public void setAuthUid(String authUid) {
		this.authUid = authUid;
	}

	public String getAuthSecName() {
		return authSecName;
	}

	public void setAuthSecName(String authSecName) {
		this.authSecName = authSecName;
	}

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}

	public String getPlotBoxName() {
		return plotBoxName;
	}

	public void setPlotBoxName(String plotBoxName) {
		this.plotBoxName = plotBoxName;
	}

	public Timestamp getAuthTime() {
		return authTime;
	}

	public void setAuthTime(Timestamp authTime) {
		this.authTime = authTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getExtAddr() {
		return extAddr;
	}

	public void setExtAddr(String extAddr) {
		this.extAddr = extAddr;
	}

}
