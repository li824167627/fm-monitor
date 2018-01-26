package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 给微信好友分享门禁
 **/
public class ShareWechatOrderParam {
	private String token; // 用户token
	@NotEmpty(message = "来访时间不能为空")
	private String visitDate; // 来访日期
	@NotEmpty(message = "地址不能为空")
	private String addrId; // 个人地址id
	private String content; // 拜访内容
	private String name; // type=2分享微信时，输入姓名
	private String phone; // type=2分享微信时，输入手机号

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setVisitDate(String visitDate) {
 		this.visitDate = visitDate;
	}

	public String getVisitDate() {
 		return visitDate;
	}

	public void setAddrId(String addrId) {
 		this.addrId = addrId;
	}

	public String getAddrId() {
 		return addrId;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

}
