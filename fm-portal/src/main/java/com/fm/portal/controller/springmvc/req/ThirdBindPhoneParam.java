package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 第三方登录时绑定手机号
 **/
public class ThirdBindPhoneParam {
	@NotEmpty(message = "openid不能为空")
	private String openid; // openid，不能为空
	private String icon; // 头像
	@NotEmpty(message = "登录端不能为空")
	@Pattern(regexp = "^1|2$", message = "类型不正确，1用户端2保安端")
	private String loginPort; // 登录端：1用户端2保安端
	@Pattern(regexp = "^1|2$", message = "登录类型不正确：1微信，2QQ")
	private String type; // 登录类型：1微信，2QQ,不能为空
	@NotEmpty(message = "验证码不能为空")
	private String vcode; // 手机验证码
	@NotEmpty(message = "手机不能为空")
	private String phone; // 绑定手机号

	public void setOpenid(String openid) {
 		this.openid = openid;
	}

	public String getOpenid() {
 		return openid;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

	public void setLoginPort(String loginPort) {
 		this.loginPort = loginPort;
	}

	public String getLoginPort() {
 		return loginPort;
	}

	public void setType(String type) {
 		this.type = type;
	}

	public String getType() {
 		return type;
	}

	public void setVcode(String vcode) {
 		this.vcode = vcode;
	}

	public String getVcode() {
 		return vcode;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

}
