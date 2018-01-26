package com.fm.portal.controller.res.bean;


/**
 * 消息信息
 **/
public class RMsgBean {
	private Integer mid; // id
	private String tuid; // 目标id
	private String tname; // 目标姓名
	private String title; // 消息标题
	private String content; // 消息内容
	private Integer type; // 消息类型
	private String extras; // 消息传递内容
	private String addTimeStr; // 发送时间
	private Long addTime; // 发送时间戳
	private Integer isRead; // 是否已读0未读1已读
	private Integer loginPort; // 所属手机端：1用户2管理

	public void setMid(Integer mid) {
 		this.mid = mid;
	}

	public Integer getMid() {
 		return mid;
	}

	public void setTuid(String tuid) {
 		this.tuid = tuid;
	}

	public String getTuid() {
 		return tuid;
	}

	public void setTname(String tname) {
 		this.tname = tname;
	}

	public String getTname() {
 		return tname;
	}

	public void setTitle(String title) {
 		this.title = title;
	}

	public String getTitle() {
 		return title;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

	public void setExtras(String extras) {
 		this.extras = extras;
	}

	public String getExtras() {
 		return extras;
	}

	public void setAddTimeStr(String addTimeStr) {
 		this.addTimeStr = addTimeStr;
	}

	public String getAddTimeStr() {
 		return addTimeStr;
	}

	public void setAddTime(Long addTime) {
 		this.addTime = addTime;
	}

	public Long getAddTime() {
 		return addTime;
	}

	public void setIsRead(Integer isRead) {
 		this.isRead = isRead;
	}

	public Integer getIsRead() {
 		return isRead;
	}

	public void setLoginPort(Integer loginPort) {
 		this.loginPort = loginPort;
	}

	public Integer getLoginPort() {
 		return loginPort;
	}

}
