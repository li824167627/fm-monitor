package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 给我的朋友和群组来访，发放门禁
 **/
public class ShareFriendOrderParam {
	private String token; // 用户token
	@NotEmpty(message = "来访时间不能为空")
	private String visitDate; // 来访日期
	@NotEmpty(message = "地址不能为空")
	private String addrId; // 个人地址id
	private String content; // 拜访内容
	@Pattern(regexp = "^1|2$", message = "类型不正确：1 好友，2群组")
	private String type; // 类型:1 好友，2群组
	private String groupId; // 分组Id
	private String userIds; // 用户Id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setVisitDate(String visitDate) {
 		this.visitDate = visitDate;
	}

	public String getVisitDate() {
 		return visitDate;
	}

	public void setAddrId(String addrId) {
 		this.addrId = addrId;
	}

	public String getAddrId() {
 		return addrId;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setType(String type) {
 		this.type = type;
	}

	public String getType() {
 		return type;
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
