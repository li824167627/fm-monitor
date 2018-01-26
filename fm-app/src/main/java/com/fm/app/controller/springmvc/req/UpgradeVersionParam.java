package com.fm.app.controller.springmvc.req;



/**
 * 更新版本
 **/
public class UpgradeVersionParam {
	private String token; // 用户token
	private Integer vercode; // 版本号

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setVercode(Integer vercode) {
 		this.vercode = vercode;
	}

	public Integer getVercode() {
 		return vercode;
	}

}
