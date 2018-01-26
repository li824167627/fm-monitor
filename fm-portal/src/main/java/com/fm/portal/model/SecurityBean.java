package com.fm.portal.model;

import java.sql.Timestamp;

/**
 * 保安信息
 */
public class SecurityBean {

	private String secId; // 用户id
	private String name; // 用户姓名
	private String phone;
	private String icon;
	private String password;
	private Integer isSetPwd;
	private Integer gender; // 用户性别，1：男，2：女
	private String idNo; // 身份证
	private String ext; // 认证提交信息对象
	private Integer isAuthSec; // 是否认证为保安 1认证 0未认证
	private Timestamp submitTime; // 提交时间
	private Timestamp actionTime; // 操作时间
	private String actionName; // 操作人
	private String actionId; // 操作时间
	private Integer state; // 保安状态 0已提交 1审核通过 2审核未通过
	private String reason; // 审核失败原因
	private Integer plotId; // 小区id
	private Integer isAllot; // 是否分配 0未分配 1已分配 2待分配
	private Integer boxId; // 小区岗亭id
	private String health;
	private Double height;
	private String photo;
	private String station;
	private String secNo;
	private String qualified;

	// 扩展显示字段
	private String plotName; //
	private String plotBoxName; //
	private Integer plotType;
	private String address; // 地址
	private String propertyName; //

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Integer getIsAuthSec() {
		return isAuthSec;
	}

	public void setIsAuthSec(Integer isAuthSec) {
		this.isAuthSec = isAuthSec;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getActionTime() {
		return actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
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

	public Integer getPlotId() {
		return plotId;
	}

	public void setPlotId(Integer plotId) {
		this.plotId = plotId;
	}

	public Integer getIsAllot() {
		return isAllot;
	}

	public void setIsAllot(Integer isAllot) {
		this.isAllot = isAllot;
	}

	public Integer getBoxId() {
		return boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getSecNo() {
		return secNo;
	}

	public void setSecNo(String secNo) {
		this.secNo = secNo;
	}

	public String getQualified() {
		return qualified;
	}

	public void setQualified(String qualified) {
		this.qualified = qualified;
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

	public Integer getPlotType() {
		return plotType;
	}

	public void setPlotType(Integer plotType) {
		this.plotType = plotType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsSetPwd() {
		return isSetPwd;
	}

	public void setIsSetPwd(Integer isSetPwd) {
		this.isSetPwd = isSetPwd;
	}

}