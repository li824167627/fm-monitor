package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除联系人
 **/
public class RemoveContactParam {
	private String token; // 用户token
	@NotEmpty(message = "联系人不能为空")
	private String userId; // 联系人id

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
