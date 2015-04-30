package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.SrvchkDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgSrvchk;

public class SrvchkDaoImpl extends BaseDao<TblCfgSrvchk> implements SrvchkDao {
	public void deleteSrvchkList() {
		List<TblCfgSrvchk> list = list();
		
		if (list != null && list.size() > 0) {
			getHibernateTemplate().deleteAll(list);
		}
	}
}
