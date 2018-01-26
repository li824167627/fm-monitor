package com.fm.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.portal.cache.dao.AccountCacheDao;
import com.fm.portal.constants.ConfigConstants;
import com.fm.portal.controller.res.bean.RCarInfoBean;
import com.fm.portal.controller.res.bean.RMsgBean;
import com.fm.portal.controller.res.bean.ROrderQRcodeBean;
import com.fm.portal.controller.res.bean.RPlotInfoBean;
import com.fm.portal.controller.res.bean.RUserAddrBean;
import com.fm.portal.model.CarInfoBean;
import com.fm.portal.model.MessageBean;
import com.fm.portal.model.PlotBean;
import com.fm.portal.model.UserAddrBean;
import com.fm.portal.model.UserBean;
import com.fm.portal.model.vo.PlotVo;
import com.fm.portal.model.vo.UserAddrVo;
import com.fm.portal.persist.dao.MsgDao;
import com.fm.portal.persist.dao.PlotDao;
import com.fm.portal.persist.dao.UserAddrDao;
import com.fm.portal.persist.dao.UserCarDao;
import com.fm.portal.persist.dao.UserDao;
import com.fm.portal.service.UserService;
import com.fm.portal.service.exception.ServiceException;
import com.northend.util.AppTextUtil;
import com.northend.util.DateUtil;
import com.northend.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	AccountCacheDao accountCacheImpl;

	@Autowired
	UserDao userImpl;

	@Autowired
	PlotDao plotImpl;

	@Autowired
	MsgDao msgImpl;

	@Override
	public PageResult<RUserAddrBean> getAddrs2User(UserBean user, String userId) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RUserAddrBean> result = new PageResult<RUserAddrBean>();
		List<RUserAddrBean> resList = new ArrayList<RUserAddrBean>();
		String uid = StringUtil.isEmpty(userId) ? user.getId() : userId;
		UserBean setUser = userImpl.selectOneByUid(uid);
		if (setUser == null) {
			throw new ServiceException("object_is_not_exist", "用户");
		}
		int showType = StringUtil.isEmpty(userId) ? 0 : 1;
		// int count = userAddrImpl.selectAddrs2UserCount(uid, showType);
		// if (count > 0) {
		//
		// List<UserAddrVo> lists = userAddrImpl.selectAddrs2UserList(uid, showType);
		// if (lists != null) {
		// RUserAddrBean rb = null;
		// for (UserAddrVo addr : lists) {
		// rb = new RUserAddrBean();
		// rb = parseAddr(addr);
		// resList.add(rb);
		// }
		// }
		// }
		// result.setData(resList);
		// result.setCount(count);
		return result;
	}

	/**
	 * 格式化数据
	 * 
	 * @param contact
	 * @return
	 */
	private RUserAddrBean parseAddr(UserAddrVo addr) {
		RUserAddrBean res = new RUserAddrBean();
		res.setAddr(addr.getPlotAddr());
		res.setId(addr.getId());
		res.setName(addr.getConName());
		res.setPhone(addr.getConPhone());
		res.setPlotName(addr.getPlotName());
		res.setPlotType(addr.getPlotType());
		res.setShowType(addr.getShowType());
		res.setUserId(addr.getUserId());
		res.setType(addr.getType());
		res.setExt(addr.getExt());
		res.setState(addr.getState());
		res.setReason(addr.getReason());
		return res;
	}

	private RUserAddrBean parseAddr(UserAddrBean addr) {
		RUserAddrBean res = new RUserAddrBean();
		res.setId(addr.getId());
		res.setName(addr.getConName());
		res.setPhone(addr.getConPhone());
		res.setShowType(addr.getShowType());
		res.setUserId(addr.getUserId());
		res.setPlotType(addr.getPlotType());
		res.setType(addr.getType());
		res.setExt(addr.getExt());
		res.setState(addr.getState());
		res.setReason(addr.getReason());
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public RUserAddrBean editAddr2Plot(UserBean user, int id, int plotId, String ext, String conPhone, String conName) {
		RUserAddrBean res = new RUserAddrBean();
		// if (user == null) {
		// throw new ServiceException("token_fail");
		// }
		// boolean flag = false;
		// String uid = user.getId();
		// UserAddrBean addr = userAddrImpl.selectOneById(id);
		// if (addr == null) {// 新建
		// PlotBean plot = plotImpl.selectOneById(plotId);
		// if (plot == null) {// 小区信息
		// throw new ServiceException("object_is_not_exist", "小区");
		// }
		// addr = new UserAddrBean();
		// addr.setExt(ext);
		// addr.setConName(conName);
		// addr.setConPhone(conPhone);
		// addr.setUserId(uid);
		// addr.setPlotId(plotId);
		// addr.setType(1);//
		// flag = userAddrImpl.insert(addr) > 0;
		// if (!flag) {
		// throw new ServiceException("database_insert_fail", "用户地址");
		// }
		// } else { // 编辑
		// addr.setExt(ext);
		// addr.setConName(conName);
		// addr.setConPhone(conPhone);
		// addr.setType(1);
		// addr.setState(0);// 更新后重新审核地址信息
		// flag = userAddrImpl.update(addr) > 0;
		// if (!flag) {
		// throw new ServiceException("database_update_fail", "用户地址");
		// }
		// }
		// res = parseAddr(addr);
		return res;
	}

	@Override
	public boolean removeAddr(UserBean user, int aid) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		// UserAddrBean addr = userAddrImpl.selectOneById(aid);
		// if (addr == null) {
		// throw new ServiceException("object_is_not_exist", "用户地址");
		// }
		// flag = userAddrImpl.delAddr(addr) > 0;
		// if (!flag) {
		// throw new ServiceException("object_is_not_exist", "联系人");
		// }
		return flag;
	}

	@Override
	public boolean setShowType(UserBean user, int aid, int showType) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		// UserAddrBean addr = userAddrImpl.selectOneById(aid);
		// if (addr == null) {
		// throw new ServiceException("object_is_not_exist", "用户地址");
		// }
		// UserAddrBean update = new UserAddrBean();
		// update.setId(aid);
		// update.setShowType(showType);
		// flag = userAddrImpl.update(update) > 0;
		// if (!flag) {
		// throw new ServiceException("object_is_not_exist", "联系人");
		// }
		return flag;
	}

	@Override
	public PageResult<RPlotInfoBean> getPlots(UserBean user, String key) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RPlotInfoBean> result = new PageResult<RPlotInfoBean>();
		List<RPlotInfoBean> resList = new ArrayList<RPlotInfoBean>();
		String uid = user.getId();
		int count = plotImpl.selectPlotCount(uid, key);
		if (count > 0) {

			List<PlotVo> lists = plotImpl.selectPlotList(uid, key);

			if (lists != null) {
				RPlotInfoBean rb = null;
				for (PlotVo plot : lists) {
					rb = new RPlotInfoBean();
					rb = parsePlot(plot);
					resList.add(rb);
				}
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	/**
	 * 格式化小区数据
	 * 
	 * @param plot
	 * @return
	 */
	private RPlotInfoBean parsePlot(PlotVo plot) {
		RPlotInfoBean res = new RPlotInfoBean();
		res.setAddress(plot.getAddress());
		res.setId(plot.getId());
		res.setName(plot.getName());
		res.setPropertyName(plot.getPropertyName());
		res.setType(plot.getType());
		return res;
	}

	@Override
	public PageResult<RCarInfoBean> getCars2User(UserBean user) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RCarInfoBean> result = new PageResult<RCarInfoBean>();
		List<RCarInfoBean> resList = new ArrayList<RCarInfoBean>();
		String uid = user.getId();
		// int count = userCarImpl.selectCount2User(uid);
		// if (count > 0) {
		// List<CarInfoBean> lists = userCarImpl.selectList2User(uid);
		// if (lists != null) {
		// RCarInfoBean rb = null;
		// for (CarInfoBean car : lists) {
		// rb = new RCarInfoBean();
		// rb = parseCar(car);
		// resList.add(rb);
		// }
		// }
		// }
		// result.setData(resList);
		// result.setCount(count);
		return result;
	}

	/**
	 * 格式化车辆信息
	 * 
	 * @param car
	 * @return
	 */
	private RCarInfoBean parseCar(CarInfoBean car) {
		RCarInfoBean res = new RCarInfoBean();
		res.setId(car.getId());
		res.setLetter(car.getLetter());
		res.setNo(car.getNo());
		res.setUid(car.getUserId());
		res.setCreatTime(car.getCreatTime() != null ? car.getCreatTime().getTime() / 1000 : null);
		return res;
	}

	@Override
	public RCarInfoBean eidtCar(UserBean user, int id, String number) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		CarInfoBean car = null; // userCarImpl.selectOneById(id);
		// if (car == null) {// 新建
		// car = new CarInfoBean();
		// }
		// car.setUserId(user.getId());
		// car.setLetter(number.substring(0, 1));
		// car.setNo(number.substring(1));
		// flag = userCarImpl.replaceCarInfo(car) > 0;
		// if (!flag) {
		// throw new ServiceException("database_insert_fail", "联系人");
		// }
		return parseCar(car);
	}

	@Override
	public boolean delCar(UserBean user, int cid) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		// CarInfoBean car = userCarImpl.selectOneById(cid);
		// if (car == null) {// 新建
		// throw new ServiceException("object_is_not_exist", "车辆信息");
		// }
		// flag = userCarImpl.delete(cid) > 0;
		// if (!flag) {
		// throw new ServiceException("database_delete_fail", "联系人");
		// }
		return flag;
	}

	@Override
	public ROrderQRcodeBean getOrderCode(UserBean user) throws Exception {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		ROrderQRcodeBean orderToken = new ROrderQRcodeBean();

		String token = AppTextUtil.getToken();
		String url = ConfigConstants.getInstance().getWebDomain() + "/download.html?orderToken=" + token
				+ "&actionType=1";
		orderToken.setQRcodeUrl("http://" + url);

		long second = DateUtil.restSecInDay();
		accountCacheImpl.setOrderToken(token, user.getId(), second + 7200);

		return orderToken;
	}

	@Override
	public PageResult<RMsgBean> getMsgs(UserBean user, int page, int pageSize, int type) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RMsgBean> result = new PageResult<RMsgBean>();
		List<RMsgBean> resList = new ArrayList<RMsgBean>();
		String uid = user.getId();
		int count = msgImpl.selecMsgs2UserCount(uid, type, -1);
		if (count > 0) {

			List<MessageBean> lists = msgImpl.selectMsgs2UserList(uid, type, page, pageSize, -1);
			if (lists != null) {
				RMsgBean rb = null;
				for (MessageBean msg : lists) {
					rb = new RMsgBean();
					rb = parseMsg(msg);
					resList.add(rb);
				}
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	private RMsgBean parseMsg(MessageBean msg) {
		RMsgBean res = new RMsgBean();
		res.setContent(msg.getContent());
		res.setExtras(msg.getExtras());
		res.setIsRead(msg.getIsRead());
		res.setMid(msg.getMid());
		res.setTitle(msg.getTitle());
		res.setContent(msg.getContent());
		res.setTname(msg.getTname());
		res.setTuid(msg.getTuid());
		res.setType(msg.getType());
		// res.setAddTimeStr(DateUtil.);
		res.setAddTime(msg.getAddTime() != null ? msg.getAddTime().getTime() / 1000 : null);
		return res;
	}

	@Override
	public boolean readMsg(UserBean user, int readType, int type, int mid) {
		boolean flag = false;
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		String uid = user.getId();
		if (readType == 1) { // 分类下消息
			int count = msgImpl.selectUnReadCout(uid, type);
			if (count > 0) {
				flag = msgImpl.updateIsRead2Type(uid, type) > 0;
				if (!flag) {
					throw new ServiceException("database_update_fail", "消息已读");
				}
			}
		} else {// id
			MessageBean msg = msgImpl.selectOneById(mid);
			if (msg == null) {
				throw new ServiceException("object_is_not_exist", "消息不存在");
			}
			flag = msgImpl.updateIsRead(msg) > 0;
			if (!flag) {
				throw new ServiceException("database_update_fail", "消息已读");
			}
		}
		return flag;
	}

	@Override
	public int getUnReadNUm(UserBean user) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		int count = msgImpl.selectUnReadCout(user.getId(), 0);
		return count;
	}

}
