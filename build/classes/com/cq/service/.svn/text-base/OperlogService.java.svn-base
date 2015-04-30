package com.cq.service;

import java.util.List;

import com.cq.table.TblOperlog;

public interface OperlogService {
	public void logLogin(String user, String cause);
	public void logTableOperation(TblOperlog ol) throws Exception;
	public void logFileOperation(String user, String desc);
	
	public List<TblOperlog> getOperlog(String userName, 
			String startDate, String endDate, String opMode, int firstResult) throws Exception;//查询日志信息
	public int getCountPage(String userName,  String startDate,
			String endDate, String opMode, int firstResult) throws Exception;
}
