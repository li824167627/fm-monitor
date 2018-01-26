package com.fm.portal.persist.dao;

import java.util.List;

import com.fm.portal.model.UserRelationBean;
import com.fm.portal.model.vo.UserContactVo;

public interface ContactDao {

	/**
	 * 获取用户所有联系人数量
	 * 
	 * @param id
	 * @param key
	 * @return
	 */
	int selectContacts2UserCount(String id, String key);

	/**
	 * 获取用户所有联系人
	 * 
	 * @param id
	 * @param key
	 * @return
	 */
	List<UserContactVo> selectContacts2UserList(String id, String key);

	/**
	 * 获取未添加过的联系人数量，不包括正在审核的
	 * 
	 * @param id
	 * @param key
	 * @return
	 */
	int selectContactsCount(String uid, String key);

	/**
	 * 获取未添加过的联系人，不包括正在审核的
	 * 
	 * @param id
	 * @param key
	 * @return
	 */
	List<UserContactVo> selectContactsList(String uid, String key);

	/**
	 * 获取申请的联系人数量
	 * 
	 * @param uid
	 * @return
	 */
	int selectApplyCount(String uid);

	/**
	 * 获取申请的联系人记录
	 * 
	 * @param uid
	 * @return
	 */
	List<UserContactVo> selectApplyList(String uid);

	/**
	 * 获取邀请的联系人数量
	 * 
	 * @param uid
	 * @return
	 */
	int selectInviteCount(String uid);

	/**
	 * 获取邀请的联系人
	 * 
	 * @param uid
	 * @return
	 */
	List<UserContactVo> selectInviteList(String uid);

	/**
	 * 获取分组内联系人数量
	 * 
	 * @param uid
	 * @return
	 */
	int selectGroupContactsCount(String groupId);

	/**
	 * 获取分组内联系人
	 * 
	 * @param uid
	 * @return
	 */
	List<UserContactVo> selectGroupContactsList(String groupId);

	/**
	 * 获取联系人关系
	 * 
	 * @param uid
	 * @param userId
	 * @return
	 */
	UserRelationBean selectOneByUid(String uid, String userId, Integer state);

	/**
	 * 插入联系人关系
	 * 
	 * @param ur
	 * @return
	 */
	int insert(UserRelationBean ur);

	/**
	 * 根据id查询联系人关系
	 * 
	 * @param uid
	 * @return
	 */
	UserRelationBean selectOneById(String id);

	/**
	 * 更新状态
	 * 
	 * @param updateUr
	 * @return
	 */
	int updateState(UserRelationBean updateUr);

	/**
	 * 查询已添加的好友和申请的好友列表
	 * 
	 * @param uid
	 * @param key
	 * @return
	 */
	List<UserContactVo> selectlinkedContacts2User(String uid, String key);

	int deletRelation(UserRelationBean ur);

	int deleteGroupUser(String uid, String userId);

	int selectGroupUser(String uid, String userId);

}
