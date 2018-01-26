package com.fm.app.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.fm.app.constants.ConfigConstants;
import com.fm.app.constants.StringConstants;
import com.fm.app.controller.res.bean.RUserContactBean;
import com.fm.app.model.MessageBean;
import com.fm.app.model.UserBean;
import com.fm.app.model.UserGroupBean;
import com.fm.app.model.UserRelationBean;
import com.fm.app.model.vo.UserContactVo;
import com.fm.app.persist.dao.ContactDao;
import com.fm.app.persist.dao.GroupDao;
import com.fm.app.persist.dao.MsgDao;
import com.fm.app.persist.dao.UserDao;
import com.fm.app.service.ContactService;
import com.fm.app.service.exception.ServiceException;
import com.fm.app.util.jpush.JpushUtil;
import com.northend.util.AppTextUtil;

@Service
public class ContactServiceImpl implements ContactService {
	Logger logger = Logger.getLogger(ContactServiceImpl.class);

	@Autowired
	ContactDao contactImpl;

	@Autowired
	GroupDao groupImpl;

	@Autowired
	UserDao userImpl;

	@Autowired
	MsgDao msgImpl;

	@Override
	public PageResult<RUserContactBean> getContacts2User(UserBean user, String key) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RUserContactBean> result = new PageResult<RUserContactBean>();
		List<RUserContactBean> resList = new ArrayList<RUserContactBean>();
		String uid = user.getId();
		int count = contactImpl.selectContacts2UserCount(uid, key);
		if (count > 0) {

			List<UserContactVo> lists = contactImpl.selectContacts2UserList(uid, key);

			if (lists != null) {
				RUserContactBean rb = null;
				for (UserContactVo contact : lists) {
					rb = new RUserContactBean();
					rb = parseContact(contact);
					resList.add(rb);
				}
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	/**
	 * 格式化数据
	 * 
	 * @param contact
	 * @return
	 */
	private RUserContactBean parseContact(UserContactVo contact) {
		UserRelationBean relation = contact.getRelation();
		RUserContactBean res = new RUserContactBean();
		res.setGender(contact.getGender());
		res.setIcon(contact.getIcon());
		res.setLetter(contact.getLetter());
		res.setName(contact.getName());
		res.setUserId(contact.getId());
		res.setPhone(contact.getPhone());
		if (relation != null) {
			res.setId(relation.getId());
			res.setActionTime(relation.getActionTime() != null ? relation.getActionTime().getTime() / 1000 : 0);
			res.setApplyTime(relation.getApplyTime() != null ? relation.getApplyTime().getTime() / 1000 : 0);
			res.setState(relation.getState());
			res.setRemark(relation.getRemark());
			res.setType(relation.getType());
		}
		return res;
	}

	@Override
	public PageResult<RUserContactBean> getContacts(UserBean user, String key) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RUserContactBean> result = new PageResult<RUserContactBean>();
		List<RUserContactBean> resList = new ArrayList<RUserContactBean>();
		String uid = user.getId();
		int count = contactImpl.selectContactsCount(uid, key);
		List<UserContactVo> lists = contactImpl.selectContactsList(uid, key);
		List<UserContactVo> contacts = contactImpl.selectlinkedContacts2User(uid, key);

		LinkedList<UserContactVo> AllLists = new LinkedList<>(lists);// 大集合用linkedlist
		Iterator<UserContactVo> iter = AllLists.iterator();// 采用Iterator迭代器进行数据的操作
		while (iter.hasNext()) {
			UserContactVo con = iter.next();
			if (contacts.contains(con)) {
				iter.remove();
			}
		}
		if (AllLists != null) {
			RUserContactBean rb = null;
			for (UserContactVo contact : AllLists) {
				rb = new RUserContactBean();
				rb = parseContact(contact);
				resList.add(rb);
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	@Override
	public PageResult<RUserContactBean> getContacts2Apply(UserBean user) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RUserContactBean> result = new PageResult<RUserContactBean>();
		List<RUserContactBean> resList = new ArrayList<RUserContactBean>();
		String uid = user.getId();
		int count = contactImpl.selectApplyCount(uid);
		if (count > 0) {

			List<UserContactVo> lists = contactImpl.selectApplyList(uid);

			if (lists != null) {
				RUserContactBean rb = null;
				for (UserContactVo contact : lists) {
					rb = new RUserContactBean();
					rb = parseContact(contact);
					resList.add(rb);
				}
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	@Override
	public PageResult<RUserContactBean> getContacts2Invite(UserBean user) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		PageResult<RUserContactBean> result = new PageResult<RUserContactBean>();
		List<RUserContactBean> resList = new ArrayList<RUserContactBean>();
		String uid = user.getId();
		int count = contactImpl.selectInviteCount(uid);
		if (count > 0) {

			List<UserContactVo> lists = contactImpl.selectInviteList(uid);

			if (lists != null) {
				RUserContactBean rb = null;
				for (UserContactVo contact : lists) {
					rb = new RUserContactBean();
					rb = parseContact(contact);
					resList.add(rb);
				}
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	@Override
	public PageResult<RUserContactBean> getContacts2Group(UserBean user, String groupId) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		UserGroupBean group = groupImpl.selectOneById(groupId);
		if (group == null) {
			throw new ServiceException("object_is_not_exist", "分组");
		}
		if (!user.getId().equals(group.getUserId())) {
			throw new ServiceException("group_is_not_user");
		}
		PageResult<RUserContactBean> result = new PageResult<RUserContactBean>();
		List<RUserContactBean> resList = new ArrayList<RUserContactBean>();
		int count = contactImpl.selectGroupContactsCount(groupId);
		if (count > 0) {

			List<UserContactVo> lists = contactImpl.selectGroupContactsList(groupId);

			if (lists != null) {
				RUserContactBean rb = null;
				for (UserContactVo contact : lists) {
					rb = new RUserContactBean();
					rb = parseContact(contact);
					resList.add(rb);
				}
			}
		}
		result.setData(resList);
		result.setCount(count);
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean apply(UserBean user, String remark, String userId) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		String uid = user.getId();
		UserRelationBean ur = contactImpl.selectOneByUid(uid, userId, null);
		if (ur != null) {
			if (ur.getState() == 2 || ur.getState() == 3) {// 删除的更新状态重新申请
				UserRelationBean updateUr = new UserRelationBean();
				updateUr.setId(ur.getId());
				updateUr.setState(0); // 重新申请
				updateUr.setType(1);// 主动添加
				updateUr.setApplyTime(new Timestamp(System.currentTimeMillis()));
				flag = contactImpl.updateState(updateUr) > 0;
				if (!flag) {
					throw new ServiceException("database_update_fail", "联系人");
				}
			} else if (ur.getState() == 1) { // 已经是好友
				throw new ServiceException("user_is_contact");
			}
		} else {
			ur = new UserRelationBean();
			ur.setId(AppTextUtil.getPrimaryKey());
			ur.setUserId(uid);
			ur.setToUserId(userId);
			ur.setState(0);
			ur.setType(1);// 自己添加
			ur.setRemark(remark);
			flag = contactImpl.insert(ur) > 0;
			if (!flag) {
				throw new ServiceException("database_insert_fail", "申请联系人");
			}
		}

		UserBean toUser = userImpl.selectOneByUid(userId);
		// 通知
		Map<String, String> extras = new HashMap<>();
		extras.put("type", "3");
		extras.put("userId", toUser.getId());
		extras.put("name", toUser.getName());
		extras.put("state", "0");
		String title = StringConstants.getInstance().getString("contact_title");
		String content = StringConstants.getInstance().getString("add_contact", new Object[] { user.getName() });
		String msgContent = "【" + ConfigConstants.getInstance().getAliSignName() + "】" + content;
		Set<String> alias = new HashSet<>();
		alias.add(toUser.getId());
		int code = 501;
		JpushUtil.init(ConfigConstants.getInstance().getJpushAppKey(), ConfigConstants.getInstance().getJpushSecret());

		MessageBean msg = new MessageBean();
		msg.setTitle(title);
		msg.setContent(msgContent);
		msg.setExtras(JSON.toJSONString(extras));
		msg.setType(3);
		msg.setTuid(toUser.getId());
		msg.setCode(code);
		msg.setLoginPort(1);// 用户端
		flag = msgImpl.insert(msg) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "好友消息");
		}

		JpushUtil.sendPushNotificationByAlias(alias, msgContent, title, extras);
		return flag;

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean agree(UserBean user, String aid) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		UserRelationBean ur = contactImpl.selectOneById(aid);
		if (ur == null) {
			throw new ServiceException("user_contact_add_not");
		}
		if (ur.getState() == 1) {
			throw new ServiceException("user_is_contact");
		}
		UserRelationBean updateUr = new UserRelationBean();
		updateUr.setId(aid);
		updateUr.setState(1);// 同意
		flag = contactImpl.updateState(updateUr) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "联系人");
		}
		// 同意后插入两条关系
		UserRelationBean newur = contactImpl.selectOneByUid(ur.getToUserId(), ur.getUserId(), null);
		if (newur != null) {
			updateUr = new UserRelationBean();
			updateUr.setId(newur.getId());
			updateUr.setState(1); // 好友
			updateUr.setApplyTime(new Timestamp(System.currentTimeMillis()));
			flag = contactImpl.updateState(updateUr) > 0;
			if (!flag) {
				throw new ServiceException("database_update_fail", "联系人");
			}
		} else {
			newur = new UserRelationBean();
			newur.setId(AppTextUtil.getPrimaryKey());
			newur.setUserId(ur.getToUserId());
			newur.setToUserId(ur.getUserId());
			newur.setState(1);
			newur.setType(2);// auto添加
			flag = contactImpl.insert(newur) > 0;
			if (!flag) {
				throw new ServiceException("database_insert_fail", "申请联系人");
			}
		}

		UserBean applyUser = userImpl.selectOneByUid(ur.getUserId());
		// 通知
		Map<String, String> extras = new HashMap<>();
		extras.put("type", "3");
		extras.put("userId", applyUser.getId());
		extras.put("name", applyUser.getName());
		extras.put("state", "1");
		String title = StringConstants.getInstance().getString("contact_title");
		String content = StringConstants.getInstance().getString("add_contact_success",
				new Object[] { user.getName() });
		String msgContent = "【" + ConfigConstants.getInstance().getAliSignName() + "】" + content;
		Set<String> alias = new HashSet<>();
		alias.add(applyUser.getId());
		int code = 502;
		JpushUtil.init(ConfigConstants.getInstance().getJpushAppKey(), ConfigConstants.getInstance().getJpushSecret());

		MessageBean msg = new MessageBean();
		msg.setTitle(title);
		msg.setContent(msgContent);
		msg.setExtras(JSON.toJSONString(extras));
		msg.setType(3);
		msg.setTuid(applyUser.getId());
		msg.setCode(code);
		msg.setLoginPort(1);// 用户端
		flag = msgImpl.insert(msg) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "好友消息");
		}

		JpushUtil.sendPushNotificationByAlias(alias, msgContent, title, extras);

		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean reject(UserBean user, String aid) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		UserRelationBean ur = contactImpl.selectOneById(aid);
		if (ur == null) {
			throw new ServiceException("user_contact_add_not");
		}
		if (ur.getState() == 1) {
			throw new ServiceException("user_is_contact");
		}
		if (ur.getState() == 2) {
			throw new ServiceException("contact_is_refuse");
		}
		UserRelationBean updateUr = new UserRelationBean();
		updateUr.setId(aid);
		updateUr.setState(2);// 拒绝
		flag = contactImpl.updateState(updateUr) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "联系人");
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean remove(UserBean user, String userId) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		String uid = user.getId();
		UserRelationBean ur = contactImpl.selectOneByUid(uid, userId, 1);// 好友
		if (ur == null) {
			throw new ServiceException("user_contact_add_not");
		}
		UserRelationBean updateUr = new UserRelationBean();
		updateUr.setId(ur.getId());
		updateUr.setState(3);// 拒绝
		flag = contactImpl.updateState(updateUr) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "联系人");
		}
		int groupNum = contactImpl.selectGroupUser(uid, userId);
		if (groupNum > 0) {// 如果有分组
			// 删除分组关系
			flag = contactImpl.deleteGroupUser(uid, userId) > 0;
			if (!flag) {
				throw new ServiceException("database_delete_fail", "分组联系人");
			}
		}

		return flag;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean removeReq(UserBean user, String id) {
		if (user == null) {
			throw new ServiceException("token_fail");
		}
		boolean flag = false;
		UserRelationBean ur = contactImpl.selectOneById(id);// 好友
		if (ur == null) {
			throw new ServiceException("user_contact_add_not");
		}
		flag = contactImpl.deletRelation(ur) > 0;
		if (!flag) {
			throw new ServiceException("database_delete_fail", "联系人请求");
		}
		return flag;
	}

}