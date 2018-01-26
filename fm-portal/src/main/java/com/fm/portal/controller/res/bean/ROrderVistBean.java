package com.fm.portal.controller.res.bean;


/**
 * 用户门禁信息
 **/
public class ROrderVistBean {
	private Integer state; // 门禁审核状态：0提交1同意2不同意
	private String phone; // 用户phone
	private String ovId; // 拜访Id
	private String ovUid; // 拜访对象Id
	private String name; // 拜访对象姓名
	private String reason; // 拒绝原因
	private String icon; // 拜访对象头像
	private Long visitTime; // 拜访时间
	private Integer isView; // 是否查看0未看1已看
	private Long viewTime; // 查看时间
	private Long actionTime; // 审核时间
	private Integer visitNum; // 来访次数

	public void setState(Integer state) {
 		this.state = state;
	}

	public Integer getState() {
 		return state;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

	public void setOvId(String ovId) {
 		this.ovId = ovId;
	}

	public String getOvId() {
 		return ovId;
	}

	public void setOvUid(String ovUid) {
 		this.ovUid = ovUid;
	}

	public String getOvUid() {
 		return ovUid;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

	public void setVisitTime(Long visitTime) {
 		this.visitTime = visitTime;
	}

	public Long getVisitTime() {
 		return visitTime;
	}

	public void setIsView(Integer isView) {
 		this.isView = isView;
	}

	public Integer getIsView() {
 		return isView;
	}

	public void setViewTime(Long viewTime) {
 		this.viewTime = viewTime;
	}

	public Long getViewTime() {
 		return viewTime;
	}

	public void setActionTime(Long actionTime) {
 		this.actionTime = actionTime;
	}

	public Long getActionTime() {
 		return actionTime;
	}

	public void setVisitNum(Integer visitNum) {
 		this.visitNum = visitNum;
	}

	public Integer getVisitNum() {
 		return visitNum;
	}

}
