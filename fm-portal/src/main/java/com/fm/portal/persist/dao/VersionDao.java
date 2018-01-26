package com.fm.portal.persist.dao;

import com.fm.portal.model.UserVersionBean;
import com.fm.portal.model.VersionBean;

public interface VersionDao {

	int selectMaxVer2Type(int type);

	VersionBean selectMaxOne2Type(int type);

	int insertUserVersion(UserVersionBean uv);

}
