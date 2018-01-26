package com.fm.app.controller.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.app.controller.res.*;
import com.fm.app.controller.res.bean.*;
import com.fm.app.controller.springmvc.req.*;

import java.util.*;

/**
 * 公共-相关接口
 **/
@Controller
@RequestMapping(value = "/app/common", produces = "application/json")
public class SCommonController {
	@Autowired
	com.fm.app.controller.CommonController commonController;

	/**
	 * 发送验证码
	 **/
	@RequestMapping("/v1/sendVCode")
	@ResponseBody
	public BaseResult sendVCode(@Validated SendVCodeParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return commonController.sendVCode(param, request, response);
	}

	/**
	 * 全国区域
	 **/
	@RequestMapping("/v1/area")
	@ResponseBody
	public ObjectResult<RAreaBean> area(@Validated GetAreaParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RAreaBean> res = new ObjectResult<RAreaBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return commonController.area(param, request, response);
	}

	/**
	 * 更新版本
	 **/
	@RequestMapping("/v1/upgradeVersion")
	@ResponseBody
	public ObjectResult<RVersionBean> upgradeVersion(@Validated UpgradeVersionParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RVersionBean> res = new ObjectResult<RVersionBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return commonController.upgradeVersion(param, request, response);
	}
}
