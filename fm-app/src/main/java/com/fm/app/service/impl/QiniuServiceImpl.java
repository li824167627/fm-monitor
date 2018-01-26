package com.fm.app.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fm.app.cache.dao.QiniuCache;
import com.fm.app.controller.res.bean.RQiniuFileBean;
import com.fm.app.service.QiniuService;
import com.fm.app.service.exception.ServiceException;
import com.northend.util.AppTextUtil;
import com.northend.util.MD5Util;
import com.northend.util.RandomUtil;
import com.northend.util.StringUtil;
import com.northend.util.qiniu.QiniuManager;
import com.northend.util.qiniu.QiniuReFile;
import com.qiniu.common.Zone;

@Service
public class QiniuServiceImpl implements QiniuService {
	Logger logger = Logger.getLogger(QiniuServiceImpl.class);

	@Autowired
	QiniuCache qiniuCacheImpl;

	private final String accessKey = "6fawAoYSDOZiamTCDHdu6SSWj9BEvPIBeg1b-AIO";
	private final String secretKey = "QyS6Z3lHJhFP67Wr2eklfYycARfvYWlLprOjeVBs";
	Zone zone = Zone.zone1();
	private final String bucket = "security";
	private final String qiniuLinkUrl = "http://oxwax4mfs.bkt.clouddn.com/";
	private final String qiniuCDNurl = null; // TODO 这是其他域名的cdn测试的

	QiniuManager qiniuManager = QiniuManager.getInstance(accessKey, secretKey, bucket, zone);

	@Override
	public String getToken() {
		return getQiniuToken();
	}

	@Override
	public String getQiniuLinkUrl() {
		return qiniuLinkUrl;
	}

	@Override
	public String getQiniuCDNurl() {
		return qiniuCDNurl;
	}

	// 七牛常用静态资源统一管理
	public static Map<String, String> QiNiuStaticRes = new HashMap<>();
	static {
		QiNiuStaticRes.put("guardBackground1.jpg", "guardBackground1.jpg");
		QiNiuStaticRes.put("area_v1.json", "area_v1.json");
		QiNiuStaticRes.put("lanseboxlogo512*512.png", "lanseboxlogo512*512.png");
		QiNiuStaticRes.put("res_submit_idcard_back.png", "res_submit_idcard_back.png");
		QiNiuStaticRes.put("res_submit_idcard_front.png", "res_submit_idcard_front.png");
		QiNiuStaticRes.put("res_full_body_picture.jpg", "res_full_body_picture.jpg");
		QiNiuStaticRes.put("res_head_picture.jpg", "res_head_picture.jpg");
		QiNiuStaticRes.put("res_recruit_security_staff_bg_image.png", "res_recruit_security_staff_bg_image.png");
	}

	public static String getQiNiuStaticResByKey(String key) {
		return QiNiuStaticRes.get(key);
	}

	/**
	 * 从微信上获取文件
	 * 
	 * @param access_token
	 * @param media_id
	 * @return
	 */
	private byte[] getFileFromWxServer(String access_token, String media_id) {

		return null;
	}

	/**
	 * 获取七牛 token
	 * 
	 * @return
	 */
	private String getQiniuToken() {
		long expireSeconds = 3600;
		String token = qiniuCacheImpl.getToken();
		if (token == null) {
			token = qiniuManager.getToken(expireSeconds);
			qiniuCacheImpl.setToken(token, expireSeconds - 200);
		}
		return token;
	}

	@Override
	public RQiniuFileBean uploadFile(String media_id) {

		// String access_token = wechatServiceImpl.getAccessToken();
		String access_token = "";

		byte[] value = getFileFromWxServer(access_token, media_id);

		logger.info("value size is :" + value.length);

		String qiniuToken = getQiniuToken();
		QiniuReFile file = qiniuManager.upload(qiniuToken,
				MD5Util.md5(System.currentTimeMillis() + RandomUtil.getRandomCharAndNum(10)), value);

		if (file != null) {
			RQiniuFileBean data = new RQiniuFileBean();
			data.setKey(file.getKey());
			data.setImgH(file.getImgH());
			data.setImgW(file.getImgW());
			if (qiniuCDNurl == null) {
				data.setUrl(qiniuLinkUrl + file.getKey());
			} else {
				data.setUrl(qiniuCDNurl + file.getKey());
			}

			return data;
		}

		return null;
	}

	@Override
	public RQiniuFileBean uploadImgFile(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 不是文件
		if (!multipartResolver.isMultipart(request)) {
			throw new ServiceException("param_is_error", "文件");
		}
		// 转换成多部分request
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request;
		// 文件类型限制
		String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
		byte[] value;
		// 取得request中的所有文件名
		Iterator<String> iter = multRequest.getFileNames();
		try {
			while (iter.hasNext()) {
				MultipartFile file = multRequest.getFile(iter.next());
				if (file == null)
					continue;

				String uploadFileName = file.getOriginalFilename(); // 取得当前上传文件的文件名称
				if (StringUtil.isEmpty(uploadFileName)) // 如果名称为“” 说明该文件不存在
					continue;

				boolean allowed = Arrays.asList(allowedType).contains(file.getContentType());
				if (!allowed) {
					throw new ServiceException("imgType_not_allow", file.getContentType());
				}

				// 图片大小限制
				if (file.getSize() > 1024 * 1024 * 1000 * 2) { // 12M
					throw new ServiceException("img_too_large");
				}
				// 包含原始文件名的字符串
				String fi = file.getOriginalFilename();
				// 提取文件拓展名
				String fileNameExtension = fi.substring(fi.indexOf("."), fi.length());
				// 生成云端的真实文件名
				String remoteFileName = AppTextUtil.getFileKey() + fileNameExtension;
				value = file.getBytes();
				String qiniuToken = getQiniuToken();
				QiniuReFile qinuFile = qiniuManager.upload(qiniuToken, remoteFileName, value);
				if (qinuFile != null) {
					RQiniuFileBean data = new RQiniuFileBean();
					data.setKey(qinuFile.getKey());
					data.setImgH(qinuFile.getImgH());
					data.setImgW(qinuFile.getImgW());
					if (qiniuCDNurl == null) {
						data.setUrl(qiniuLinkUrl + qinuFile.getKey());
					} else {
						data.setUrl(qiniuCDNurl + qinuFile.getKey());
					}
					return data;
				}
			}
		} catch (IOException e) {
			throw new ServiceException("param_is_error", "上传文件");
		}
		return null;
	}

}
