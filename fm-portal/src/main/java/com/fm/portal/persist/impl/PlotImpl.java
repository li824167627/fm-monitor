package com.fm.portal.persist.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.portal.model.PlotBean;
import com.fm.portal.model.vo.PlotVo;
import com.fm.portal.persist.dao.PlotDao;
import com.northend.util.StringUtil;

@Repository
public class PlotImpl extends BaseImpl implements PlotDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".PlotMapper";

	@Override
	public PlotBean selectOneById(int plotId) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneById", plotId);
	}

	@Override
	public List<PlotVo> selectPlotList(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectPlotList", params);
	}

	@Override
	public int selectPlotCount(String uid, String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("key", !StringUtil.isEmpty(key) ? key : null);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectPlotCount", params);
	}

}
