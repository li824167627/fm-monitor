package com.fm.portal.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.csource.common.NameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fm.portal.controller.res.bean.RFdfsFileBean;
import com.fm.portal.service.FastDFSManager;
import com.fm.portal.service.FileService;
import com.fm.portal.service.exception.ServiceException;
import com.northend.util.StringUtil;

@Service
public class FileServiceImpl implements FileService {
	Logger logger = Logger.getLogger(FileServiceImpl.class);

	@Override
	public RFdfsFileBean uploadImg(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 不是文件
		if (!multipartResolver.isMultipart(request)) {
			throw new ServiceException("param_is_error", "文件");
		}
		// 转换成多部分request
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request;
		// 文件类型限制
		String[] allowedType = { "image/jpeg", "image/jpg", "image/png", "image/bmp", "image/gif" };
		// 取得request中的所有文件名
		Iterator<String> iter = multRequest.getFileNames();
		try {
			while (iter.hasNext()) {
				MultipartFile file = multRequest.getFile(iter.next());
				if (file == null)
					continue;

				String uploadFileName = file.getOriginalFilename(); // 取得当前上传文件的文件名称
				if (StringUtil.isEmpty(uploadFileName)) // 如果名称为 "" 说明该文件不存在
					continue;

				boolean allowed = Arrays.asList(allowedType).contains(file.getContentType());
				if (!allowed) {
					throw new ServiceException("imgType_not_allow", file.getContentType());
				}

				// 图片大小限制
				if (file.getSize() > 16777216) { // 16M
					throw new ServiceException("img_too_large");
				}
				// 包含原始文件名的字符串
				String fi = file.getOriginalFilename();
				// 提取文件拓展名
				// String fileNameExtension = fi.substring(fi.indexOf("."), fi.length());
				// 生成云端的真实文件名
				// String remoteFileName = AppTextUtil.getFileKey() + fileNameExtension;
				NameValuePair meta_list[] = new NameValuePair[] {};
				String fileIds[] = FastDFSManager.getInstance().upload(file.getBytes(),
						fi.substring(fi.indexOf(".") + 1), meta_list);
				if (fileIds != null && fileIds.length > 1) {
					RFdfsFileBean data = new RFdfsFileBean();
					if (!StringUtil.isEmpty(fileIds[1])) {
						if (fileIds[1].lastIndexOf("/") > 0) {
							data.setKey(fileIds[1].substring(fileIds[1].lastIndexOf("/") + 1));
						}
						if (fileIds[1].lastIndexOf(".") > 0) {
							data.setFormat(fileIds[1].substring(fileIds[1].lastIndexOf(".") + 1));
						}
					} else {
						data.setKey("");
						data.setFormat("");
					}
					data.setGroup(fileIds[0]);
					data.setGroupPath(fileIds[1]);
					data.setUrl("http://" + FastDFSManager.FDFS_SERVER_IP + ":" + FastDFSManager.FDFS_SERVER_PORT + "/"
							+ fileIds[0] + "/" + fileIds[1]);
					return data;
				}
			}
		} catch (IOException e) {
			throw new ServiceException("error", "IO异常");
		}
		return null;
	}

}
