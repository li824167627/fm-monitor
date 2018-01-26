package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 同意添加为联系人
 **/
public class AgreeContactParam {
	private String token; // 用户token
	@NotEmpty(message = "申请不能为空")
	private String aid; // 申请id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setAid(String aid) {
 		this.aid = aid;
	}

	public String getAid() {
 		return aid;
	}

}
