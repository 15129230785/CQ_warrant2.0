package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblCfgBankinfo;

public interface BankinfoDao extends DAO<TblCfgBankinfo> {
	public List<TblCfgBankinfo> findBankinfoByNow();
	public TblCfgBankinfo findBankinfoByBidAndDate(String bid, String date);
	public int checkBankinfo(String bid, String startDate, String endDate);
	public int checkBankinfo(int id, String bid, String startDate, String endDate);
}
