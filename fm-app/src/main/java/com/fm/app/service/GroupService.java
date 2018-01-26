package com.fm.app.service;

import com.fm.app.controller.res.bean.RUserGroupBean;
import com.fm.app.model.UserBean;
import com.fm.app.service.impl.PageResult;

public interface GroupService {

	/**
	 * 获取用户所有分组
	 * 
	 * @param user
	 * @param key
	 * @return
	 */
	PageResult<RUserGroupBean> getGroups2User(UserBean user, String key);

	/**
	 * 添加分组
	 * 
	 * @param user
	 * @param name
	 * @param icon
	 * @return
	 */
	RUserGroupBean add(UserBean user, String name, String icon);

	/**
	 * 编辑分组名称
	 * 
	 * @param user
	 * @param name
	 * @param gid
	 * @return
	 */
	boolean editName(UserBean user, String name, String gid);

	/**
	 * 编辑分组图标
	 * 
	 * @param user
	 * @param name
	 * @param gid
	 * @return
	 */
	boolean editIcon(UserBean user, String icon, String gid);

	/**
	 * 删除分组
	 * 
	 * @param user
	 * @param gid
	 * @return
	 */
	boolean remove(UserBean user, String gid);

	/**
	 * 向分组添加联系人
	 * 
	 * @param user
	 * @param gid
	 * @param uids
	 * @return
	 */
	boolean addUsers(UserBean user, String gid, String uids);

	/**
	 * 删除分组内联系人
	 * 
	 * @param user
	 * @param gid
	 * @param uids
	 * @return
	 */
	boolean removeUsers(UserBean user, String gid, String uids);

}
