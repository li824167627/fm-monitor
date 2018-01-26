package com.fm.portal.controller.springmvc.req;



/**
 * 获取用户当前认证信息
 **/
public class GetAuthInfoParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
