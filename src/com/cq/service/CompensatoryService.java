package com.cq.service;

import java.util.Date;

public interface CompensatoryService {
	public String compensatoryProcess(String taskid, String wid, String sel,
			String selValue, String mode, String describe0, String describe1,
			String describe2, String describe3, String describe4, Date startDate, 
			double benjin, double lixi, double faxi, double shouxu,
			double zhixing, double qita) throws Exception;
}
