package com.fm.portal.cache.dao;

import com.fm.portal.cache.callback.GetObjFromDBInterface;
import com.fm.portal.model.AreaV1Bean;

public interface AreaCacheDao {

	AreaV1Bean getAreaInfo(int provinceId, GetObjFromDBInterface<AreaV1Bean> callback);

}
