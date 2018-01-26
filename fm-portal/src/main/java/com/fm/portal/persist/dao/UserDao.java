package com.fm.portal.persist.dao;

import java.util.List;

import com.fm.portal.model.UserBean;
import com.fm.portal.model.UserThirdBean;
import com.fm.portal.model.vo.UserAuthVo;

public interface UserDao {

	UserAuthVo selectOneByPhone(String phone);

	int insert(UserBean newuser);

	int update(UserBean updateBean);

	int updateLoginTime(UserBean updateBean);

	UserAuthVo selectOneByOpenId(String openId);

	int insertThird(UserThirdBean third);

	UserBean selectOneByUid(String uid);

	UserAuthVo selectAuthVoByUid(String uid);

	List<UserBean> selectListByIds(List<String> uids);

}
