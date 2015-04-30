package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.ComdoclistDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgComdoclist;

public class ComdoclistDaoImpl extends BaseDao<TblCfgComdoclist> implements ComdoclistDao {
	public List<TblCfgComdoclist> list() {
		return findByHql("from TblCfgComdoclist cdl order by cdl.did");
	}
	
	public List<TblCfgComdoclist> findDocByType(String type) {
		return findByHql("from TblCfgComdoclist cdl WHERE cdl.file='"
					+ type + "' order by cdl.did");
	}

	public TblCfgComdoclist findDocByDid(String did) {
		return findByHql("from TblCfgComdoclist cdl WHERE cdl.did='"
				+ did + "'").get(0);
	}

	public void deleteComdocList() {
		List<TblCfgComdoclist> list = list();
		
		if (list != null && list.size() > 0) {
			getHibernateTemplate().deleteAll(list);
		}
	}
}
