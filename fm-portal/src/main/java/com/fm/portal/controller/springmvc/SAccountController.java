package com.fm.portal.controller.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import com.fm.portal.controller.res.*;
import com.fm.portal.controller.res.bean.*;
import com.fm.portal.controller.springmvc.req.*;

/**
 * 账户-相关接口
 **/
@Controller
@RequestMapping(value = "/app/account", produces = "application/json")
public class SAccountController {
	@Autowired
	com.fm.portal.controller.AccountController accountController;

	/**
	 * 登录
	 **/
	@RequestMapping("/v1/login")
	@ResponseBody
	public ObjectResult<RUserBean> login(@Validated LoginParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserBean> res = new ObjectResult<RUserBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.login(param, request, response);
	}

	/**
	 * 第三方登录
	 **/
	@RequestMapping("/v1/thirdLogin")
	@ResponseBody
	public ObjectResult<RUserBean> thirdLogin(@Validated ThirdLoginParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserBean> res = new ObjectResult<RUserBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.thirdLogin(param, request, response);
	}

	/**
	 * 第三方登录时绑定手机号
	 **/
	@RequestMapping("/v1/thirdBindPhone")
	@ResponseBody
	public ObjectResult<RUserBean> thirdBindPhone(@Validated ThirdBindPhoneParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserBean> res = new ObjectResult<RUserBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.thirdBindPhone(param, request, response);
	}

	/**
	 * 修改手机号
	 **/
	@RequestMapping("/v1/updatePhone")
	@ResponseBody
	public BaseResult updatePhone(@Validated UpdatePhoneParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.updatePhone(param, request, response);
	}

	/**
	 * 更新头像
	 **/
	@RequestMapping("/v1/updateIcon")
	@ResponseBody
	public BaseResult updateIcon(@Validated UserHeadParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.updateIcon(param, request, response);
	}

	/**
	 * 更新密码
	 **/
	@RequestMapping("/v1/updatePwd")
	@ResponseBody
	public BaseResult updatePwd(@Validated EditPwdParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.updatePwd(param, request, response);
	}

	/**
	 * 用户认证
	 **/
	@RequestMapping("/v1/applyAuth")
	@ResponseBody
	public BaseResult applyAuth(@Validated ApplyAuthParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.applyAuth(param, request, response);
	}

	/**
	 * 获取用户当前认证信息
	 **/
	@RequestMapping("/v1/getAuthInfo")
	@ResponseBody
	public ObjectResult<RUserAuthBean> getAuthInfo(@Validated GetAuthInfoParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserAuthBean> res = new ObjectResult<RUserAuthBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.getAuthInfo(param, request, response);
	}

	/**
	 * 用户退出
	 **/
	@RequestMapping("/v1/signOut")
	@ResponseBody
	public BaseResult signOut(@Validated SignOutParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.signOut(param, request, response);
	}

	/**
	 * 验证手机验证码
	 **/
	@RequestMapping("/v1/checkVcode")
	@ResponseBody
	public ObjectResult<RCheckCodeBean> checkVcode(@Validated CheckVcodeParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RCheckCodeBean> res = new ObjectResult<RCheckCodeBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.checkVcode(param, request, response);
	}

	/**
	 * 根据token获取用户信息
	 **/
	@RequestMapping("/v1/getUserInfo")
	@ResponseBody
	public ObjectResult<RUserBean> getUserInfo(@Validated GetUserInfoParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserBean> res = new ObjectResult<RUserBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return accountController.getUserInfo(param, request, response);
	}
}
