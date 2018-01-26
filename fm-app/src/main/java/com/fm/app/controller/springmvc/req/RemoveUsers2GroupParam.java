package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 删除分组内联系人
 **/
public class RemoveUsers2GroupParam {
	private String token; // 用户token
	@NotEmpty(message = "分组不能为空")
	private String groupId; // 分组Id
	@NotEmpty(message = "联系人不能为空")
	private String userIds; // 联系人id数组

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

	public void setUserIds(String userIds) {
 		this.userIds = userIds;
	}

	public String getUserIds() {
 		return userIds;
	}

}
