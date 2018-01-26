package com.fm.portal.controller.res.bean;


/**
 * 用户分组信息
 **/
public class RUserGroupBean {
	private Integer id; // 分组id
	private String userId; // 分组拥有人
	private String name; // 分组名
	private String icon; // 分组icon
	private String tag; // 分组标签
	private Integer num; // 群人数
	private Long createTime; // 创建时间时间戳到秒

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

	public void setTag(String tag) {
 		this.tag = tag;
	}

	public String getTag() {
 		return tag;
	}

	public void setNum(Integer num) {
 		this.num = num;
	}

	public Integer getNum() {
 		return num;
	}

	public void setCreateTime(Long createTime) {
 		this.createTime = createTime;
	}

	public Long getCreateTime() {
 		return createTime;
	}

}
