package com.fm.app.model.vo;

import com.fm.app.model.SecurityBean;
import com.fm.app.model.UserBean;

/**
 * 用户及用户验证信息
 */
public class UserSecAuthVo extends UserBean {

	private SecurityBean secAuth;

	public SecurityBean getSecAuth() {
		return secAuth;
	}

	public void setSecAuth(SecurityBean secAuth) {
		this.secAuth = secAuth;
	}
}
