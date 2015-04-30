package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.BranchinfoDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblBranchinfo;

public class BranchinfoDaoImpl extends BaseDao<TblBranchinfo> implements
		BranchinfoDao {
	
	public List<TblBranchinfo> findBranchinfoByEidAndName(String eid, String name) {
		String hql = "";
		
		hql += "from TblBranchinfo bi where bi.eid = '"
				+ eid + "' and name = '" + name + "'";
		
		return findByHql(hql);
	}
	
	public List<TblBranchinfo> findBranchinfoByEidAndName1(int kid,String eid,
			String name) {
		String hql = "";
		
		hql += "from TblBranchinfo bi where bi.eid = '"
				+ eid + "' and name = '" + name + "' and kid!="+kid;
		
		return findByHql(hql);
	}
}
