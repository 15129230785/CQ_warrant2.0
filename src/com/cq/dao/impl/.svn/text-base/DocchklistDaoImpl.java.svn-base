package com.cq.dao.impl;

import java.util.List;

import com.cq.dao.DocchklistDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.TblDocchklist;

public class DocchklistDaoImpl extends BaseDao<TblDocchklist> implements
		DocchklistDao {
	public List<TblDocchklist> list(String wid, int num) {
		return findByHql("from TblDocchklist dcc where dcc.wid = '" + wid + "'and dcc.times=" + num + "");
	}
}
