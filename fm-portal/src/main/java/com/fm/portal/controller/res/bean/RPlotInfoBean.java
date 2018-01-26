package com.fm.portal.controller.res.bean;


/**
 * 小区地址信息
 **/
public class RPlotInfoBean {
	private Integer id; // 小区id
	private String name; // 小区名称
	private String address; // 地址
	private Integer type; // 小区类型：1居住区 2 企业
	private String propertyName; // 物业名称

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setAddress(String address) {
 		this.address = address;
	}

	public String getAddress() {
 		return address;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

	public void setPropertyName(String propertyName) {
 		this.propertyName = propertyName;
	}

	public String getPropertyName() {
 		return propertyName;
	}

}
