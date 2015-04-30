package com.cq.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.cq.dao.CQMemberShipDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.CQGroup;
import com.cq.table.CQMemberShip;
import com.cq.table.CQUser;
import com.cq.util.GlobalData;

public class CQMemberShipDaoImpl extends BaseDao<CQMemberShip> implements
		CQMemberShipDao {
	public List<CQMemberShip> findMemberShipByUser(String userid) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.createAlias("user", "u");
		dc.add(Restrictions.eq("u.name", userid));
		return findByCriterias(dc);
	}

	public List<CQMemberShip> findMemberShipByGroup(String groupid) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.createAlias("group", "g");
		dc.add(Restrictions.eq("g.name", groupid));
		return findByCriterias(dc);
	}

	public List<CQMemberShip> findMemberShipByUserAndGroup(String userid,
			String groupid) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		
		dc.createAlias("user", "u");
		dc.createAlias("group", "g");
		dc.add(Restrictions.eq("u.name", userid));
		dc.add(Restrictions.eq("g.name", groupid));
		return findByCriterias(dc);
	}
	
	public List<String> findReviewUser() {
		/*String sql = "select name from jbpm4_cq_user"
				+ " where jbpm4_cq_user.name"
				+ " IN (select user from jbpm4_cq_membership, jbpm4_cq_group"
				+ " where group_ = jbpm4_cd_group.name"
				+ " and jbpm4_cq_group.name='" + tools.reviewGroupName + "')";*/
		
		DetachedCriteria dcgroup = DetachedCriteria.forClass(CQGroup.class);
		dcgroup.add(Restrictions.eq("name", GlobalData.reviewGroupName));
		dcgroup.setProjection(Projections.property("name"));
		
		DetachedCriteria dcuser = DetachedCriteria.forClass(CQUser.class);
		dcuser.setProjection(Projections.property("name"));
		
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		dc.createAlias("user", "u");
		dc.createAlias("group", "g");
		dc.setProjection(Projections.property("u.name"));
		dc.add(Property.forName("u.name").in(dcuser));
		dc.add(Property.forName("g.name").in(dcgroup));
		
		List<String> list = getHibernateTemplate().findByCriteria(dc);
		if (list == null || list.size() == 0) {
			log.warn("系统中没有配置评审委员会相关的组信息");
			return null;
		}
		return list;
	}
}
