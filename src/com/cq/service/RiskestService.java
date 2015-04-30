package com.cq.service;

import java.util.Date;
import java.util.List;

import com.cq.table.TblPersonalrisk;
import com.cq.table.TblRiskest;

public interface RiskestService {
	public void setFinanceest(String wid, String name, Date startDate,
			String managerial, String achievement, String brand,
			String occupancy, String reserve, String nature, String client,
			String right, String patent, String ability,
			String assessSummarize, String due, String warrant, String credit,
			String enterprise, String creditSummary,int purpose,
			int experience, int prospect, int resource, int skill, int credits) throws Exception;
	public List<TblRiskest> getTblRiskest(String wid);
	public List<TblPersonalrisk> getTblPersonalrisk(String wid);
	
	public String companyRiskEst(String taskid, String selValue, String wid,
			Date startDate, String managerial, String achievement, String brand,
			String occupancy, String reserve, String nature, String client,
			String right, String patent, String ability, String assessSummarize,
			String due, String warrant, String credit, String enterprise, String creditSummary,
			int purpose, int experience, int prospect, int resource, int skill, int credits) throws Exception;
	public String personRiskEst(String taskid, String selValue, String wid,
			 int age, int ducationLevel, int martialStatus, int liveTime, int socialSecurity,
			 int job, double familyIncome, int numb, double grossDebt, double totalAssets,
			 int housSituation, String reimbursement, String cguemeforianaly, int purpos) throws Exception;
}
