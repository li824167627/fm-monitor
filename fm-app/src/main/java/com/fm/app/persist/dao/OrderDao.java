package com.fm.app.persist.dao;

import java.util.List;

import com.fm.app.model.UserOrderBean;
import com.fm.app.model.UserOrderVisitBean;
import com.fm.app.model.UserVisitLogBean;
import com.fm.app.model.vo.UserOrderVisitVo;
import com.fm.app.model.vo.UserOrderVo;

public interface OrderDao {

	/**
	 * 插入工单表
	 * 
	 * @param order
	 * @return
	 */
	int insertOrder(UserOrderBean order);

	/**
	 * 插入门禁表
	 * 
	 * @param visit
	 * @return
	 */
	int insertOrderVist(UserOrderVisitBean visit);

	/**
	 * 获取工单信息
	 * 
	 * @param oid
	 * @return
	 */
	UserOrderBean selectOneById(String oid);

	/**
	 * 好友与群组下好友的来访信息
	 * 
	 * @param ov
	 * @return
	 */
	int insertUsersOrder(List<UserOrderVisitBean> ov);

	int selecOrders2UserCount(String uid, int type, String time, String name, int plotId);

	List<UserOrderVo> selectOrders2UserList(String uid, int type, String time, String name, int page, int pageSize,
			int plotId);

	int updateVisitState(UserOrderVisitBean update);

	int updateVisitAuth(UserOrderVisitBean update);

	UserOrderVisitVo selectVisitbyId(String oid);

	int insertVisitLog(UserVisitLogBean visitlog);

	UserOrderVo selectNowOrderVoById(String oid, String time);

	int updateAddr(UserOrderBean upOrder);

	int selecVisitLogs2SecCount(String uid);

	List<UserVisitLogBean> selectVisitLogs2Sec(String uid, int page, int pageSize);

	int selecOrders2TokenCount(String uid, int type, String time, String name, int plotId);

	List<UserOrderVo> selectOrders2Token(String uid, int type, String time, String name, int plotId);

	UserOrderVisitBean selectOneByOidUid(int oid, String id, Integer type);

	int updateVisitView(UserOrderVisitBean update);

	int updateOrderView(UserOrderBean updateorder);

}
