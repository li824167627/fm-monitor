package com.fm.app.controller.springmvc.req;



/**
 * 获取用户车辆信息
 **/
public class GetCars2UserParam {
	private String token; // 用户token

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
