package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblCfgComdoclist;

public interface ComdoclistDao extends DAO<TblCfgComdoclist>{
	public List<TblCfgComdoclist> list();
	public List<TblCfgComdoclist> findDocByType(String type);
	public TblCfgComdoclist findDocByDid(String did);
	public void deleteComdocList();
}
