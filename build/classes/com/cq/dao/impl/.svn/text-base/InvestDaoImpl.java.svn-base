package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.InvestDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblInvest;

public class InvestDaoImpl extends BaseDao<TblInvest> implements InvestDao {
	public List<TblInvest> findInvestByEidAndName(String eid, String name) {
		String hql = "";
		hql = "from TblInvest invest where invest.eid = '" + eid + "' and invest.name = '" + name + "'";
		return findByHql(hql);
	}
	public List<TblInvest> findInvestByEidAndName1(int kid,String eid, String name) {
		String hql = "";
		hql = "from TblInvest invest where invest.eid = '" + eid + "' and invest.name = '" + name + "' and kid!="+kid;
		return findByHql(hql);
	}
}
