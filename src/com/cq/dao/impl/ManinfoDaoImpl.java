package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.ManinfoDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblManinfo;

public class ManinfoDaoImpl extends BaseDao<TblManinfo> implements ManinfoDao {
	public List<TblManinfo> findManinfoBySql(String sql) {
		return findByHql(sql);
	}
}
