package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 申请门禁
 **/
public class ApplyOrderParam {
	private String token; // 用户token
	@NotEmpty(message = "拜访时间不能为空")
	private String visitDate; // 拜访日期
	@NotEmpty(message = "请选择拜访用户")
	private String userId; // 用户id
	private String content; // 拜访内容

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

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

}
