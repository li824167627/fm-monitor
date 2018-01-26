package com.fm.portal.controller.springmvc.req;



/**
 * 获取邀请的联系人记录
 **/
public class GetContacts2InviteParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
