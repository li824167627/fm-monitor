package com.fm.portal.persist.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.portal.model.UserOrderBean;
import com.fm.portal.model.UserOrderVisitBean;
import com.fm.portal.model.UserVisitLogBean;
import com.fm.portal.model.vo.UserOrderVisitVo;
import com.fm.portal.model.vo.UserOrderVo;
import com.fm.portal.persist.dao.OrderDao;
import com.northend.util.StringUtil;

@Repository
public class OrderImpl extends BaseImpl implements OrderDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".OrderMapper";

	@Override
	public int insertOrder(UserOrderBean order) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertOrder", order);
	}

	@Override
	public int insertOrderVist(UserOrderVisitBean visit) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertOrderVist", visit);
	}

	@Override
	public UserOrderBean selectOneById(String oid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneById", oid);
	}

	@Override
	public int insertUsersOrder(List<UserOrderVisitBean> ov) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertUsersOrder", ov);
	}

	@Override
	public int selecOrders2UserCount(String uid, int type, String time, String name, int plotId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("type", type);
		params.put("name", name);
		params.put("plotId", plotId);
		params.put("time", StringUtil.isEmpty(time) ? null : time);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selecOrders2UserCount", params);
	}

	@Override
	public List<UserOrderVo> selectOrders2UserList(String uid, int type, String time, String name, int page,
			int pageSize, int plotId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("type", type);
		params.put("name", name);
		params.put("time", StringUtil.isEmpty(time) ? null : time);
		params.put("start", page * pageSize);
		params.put("length", pageSize);
		params.put("plotId", plotId);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectOrders2UserList", params);
	}

	@Override
	public int selecOrders2TokenCount(String uid, int type, String time, String name, int plotId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("type", type);
		params.put("name", name);
		params.put("plotId", plotId);
		params.put("time", StringUtil.isEmpty(time) ? null : time);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selecOrders2TokenCount", params);
	}

	@Override
	public List<UserOrderVo> selectOrders2Token(String uid, int type, String time, String name, int plotId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("type", type);
		params.put("name", name);
		params.put("time", StringUtil.isEmpty(time) ? null : time);
		params.put("plotId", plotId);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectOrders2Token", params);
	}

	@Override
	public int updateVisitState(UserOrderVisitBean update) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateVisitState", update);
	}

	@Override
	public int updateVisitAuth(UserOrderVisitBean update) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateVisitAuth", update);
	}

	@Override
	public UserOrderVisitVo selectVisitbyId(String oid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectVisitbyId", oid);
	}

	@Override
	public int insertVisitLog(UserVisitLogBean visitlog) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertVisitLog", visitlog);
	}

	@Override
	public UserOrderVo selectNowOrderVoById(String oid, String time) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", oid);
		params.put("time", StringUtil.isEmpty(time) ? null : time);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOrderVoById", params);
	}

	@Override
	public int updateAddr(UserOrderBean upOrder) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateAddr", upOrder);
	}

	@Override
	public int selecVisitLogs2SecCount(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selecVisitLogs2SecCount", params);
	}

	@Override
	public List<UserVisitLogBean> selectVisitLogs2Sec(String uid, int page, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params.put("start", page * pageSize);
		params.put("length", pageSize);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectVisitLogs2Sec", params);
	}

	@Override
	public UserOrderVisitBean selectOneByOidUid(int oid, String id, Integer type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", id);
		params.put("oid", oid);
		params.put("type", type);

		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneByOidUid", params);
	}

	@Override
	public int updateVisitView(UserOrderVisitBean update) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateVisitView", update);
	}

	@Override
	public int updateOrderView(UserOrderBean updateorder) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateOrderView", updateorder);
	}

}
