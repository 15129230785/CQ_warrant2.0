package com.cq.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.cq.dao.ShareholderDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblShareholder;

public class ShareholderDaoImpl extends BaseDao<TblShareholder> implements
		ShareholderDao {
	public double getStockProportionSum(String eid) {
		double temp = 0;
		
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		dc.add(Restrictions.eq("eid", eid));
		dc.setProjection(Projections.sum("proportion"));
		temp = sumByCriterias(dc);

		return temp;
	}
	
	public double getStockProportionSum(String eid, int kid) {
		double temp = 0;
		
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		dc.add(Restrictions.eq("eid", eid));
		dc.add(Restrictions.ne("kid", kid));
		dc.setProjection(Projections.sum("proportion"));
		temp = sumByCriterias(dc);

		return temp;
	}
}
