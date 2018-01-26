package com.fm.portal.controller.springmvc.req;



/**
 * 用户退出
 **/
public class SignOutParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
