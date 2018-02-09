package com.fm.portal.service;

import javax.servlet.http.HttpServletRequest;

import com.fm.portal.controller.res.bean.RFdfsFileBean;

public interface FileService {

	RFdfsFileBean uploadImg(HttpServletRequest request);

}
