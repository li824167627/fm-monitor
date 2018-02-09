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
 * 文件-相关接口
 **/
@Controller
@RequestMapping(value = "/app/file", produces = "application/json")
public class SFileController {
	@Autowired
	com.fm.portal.controller.FileController fileController;

	/**
	 * 文件-微信上传文件
	 **/
	@RequestMapping("/v1/uploadWechatFile")
	@ResponseBody
	public ObjectResult<RQiniuFileBean> uploadWechatFile(@Validated UploadFileParam param, BindingResult error,
			HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RQiniuFileBean> res = new ObjectResult<RQiniuFileBean>();
		if (error.hasErrors()) {
			res.setRescode(BaseResult.param.getCode());
			res.setMsg(error.getFieldError().getDefaultMessage());
			return res;
		}

		return fileController.uploadWechatFile(param, request, response);
	}

	/**
	 * 七牛-配置信息
	 **/
	@RequestMapping("/v1/getQiNiuConfig")
	@ResponseBody
	public ObjectResult<RQiNiuConfigBean> getQiNiuConfig(HttpServletRequest request, HttpServletResponse response) {

		return fileController.getQiNiuConfig(request, response);
	}

	/**
	 * 七牛-上传文件
	 **/
	@RequestMapping("/v1/upload2QiNiuImage")
	@ResponseBody
	public ObjectResult<RQiniuFileBean> upload2QiNiuImage(HttpServletRequest request, HttpServletResponse response) {

		return fileController.upload2QiNiuImage(request, response);
	}

	/**
	 * 文件-上传图片
	 **/
	@RequestMapping("/v1/upload2FdfsImage")
	@ResponseBody
	public ObjectResult<RFdfsFileBean> upload2FdfsImage(HttpServletRequest request, HttpServletResponse response) {

		return fileController.upload2FdfsImage(request, response);
	}
}
