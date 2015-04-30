package com.cq.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cq.dao.AnalysisindexDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgAnalysisindex;

public class AnalysisindexDaoImpl extends BaseDao<TblCfgAnalysisindex> implements AnalysisindexDao {
	static Logger log = Logger.getLogger(AnalysisindexDaoImpl.class);

	public void deleteAnalysisindexList() {
		List<TblCfgAnalysisindex> list = list();
		
		if(list != null && list.size() > 0) {
			getHibernateTemplate().deleteAll(list);
		}
	}
}
