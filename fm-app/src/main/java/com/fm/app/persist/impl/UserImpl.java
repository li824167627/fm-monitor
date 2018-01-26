package com.fm.app.persist.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.app.model.UserBean;
import com.fm.app.model.UserThirdBean;
import com.fm.app.model.vo.UserAuthVo;
import com.fm.app.persist.dao.UserDao;

@Repository
public class UserImpl extends BaseImpl implements UserDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".UserMapper";

	@Override
	public UserAuthVo selectOneByPhone(String phone) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneByPhone", phone);
	}

	@Override
	public int insert(UserBean newuser) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", newuser);
	}

	@Override
	public int update(UserBean updateBean) {
		return sqlSessionTemplate.update(NAME_SPACE + ".update", updateBean);
	}

	@Override
	public int updateLoginTime(UserBean updateBean) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateLoginTime", updateBean);
	}

	@Override
	public UserAuthVo selectOneByOpenId(String openId) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneByOpenId", openId);
	}

	@Override
	public int insertThird(UserThirdBean third) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertThird", third);

	}

	@Override
	public UserBean selectOneByUid(String uid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneByUid", uid);
	}

	@Override
	public UserAuthVo selectAuthVoByUid(String uid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectAuthVoByUid", uid);
	}

	@Override
	public List<UserBean> selectListByIds(List<String> uids) {
		Map<String, Object> where = new HashMap<>();
		where.put("beans", uids);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectListByIds", where);
	}

}
