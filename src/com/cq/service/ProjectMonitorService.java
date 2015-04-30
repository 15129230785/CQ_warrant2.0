package com.cq.service;

import java.util.List;

import com.cq.table.TblProjectmonitor;

public interface ProjectMonitorService {
	public List<TblProjectmonitor> getTblProjectmonitor(String wid);
	
	public String projectTrack(String taskid, String selValue, String wid, String finance,
			String work, String fund, String antiwarrant, String matter, String conclusion,
			String issue) throws Exception;
	public String loanDateWarrant(String taskid, String wid, String warrantLoanDate, String antiwarrant)
			throws Exception;
}
