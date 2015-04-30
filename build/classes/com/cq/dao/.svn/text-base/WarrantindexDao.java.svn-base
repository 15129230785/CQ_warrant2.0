package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblWarrantindex;

public interface WarrantindexDao extends DAO<TblWarrantindex> {
	public long getCountByTypeAndId(String wid, char type, String id);
	public List<TblWarrantindex> findWarrantInfoByIdAndType(String id, char type);
	public TblWarrantindex findByWid(String wid);
}
