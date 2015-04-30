package com.cq.dao;

import java.util.List;

import com.cq.dao.base.DAO;
import com.cq.table.TblCfgTaskgroup;

public interface TaskGroupDao extends DAO<TblCfgTaskgroup> {
	public List<TblCfgTaskgroup> findTaskGroupByTaskName(String taskName);
	public List<TblCfgTaskgroup> findTaskGroupAll();
	public List<TblCfgTaskgroup> findTaskGroupByTaskGroup(String taskGroup);
	public List<TblCfgTaskgroup> findTaskGroupByTaskNameAndTaskGroup(String taskName, String taskGroup);
	public List<TblCfgTaskgroup> findTaskGroupByTaskNameList(List<String> taskNameList);
}
