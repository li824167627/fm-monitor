package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 编辑分组名称
 **/
public class EditGroupNameParam {
	private String token; // 用户token
	@NotEmpty(message = "分组不能为空")
	private String groupId; // 分组id
	@NotEmpty(message = "分组名称不能为空")
	private String name; // 分组名称

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

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

}
