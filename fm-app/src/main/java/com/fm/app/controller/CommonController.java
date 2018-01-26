package com.fm.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fm.app.controller.res.BaseResult;
import com.fm.app.controller.res.ObjectResult;
import com.fm.app.controller.res.bean.RAreaBean;
import com.fm.app.controller.res.bean.RVersionBean;
import com.fm.app.controller.springmvc.req.GetAreaParam;
import com.fm.app.controller.springmvc.req.SendVCodeParam;
import com.fm.app.controller.springmvc.req.UpgradeVersionParam;
import com.fm.app.model.UserBean;
import com.fm.app.service.CommonService;
import com.fm.app.service.QiniuService;
import com.fm.app.service.exception.ServiceException;
import com.northend.util.NumUtil;

@Component
public class CommonController {
	Logger logger = Logger.getLogger(CommonController.class);

	@Autowired
	CommonService commonServiceImpl;

	@Autowired
	QiniuService qiniuServiceImpl;

	public BaseResult sendVCode(SendVCodeParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			String phone = param.getPhone();
			int type = NumUtil.toInt(param.getType(), 1);
			String token = param.getToken();
			boolean flag = commonServiceImpl.sendVCode(phone, type, token);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	public ObjectResult<RAreaBean> area(GetAreaParam param, HttpServletRequest request, HttpServletResponse response) {
		ObjectResult<RAreaBean> result = new ObjectResult<>();
		RAreaBean areaBean = commonServiceImpl.getArea();
		result.setData(areaBean);
		return result;
	}

	public ObjectResult<RVersionBean> upgradeVersion(UpgradeVersionParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RVersionBean> result = new ObjectResult<RVersionBean>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			int vercode = NumUtil.toInt(param.getVercode(), 1);
			RVersionBean version = commonServiceImpl.selectVersion(user, vercode);
			result.setFlag(version != null);
			result.setData(version);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

}
