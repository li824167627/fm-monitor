package com.fm.portal.model.vo;

import com.fm.portal.model.UserAddrBean;

/**
 * 用户及用户验证信息
 */
public class UserAddrVo extends UserAddrBean {

	private String plotName;// 小区名称

	private String plotAddr;// 小区地址

	private Integer plotType;// 小区类型

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}

	public String getPlotAddr() {
		return plotAddr;
	}

	public void setPlotAddr(String plotAddr) {
		this.plotAddr = plotAddr;
	}

	public Integer getPlotType() {
		return plotType;
	}

	public void setPlotType(Integer plotType) {
		this.plotType = plotType;
	}

}
