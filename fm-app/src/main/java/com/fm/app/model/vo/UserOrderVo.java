package com.fm.app.model.vo;

import java.util.List;

import com.fm.app.model.OrderVistBean;
import com.fm.app.model.PlotInfoBean;
import com.fm.app.model.UserOrderBean;

/**
 * 用户及用户验证信息
 */
public class UserOrderVo extends UserOrderBean {

	private PlotInfoBean plot; // 小区信息
	private List<OrderVistBean> visit; // 用户门禁信息
	private String userName;
	private String userPhone;

	public PlotInfoBean getPlot() {
		return plot;
	}

	public void setPlot(PlotInfoBean plot) {
		this.plot = plot;
	}

	public List<OrderVistBean> getVisit() {
		return visit;
	}

	public void setVisit(List<OrderVistBean> visit) {
		this.visit = visit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}
