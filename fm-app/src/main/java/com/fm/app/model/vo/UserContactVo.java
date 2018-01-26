package com.fm.app.model.vo;

import com.fm.app.model.UserBean;
import com.fm.app.model.UserRelationBean;

/**
 * 用户及用户联系人关系信息
 */
public class UserContactVo extends UserBean {

	private UserRelationBean relation;

	public UserRelationBean getRelation() {
		return relation;
	}

	public void setRelation(UserRelationBean relation) {
		this.relation = relation;
	}
}
