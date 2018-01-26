package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 第三方登录
 **/
public class ThirdLoginParam {
	@NotEmpty(message = "登录类型不能为空")
	@Pattern(regexp = "^1|2$", message = "登录类型不正确：1微信，2QQ")
	private String type; // 登录类型：1微信，2QQ,不能为空
	private String icon; // 头像
	@NotEmpty(message = "openid不能为空")
	private String openid; // openid，不能为空
	@NotEmpty(message = "登录端不能为空")
	@Pattern(regexp = "^1|2$", message = "类型不正确，1用户端2保安端")
	private String loginPort; // 登录端：1用户端2保安端
	private String deviceId; // 设备id
	private String os; // 操作系统
	private String model; // 设备机型
	private String fromType; // 1ios 2android
	private String resolution; // 分辨率 1024，2048

	public void setType(String type) {
 		this.type = type;
	}

	public String getType() {
 		return type;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

	public void setOpenid(String openid) {
 		this.openid = openid;
	}

	public String getOpenid() {
 		return openid;
	}

	public void setLoginPort(String loginPort) {
 		this.loginPort = loginPort;
	}

	public String getLoginPort() {
 		return loginPort;
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
