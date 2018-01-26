package com.fm.app.controller.res.bean;


/**
 * 用户联系人信息
 **/
public class RUserContactBean {
	private String id; // 用户关系id
	private String userId; // 用户id
	private String phone; // 用户phone
	private String name; // 用户姓名
	private Integer gender; // 用户性别，1：男，2：女
	private String letter; // 字符串的第一个字符的首字母
	private String icon; // 用户头像
	private Long actionTime; // 审核时间
	private Long applyTime; // 申请时间
	private String remark; // 申请原因
	private Integer type; // 用户状态，1：申请添加，2：自动添加
	private Integer state; // 联系人状态：0申请中 1好友关系 2拒绝 3删除

	public void setId(String id) {
 		this.id = id;
	}

	public String getId() {
 		return id;
	}

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setGender(Integer gender) {
 		this.gender = gender;
	}

	public Integer getGender() {
 		return gender;
	}

	public void setLetter(String letter) {
 		this.letter = letter;
	}

	public String getLetter() {
 		return letter;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

	public void setActionTime(Long actionTime) {
 		this.actionTime = actionTime;
	}

	public Long getActionTime() {
 		return actionTime;
	}

	public void setApplyTime(Long applyTime) {
 		this.applyTime = applyTime;
	}

	public Long getApplyTime() {
 		return applyTime;
	}

	public void setRemark(String remark) {
 		this.remark = remark;
	}

	public String getRemark() {
 		return remark;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

	public void setState(Integer state) {
 		this.state = state;
	}

	public Integer getState() {
 		return state;
	}

}
