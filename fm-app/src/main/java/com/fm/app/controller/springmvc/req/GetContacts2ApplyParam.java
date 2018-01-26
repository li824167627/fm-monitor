package com.fm.app.controller.springmvc.req;



/**
 * 获取申请的联系人记录
 **/
public class GetContacts2ApplyParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
