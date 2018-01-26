package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 编辑/添加车辆
 **/
public class EditCarParam {
	private String token; // 用户token
	private Integer id; // 车辆id
	@NotEmpty(message = "车牌号不能为空")
	private String number; // 车牌号

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

	public void setNumber(String number) {
 		this.number = number;
	}

	public String getNumber() {
 		return number;
	}

}
