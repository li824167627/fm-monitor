package com.fm.portal.persist.dao;

import com.fm.portal.model.UserAuthBean;
import com.fm.portal.model.UserAuthLogBean;

public interface UserAuthDao {

	UserAuthBean selectAuthByUid(String id);

	int update(UserAuthBean auth);

	int insert(UserAuthBean auth);

	int insertAuthLog(UserAuthLogBean authLog);

}
