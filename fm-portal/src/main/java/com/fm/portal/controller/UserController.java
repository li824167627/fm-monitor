package com.fm.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fm.portal.controller.res.BaseResult;
import com.fm.portal.controller.res.ListResult;
import com.fm.portal.controller.res.ObjectResult;
import com.fm.portal.controller.res.bean.RCarInfoBean;
import com.fm.portal.controller.res.bean.RMsgBean;
import com.fm.portal.controller.res.bean.ROrderQRcodeBean;
import com.fm.portal.controller.res.bean.RPlotInfoBean;
import com.fm.portal.controller.res.bean.RUserAddrBean;
import com.fm.portal.controller.springmvc.req.DelCarParam;
import com.fm.portal.controller.springmvc.req.EditAddr2PlotParam;
import com.fm.portal.controller.springmvc.req.EditCarParam;
import com.fm.portal.controller.springmvc.req.GetAddr2UserParam;
import com.fm.portal.controller.springmvc.req.GetCars2UserParam;
import com.fm.portal.controller.springmvc.req.GetMsgsParam;
import com.fm.portal.controller.springmvc.req.GetOrderCodeParam;
import com.fm.portal.controller.springmvc.req.GetPlotsParam;
import com.fm.portal.controller.springmvc.req.GetUnReadNumParam;
import com.fm.portal.controller.springmvc.req.ReadMsgParam;
import com.fm.portal.controller.springmvc.req.RemoveAddrParam;
import com.fm.portal.controller.springmvc.req.SetAddrShowParam;
import com.fm.portal.model.UserBean;
import com.fm.portal.service.UserService;
import com.fm.portal.service.exception.ServiceException;
import com.fm.portal.service.impl.PageResult;
import com.northend.util.NumUtil;

@Component
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userServiceImpl;

	/**
	 * 获取用户地址
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ListResult<RUserAddrBean> getAddrs2User(GetAddr2UserParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ListResult<RUserAddrBean> result = new ListResult<>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			String uid = param.getUserId();
			PageResult<RUserAddrBean> resData = userServiceImpl.getAddrs2User(user, uid);
			if (resData != null) {
				result.setData(resData.getData());
				result.setTotalSize(resData.getCount());
			}
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 添加地址
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RUserAddrBean> editAddr2Plot(EditAddr2PlotParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RUserAddrBean> result = new ObjectResult<RUserAddrBean>();
		try {
			int id = NumUtil.toInt(param.getId(), 0);
			int plotId = NumUtil.toInt(param.getPlotId(), 0);
			String ext = param.getExt();
			String conPhone = param.getConPhone();
			String conName = param.getConName();
			UserBean user = (UserBean) request.getAttribute("user");
			RUserAddrBean addr = userServiceImpl.editAddr2Plot(user, id, plotId, ext, conPhone, conName);
			result.setFlag(addr != null);
			result.setData(addr);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 删除地址
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult remove(RemoveAddrParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			int aid = NumUtil.toInt(param.getAid(), 0);
			UserBean user = (UserBean) request.getAttribute("user");
			boolean flag = userServiceImpl.removeAddr(user, aid);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 设置显示状态
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult setShowType(SetAddrShowParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			int aid = NumUtil.toInt(param.getAid(), 0);
			int showType = NumUtil.toInt(param.getShowType(), 0);// 1显示 0不显示
			UserBean user = (UserBean) request.getAttribute("user");
			boolean flag = userServiceImpl.setShowType(user, aid, showType);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 获取小区地址
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ListResult<RPlotInfoBean> getPlots(GetPlotsParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ListResult<RPlotInfoBean> result = new ListResult<>();
		try {
			String key = param.getKey();
			UserBean user = (UserBean) request.getAttribute("user");
			PageResult<RPlotInfoBean> resData = userServiceImpl.getPlots(user, key);
			if (resData != null) {
				result.setData(resData.getData());
				result.setTotalSize(resData.getCount());
			}
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 获取用户车辆
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ListResult<RCarInfoBean> getCars2User(GetCars2UserParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ListResult<RCarInfoBean> result = new ListResult<>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			PageResult<RCarInfoBean> resData = userServiceImpl.getCars2User(user);
			if (resData != null) {
				result.setData(resData.getData());
				result.setTotalSize(resData.getCount());
			}
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	/**
	 * 编辑/新建车辆
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<RCarInfoBean> eidtCar(EditCarParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<RCarInfoBean> result = new ObjectResult<RCarInfoBean>();
		try {
			int id = NumUtil.toInt(param.getId(), 0);
			String number = param.getNumber();
			UserBean user = (UserBean) request.getAttribute("user");
			RCarInfoBean carInfo = userServiceImpl.eidtCar(user, id, number);
			result.setFlag(carInfo != null);
			result.setData(carInfo);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 删除车辆
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public BaseResult delCar(DelCarParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			int cid = NumUtil.toInt(param.getCid(), 0);
			UserBean user = (UserBean) request.getAttribute("user");
			boolean flag = userServiceImpl.delCar(user, cid);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 获取用户二维码信息
	 * 
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	public ObjectResult<ROrderQRcodeBean> getOrderCode(GetOrderCodeParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<ROrderQRcodeBean> result = new ObjectResult<ROrderQRcodeBean>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			ROrderQRcodeBean code = userServiceImpl.getOrderCode(user);
			result.setFlag(code != null);
			result.setData(code);
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	public ListResult<RMsgBean> getMsgs(GetMsgsParam param, HttpServletRequest request, HttpServletResponse response) {
		ListResult<RMsgBean> result = new ListResult<RMsgBean>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			int pageSize = NumUtil.toInt(param.getPageSize(), 20);
			int page = NumUtil.toInt(param.getPage(), 0);
			int type = NumUtil.toInt(param.getType(), 0);
			PageResult<RMsgBean> resData = userServiceImpl.getMsgs(user, page, pageSize, type);
			if (resData != null) {
				result.setData(resData.getData());
				result.setTotalSize(resData.getCount());
			}
		} catch (ServiceException e) {
			result.setServiceException(e);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setFlag(false);
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public BaseResult readMsg(ReadMsgParam param, HttpServletRequest request, HttpServletResponse response) {
		BaseResult result = new BaseResult();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			int readType = NumUtil.toInt(param.getReadType(), 1);// 1分类2一条
			int type = NumUtil.toInt(param.getType(), 1);
			int mid = NumUtil.toInt(param.getMid(), 0);
			boolean flag = userServiceImpl.readMsg(user, readType, type, mid);
			result.setFlag(flag);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

	public ObjectResult<Integer> getUnReadNUm(GetUnReadNumParam param, HttpServletRequest request,
			HttpServletResponse response) {
		ObjectResult<Integer> result = new ObjectResult<Integer>();
		try {
			UserBean user = (UserBean) request.getAttribute("user");
			int num = userServiceImpl.getUnReadNUm(user);
			result.setData(num);
		} catch (ServiceException e) {
			result.setServiceException(e);
		}
		return result;
	}

}
