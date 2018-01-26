package com.fm.app.persist.dao;

import java.util.List;

import com.fm.app.model.UserBean;
import com.fm.app.model.UserGroupBean;
import com.fm.app.model.UserGroupMemberBean;

public interface GroupDao {

	/**
	 * 获取用户的分组数量
	 * 
	 * @param uid
	 * @param key
	 * @return
	 */
	int selectGroups2UserCount(String uid, String key);

	/**
	 * 获取用户的分组
	 * 
	 * @param uid
	 * @param key
	 * @return
	 */
	List<UserGroupBean> selectGroups2UserList(String uid, String key);

	/**
	 * 新建分组
	 * 
	 * @param group
	 * @return
	 */
	int insertGroup(UserGroupBean group);

	/**
	 * 插入分组成员
	 * 
	 * @param members
	 * @return
	 */
	int insertGroupMembers(List<UserGroupMemberBean> members);

	/**
	 * 根据id获取分组
	 * 
	 * @param gid
	 * @return
	 */
	UserGroupBean selectOneById(String gid);

	/**
	 * 更新分组
	 * 
	 * @param newGroup
	 * @return
	 */
	int update(UserGroupBean newGroup);

	/**
	 * 删除分组
	 * 
	 * @param group
	 * @return
	 */
	int del(UserGroupBean group);

	/**
	 * 删除分组下所有成员
	 * 
	 * @param id
	 * @return
	 */
	int delMembers(Integer id);

	/**
	 * 删除分组成员
	 * 
	 * @param members
	 * @return
	 */
	int delGroupMembers(List<UserGroupMemberBean> members);

	/**
	 * 获取群组下的用户
	 * 
	 * @param groupId
	 * @return
	 */
	List<UserBean> selectUidByGroupId(String groupId);

	int selectMemberCout2Group(String gid);

}
