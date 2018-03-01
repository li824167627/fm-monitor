package com.fm.control.persist.impl;

import org.springframework.stereotype.Repository;

import com.fm.control.model.MsgBean;
import com.fm.control.persist.dao.MsgDao;

@Repository
public class MsgImpl extends BaseImpl implements MsgDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".MsgMapper";

	@Override
	public int insert(MsgBean bean) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", bean);
	}

}
