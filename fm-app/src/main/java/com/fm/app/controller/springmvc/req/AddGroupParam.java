package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 添加分组
 **/
public class AddGroupParam {
	private String token; // 用户token
	@NotEmpty(message = "分组名称不能为空")
	private String name; // 分组名称
	private String icon; // 分组图标

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

}
