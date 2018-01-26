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
 * 用户-相关接口
 **/
@Controller
@RequestMapping(value = "/app/user", produces = "application/json")
public class SUserController {
	@Autowired
	com.fm.app.controller.UserController userController;

	/**
	 * 获取用户地址信息
	 **/
	@RequestMapping("/v1/getAddrs2User")
	@ResponseBody
	public ListResult<RUserAddrBean> getAddrs2User(@Validated GetAddr2UserParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ListResult<RUserAddrBean> res = new ListResult<RUserAddrBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.getAddrs2User(param, request, response);
	}

	/**
	 * 添加地址
	 **/
	@RequestMapping("/v1/editAddr2Plot")
	@ResponseBody
	public ObjectResult<RUserAddrBean> editAddr2Plot(@Validated EditAddr2PlotParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RUserAddrBean> res = new ObjectResult<RUserAddrBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.editAddr2Plot(param, request, response);
	}

	/**
	 * 删除地址
	 **/
	@RequestMapping("/v1/remove")
	@ResponseBody
	public BaseResult remove(@Validated RemoveAddrParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.remove(param, request, response);
	}

	/**
	 * 设置公开地址
	 **/
	@RequestMapping("/v1/setShowType")
	@ResponseBody
	public BaseResult setShowType(@Validated SetAddrShowParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.setShowType(param, request, response);
	}

	/**
	 * 获取工作区信息，物业信息，小区信息，地址
	 **/
	@RequestMapping("/v1/getPlots")
	@ResponseBody
	public ListResult<RPlotInfoBean> getPlots(@Validated GetPlotsParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ListResult<RPlotInfoBean> res = new ListResult<RPlotInfoBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.getPlots(param, request, response);
	}

	/**
	 * 获取用户车辆信息
	 **/
	@RequestMapping("/v1/getCars2User")
	@ResponseBody
	public ListResult<RCarInfoBean> getCars2User(@Validated GetCars2UserParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ListResult<RCarInfoBean> res = new ListResult<RCarInfoBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.getCars2User(param, request, response);
	}

	/**
	 * 编辑/添加车辆
	 **/
	@RequestMapping("/v1/editCar")
	@ResponseBody
	public ObjectResult<RCarInfoBean> eidtCar(@Validated EditCarParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RCarInfoBean> res = new ObjectResult<RCarInfoBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.eidtCar(param, request, response);
	}

	/**
	 * 删除车辆
	 **/
	@RequestMapping("/v1/delCar")
	@ResponseBody
	public BaseResult delCar(@Validated DelCarParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.delCar(param, request, response);
	}

	/**
	 * 获取用户二维码token
	 **/
	@RequestMapping("/v1/getOrderCode")
	@ResponseBody
	public ObjectResult<ROrderQRcodeBean> getOrderCode(@Validated GetOrderCodeParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<ROrderQRcodeBean> res = new ObjectResult<ROrderQRcodeBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.getOrderCode(param, request, response);
	}

	/**
	 * 获取消息记录
	 **/
	@RequestMapping("/v1/getMsgs")
	@ResponseBody
	public ListResult<RMsgBean> getMsgs(@Validated GetMsgsParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ListResult<RMsgBean> res = new ListResult<RMsgBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.getMsgs(param, request, response);
	}

	/**
	 * 消息已读
	 **/
	@RequestMapping("/v1/readMsg")
	@ResponseBody
	public BaseResult readMsg(@Validated ReadMsgParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		BaseResult res = new BaseResult();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.readMsg(param, request, response);
	}

	/**
	 * 消息未读数量
	 **/
	@RequestMapping("/v1/getUnReadNUm")
	@ResponseBody
	public ObjectResult<Integer> getUnReadNUm(@Validated GetUnReadNumParam param, BindingResult error, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<Integer> res = new ObjectResult<Integer>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return userController.getUnReadNUm(param, request, response);
	}
}
