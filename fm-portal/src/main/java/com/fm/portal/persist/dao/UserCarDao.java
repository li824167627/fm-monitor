package com.fm.portal.persist.dao;

import java.util.List;

import com.fm.portal.model.CarInfoBean;

public interface UserCarDao {
	/**
	 * 查询用户车辆数量
	 * 
	 * @param uid
	 * @return
	 */
	int selectCount2User(String uid);

	/**
	 * 查询用户车辆
	 * 
	 * @param uid
	 * @return
	 */
	List<CarInfoBean> selectList2User(String uid);

	/**
	 * 根据ID获取车辆信息
	 * 
	 * @param id
	 * @return
	 */
	CarInfoBean selectOneById(int id);

	/**
	 * 替换车辆信息，如果为空则插入新记录
	 * 
	 * @param car
	 * @return
	 */
	int replaceCarInfo(CarInfoBean car);

	/**
	 * 删除车辆信息
	 * 
	 * @param cid
	 * @return
	 */
	int delete(int cid);

}
