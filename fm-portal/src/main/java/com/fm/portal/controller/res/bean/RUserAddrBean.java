package com.fm.portal.controller.res.bean;


/**
 * 用户地址信息
 **/
public class RUserAddrBean {
	private Integer id; // 地址id
	private String userId; // 业主id
	private String name; // 姓名
	private String phone; // 电话号
	private String plotName; // 小区名称
	private Integer plotType; // 小区类型
	private String addr; // 地址
	private String ext; // 地址
	private Integer state; // 审核状态
	private Integer type; // 地址类型
	private Integer showType; // 是否显示
	private String reason; // 驳回原因

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

	public void setPlotName(String plotName) {
 		this.plotName = plotName;
	}

	public String getPlotName() {
 		return plotName;
	}

	public void setPlotType(Integer plotType) {
 		this.plotType = plotType;
	}

	public Integer getPlotType() {
 		return plotType;
	}

	public void setAddr(String addr) {
 		this.addr = addr;
	}

	public String getAddr() {
 		return addr;
	}

	public void setExt(String ext) {
 		this.ext = ext;
	}

	public String getExt() {
 		return ext;
	}

	public void setState(Integer state) {
 		this.state = state;
	}

	public Integer getState() {
 		return state;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

	public void setShowType(Integer showType) {
 		this.showType = showType;
	}

	public Integer getShowType() {
 		return showType;
	}

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
	}

}
