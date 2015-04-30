package com.cq.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.cq.dao.WarrantinfoDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblWarrantindex;
import com.cq.table.TblWarrantinfo;
import com.cq.util.WarrantException;

public class WarrantinfoDaoImpl extends BaseDao<TblWarrantinfo> implements
		WarrantinfoDao {
	static Logger log = Logger.getLogger(WarrantinfoDaoImpl.class);
	private String errorMsg;

	public TblWarrantinfo findWarrantinfoByWid(String wid) {
		List<TblWarrantinfo> wi = findByProperty("wid", wid);
		
		if (wi == null || wi.size() == 0) {
			return null;
		} else if (wi.size() == 1) {
			return (TblWarrantinfo) wi.get(0);
		} else {
			errorMsg = "有重复的担保项目编号";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
	}

	@Override
	public List<String> findWarrantName(String type) {
		List<String> nl = null;
		
		DetachedCriteria warrantindex = DetachedCriteria.forClass(TblWarrantindex.class);
		if ("0".equals(type)) {
			warrantindex.add(Restrictions.or(
					Restrictions.eq("type", '0'), Restrictions.eq("type", '1')));
		} else if ("1".equals(type)) {
			warrantindex.add(Restrictions.eq("type", '0'));
		} else if ("2".equals(type)) {
			warrantindex.add(Restrictions.eq("type", '1'));
		}
		warrantindex.setProjection(Projections.property("wid"));
		
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("name"));
		dc.setProjection(Projections.distinct(pl));
		dc.add(Property.forName("wid").in(warrantindex));
		
		nl = getHibernateTemplate().findByCriteria(dc);
		return nl;
	}
	
	public List<TblWarrantinfo> findWarrantByTypeAndName(String projectType,
			String projectName) {
		List<TblWarrantinfo> wl = null;
		
		DetachedCriteria warrantindex = DetachedCriteria.forClass(TblWarrantindex.class);
		if ("0".equals(projectType)) {
			warrantindex.add(Restrictions.or(
					Restrictions.eq("type", '0'), Restrictions.eq("type", '1')));
		} else if ("1".equals(projectType)) {
			warrantindex.add(Restrictions.eq("type", '0'));
		} else if ("2".equals(projectType)) {
			warrantindex.add(Restrictions.eq("type", '1'));
		}
		warrantindex.setProjection(Projections.property("wid"));
		
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		dc.add(Property.forName("wid").in(warrantindex));
		if (!(StringUtils.isBlank(projectName))) {
			dc.add(Restrictions.ilike("name", projectName, MatchMode.ANYWHERE));
		}

		wl = findByCriterias(dc);
		return wl;
	}

}
