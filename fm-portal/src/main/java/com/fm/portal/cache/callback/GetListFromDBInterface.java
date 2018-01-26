package com.fm.portal.cache.callback;

import java.util.List;

/**
 * 从数据库中获取数据
 */
public interface GetListFromDBInterface<T> {
	List<T> getList(Object... args);
}
