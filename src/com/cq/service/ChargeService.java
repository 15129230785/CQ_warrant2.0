package com.cq.service;

import java.util.List;

import com.cq.table.TblCharge;
import com.cq.util.ChargeType;

public interface ChargeService {
	public void setTblCharge(double money, String wid, String user, ChargeType type) throws Exception;
	public List<Double> getCharge(String wid) throws Exception;
	public void updateChargeDate(String wid, ChargeType type) throws Exception;
	public TblCharge findChargeInfo(String wid, ChargeType type);
	
	String charge(String taskid, String result, String selValue) throws Exception;
}
