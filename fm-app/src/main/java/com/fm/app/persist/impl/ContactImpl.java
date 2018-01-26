package com.fm.app.persist.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.app.model.UserRelationBean;
import com.fm.app.model.vo.UserContactVo;
import com.fm.app.persist.dao.ContactDao;
import com.northend.util.StringUtil;

@Repository
public class ContactImpl extends BaseImpl implements ContactDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".ContactMapper";

	@Override
	public int selectContacts2UserCount(String userId, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectContacts2UserCount", params);
	}

	@Override
	public List<UserContactVo> selectContacts2UserList(String userId, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectContacts2UserList", params);
	}

	@Override
	public int selectContactsCount(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectContactsCount", params);
	}

	@Override
	public List<UserContactVo> selectContactsList(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectContactsList", params);
	}

	@Override
	public int selectApplyCount(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectApplyCount", params);
	}

	@Override
	public List<UserContactVo> selectApplyList(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectApplyList", params);
	}

	@Override
	public int selectInviteCount(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectInviteCount", params);
	}

	@Override
	public List<UserContactVo> selectInviteList(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectInviteList", params);
	}

	@Override
	public int selectGroupContactsCount(String groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectGroupContactsCount", params);
	}

	@Override
	public List<UserContactVo> selectGroupContactsList(String groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectGroupContactsList", params);
	}

	@Override
	public UserRelationBean selectOneByUid(String uid, String userId, Integer state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("toUserId", userId);
		params.put("state", state);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneByUid", params);
	}

	@Override
	public int insert(UserRelationBean ur) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", ur);
	}

	@Override
	public UserRelationBean selectOneById(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneById", params);
	}

	@Override
	public int updateState(UserRelationBean updateUr) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".updateState", updateUr);
	}

	@Override
	public List<UserContactVo> selectlinkedContacts2User(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectlinkedContacts2User", params);
	}

	@Override
	public int deletRelation(UserRelationBean ur) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".delete", ur);

	}

	@Override
	public int deleteGroupUser(String uid, String userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("conUserId", userId);
		return sqlSessionTemplate.delete(NAME_SPACE + ".deleteGroupUser", params);
	}

	@Override
	public int selectGroupUser(String uid, String userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("conUserId", userId);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectGroupUserCount", params);

	}

}
