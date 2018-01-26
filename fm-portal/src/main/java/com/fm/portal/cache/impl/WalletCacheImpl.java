package com.fm.portal.cache.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Component;

import com.fm.portal.cache.BaseCacheImpl;
import com.fm.portal.cache.dao.WalletCacheDao;

@Component
public class WalletCacheImpl extends BaseCacheImpl implements WalletCacheDao {

	private static final String KEY_PAY_CALLBACK_FLAG = NAME_SPACE + "wallet:paycallbackflag:";

	@Override
	public boolean setPayCallbackFlag(String out_trade_no) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				if (out_trade_no == null) {
					return null;
				}
				byte[] key = (KEY_PAY_CALLBACK_FLAG + out_trade_no).getBytes();
				byte[] value = out_trade_no.getBytes();
				connection.set(key, value);
				connection.expire(key, 24 * 60 * 60);
				return true;
			}
		});
	}

	@Override
	public String getPayCallbackFlag(String out_trade_no) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_PAY_CALLBACK_FLAG + out_trade_no).getBytes();
				byte[] value = connection.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}
		});
	}

	@Override
	public boolean clearPayCallbackFlag(String out_trade_no) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_PAY_CALLBACK_FLAG + out_trade_no).getBytes();
				connection.del(key);
				return true;
			}
		});
	}

}
