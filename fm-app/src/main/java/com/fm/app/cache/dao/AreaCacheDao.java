package com.fm.app.cache.dao;

import com.fm.app.cache.callback.GetObjFromDBInterface;
import com.fm.app.model.AreaV1Bean;

public interface AreaCacheDao {

	AreaV1Bean getAreaInfo(int provinceId, GetObjFromDBInterface<AreaV1Bean> callback);

}
