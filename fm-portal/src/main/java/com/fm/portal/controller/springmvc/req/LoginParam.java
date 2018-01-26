package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 登录
 **/
public class LoginParam {
	@NotEmpty(message = "手机不能为空")
	@Pattern(regexp = "^(1)\\d{10}$", message = "手机号不合法")
	private String phone; // 手机不能为空
	private String vcode; // 手机验证码
	private String password; // 密码
	@NotEmpty(message = "登录端不能为空")
	@Pattern(regexp = "^1|2$", message = "类型不正确，1用户端2保安端")
	private String loginPort; // 登录端：1用户端2保安端
	@NotEmpty(message = "登录类型不能为空")
	@Pattern(regexp = "^1|2$", message = "类型不正确，1手机验证码登录，2用户密码登录")
	private String type; // 登录类型：1手机验证码登录，2用户密码登录
	private String deviceId; // 设备id
	private String os; // 操作系统
	private String model; // 设备机型
	private String fromType; // 1ios 2android
	private String resolution; // 分辨率 1024，2048

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

	public void setPassword(String password) {
 		this.password = password;
	}

	public String getPassword() {
 		return password;
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

	public void setDeviceId(String deviceId) {
 		this.deviceId = deviceId;
	}

	public String getDeviceId() {
 		return deviceId;
	}

	public void setOs(String os) {
 		this.os = os;
	}

	public String getOs() {
 		return os;
	}

	public void setModel(String model) {
 		this.model = model;
	}

	public String getModel() {
 		return model;
	}

	public void setFromType(String fromType) {
 		this.fromType = fromType;
	}

	public String getFromType() {
 		return fromType;
	}

	public void setResolution(String resolution) {
 		this.resolution = resolution;
	}

	public String getResolution() {
 		return resolution;
	}

}
