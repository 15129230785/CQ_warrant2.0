package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblCountersign;

public interface CountersignDao extends DAO<TblCountersign> {
	public List<TblCountersign> findbyName(String wid,String name);
}
