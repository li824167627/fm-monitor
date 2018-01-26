package com.fm.app.controller.springmvc.req;


import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 验证手机验证码
 **/
public class CheckVcodeParam {
	@Pattern(regexp = "^1|2$", message = "类型不正确，1找回密码，2更新手机号")
	private String type; // 类型，1找回密码，2更新手机号
	@NotEmpty(message = "新手机号不能为空")
	private String phone; // 新手机号
	@NotEmpty(message = "手机验证码不能为空")
	private String vcode; // 新手机的验证码，手机验证码不能为空

	public void setType(String type) {
 		this.type = type;
	}

	public String getType() {
 		return type;
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
