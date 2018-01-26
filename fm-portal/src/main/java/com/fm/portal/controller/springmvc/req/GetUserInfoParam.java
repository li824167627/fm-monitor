package com.fm.portal.controller.springmvc.req;



/**
 * 根据token获取用户信息
 **/
public class GetUserInfoParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
