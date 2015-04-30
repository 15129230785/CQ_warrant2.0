package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblCominfo;

public interface CominfoDao extends DAO<TblCominfo> {
	public List<TblCominfo> findCominfoByWildName(String name);
	public TblCominfo findCominfoByEid(String eid);
	public List<String> findCompanyNameList();
}
