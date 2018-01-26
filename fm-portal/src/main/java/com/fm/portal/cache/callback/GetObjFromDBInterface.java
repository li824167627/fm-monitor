package com.fm.portal.cache.callback;

/**
 * 从数据库中获取数据
 */
public interface GetObjFromDBInterface<T> {
	T getObj(Object... args);
}
