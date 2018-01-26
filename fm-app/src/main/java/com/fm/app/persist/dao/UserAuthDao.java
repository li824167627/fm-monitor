package com.fm.app.persist.dao;

import com.fm.app.model.UserAuthBean;
import com.fm.app.model.UserAuthLogBean;

public interface UserAuthDao {

	UserAuthBean selectAuthByUid(String id);

	int update(UserAuthBean auth);

	int insert(UserAuthBean auth);

	int insertAuthLog(UserAuthLogBean authLog);

}
