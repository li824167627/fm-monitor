package com.fm.portal.model;

import java.sql.Timestamp;

public class PropertyBean {

	private Integer id; //
	private String name; // 物业公司名称
	private String conName; // 联系人
	private String conPhone; // 联系人电话
	private String addr; // 物业地址
	private Timestamp createTime; //
	private String actionId; // 操作员id，运营端管员id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	@Override
	public String toString() {
		return "PropertyBean [id=" + id + ", name=" + name + ", conName=" + conName + ", conPhone=" + conPhone
				+ ", addr=" + addr + ", createTime=" + createTime + ", actionId=" + actionId + "]";
	}

}
