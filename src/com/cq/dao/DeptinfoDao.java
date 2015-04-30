package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblDeptinfo;

public interface DeptinfoDao extends DAO<TblDeptinfo> {
	public List<TblDeptinfo> findDeptinfoByEidAndName(String eid, String name);
}
