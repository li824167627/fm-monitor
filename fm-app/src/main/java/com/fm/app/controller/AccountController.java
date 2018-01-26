package com.fm.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fm.app.controller.res.BaseResult;
import com.fm.app.controller.res.ObjectResult;
import com.fm.app.controller.res.bean.RCheckCodeBean;
import com.fm.app.controller.res.bean.RUserAuthBean;
import com.fm.app.controller.res.bean.RUserBean;
import com.fm.app.controller.springmvc.req.ApplyAuthParam;
import com.fm.app.controller.springmvc.req.CheckVcodeParam;
import com.fm.app.controller.springmvc.req.EditPwdParam;
import com.fm.app.controller.springmvc.req.GetAuthInfoParam;
import com.fm.app.controller.springmvc.req.GetUserInfoParam;
import com.fm.app.controller.springmvc.req.LoginParam;
import com.fm.app.controller.springmvc.req.SignOutParam;
import com.fm.app.controller.springmvc.req.ThirdBindPhoneParam;
import com.fm.app.controller.springmvc.req.ThirdLoginParam;
import com.fm.app.controller.springmvc.req.UpdatePhoneParam;
import com.fm.app.controller.springmvc.req.UserHeadParam;
import com.fm.app.model.UserBean;
import com.fm.app.service.AccountService;
import com.fm.app.service.exception.ServiceException;
import com.northend.util.NumUtil;

@Component
public class AccountController {

	Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	AccountService accountServiceImpl;

	/**
	 * 登录
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RUserBean> login(LoginParam param, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserBean> result = new ObjectResult<>();
		try {
			String phone = param.getPhone();
			String vcode = param.getVcode();
			String password = param.getPassword();
			int type = NumUtil.toInt(param.getType(), 1);
			int loginPort = NumUtil.toInt(param.getLoginPort(), 1);// 1用户2保安
			String deviceId = param.getDeviceId();
			String os = param.getOs();
			String model = param.getModel();
			int formType = NumUtil.toInt(param.getFromType(), 1);
			String resolution = param.getResolution();
			RUserBean rb = accountServiceImpl.login(phone, password, vcode, type, deviceId, os, model, formType,
					resolution, loginPort);
			result.setData(rb);
			result.setFlag(rb != null);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 三方登录
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RUserBean> thirdLogin(ThirdLoginParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RUserBean> result = new ObjectResult<>();
		try {
			int type = NumUtil.toInt(param.getType(), 1);
			String openId = param.getOpenid();
			String icon = param.getIcon();
			String deviceId = param.getDeviceId();
			int loginPort = NumUtil.toInt(param.getLoginPort(), 1);// 1用户2保安
			String os = param.getOs();
			String model = param.getModel();
			int formType = NumUtil.toInt(param.getFromType(), 1);
			String resolution = param.getResolution();
			RUserBean rb = accountServiceImpl.thirdLogin(openId, icon, type, deviceId, os, model, formType, resolution,
					loginPort);
			result.setData(rb);
			result.setFlag(rb != null);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 第三方绑定手机账号
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RUserBean> thirdBindPhone(ThirdBindPhoneParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RUserBean> result = new ObjectResult<RUserBean>();
		try {
			int type = NumUtil.toInt(param.getType(), 1);
			String openId = param.getOpenid();
			String icon = param.getIcon();
			String phone = param.getPhone();
			String vcode = param.getVcode();
			int loginPort = NumUtil.toInt(param.getLoginPort(), 1);// 1用户2保安
			RUserBean user = accountServiceImpl.thirdBindPhone(type, openId, icon, phone, vcode, loginPort);
			result.setFlag(user != null);
			result.setData(user);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 更新手机号
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult updatePhone(UpdatePhoneParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			String phone = param.getPhone();
			String vcode = param.getVcode();
			boolean flag = accountServiceImpl.updatePhone(user, phone, vcode);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 更新头像
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult updateIcon(UserHeadParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			String icon = param.getIcon();
			boolean flag = accountServiceImpl.updateIcon(user, icon);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 更新个人密码
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult updatePwd(EditPwdParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			String pwd = param.getPwd();
			String confirmPwd = param.getConfirmPwd();
			String checkToken = param.getCheckToken();
			boolean flag = accountServiceImpl.updatePwd(user, pwd, confirmPwd, checkToken);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 提交认证信息
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult applyAuth(ApplyAuthParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			String name = param.getName();
			Integer gender = NumUtil.toInt(param.getGender(), 1);// 1 男， 2 女
			String idNo = param.getIdNo();
			String idInfo = param.getIdInfo();
			boolean flag = accountServiceImpl.applyAuth(user, name, gender, idNo, idInfo);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 获取用户验证信息
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RUserAuthBean> getAuthInfo(GetAuthInfoParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RUserAuthBean> result = new ObjectResult<>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			RUserAuthBean rb = accountServiceImpl.getAuthInfo(user);
			result.setData(rb);
			result.setFlag(rb != null);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 登出
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult signOut(SignOutParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			String userId = (String) request.getAttribute("userId");
			boolean flag = accountServiceImpl.signOut(userId);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 验证手机验证是否通过
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RCheckCodeBean> checkVcode(CheckVcodeParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RCheckCodeBean> result = new ObjectResult<RCheckCodeBean>();
		try {
			String phone = param.getPhone();
			String vcode = param.getVcode();
			int type = NumUtil.toInt(param.getType(), 0);
			RCheckCodeBean checkToken = accountServiceImpl.checkCode(phone, vcode, type);
			result.setFlag(checkToken != null);
			result.setData(checkToken);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RUserBean> getUserInfo(GetUserInfoParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RUserBean> result = new ObjectResult<RUserBean>();
		try {
			String userId = (String) request.getAttribute("userId");
			String token = param.getToken();
			RUserBean user = accountServiceImpl.getUserInfoByToken(userId, token);
			result.setFlag(user != null);
			result.setData(user);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

}
