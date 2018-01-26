package com.fm.portal.controller.springmvc.req;



/**
 * 添加地址
 **/
public class EditAddr2PlotParam {
	private String token; // 用户token
	private Integer id; // 地址id
	private String plotId; // 用户token
	private String ext; // 地址信息
	private String conPhone; // 临时手机号
	private String conName; // 临时联系人

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setPlotId(String plotId) {
 		this.plotId = plotId;
	}

	public String getPlotId() {
 		return plotId;
	}

	public void setExt(String ext) {
 		this.ext = ext;
	}

	public String getExt() {
 		return ext;
	}

	public void setConPhone(String conPhone) {
 		this.conPhone = conPhone;
	}

	public String getConPhone() {
 		return conPhone;
	}

	public void setConName(String conName) {
 		this.conName = conName;
	}

	public String getConName() {
 		return conName;
	}

}
