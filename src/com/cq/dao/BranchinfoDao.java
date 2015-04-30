package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblBranchinfo;

public interface BranchinfoDao extends DAO<TblBranchinfo> {
	public List<TblBranchinfo> findBranchinfoByEidAndName(String eid, String name);
	public List<TblBranchinfo> findBranchinfoByEidAndName1(int kid,String eid, String name);
}
