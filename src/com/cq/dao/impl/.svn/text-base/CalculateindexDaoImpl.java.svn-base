package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.CalculateindexDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgCalculateindex;

public class CalculateindexDaoImpl extends BaseDao<TblCfgCalculateindex> implements
		CalculateindexDao {
	public void deleteCalculateindexList() {
		List<TblCfgCalculateindex> list = list();
		
		if(list != null && list.size() > 0) {
			getHibernateTemplate().deleteAll(list);
		}
	}
}
