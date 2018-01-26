package com.fm.app.persist.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.app.model.UserBean;
import com.fm.app.model.UserGroupBean;
import com.fm.app.model.UserGroupMemberBean;
import com.fm.app.persist.dao.GroupDao;
import com.northend.util.StringUtil;

@Repository
public class GroupImpl extends BaseImpl implements GroupDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".GroupMapper";

	@Override
	public int selectGroups2UserCount(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectGroups2UserCount", params);

	}

	@Override
	public List<UserGroupBean> selectGroups2UserList(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectGroups2UserList", params);

	}

	@Override
	public int insertGroup(UserGroupBean group) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertGroup", group);
	}

	@Override
	public int insertGroupMembers(List<UserGroupMemberBean> members) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertGroupMembers", members);

	}

	@Override
	public UserGroupBean selectOneById(String gid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneById", gid);
	}

	@Override
	public int update(UserGroupBean newGroup) {
		return sqlSessionTemplate.update(NAME_SPACE + ".update", newGroup);

	}

	@Override
	public int del(UserGroupBean group) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".del", group);
	}

	@Override
	public int delMembers(Integer gid) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".delMembers", gid);
	}

	@Override
	public int delGroupMembers(List<UserGroupMemberBean> members) {
		return sqlSessionTemplate.delete(NAME_SPACE + ".delGroupMembers", members);
	}

	@Override
	public List<UserBean> selectUidByGroupId(String groupId) {
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectUidByGroupId", groupId);
	}

	@Override
	public int selectMemberCout2Group(String gid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", gid);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectMemberCout2Group", params);
	}

}
