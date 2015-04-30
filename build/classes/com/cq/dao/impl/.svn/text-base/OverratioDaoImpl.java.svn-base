package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.OverratioDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgOverratio;

public class OverratioDaoImpl extends BaseDao<TblCfgOverratio> implements
		OverratioDao {
	public void deleteOverratioList() {
		List<TblCfgOverratio> list = list();
		
		if (list != null && list.size() > 0) {
			getHibernateTemplate().deleteAll(list);
		}
	}
}
