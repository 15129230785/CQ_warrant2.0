package com.cq.service;

import java.util.List;

import com.cq.table.TblProjecthistory;

public interface ProjectHistoryService {
	public void addProcessHistory(String wid, String desc) throws Exception;
	public List<TblProjecthistory> getProcessHistory(String wid);
}
