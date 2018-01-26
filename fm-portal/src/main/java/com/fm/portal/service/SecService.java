package com.fm.portal.service;

import com.fm.portal.controller.res.bean.RCheckCodeBean;
import com.fm.portal.controller.res.bean.RMsgBean;
import com.fm.portal.controller.res.bean.RSecAuthBean;
import com.fm.portal.controller.res.bean.RSecStateBean;
import com.fm.portal.model.SecurityBean;
import com.fm.portal.service.impl.PageResult;

public interface SecService {

	boolean signOut(String userId);

	boolean authSec(SecurityBean sec, String name, int gender, String idNo, String idInfo, double height, String health,
			String photo, String secNo, String station, String qualified);

	RSecStateBean getSecState(SecurityBean sec);

	RSecAuthBean getUserInfoByToken(String userId, String token);

	RSecAuthBean login(String phone, String password, String vcode, int type, String deviceId, String os, String model,
			int formType, String resolution);

	RSecAuthBean thirdLogin(String openId, String icon, int type, String deviceId, String os, String model,
			int formType, String resolution);

	RSecAuthBean thirdBindPhone(int type, String openId, String icon, String phone, String vcode);

	SecurityBean getSecUserById(String sid);

	boolean updatePhone(SecurityBean sec, String phone, String vcode);

	boolean updateIcon(SecurityBean sec, String icon);

	boolean updatePwd(SecurityBean sec, String pwd, String confirmPwd, String checkToken);

	RCheckCodeBean checkCode(String phone, String vcode, int type);

	boolean sendVCode(String phone, int type, String token);

	PageResult<RMsgBean> getMsgs(SecurityBean sec, int page, int pageSize, int type);

	boolean readMsg(SecurityBean sec, int readType, int type, int mid);

	int getUnReadNUm(SecurityBean sec);

}
