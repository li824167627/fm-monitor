package com.fm.app.persist.dao;

import com.fm.app.model.UserVersionBean;
import com.fm.app.model.VersionBean;

public interface VersionDao {

	int selectMaxVer2Type(int type);

	VersionBean selectMaxOne2Type(int type);

	int insertUserVersion(UserVersionBean uv);

}
