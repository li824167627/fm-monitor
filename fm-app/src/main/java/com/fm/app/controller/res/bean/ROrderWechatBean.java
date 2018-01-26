package com.fm.app.controller.res.bean;


/**
 * 微信显示来访信息
 **/
public class ROrderWechatBean {
	private Integer id; // id
	private String QRcodeUrl; // 微信二维码url
	private String userId; // 申请人Id
	private String userName; // 申请人姓名
	private String userPhone; // 申请人手机号
	private String content; // 工单内容
	private String extAddr; // 业主地址JSON
	private Integer isExpire; // 是否过期
	private Long expireTime; // 过期时间
	private Long createTime; // 申请时间

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setQRcodeUrl(String QRcodeUrl) {
 		this.QRcodeUrl = QRcodeUrl;
	}

	public String getQRcodeUrl() {
 		return QRcodeUrl;
	}

	public void setUserId(String userId) {
 		this.userId = userId;
	}

	public String getUserId() {
 		return userId;
	}

	public void setUserName(String userName) {
 		this.userName = userName;
	}

	public String getUserName() {
 		return userName;
	}

	public void setUserPhone(String userPhone) {
 		this.userPhone = userPhone;
	}

	public String getUserPhone() {
 		return userPhone;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setExtAddr(String extAddr) {
 		this.extAddr = extAddr;
	}

	public String getExtAddr() {
 		return extAddr;
	}

	public void setIsExpire(Integer isExpire) {
 		this.isExpire = isExpire;
	}

	public Integer getIsExpire() {
 		return isExpire;
	}

	public void setExpireTime(Long expireTime) {
 		this.expireTime = expireTime;
	}

	public Long getExpireTime() {
 		return expireTime;
	}

	public void setCreateTime(Long createTime) {
 		this.createTime = createTime;
	}

	public Long getCreateTime() {
 		return createTime;
	}

}
