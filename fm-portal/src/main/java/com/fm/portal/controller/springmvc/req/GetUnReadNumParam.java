package com.fm.portal.controller.springmvc.req;



/**
 * 消息未读数量
 **/
public class GetUnReadNumParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
