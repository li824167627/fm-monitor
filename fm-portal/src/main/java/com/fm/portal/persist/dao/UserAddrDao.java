package com.fm.portal.persist.dao;

import java.util.List;

import com.fm.portal.model.UserAddrBean;
import com.fm.portal.model.vo.UserAddrVo;

public interface UserAddrDao {

	/**
	 * 获取用户地址数量
	 * 
	 * @param uid
	 * @param showType
	 * @return
	 */
	int selectAddrs2UserCount(String uid, int showType);

	/**
	 * 获取用户地址列表
	 * 
	 * @param uid
	 * @return
	 */
	List<UserAddrVo> selectAddrs2UserList(String uid, int showType);

	/**
	 * 查询用户地址信息
	 * 
	 * @param id
	 * @return
	 */
	UserAddrBean selectOneById(int id);

	/**
	 * 新建用户地址
	 * 
	 * @param addr
	 * @return
	 */
	int insert(UserAddrBean addr);

	/**
	 * 更新用户地址信息
	 * 
	 * @param addr
	 * @return
	 */
	int update(UserAddrBean addr);

	/**
	 * 删除地址
	 * 
	 * @param addr
	 * @return
	 */
	int delAddr(UserAddrBean addr);

}
