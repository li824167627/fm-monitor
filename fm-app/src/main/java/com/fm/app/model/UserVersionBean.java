package com.fm.app.model;

import java.sql.Timestamp;

/**
 * 用户版本升级记录
 **/
public class UserVersionBean {
	private Integer id; // id
	private Integer vercode; // 版本号
	private String userId; // 用户id
	private Timestamp updateTime; // 更新时间
	private Integer verport; // 更新时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVercode() {
		return vercode;
	}

	public void setVercode(Integer vercode) {
		this.vercode = vercode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVerport() {
		return verport;
	}

	public void setVerport(Integer verport) {
		this.verport = verport;
	}

}
