package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.BasicratioDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblCfgBasicratio;

public class BasicratioDaoImpl extends BaseDao<TblCfgBasicratio> implements
		BasicratioDao {
	public void deleteBasicratioList() {
		List<TblCfgBasicratio> list = list();
		
		if (list != null && list.size() > 0) {
			getHibernateTemplate().deleteAll(list);
		}
	}
}
