package com.fm.portal.model.vo;

import com.fm.portal.model.OrderVistBean;
import com.fm.portal.model.UserOrderBean;

/**
 * 根据门禁ID获取用户工单及门禁信息
 */
public class UserOrderVisitVo extends UserOrderBean {
	private OrderVistBean visit; // 用户门禁信息

	public OrderVistBean getVisit() {
		return visit;
	}

	public void setVisit(OrderVistBean visit) {
		this.visit = visit;
	}
}
