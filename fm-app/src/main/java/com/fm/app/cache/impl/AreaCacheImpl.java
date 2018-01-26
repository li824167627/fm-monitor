package com.fm.app.cache.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.fm.app.cache.BaseCacheImpl;
import com.fm.app.cache.callback.GetObjFromDBInterface;
import com.fm.app.cache.dao.AreaCacheDao;
import com.fm.app.model.AreaV1Bean;

@Component
public class AreaCacheImpl extends BaseCacheImpl implements AreaCacheDao {

	final String KEY_AREA_INFO = NAME_SPACE + "areainfo";

	@Override
	public AreaV1Bean getAreaInfo(int provinceId, GetObjFromDBInterface<AreaV1Bean> callback) {
		return redisTemplate.execute(new RedisCallback<AreaV1Bean>() {
			@Override
			public AreaV1Bean doInRedis(RedisConnection connection) throws DataAccessException {
				AreaV1Bean result = null;
				byte[] key = (KEY_AREA_INFO).getBytes();
				byte[] value = connection.hGet(key, String.valueOf(provinceId).getBytes());
				if (value != null && value.length > 0) {
					result = JSON.parseObject(value, AreaV1Bean.class);
				} else {
					result = callback.getObj();
					if (result != null) {
						connection.hSet(key, String.valueOf(provinceId).getBytes(),
								JSON.toJSONString(result).getBytes());
					}
				}
				return result;
			}
		});
	}

}
