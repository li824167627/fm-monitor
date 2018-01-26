package com.fm.app.controller.springmvc.req;



/**
 * 更新头像
 **/
public class UserHeadParam {
	private String token; // 用户token
	private String icon; // 用户头像JSON

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

}
