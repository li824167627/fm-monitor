package com.fm.app.controller.res.bean;


/**
 * 保安扫码门禁记录信息
 **/
public class RVisitLogBean {
	private String orderNo; // 拜访编号
	private String authSecName; // 保安名
	private String plotName; // 小区名
	private String plotBoxName; // 岗亭
	private Long authTime; // 验证时间
	private String content; // 访问内容
	private String extAddr; // 业主地址JSON
	private Integer state; // 通过状态：1同意2不同意
	private String reason; // 不能通过原因

	public void setOrderNo(String orderNo) {
 		this.orderNo = orderNo;
	}

	public String getOrderNo() {
 		return orderNo;
	}

	public void setAuthSecName(String authSecName) {
 		this.authSecName = authSecName;
	}

	public String getAuthSecName() {
 		return authSecName;
	}

	public void setPlotName(String plotName) {
 		this.plotName = plotName;
	}

	public String getPlotName() {
 		return plotName;
	}

	public void setPlotBoxName(String plotBoxName) {
 		this.plotBoxName = plotBoxName;
	}

	public String getPlotBoxName() {
 		return plotBoxName;
	}

	public void setAuthTime(Long authTime) {
 		this.authTime = authTime;
	}

	public Long getAuthTime() {
 		return authTime;
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

	public void setState(Integer state) {
 		this.state = state;
	}

	public Integer getState() {
 		return state;
	}

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
	}

}
