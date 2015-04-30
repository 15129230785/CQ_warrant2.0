package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.FinanceestDao;
import com.cq.service.FinanceService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblFinanceest;
import com.cq.util.tools;

public class FinanceServiceImpl implements FinanceService {
	static Logger log = Logger.getLogger(FinanceServiceImpl.class);
	private String errorMsg;
	
	private FinanceestDao financeestDao;
	private TaskBaseService taskBaseService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String finance(String taskid, String sel, String selValue,
			String wid, String startDate, double debts, double asset,
			double betAsset, double loanRemaining, double flowAsset,
			double flowDebt, double saleCash, double dueDebt, double saleMoney,
			double meanAsset, double netProfit, double thisYearSale,
			double lastYearSale, double dueCash, double loan) throws Exception {
		String user = tools.getLoginUser();
		try {
			if (startDate == null) {
				Date da = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				startDate = sdf.format(da);
			} else {
				startDate = startDate.replaceAll(", ", "-");
			}

			setFinanceest(wid, user, startDate, debts, asset, betAsset,
					loanRemaining, flowAsset, flowDebt, saleCash, dueDebt,
					saleMoney, meanAsset, netProfit, thisYearSale,
					lastYearSale, dueCash, loan);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", selValue);
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（风险评审）处理");
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "财务评估业务流程处理失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	private void setFinanceest(String wid, String name, String startDate,
			double debt, double asset, double betAsset, double loanRemaining,
			double flowAsset, double flowDebt, double saleCash, double dueDebt,
			double saleMoney, double meanAsset, double netProfit,
			double thisYearSale, double lastYearSale, double dueCash,
			double loan) throws Exception {
		try {
			Date da = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
		
			d = sdf.parse(sdf.format(da));
			
			TblFinanceest tblFinanceest = new TblFinanceest();
			tblFinanceest.setWid(wid);
			tblFinanceest.setName(name);
			tblFinanceest.setStartDate(startDate);
			tblFinanceest.setDebt(debt);
			tblFinanceest.setDate(d);
			tblFinanceest.setAsset(asset);
			tblFinanceest.setNetAsset(betAsset);
			tblFinanceest.setLoanRemaining(loanRemaining);
			tblFinanceest.setFlowAsset(flowAsset);
			tblFinanceest.setFlowDebt(flowDebt);
			tblFinanceest.setSaleCash(saleCash);
			tblFinanceest.setDueDebt(dueDebt);
			tblFinanceest.setSaleMoney(saleMoney);
			tblFinanceest.setMeanAsset(meanAsset);
			tblFinanceest.setNetProfit(netProfit);
			tblFinanceest.setThisYearSale(thisYearSale);
			tblFinanceest.setLastYearSale(lastYearSale);
			tblFinanceest.setDueCash(dueCash);
			tblFinanceest.setLoan(loan);
			
			financeestDao.save(tblFinanceest);
		} catch (Exception e) {
			errorMsg = "增加财务评估数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblFinanceest> getTblFinanceest(String wid) {
		List<TblFinanceest> ld = null;

		ld = financeestDao.findByProperty("wid", wid);
		return ld;
	}

	public void setFinanceestDao(FinanceestDao financeestDao) {
		this.financeestDao = financeestDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

}
