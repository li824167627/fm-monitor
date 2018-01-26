package com.fm.portal.model;

import java.sql.Timestamp;

/**
 * 用户列表信息
 **/
public class UserRelationBean {
	private String id; // 用户关系id
	private String userId;// 用户Id
	private String toUserId;// 联系人ID；
	private Timestamp applyTime;
	private Timestamp actionTime;
	private Integer state;// 状态：0申请中 1好友关系 2拒绝 3删除
	private String remark;// 添加原因
	private Integer type;// 1 自己添加 2 auto

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public Timestamp getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public Timestamp getActionTime() {
		return actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
