package com.cq.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cq.dao.TaskGroupDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgTaskgroup;

public class TaskGroupDaoImpl extends BaseDao<TblCfgTaskgroup> implements TaskGroupDao {
	static Logger log = Logger.getLogger(TaskGroupDaoImpl.class);
	
	@Override
	public List<TblCfgTaskgroup> findTaskGroupByTaskName(String taskName) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.add(Restrictions.eq("taskid", taskName));
		dc.addOrder(Order.asc("seq"));
		return findByCriterias(dc);
	}

	@Override
	public List<TblCfgTaskgroup> findTaskGroupAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.addOrder(Order.asc("seq"));
		return findByCriterias(dc);
	}

	@Override
	public List<TblCfgTaskgroup> findTaskGroupByTaskGroup(String taskGroup) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.add(Restrictions.eq("groupid", taskGroup));
		dc.addOrder(Order.asc("seq"));
		return findByCriterias(dc);
	}

	@Override
	public List<TblCfgTaskgroup> findTaskGroupByTaskNameAndTaskGroup(
			String taskName, String taskGroup) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.add(Restrictions.eq("taskid", taskName));
		dc.add(Restrictions.eq("groupid", taskGroup));
		dc.addOrder(Order.asc("seq"));
		return findByCriterias(dc);
	}

	@Override
	public List<TblCfgTaskgroup> findTaskGroupByTaskNameList(List<String> taskNameList) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.add(Restrictions.in("taskid", taskNameList));
		dc.addOrder(Order.asc("seq"));
		return findByCriterias(dc);
	}
}
