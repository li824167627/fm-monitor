package com.fm.app.model.vo;

import com.fm.app.model.UserAuthBean;
import com.fm.app.model.UserBean;

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
