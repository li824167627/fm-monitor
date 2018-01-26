package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 更新密码
 **/
public class EditPwdParam {
	private String token; // 用户token
	@NotEmpty(message = "临时token不能为空")
	private String checkToken; // 临时token
	@NotEmpty(message = "新密码不能为空")
	private String pwd; // 新密码
	@NotEmpty(message = "确认密码不能为空")
	private String confirmPwd; // 确认新密码

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setCheckToken(String checkToken) {
 		this.checkToken = checkToken;
	}

	public String getCheckToken() {
 		return checkToken;
	}

	public void setPwd(String pwd) {
 		this.pwd = pwd;
	}

	public String getPwd() {
 		return pwd;
	}

	public void setConfirmPwd(String confirmPwd) {
 		this.confirmPwd = confirmPwd;
	}

	public String getConfirmPwd() {
 		return confirmPwd;
	}

}
