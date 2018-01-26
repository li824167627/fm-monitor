package com.fm.app.controller.res.bean;

import java.util.List;
import java.util.ArrayList;

/**
 * 用户来访工单信息
 **/
public class RComeOrderBean {
	private Integer id; // id
	private String userId; // 申请人Id
	private String userName; // 申请人姓名
	private String checkContact; // 来访人
	private String userPhone; // 申请人手机号
	private Integer type; // 工单类型：1门禁2快递
	private Integer sType; // 门禁类型：1请求门禁2发放门禁3第三方分享门禁
	private String content; // 工单内容
	private RPlotInfoBean plot; // 小区信息
	private List<ROrderVistBean> visit; // 用户门禁信息
	private String extAddr; // 业主地址JSON
	private Integer isExpire; // 是否过期
	private Long expireTime; // 过期时间
	private Long createTime; // 申请时间
	private Integer visitNum; // 来访次数
	private Integer isView; // 是否查看0未看1已看
	private Long viewTime; // 查看时间

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

	public void setUserName(String userName) {
 		this.userName = userName;
	}

	public String getUserName() {
 		return userName;
	}

	public void setCheckContact(String checkContact) {
 		this.checkContact = checkContact;
	}

	public String getCheckContact() {
 		return checkContact;
	}

	public void setUserPhone(String userPhone) {
 		this.userPhone = userPhone;
	}

	public String getUserPhone() {
 		return userPhone;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
	}

	public void setSType(Integer sType) {
 		this.sType = sType;
	}

	public Integer getSType() {
 		return sType;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setPlot(RPlotInfoBean plot) {
 		this.plot = plot;
	}

	public RPlotInfoBean getPlot() {
 		return plot;
	}

	public void setVisit(List<ROrderVistBean> visit) {
 		this.visit = visit;
	}

	public List<ROrderVistBean> getVisit() {
 		return visit;
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

	public void setVisitNum(Integer visitNum) {
 		this.visitNum = visitNum;
	}

	public Integer getVisitNum() {
 		return visitNum;
	}

	public void setIsView(Integer isView) {
 		this.isView = isView;
	}

	public Integer getIsView() {
 		return isView;
	}

	public void setViewTime(Long viewTime) {
 		this.viewTime = viewTime;
	}

	public Long getViewTime() {
 		return viewTime;
	}

}
