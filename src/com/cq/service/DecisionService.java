package com.cq.service;

import java.util.List;

import com.cq.table.TblDecision;

public interface DecisionService {
	public String projectDecision(String taskid, String sel, String selValue,
			String wwid, String decisionList, String explain, double money,
			double deposit, double assure, double commission,  double evaluate,
			String cause, double rate, double refundMoney) throws Exception;
	public StringBuffer companyCreditGrade(String wid) throws Exception;
	public StringBuffer personCreditGrade(String wid) throws Exception;
	public List<TblDecision> getTblDecision(String wid) throws Exception;
}
