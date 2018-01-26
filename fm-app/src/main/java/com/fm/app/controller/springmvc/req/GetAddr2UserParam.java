package com.fm.app.controller.springmvc.req;



/**
 * 获取用户地址信息
 **/
public class GetAddr2UserParam {
	private String token; // 用户token
	private String userId; // 用户Id，空则获取登录token用户的地址信息

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

}
