package com.fm.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面
 */
@Controller
@RequestMapping("/app/page")
public class PageController {

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	/**
	 * 保安认证
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/staffAuth")
	public ModelAndView staffAuth(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("staff/staffAuth");
		return mv;
	}

	/**
	 *我的帮助
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/help")
	public ModelAndView help(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/help");
		return mv;
	}
	
	
	/**
	 * 关于我们
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/aboutus")
	public ModelAndView aboutus(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/aboutus");
		return mv;
	}
	
	
	/**
	 * 法律条款
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/law")
	public ModelAndView law(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/law");
		return mv;
	}
	
	/**
	 * 用户协议
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/agreement")
	public ModelAndView agreement(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/agreement");
		return mv;
	}
	
	/**
	 * 注册协议
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/regAgreement")
	public ModelAndView regAgreement(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/reg_agreement");
		return mv;
	}

}
