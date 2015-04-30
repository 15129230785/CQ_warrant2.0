package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.BankinfoDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.ChargeService;
import com.cq.service.ClearService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCfgBankinfo;
import com.cq.table.TblCharge;
import com.cq.table.TblWarrantinfo;
import com.cq.util.ChargeType;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ClearServiceImpl implements ClearService {
	static Logger log = Logger.getLogger(ClearServiceImpl.class);
	private String errorMsg;
	
	private BankinfoDao bankinfoDao;
	private ChargeService chargeService;
	private TaskBaseService taskBaseService;
	private WarrantinfoDao warrantinfoDao;
	
	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String clearWarrant(String wid, String taskid, 
			String selValue, String WarrantReleaseDate, 
			double money, double warMon) throws Exception {
		String result = null;
		String history = null;
		int flag = 0;
		
		if (money >= warMon) {
			result = "yes";
		} else {
			result = "no";
			flag = 1;
		}
		
		try {
			TblWarrantinfo TblWarrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
			if (TblWarrantinfo == null) {
				errorMsg = "获取担保项目信息失败";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			Date enddate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String bid = TblWarrantinfo.getBank();
			TblCfgBankinfo bank = bankinfoDao.findBankinfoByBidAndDate(bid, sdf.format(enddate));

			if (bank != null) {
				double money1 = TblWarrantinfo.getMoney();
				double remaining = bank.getRemaining();
				double quota = bank.getQuota();
				double refundremaning = 0;
				if (money1 + remaining >= quota) {
					refundremaning = quota;
				} else {
					refundremaning = money1 + remaining;
				}
				
				bank.setRemaining(refundremaning);
				bankinfoDao.update(bank);
			} else {
				log.warn("数据库查询银行信息失败" + bid);
			}
			
			TblWarrantinfo.setPaidMoney(money);
			TblWarrantinfo.setWarrantReleaseDate(sdf.parse(WarrantReleaseDate));
			if (flag == 1) {
				TblWarrantinfo.setCompensatory('1');
				TblWarrantinfo.setCompensatoryMoney(warMon - money);
				history = "进入下一步（代偿）处理";
			} else {
				history = "进入下一步（退保证金）处理";
			}
			warrantinfoDao.update(TblWarrantinfo);
			
			TblCharge charge = chargeService.findChargeInfo(wid, ChargeType.GETBAIL);
			if (charge != null) {
				double bailMoney = charge.getMoney();
				chargeService.setTblCharge(bailMoney, wid,
						tools.getLoginUser(), ChargeType.RETURNBAIL);
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("normal", result);
			map.put("user", selValue);
			taskBaseService.setTaskVar(taskid, "history", history);
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "担保解除业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public void setBankinfoDao(BankinfoDao bankinfoDao) {
		this.bankinfoDao = bankinfoDao;
	}

	public void setChargeService(ChargeService chargeService) {
		this.chargeService = chargeService;
	}

}
