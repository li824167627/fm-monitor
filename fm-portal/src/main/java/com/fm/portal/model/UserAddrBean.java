package com.fm.portal.model;

import java.sql.Timestamp;

/**
 * 用户地址信息
 **/
public class UserAddrBean {
	private Integer id; // 地址id
	private Integer type; // 是否显示1绑定地址 2自己添加地址
	private String userId; // 业主id
	private String conName; // 姓名
	private String conPhone; // 电话号
	private Integer plotId; // 小区id
	private String ext;// 门牌号对象
	private String district;/// 具体门牌号
	private String addr; // 地址
	private Integer showType; // 是否显示
	private Timestamp createTime;// 创建时间
	private Integer state;// 审核状态：
	private Integer isDef;// 是否是默认
	private String reason;// 驳回原因
	private Integer plotType;// 驳回原因
	private String plotName;

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

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConPhone() {
		return conPhone;
	}

	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}

	public Integer getPlotId() {
		return plotId;
	}

	public void setPlotId(Integer plotId) {
		this.plotId = plotId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getExt() {
		return ext;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsDef() {
		return isDef;
	}

	public void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getPlotType() {
		return plotType;
	}

	public void setPlotType(Integer plotType) {
		this.plotType = plotType;
	}

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}

}
