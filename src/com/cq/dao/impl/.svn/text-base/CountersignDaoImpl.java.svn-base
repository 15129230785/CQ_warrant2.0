package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.CountersignDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCountersign;

public class CountersignDaoImpl extends BaseDao<TblCountersign> implements
		CountersignDao {
	public List<TblCountersign> findbyName(String wid, String name) {
		 return findByHql("from TblCountersign cs where cs.wid='" + wid+ "'and cs.name='" + name + "'");
	}
}
