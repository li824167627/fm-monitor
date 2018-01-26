package com.fm.portal.model;

import java.sql.Timestamp;

/**
 * 用户门禁信息
 **/
public class OrderVistBean {
	private String ovId;
	private Integer state; // 门禁审核状态：0提交1同意2不同意
	private Integer isView; // 是否查看0未看1已看
	private Timestamp viewTime; // 查看时间
	private Timestamp actionTime; // 审核时间
	private Timestamp visitTime; // 拜访时间
	private String ovPhone;
	private String ovName;
	private String ovIcon;
	private String ovUid;
	private String reason;
	private Integer visitNum;

	public Integer getState() {
		return state;
	}

	public String getOvId() {
		return ovId;
	}

	public void setOvId(String ovId) {
		this.ovId = ovId;
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

	public String getOvPhone() {
		return ovPhone;
	}

	public void setOvPhone(String ovPhone) {
		this.ovPhone = ovPhone;
	}

	public String getOvName() {
		return ovName;
	}

	public void setOvName(String ovName) {
		this.ovName = ovName;
	}

	public String getOvIcon() {
		return ovIcon;
	}

	public void setOvIcon(String ovIcon) {
		this.ovIcon = ovIcon;
	}

	public String getOvUid() {
		return ovUid;
	}

	public void setOvUid(String ovUid) {
		this.ovUid = ovUid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
}
