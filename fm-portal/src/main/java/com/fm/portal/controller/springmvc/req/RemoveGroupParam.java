package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除分组
 **/
public class RemoveGroupParam {
	private String token; // 用户token
	@NotEmpty(message = "分组不能为空")
	private String groupId; // 分组id

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

}
