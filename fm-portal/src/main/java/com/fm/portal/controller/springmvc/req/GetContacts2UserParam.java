package com.fm.portal.controller.springmvc.req;



/**
 * 获取用户所有联系人
 **/
public class GetContacts2UserParam {
	private String key; // 模糊搜索按手机号、姓名、拼音
	private String token; // 用户token

	public void setKey(String key) {
 		this.key = key;
	}

	public String getKey() {
 		return key;
	}

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
