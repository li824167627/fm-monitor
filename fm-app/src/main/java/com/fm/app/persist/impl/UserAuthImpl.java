package com.fm.app.persist.impl;

import org.springframework.stereotype.Repository;

import com.fm.app.model.UserAuthBean;
import com.fm.app.model.UserAuthLogBean;
import com.fm.app.persist.dao.UserAuthDao;

@Repository
public class UserAuthImpl extends BaseImpl implements UserAuthDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".UserAuthMapper";

	@Override
	public UserAuthBean selectAuthByUid(String userId) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectAuthByUid", userId);

	}

	@Override
	public int update(UserAuthBean auth) {
		return sqlSessionTemplate.update(NAME_SPACE + ".update", auth);
	}

	@Override
	public int insert(UserAuthBean auth) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", auth);
	}

	@Override
	public int insertAuthLog(UserAuthLogBean authLog) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertAuthLog", authLog);
	}

}
