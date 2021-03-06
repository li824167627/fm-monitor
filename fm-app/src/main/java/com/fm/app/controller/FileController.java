package com.fm.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fm.app.cache.dao.AccountCacheDao;
import com.fm.app.controller.res.ObjectResult;
import com.fm.app.controller.res.bean.RQiNiuConfigBean;
import com.fm.app.controller.res.bean.RQiniuFileBean;
import com.fm.app.controller.springmvc.req.UploadFileParam;
import com.fm.app.service.QiniuService;
import com.fm.app.service.exception.ServiceException;

@Component
public class FileController {

	@Autowired
	QiniuService qiniuServiceImpl;

	@Autowired
	AccountCacheDao accountCacheImpl;

	public ObjectResult<RQiniuFileBean> uploadFile(UploadFileParam param, HttpServletRequest request,
			HttpServletResponse response) {

		ObjectResult<RQiniuFileBean> result = new ObjectResult<>();
		try {
			String media_id = param.getMedia_id();
			RQiniuFileBean file = qiniuServiceImpl.uploadFile(media_id);
			result.setData(file);
			result.setFlag(file != null);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	public ObjectResult<RQiniuFileBean> uploadImage(HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RQiniuFileBean> result = new ObjectResult<>();
		try {
			RQiniuFileBean file = qiniuServiceImpl.uploadImgFile(request);
			result.setData(file);
			result.setFlag(file != null);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	public ObjectResult<RQiNiuConfigBean> getQiNiuConfig(HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RQiNiuConfigBean> result = new ObjectResult<RQiNiuConfigBean>();
		try {
			RQiNiuConfigBean rb = new RQiNiuConfigBean();
			String token = qiniuServiceImpl.getToken();
			rb.setToken(token);
			rb.setQiniuLinkUrl(qiniuServiceImpl.getQiniuLinkUrl());
			result.setData(rb);
			result.setFlag(true);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}
}
