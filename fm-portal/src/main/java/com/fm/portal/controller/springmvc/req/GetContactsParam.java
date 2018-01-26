package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 获取未添加过的联系人，不包括正在审核的
 **/
public class GetContactsParam {
	@NotEmpty(message = "输入搜索的好友手机号")
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
