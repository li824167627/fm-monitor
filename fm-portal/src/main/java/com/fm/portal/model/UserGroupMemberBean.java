package com.fm.portal.model;

import java.sql.Timestamp;

/**
 * 用户分组信息
 **/
public class UserGroupMemberBean {
	private Integer id; // 分组id
	private Integer groupId; // 分组ID
	private String userId; // 用户ID
	private Timestamp createTime; // 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
