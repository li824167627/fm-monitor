package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除联系人请求
 **/
public class RemoveContactReqParam {
	private String token; // 用户token
	@NotEmpty(message = "请求id不能为空")
	private String id; // 请求id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setId(String id) {
 		this.id = id;
	}

	public String getId() {
 		return id;
	}

}
