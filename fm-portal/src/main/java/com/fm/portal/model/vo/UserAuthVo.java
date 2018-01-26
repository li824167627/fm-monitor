package com.fm.portal.model.vo;

import com.fm.portal.model.UserAuthBean;
import com.fm.portal.model.UserBean;

/**
 * 用户及用户验证信息
 */
public class UserAuthVo extends UserBean {

	private UserAuthBean auth;

	public UserAuthBean getAuth() {
		return auth;
	}

	public void setAuth(UserAuthBean auth) {
		this.auth = auth;
	}

}
