package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.DeptinfoDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblDeptinfo;

public class DeptinfoDaoImpl extends BaseDao<TblDeptinfo> implements
		DeptinfoDao {
	public List<TblDeptinfo> findDeptinfoByEidAndName(String eid, String name) {
		return findByHql("from TblDeptinfo dept where dept.Eid='" + eid+ "'and dept.Name='" + name + "'");
	}
}
