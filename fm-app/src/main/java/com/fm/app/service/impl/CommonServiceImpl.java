package com.fm.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.northend.util.RandomUtil;
import com.northend.util.StringUtil;
import com.northend.util.aliMessage.MessageUtil;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.fm.app.cache.dao.AccountCacheDao;
import com.fm.app.cache.dao.CommonCacheDao;
import com.fm.app.constants.ConfigConstants;
import com.fm.app.controller.res.bean.RAreaBean;
import com.fm.app.controller.res.bean.RVersionBean;
import com.fm.app.model.SecurityBean;
import com.fm.app.model.UserBean;
import com.fm.app.model.UserVersionBean;
import com.fm.app.model.VersionBean;
import com.fm.app.persist.dao.UserDao;
import com.fm.app.persist.dao.UserLoginLogDao;
import com.fm.app.persist.dao.VersionDao;
import com.fm.app.service.CommonService;
import com.fm.app.service.QiniuService;
import com.fm.app.service.exception.ServiceException;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	AccountCacheDao accountCacheImpl;

	@Autowired
	UserDao userImpl;

	@Autowired
	VersionDao versionImpl;

	@Autowired
	UserLoginLogDao userLoginLogImpl;

	@Autowired
	CommonCacheDao commonCacheImpl;

	@Autowired
	QiniuService qiniuServiceImpl;

	@Override
	public boolean sendVCode(String phone, int type, String token) throws ServiceException {
		String vcode = accountCacheImpl.getVCode(type, phone);
		if (!StringUtil.isEmpty(vcode)) {
			throw new ServiceException("vcode_is_send");
		}
		// 用户
		if (type == 2) { // 找回密码

			String userId = accountCacheImpl.getUidByToken(token);
			if (StringUtil.isEmpty(userId)) {
				throw new ServiceException("token_fail");
			}
			UserBean user = userImpl.selectOneByPhone(phone);
			if (user == null) {
				throw new ServiceException("object_is_not_exist", "用户");
			}
		} else if (type == 4) {
			String userId = accountCacheImpl.getUidByToken(token);
			if (StringUtil.isEmpty(userId)) {
				throw new ServiceException("token_fail");
			}
			UserBean user = userImpl.selectOneByPhone(phone);
			if (user != null) {
				throw new ServiceException("object_is_exist", "手机绑定账号");
			}
		}

		vcode = RandomUtil.getRandomNum(4);
		accountCacheImpl.setVCode(type, phone, vcode, 60 * 10);// 十分钟
		MessageUtil.init(ConfigConstants.getInstance().getAliAccessKeyId(),
				ConfigConstants.getInstance().getAliAccessKeySecret(), ConfigConstants.getInstance().getAliSignName());
		// 发短信
		SendSmsResponse response = MessageUtil.sendIdentifyingCode(phone, vcode);
		System.out.println("短信接口返回的数据----------------");
		System.out.println("Code=" + response.getCode());
		System.out.println("Message=" + response.getMessage());
		return true;
	}

	@Override
	public RAreaBean getArea() {
		RAreaBean result = new RAreaBean();
		result.setUrl(qiniuServiceImpl.getQiniuLinkUrl() + QiniuServiceImpl.getQiNiuStaticResByKey("area_v1.json"));
		result.setVersion("area_v1");
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public RVersionBean selectVersion(UserBean user, int vercode) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		int maxVer = versionImpl.selectMaxVer2Type(1);
		if (vercode == maxVer) {
			throw new ServiceException("version_is_lastest");
		}
		VersionBean ver = versionImpl.selectMaxOne2Type(1);
		RVersionBean res = parse(ver);
		// 插入用户版本表
		UserVersionBean uv = new UserVersionBean();
		uv.setVerport(1);
		uv.setUserId(user.getId());
		uv.setVercode(vercode);
		boolean flag = versionImpl.insertUserVersion(uv) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "版本更新记录");
		}
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public RVersionBean selectVersion(SecurityBean user, int vercode) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		int maxVer = versionImpl.selectMaxVer2Type(2);
		if (vercode == maxVer) {
			throw new ServiceException("version_is_lastest");
		}
		VersionBean ver = versionImpl.selectMaxOne2Type(2);
		RVersionBean res = parse(ver);
		// 插入用户版本表
		UserVersionBean uv = new UserVersionBean();
		uv.setVerport(2);
		uv.setUserId(user.getSecId());
		uv.setVercode(vercode);
		boolean flag = versionImpl.insertUserVersion(uv) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "版本更新记录");
		}
		return res;
	}

	private RVersionBean parse(VersionBean ver) {
		RVersionBean res = new RVersionBean();
		res.setContent(ver.getContent());
		res.setCreateTime(ver.getCreateTime() != null ? ver.getCreateTime().getTime() / 1000 : null);
		res.setFmd5(ver.getFmd5());
		res.setFsize(ver.getFsize());
		res.setId(ver.getId());
		res.setUrl(ver.getUrl());
		res.setVercode(ver.getVercode());
		res.setVername(ver.getVername());
		res.setVerport(ver.getVerport());
		return res;
	}

}
