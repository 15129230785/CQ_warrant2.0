package com.cq.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cq.dao.CQGroupDao;
import com.cq.dao.base.BaseDao;
import com.cq.table.CQGroup;

public class CQGroupDaoImpl extends BaseDao<CQGroup> implements CQGroupDao {
	public List<String> getGroupNameList() {
		List<String> idl = null;
		List<CQGroup> gl = null;

		gl = list();
		if (gl == null || gl.size() == 0) {
			log.warn("系统没有配置用户组信息");
			return null;
		}

		idl = new ArrayList<String>();
		for (int i = 0; i < gl.size(); i++) {
			CQGroup group = gl.get(i);
			idl.add(group.getName());
		}
		return idl;
	}
}
