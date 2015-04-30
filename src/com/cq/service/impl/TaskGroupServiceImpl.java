package com.cq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.jbpm.api.IdentityService;

import com.cq.bean.UserRight;
import com.cq.dao.TaskGroupDao;
import com.cq.service.TaskGroupService;
import com.cq.table.TblCfgTaskgroup;
import com.cq.util.GlobalData;
import com.cq.util.tools;

public class TaskGroupServiceImpl implements TaskGroupService {
	static Logger log = Logger.getLogger(TaskGroupServiceImpl.class);
	private String errorMsg;

	private IdentityService identityService;
	private TaskGroupDao taskgroupDao;

	public List<String> getTaskGroupList(String taskName) {
		List<String> gl = null;

		List<TblCfgTaskgroup> tgl = taskgroupDao.findTaskGroupByTaskName(taskName);
		if (tgl == null || tgl.size() == 0) {
			log.warn("根据任务名称获取处理该任务的用户组失败" + tgl);
			return null;
		}

		gl = new ArrayList<String>();
		for (int i = 0; i < tgl.size(); i++) {
			gl.add(tgl.get(i).getGroupid());
		}
		return gl;
	}

	public boolean addTaskGroupList(String taskName, String taskGroup)
			throws Exception {
		boolean boo = false;
		int number = 0;
		
		List<TblCfgTaskgroup> tgl = taskgroupDao.findTaskGroupByTaskName(taskName);
		if (null != tgl && 0 < tgl.size()) {
			for (int i = 0; i < tgl.size(); i++) {
				if (taskGroup.equals(tgl.get(i).getGroupid())) {
					return boo;
				}
			}
			number = tgl.get(tgl.size() - 1).getSeq() + 1;
		}

		try {
			TblCfgTaskgroup tg = new TblCfgTaskgroup();
			tg.setTaskid(taskName);
			tg.setGroupid(taskGroup);
			tg.setSeq(number);
			taskgroupDao.save(tg);
			boo = true;
		} catch (Exception e) {
			errorMsg = "添加" + taskName + "关系失败";
			tools.throwException(e, log, errorMsg);
		}
		return boo;
	}

	public boolean deleteTaskGroup(String taskName, String taskGroup)
			throws Exception {
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(TblCfgTaskgroup.class);
			dc.add(Restrictions.eq("taskid", taskName));
			dc.add(Restrictions.eq("groupid", taskGroup));
			
			List<TblCfgTaskgroup> tgl = taskgroupDao.findByCriterias(dc);
			if (tgl == null || tgl.size() == 0) {
				return false;
			} else if (tgl.size() > 1) {
				return false;
			} else {
				taskgroupDao.delete(tgl.get(0).getKid());
			}
		} catch (Exception e) {
			errorMsg = "删除" + taskName + "关系失败";
			tools.throwException(e, log, errorMsg);
		}
		return true;
	}
	
	public List<TblCfgTaskgroup> getTaskGroupList (String taskName, String taskGroup)
			throws Exception {
		List<TblCfgTaskgroup> list = null;
		
		if (StringUtils.isBlank(taskName) && StringUtils.isBlank(taskGroup)) {
			list = taskgroupDao.findTaskGroupAll();
		} else if (!StringUtils.isBlank(taskName) && StringUtils.isBlank(taskGroup)) {
			list = taskgroupDao.findTaskGroupByTaskName(taskName);
		} else if (StringUtils.isBlank(taskName) && !StringUtils.isBlank(taskGroup)) {
			list = taskgroupDao.findTaskGroupByTaskGroup(taskGroup);
		} else if (!StringUtils.isBlank(taskName) && !StringUtils.isBlank(taskGroup)) {
			list = taskgroupDao.findTaskGroupByTaskNameAndTaskGroup(taskName, taskGroup);
		}
		return list;
	}
	
	@Override
	public UserRight getUserRight() throws Exception {
		List<String> groupList = identityService.findGroupIdsByUser(tools.getLoginUser());
		List<String> temp = null;
		if((groupList == null) || (groupList.size() <= 0)) {
			log.warn("获取登录用户的组信息失败" + groupList);
			return null;
		}
		
		List<String> tnl = new ArrayList<String>();
		tnl.add("projectApply");
		tnl.add("clientManage");
		tnl.add("projectManage");
		List<TblCfgTaskgroup> tgl = taskgroupDao.findTaskGroupByTaskNameList(tnl);
		
		UserRight ur = new UserRight();
		temp = haveSameElements(groupList, GlobalData.antiWarrantGroups);
		if (temp.size() >0) {
			ur.setAntiWarrant(1);
		} else {
			ur.setAntiWarrant(0);
		}
		
		List<String> gl = getGroupListByTask("projectApply", tgl);
		if (gl == null) {
			ur.setProjectApply(0);
		} else {
			temp = haveSameElements(groupList, gl);
			if (temp.size() >0) {
				ur.setProjectApply(1);
			} else {
				ur.setProjectApply(0);
			}
		}
		
		gl = getGroupListByTask("clientManage", tgl);
		if (gl == null) {
			ur.setClientManage(0);
		} else {
			temp = haveSameElements(groupList, gl);
			if (temp.size() >0) {
				ur.setClientManage(1);
			} else {
				ur.setClientManage(0);
			}
		}
		
		gl = getGroupListByTask("projectManage", tgl);
		if (gl == null) {
			ur.setProjectManage(0);
		} else {
			temp = haveSameElements(groupList, gl);
			if (temp.size() >0) {
				ur.setProjectManage(1);
			} else {
				ur.setProjectManage(0);
			}
		}
		
		if (gl == null) {
			gl = new ArrayList<String>();
		} else {
			gl.clear();
		}
		gl.add("管理员");
		temp = haveSameElements(groupList, gl);
		if (temp.size() >0) {
			ur.setAdmin(1);
		} else {
			ur.setAdmin(0);
		}
		
		return ur;
	}
	
	private List<String> getGroupListByTask(String taskName, List<TblCfgTaskgroup> tgl) {
		if (tgl == null || tgl.size() == 0) {
			return null;
		}
		
		List<String> gl = new ArrayList<String>();
		for (int i = 0; i < tgl.size(); i++) {
			TblCfgTaskgroup tg = tgl.get(i);
			if (taskName.equals(tg.getTaskid())) {
				gl.add(tg.getGroupid());
			}
		}
		return gl;
	}
	
	private List<String> haveSameElements(List<String> a, List<String> b) {
		List<String> temp = new ArrayList<String>();
		temp.addAll(a);
		temp.retainAll(b);
		return temp;
	}

	public void setTaskgroupDao(TaskGroupDao taskgroupDao) {
		this.taskgroupDao = taskgroupDao;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
}
