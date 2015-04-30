package com.cq.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cq.dao.BankinfoDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgBankinfo;

public class BankinfoDaoImpl extends BaseDao<TblCfgBankinfo> implements BankinfoDao {
	static Logger log = Logger.getLogger(BankinfoDaoImpl.class);
	
	public TblCfgBankinfo findBankinfoByBidAndDate(String bid, String date) {
		String hql = "";
		
		hql += "from TblCfgBankinfo bi where bi.bid = '"
				+ bid + "' and '" + date + "' between bi.startdate and bi.enddate";
		
		List<TblCfgBankinfo> lbi = findByHql(hql);
		if (lbi != null && lbi.size() == 1) {
			return (TblCfgBankinfo)lbi.get(0);
		} else {
			log.warn("银行信息表中没有配置符合要求的银行信息，请重新配置");
			return null;
		}
	}

	public int checkBankinfo(int id, String bid, String startDate, String endDate)
	{
		String hql = "";
		
		hql += "from TblCfgBankinfo bi where bi.bid = '"
				+ bid + "' and not ('" + endDate + "' " + " < bi.startdate or '" + startDate + "' > bi.enddate)"
				+ " and bi.id <> " + id;
		
		List<TblCfgBankinfo> lbi = findByHql(hql);
		if (lbi != null && lbi.size() > 0) {
			return lbi.size();
		}
		
		return 0;
	}
	
	public int checkBankinfo(String bid, String startDate, String endDate)
	{
		String hql = "";
		
		hql += "from TblCfgBankinfo bi where bi.bid = '"
				+ bid + "' and not ('" + endDate + "' " + " < bi.startdate or '" + startDate + "' > bi.enddate)";
		List<TblCfgBankinfo> lbi = findByHql(hql);
		if (lbi != null && lbi.size() > 0) {
			return lbi.size();
		}
		
		return 0;
	}

	public List<TblCfgBankinfo> findBankinfoByNow() {
		String hql = "from TblCfgBankinfo bi WHERE NOW() BETWEEN bi.startdate AND bi.enddate";
		return findByHql(hql);
	}
}
