package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除地址
 **/
public class RemoveAddrParam {
	private String token; // 用户token
	@NotEmpty(message = "地址id不能为空")
	private String aid; // 地址id

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
