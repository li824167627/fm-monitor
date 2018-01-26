package com.fm.app.service;

import com.fm.app.controller.res.bean.RUserContactBean;
import com.fm.app.model.UserBean;
import com.fm.app.service.impl.PageResult;

public interface ContactService {

	/**
	 * 获取用户所有联系人
	 * 
	 * @param key
	 * @return
	 */
	PageResult<RUserContactBean> getContacts2User(UserBean user, String key);

	/**
	 * 获取未添加过的联系人，不包括正在审核的
	 * 
	 * @param key
	 * @return
	 */
	PageResult<RUserContactBean> getContacts(UserBean user, String key);

	/**
	 * 获取申请的联系人记录
	 * 
	 * @return
	 */
	PageResult<RUserContactBean> getContacts2Apply(UserBean user);

	/**
	 * 获取邀请的联系人记录
	 * 
	 * @return
	 */
	PageResult<RUserContactBean> getContacts2Invite(UserBean user);

	/**
	 * 获取分组内联系人
	 * 
	 * @param groupId
	 * @return
	 */
	PageResult<RUserContactBean> getContacts2Group(UserBean user, String groupId);

	/**
	 * 申请为联系人
	 * 
	 * @param user
	 * @param remark
	 * @param userId
	 * @return
	 */
	boolean apply(UserBean user, String remark, String userId);

	/**
	 * 同意添加为联系人
	 * 
	 * @param user
	 * @param aid
	 * @return
	 */
	boolean agree(UserBean user, String aid);

	/**
	 * 拒绝添加为联系人
	 * 
	 * @param user
	 * @param aid
	 * @return
	 */
	boolean reject(UserBean user, String aid);

	/**
	 * 删除联系人
	 * 
	 * @param user
	 * @param userId
	 * @return
	 */
	boolean remove(UserBean user, String userId);

	boolean removeReq(UserBean user, String id);

}
