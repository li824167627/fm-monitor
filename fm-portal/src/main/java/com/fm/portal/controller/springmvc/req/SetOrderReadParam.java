package com.fm.portal.controller.springmvc.req;



/**
 * 设置消息已读
 **/
public class SetOrderReadParam {
	private String token; // 用户token
	private Integer oid; // 访问信息id
	private Integer type; // 页面：1拜访2来访

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setOid(Integer oid) {
 		this.oid = oid;
	}

	public Integer getOid() {
 		return oid;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

}
