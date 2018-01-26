package com.fm.app.service;

import com.fm.app.controller.res.bean.RCarInfoBean;
import com.fm.app.controller.res.bean.RMsgBean;
import com.fm.app.controller.res.bean.ROrderQRcodeBean;
import com.fm.app.controller.res.bean.RPlotInfoBean;
import com.fm.app.controller.res.bean.RUserAddrBean;
import com.fm.app.model.UserBean;
import com.fm.app.service.impl.PageResult;

public interface UserService {

	/**
	 * 获取用户地址列表
	 * 
	 * @param user
	 * @param uid
	 * @return
	 */
	PageResult<RUserAddrBean> getAddrs2User(UserBean user, String uid);

	/**
	 * 新建编辑地址
	 * 
	 * @param user
	 * @param id
	 * @param plotId
	 * @param ext
	 * @param conPhone
	 * @param conName
	 * @return
	 */
	RUserAddrBean editAddr2Plot(UserBean user, int id, int plotId, String ext, String conPhone, String conName);

	/**
	 * 删除地址
	 * 
	 * @param user
	 * @param aid
	 * @return
	 */
	boolean removeAddr(UserBean user, int aid);

	/**
	 * 设置显示状态
	 * 
	 * @param user
	 * @param aid
	 * @param showType
	 * @return
	 */
	boolean setShowType(UserBean user, int aid, int showType);

	/**
	 * 获取小区地址
	 * 
	 * @param user
	 * @param key
	 * @return
	 */
	PageResult<RPlotInfoBean> getPlots(UserBean user, String key);

	/**
	 * 获取用户车辆
	 * 
	 * @param user
	 * @return
	 */
	PageResult<RCarInfoBean> getCars2User(UserBean user);

	/**
	 * 编辑新建车辆信息
	 * 
	 * @param user
	 * @param id
	 * @param number
	 * @return
	 */
	RCarInfoBean eidtCar(UserBean user, int id, String number);

	/**
	 * 删除车辆
	 * 
	 * @param user
	 * @param cid
	 * @return
	 */
	boolean delCar(UserBean user, int cid);

	ROrderQRcodeBean getOrderCode(UserBean user) throws Exception;

	PageResult<RMsgBean> getMsgs(UserBean user, int page, int pageSize, int type);

	boolean readMsg(UserBean user, int readType, int type, int mid);

	int getUnReadNUm(UserBean user);

}
