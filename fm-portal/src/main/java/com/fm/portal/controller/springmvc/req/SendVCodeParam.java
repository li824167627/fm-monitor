package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 发送验证码
 **/
public class SendVCodeParam {
	@NotEmpty(message = "手机号不能为空！")
	@Pattern(regexp = "^(1)\\d{10}$", message = "手机号格式不正确！")
	private String phone; // 手机号码
	@Pattern(regexp = "^1|2|3|4$", message = "类型不正确，1登录注册2修改密码3绑定手机号4更新手机号")
	private String type; // 类型，1登录注册2修改密码3绑定手机号4更新手机号
	private String token; // token:当绑定，更新手机号，修改密码，都需要传token

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

	public void setType(String type) {
 		this.type = type;
	}

	public String getType() {
 		return type;
	}

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

}
