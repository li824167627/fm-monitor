package com.fm.app.persist.impl;

import org.springframework.stereotype.Repository;

import com.fm.app.model.UserLoginLogBean;
import com.fm.app.persist.dao.UserLoginLogDao;

@Repository
public class UserLoginLogImpl extends BaseImpl implements UserLoginLogDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".UserLoginLogMapper";

	@Override
	public int insert(UserLoginLogBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

}
