package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 申请添加为联系人
 **/
public class ApplyContactParam {
	private String token; // 用户token
	private String remark; // 添加备注
	@NotEmpty(message = "联系人不能为空")
	private String userId; // 联系人id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setRemark(String remark) {
 		this.remark = remark;
	}

	public String getRemark() {
 		return remark;
	}

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

}
