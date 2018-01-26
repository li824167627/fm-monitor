package com.fm.app.cache.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Component;

import com.fm.app.cache.BaseCacheImpl;
import com.fm.app.cache.dao.CommonCacheDao;

@Component
public class CommonCacheImpl extends BaseCacheImpl implements CommonCacheDao {

	final String KEY_AREA_INFO = NAME_SPACE + "areainfo";
	final String KEY_LAST_LOGIN_TYPE = NAME_SPACE + "lastlogintype:";

	@Override
	public boolean setLastLoginType(String phone, int type) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_LAST_LOGIN_TYPE + phone).getBytes();
				connection.set(key, String.valueOf(type).getBytes());
				return true;
			}
		});
	}

	@Override
	public Integer getLastLoginType(String phone) {
		return redisTemplate.execute(new RedisCallback<Integer>() {
			@Override
			public Integer doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_LAST_LOGIN_TYPE + phone).getBytes();
				byte[] value = connection.get(key);
				if (value != null) {
					return Integer.valueOf(new String(value));
				}
				return null;
			}
		});
	}

}
