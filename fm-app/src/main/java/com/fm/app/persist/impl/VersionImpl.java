package com.fm.app.persist.impl;

import org.springframework.stereotype.Repository;

import com.fm.app.model.UserVersionBean;
import com.fm.app.model.VersionBean;
import com.fm.app.persist.dao.VersionDao;

@Repository
public class VersionImpl extends BaseImpl implements VersionDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".VersionMapper";

	@Override
	public int selectMaxVer2Type(int type) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectMaxVer2Type", type);
	}

	@Override
	public VersionBean selectMaxOne2Type(int type) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectMaxOne2Type", type);
	}

	@Override
	public int insertUserVersion(UserVersionBean uv) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertUserVersion", uv);

	}

}
