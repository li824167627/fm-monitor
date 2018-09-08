package com.fm.portal.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fm.portal.cache.dao.AccountCacheDao;
import com.fm.portal.cache.dao.CommonCacheDao;
import com.fm.portal.controller.res.bean.RUserBean;
import com.fm.portal.model.UserBean;
import com.fm.portal.model.UserLoginLogBean;
import com.fm.portal.model.vo.UserAuthVo;
import com.fm.portal.persist.dao.ContactDao;
import com.fm.portal.persist.dao.MsgDao;
import com.fm.portal.persist.dao.UserAuthDao;
import com.fm.portal.persist.dao.UserDao;
import com.fm.portal.persist.dao.UserLoginLogDao;
import com.fm.portal.service.exception.ServiceException;
import com.northend.util.AppTextUtil;
import com.northend.util.MD5Util;
import com.northend.util.StringUtil;



@ContextConfiguration(locations = {"classpath:resources/*.xml"})
public class AccountServiceTest  {
	
	@Autowired
	ContactDao contactDao;
	@Autowired
	UserDao userImpl;

	@Autowired
	UserAuthDao userAuthImpl;

	@Autowired
	AccountCacheDao accountCacheImpl;

	@Autowired
	CommonCacheDao commonCacheImpl;

	@Autowired
	UserLoginLogDao userLoginLogImpl;

	@Autowired
	MsgDao msgImpl;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public RUserBean testLogin(String phone, String password, String vcode, int type, String deviceId, String os,
			String model, int formType, String resolution, int loginPort) {
		RUserBean result = new RUserBean();
		String cachCode = accountCacheImpl.getVCode(1, phone); // 1 登录
		UserAuthVo user = userImpl.selectOneByPhone(phone);
		if (type == 1) { // 1手机验证码登录
			if (StringUtil.isEmpty(cachCode)) {
				throw new ServiceException("vcode_is_expire");
			}
			if (!cachCode.equals(vcode)) {
				throw new ServiceException("vcode_is_error");
			}
			if (user == null) { // 用户不存在，做注册处理
				user = new UserAuthVo();
				String newId = AppTextUtil.getPrimaryKey();
				user.setId(newId);
				user.setPhone(phone);
				UserBean newuser = new UserBean();
				newuser.setId(newId);
				newuser.setPhone(phone);
				newuser.setPassword("");// 密码默认为空
				newuser.setName("");
				newuser.setLetter("");
				newuser.setIcon("");
				newuser.setGender(1);
				newuser.setIsSetPwd(0);// 是否设置密码 1设置 0未设置
				boolean flag = userImpl.insert(newuser) > 0;
				if (!flag) {
					throw new ServiceException("database_insert_fail", "用户");
				}
			}
		} else {// 账号密码登录
			
			if (user == null) {// 未注册登录不了
				throw new ServiceException("login_account_password_error");

			}
			if (user.getIsSetPwd() == 0) {
				throw new ServiceException("user_password_not_set");
			}
			if (!user.getPassword().equals(MD5Util.md5(password))) {
				throw new ServiceException("login_account_password_error");
			}
		}

		String token = AppTextUtil.getToken();
		String id = user.getId();
		JSONObject acJson = new JSONObject();
		acJson.put("id", id);
		acJson.put("type", loginPort);
		accountCacheImpl.setToken(token, JSON.toJSONString(acJson), 7 * 24 * 3600);

		UserLoginLogBean logBean = new UserLoginLogBean();
		logBean.setUid(id);
		logBean.setDeviceId(deviceId);
		logBean.setOs(os);
		logBean.setModel(model);
		logBean.setResolution(resolution);
		logBean.setOtype(1);
		logBean.setState(1);
		boolean flag = userLoginLogImpl.insert(logBean) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "用户登录");
		}

		flag = userImpl.updateLoginTime(user) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "用户登录时间");
		}

		if (loginPort == 1) {
			result = null;
		}

		result.setToken(token);

		return result;
	}

	@Test
	public void testThirdLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testThirdBindPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testSignOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateIcon() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePwd() {
		fail("Not yet implemented");
	}

	@Test
	public void testApplyAuth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuthInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserInfoByToken() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserById() {
		fail("Not yet implemented");
	}

}
