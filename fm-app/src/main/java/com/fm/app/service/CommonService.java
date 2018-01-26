package com.fm.app.service;

import com.fm.app.controller.res.bean.RAreaBean;
import com.fm.app.controller.res.bean.RVersionBean;
import com.fm.app.model.SecurityBean;
import com.fm.app.model.UserBean;
import com.fm.app.service.exception.ServiceException;

public interface CommonService {

	/**
	 * 发送验证码
	 * 
	 * @param phone
	 * @param type
	 *            验证码类型： 1登录注册 ,2,找回密码，3修改密码，4首次绑定手机号，5更新手机号，6 验证手机号
	 * @param token
	 *            用户token
	 * @return
	 * @throws ServiceException
	 */
	boolean sendVCode(String phone, int type, String token) throws ServiceException;

	RAreaBean getArea();

	RVersionBean selectVersion(UserBean user, int vercode);

	RVersionBean selectVersion(SecurityBean sec, int vercode);

}
