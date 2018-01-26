package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 修改手机号
 **/
public class UpdatePhoneParam {
	private String token; // 用户token
	@NotEmpty(message = "新手机号不能为空")
	private String phone; // 新手机号
	@NotEmpty(message = "验证码不能为空")
	private String vcode; // 手机验证码

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

	public void setVcode(String vcode) {
 		this.vcode = vcode;
	}

	public String getVcode() {
 		return vcode;
	}

}
