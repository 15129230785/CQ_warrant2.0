package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.PersueDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblPersue;

public class PersueDaoImpl extends BaseDao<TblPersue> implements
			PersueDao {
	public TblPersue findPersueByWidAndMode(String wid, String mode) {
		String hql = "from TblPersue p where p.wid = '" + wid + "' and p.mode = '" + mode + "'";
		
		List<TblPersue> list = findByHql(hql);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
}
