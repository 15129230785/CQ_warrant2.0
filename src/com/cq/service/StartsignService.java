package com.cq.service;

import java.util.List;

import com.cq.table.TblStartSign;

public interface StartsignService {
	public List<String> getSignNameList() throws Exception;
	public List<TblStartSign> getTblStartSign(String wid);
	
	public String startSign(String taskid, String wid, String name, String checkbox, String check) throws Exception;
}
