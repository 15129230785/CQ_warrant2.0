package com.cq.service;

import java.util.List;

import com.cq.table.TblManaudit;

public interface ConsiderationService {
	public String consideration(String taskid, String wid, String sel,
			String finance, String law, String over, String emcee,
			String value, String serviceType, String selValue,
			double refundMoney) throws Exception;
	public List<TblManaudit> getTblManaudit(String wid);
}
