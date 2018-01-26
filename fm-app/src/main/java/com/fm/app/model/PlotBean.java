package com.fm.app.model;

import java.sql.Timestamp;

//物业小区信息
public class PlotBean {

	private Integer id;
	private String name; // 小区名称，如 星河湾
	private String conName; // 联系人
	private String conPhone; // 联系人电话
	private String address; // 小区详细地址 如：北京市海淀区城府路45号
	private String district; // 区域 ["北京市","海淀区"]
	private Timestamp createTime; // 创建时间
	private Integer propertyId; // 物业id
	private Integer type;// 小区类型：1居民 2企业

	private String propertyName;// 物业名称

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}
