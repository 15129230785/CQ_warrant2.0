package com.cq.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.cq.dao.ProductDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblProduct;

public class ProductDaoImpl extends BaseDao<TblProduct> implements
		ProductDao {
	public double getIncomeProportionSum(String eid) {
		double temp = 0;
		
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		dc.add(Restrictions.eq("eid", eid));
		dc.setProjection(Projections.sum("incomeProportion"));
		temp = sumByCriterias(dc);
		
		return temp;
	}
}
