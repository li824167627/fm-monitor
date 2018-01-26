package com.fm.portal.controller.springmvc.req;



/**
 * 获取工作区信息，物业信息，小区信息，地址
 **/
public class GetPlotsParam {
	private String token; // 用户token
	private String key; // 模糊搜索按手机号、姓名、拼音

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setKey(String key) {
 		this.key = key;
	}

	public String getKey() {
 		return key;
	}

}
