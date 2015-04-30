package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblWarrantinfo;

public interface WarrantinfoDao extends DAO<TblWarrantinfo> {
	public TblWarrantinfo findWarrantinfoByWid(String wid);
	
	public List<String> findWarrantName(String type);
	public List<TblWarrantinfo> findWarrantByTypeAndName(String projectType, String projectName);
}
