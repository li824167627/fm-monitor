package com.fm.portal.persist.dao;

import java.util.List;

import com.fm.portal.model.PlotBean;
import com.fm.portal.model.vo.PlotVo;

public interface PlotDao {

	/**
	 * 根据id获取小区信息
	 * 
	 * @param plotId
	 * @return
	 */
	PlotBean selectOneById(int plotId);

	/**
	 * 查询小区列表
	 * 
	 * @param uid
	 * @param key
	 * @return
	 */
	List<PlotVo> selectPlotList(String uid, String key);

	/**
	 * 查询小区数量
	 * 
	 * @param uid
	 * @param key
	 * @return
	 */
	int selectPlotCount(String uid, String key);

}
