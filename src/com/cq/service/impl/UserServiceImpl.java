package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbpm.api.IdentityService;
import org.jbpm.api.identity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.CQGroupDao;
import com.cq.dao.CQMemberShipDao;
import com.cq.dao.CQUserDao;
import com.cq.service.UserService;
import com.cq.table.CQMemberShip;
import com.cq.table.CQUser;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class UserServiceImpl implements UserService {
	static Logger log = Logger.getLogger(UserServiceImpl.class);
	private String errorMsg;

	private IdentityService identityService;
	private CQGroupDao groupDao;
	private CQMemberShipDao memberShipDao;
	private CQUserDao userDao;
	
	/**
	 * 添加用户
	 * @throws WarrantException 
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String addUser(String name, String pass, String email) throws Exception {
		String givenName = null;
		
		try {
			User l = identityService.findUserById(name);
			if (l != null) {
				errorMsg = "要增加的用户在系统中已经存在";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			identityService.createUser(name, givenName, email, pass);
		} catch (Exception e) {
			errorMsg = "增加用户失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	/**
	 * 添加组
	 * @throws Exception
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String addGroup(String name) throws Exception {
		try {
			identityService.createGroup(name);
		} catch (Exception e) {
			errorMsg = "增加组失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	/**
	 * 添加关系
	 * @throws Exception 
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String addMemberShip(String userId, String groupId) throws Exception {
		try {
			identityService.createMembership(userId, groupId);
		} catch (Exception e) {
			errorMsg = "增加角色关系失败";
			tools.throwException(e, log, errorMsg);
		} 
		
		return "success";
	}

	/**
	 * sql数据库模糊查询id
	 * @throws Exception 
	 * */
	@Override
	public List<CQUser> getUserByWildId(String id) throws Exception {
		List<CQUser> uList = null;

		try {
//			String sql = "SELECT ID_ from jbpm4_id_user WHERE ID_ LIKE '%" + id
//					+ "%'";
			uList = userDao.findByWildProperty("id", id);
		} catch (Exception e) {
			errorMsg = "模糊查询用户失败";
			tools.throwException(e, log, errorMsg);
		}
		return uList;
	}

	@Override
	public CQUser getUserByName(String name) {
		return userDao.findOnlyByProperty("name", name);
	}

	/**
	 * 查询User数据
	 * @throws Exception 
	 * */
	@Override
	public List<User> userList() throws Exception {
		List<User> userList = null;
		try {
			userList = identityService.findUsers();
		} catch (Exception e) {
			errorMsg = "获取用户列表失败";
			tools.throwException(e, log, errorMsg);
		}
		return userList;
	}

	/**
	 * 根据userID查询部门
	 * @throws Exception 
	 * */
	@Override
	public List<String> groupList(String id) throws Exception {
		List<String> gl = null;

		try {
			gl = identityService.findGroupIdsByUser(id);
		} catch (Exception e) {
			errorMsg = "根据用户获取部门信息失败";
			tools.throwException(e, log, errorMsg);
		}
		return gl;
	}

	/**
	 * 删除用户及关系
	 * @throws Exception 
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String deleteUser(String s) throws Exception {
		try {
			identityService.deleteUser(s);
		} catch (Exception e) {
			errorMsg = "删除用户失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	/***
	 * 删除关系
	 * @throws Exception 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String deleteMemberShip(long kid) throws Exception {
		try {
			CQMemberShip ms = memberShipDao.get(kid);
			String user = ms.getUser().getId();
			String group = ms.getGroup().getId();
			identityService.deleteMembership(user, group, null);
		} catch (Exception e) {
			errorMsg = "删除组关系失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	/***
	 * 删除角色
	 * @throws Exception 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String deleteGroup(String user) throws Exception {
		try {
			identityService.deleteGroup(user);
		} catch (Exception e) {
			errorMsg = "删除组失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	/**
	 * 查询GROUP ID
	 * @throws Exception 
	 * */
	@Override
	public List<String> groupNameList() throws Exception {
		List<String> li = null;
		
		try {
			li = groupDao.getGroupNameList();
		} catch (Exception e) {
			errorMsg = "查找组名称列表失败";
			tools.throwException(e, log, errorMsg);
		}
		
		return li;
	}

	/**
	 * 修改邮箱
	 * @throws Exception 
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String updateEmail(String name, String email) throws Exception {
		try {
			CQUser user = (CQUser) identityService.findUserById(name);
			user.setEmail(email);
			userDao.update(user);
		} catch (Exception e) {
			errorMsg = "修改用户email邮箱失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	/**
	 * 通过JBDC给实体类Mem赋值
	 * */
	@Override
	public List<CQMemberShip> getMemberShip(String userid, String groupid) {
		List<CQMemberShip> ms = null;
		
		if (userid == null && groupid == null) {
			ms = memberShipDao.list();
		} else if (userid != null && groupid == null) {
			ms = memberShipDao.findMemberShipByUser(userid);
		} else if (userid == null && groupid != null) {
			ms = memberShipDao.findMemberShipByGroup(groupid);
		} else if (userid != null && groupid != null) {
			ms = memberShipDao.findMemberShipByUserAndGroup(userid, groupid);
		} else {
			ms = memberShipDao.list();
		}
		return ms;
	}

	/**
	 * 判断密码 1）密码中包含小写英文字母 2）密码中包含大写英文字母
	 * 3）密码中包含~`!@#$%ˆ&*()_-+={[]}|\:;”’<,>.?/等标点符号 4）密码中包含数字
	 * */
	@SuppressWarnings("unused")
	private String decide(String pass) {
		// String pass = "qwert";
		int d = 0;
		int nn = 0;
		int ns = 0;
		int nd = 0;
		int nx = 0;
		for (int i = 0; i < pass.length(); i++) {
			d = pass.charAt(i);
			if (d >= 48 && d <= 57) {
				nn = 1;
			}
			if (d >= 33 && d <= 47 || d >= 91 && d <= 96 || d >= 58 && d <= 64
					|| d >= 123 && d <= 126) {
				ns = 1;
			}
			if (d >= 65 && d <= 90) {
				nd = 1;
			}
			if (d >= 97 && d <= 122) {
				nx = 1;
			}
		}
		int z = ns + nd + nx + nn;
		if (z >= 3) {
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * 修改密码
	 * @throws Exception 
	 * */
	@Override
	public String updatePassword(String passWord, String name) throws Exception {
		String moddate = null;

		Date date = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			moddate = sdf.format(date);
		} catch (Exception e1) {
			errorMsg = "日期格式处理出现错误";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		try {
			CQUser user = (CQUser) identityService.findUserById(name);
			user.setPassword(passWord);
			user.setModdate(moddate);
			userDao.update(user);
			return "success";
		} catch (Exception e) {
			errorMsg = "修改用户密码失败";
			tools.throwException(e, log, errorMsg);
		}
		return "error";
	}
	
	@Override
	public List<String> findReviewUser() {
		return memberShipDao.findReviewUser();
	}
	
	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

	public void setUserDao(CQUserDao userDao) {
		this.userDao = userDao;
	}

	public void setGroupDao(CQGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public void setMemberShipDao(CQMemberShipDao memberShipDao) {
		this.memberShipDao = memberShipDao;
	}
}
