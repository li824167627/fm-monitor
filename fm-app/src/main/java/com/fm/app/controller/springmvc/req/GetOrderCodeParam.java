package com.fm.app.controller.springmvc.req;



/**
 * 获取用户二维码token
 **/
public class GetOrderCodeParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
