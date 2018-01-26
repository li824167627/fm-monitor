package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除车辆
 **/
public class DelCarParam {
	private String token; // 用户token
	@NotEmpty(message = "车辆id不能为空")
	private String cid; // 车辆id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setCid(String cid) {
 		this.cid = cid;
	}

	public String getCid() {
 		return cid;
	}

}
