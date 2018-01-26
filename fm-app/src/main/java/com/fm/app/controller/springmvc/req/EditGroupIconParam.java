package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 编辑分组图标
 **/
public class EditGroupIconParam {
	private String token; // 用户token
	@NotEmpty(message = "分组不能为空")
	private String groupId; // 分组id
	@NotEmpty(message = "分组图标不能为空")
	private String icon; // 分组图标

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setGroupId(String groupId) {
 		this.groupId = groupId;
	}

	public String getGroupId() {
 		return groupId;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

}
