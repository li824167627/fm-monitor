package com.fm.portal.service;

import javax.servlet.http.HttpServletRequest;

import com.fm.portal.controller.res.bean.RQiniuFileBean;

/**
 * 七牛的service
 */
public interface QiniuService {
	/**
	 * 获取七牛token
	 * 
	 * @return
	 */
	String getToken();

	/**
	 * 七牛外链接
	 * 
	 * @return
	 */
	String getQiniuLinkUrl();

	/**
	 * 获取七牛cdn链
	 * 
	 * @return
	 */
	String getQiniuCDNurl();

	/**
	 * 从微信获取文件并且，上传文件到七牛服务器
	 * 
	 * @param media_id
	 * @return
	 */
	RQiniuFileBean uploadFile(String media_id);

	/**
	 * 上传图片到七牛
	 * 
	 * @param request
	 * @return
	 */
	RQiniuFileBean uploadImgFile(HttpServletRequest request);
}
