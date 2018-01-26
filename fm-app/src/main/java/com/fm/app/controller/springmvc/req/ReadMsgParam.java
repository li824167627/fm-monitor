package com.fm.app.controller.springmvc.req;



/**
 * 消息已读
 **/
public class ReadMsgParam {
	private String token; // 用户token
	private Integer readType; // 读消息类型1类型列表，传type2一条消息，传mid
	private Integer type; // 消息类型
	private Integer mid; // 消息id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setReadType(Integer readType) {
 		this.readType = readType;
	}

	public Integer getReadType() {
 		return readType;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

	public void setMid(Integer mid) {
 		this.mid = mid;
	}

	public Integer getMid() {
 		return mid;
	}

}
