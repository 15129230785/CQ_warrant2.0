package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.BankinfoDao;
import com.cq.dao.FieldSurveyDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.ChargeService;
import com.cq.service.FieldSurveyService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCfgBankinfo;
import com.cq.table.TblFieldsurvey;
import com.cq.table.TblWarrantinfo;
import com.cq.util.ChargeType;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class FieldSurveyServiceImpl implements FieldSurveyService {
	static Logger log = Logger.getLogger(FieldSurveyServiceImpl.class);
	private String errorMsg;
	
	private BankinfoDao bankinfoDao;
	private ChargeService chargeService;
	private FieldSurveyDao fieldSurveyDao;
	private TaskBaseService taskBaseService;
	private WarrantinfoDao warrantinfoDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String fieldSurvey (String taskid, String sel, String selValue, String wid, 
			String over, Date startDate, String product, String equipment, String manage,
			String staff, String workplace,	String counterGuarantee, String loausanalysis,
			double refundMoney) throws Exception {
		String result = "";
		String history = null;
		double quota = 0;
		double remaining = 0;
		
		String str = tools.getLoginUser();
		
		TblWarrantinfo TblWarrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
		if (TblWarrantinfo == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startDate == null) {
			startDate = date;
		}
		if (product == null) {
			product = "";
		}
		if (equipment == null) {
			equipment = "";
		}
		if (manage == null) {
			manage = "";
		}
		if (staff == null) {
			staff = "";
		}
		if (workplace == null) {
			workplace = "";
		}
		if (counterGuarantee == null) {
			counterGuarantee = "";
		}
		if (loausanalysis == null) {
			loausanalysis = "";
		}
		
		try {
			if (sel.equals("nextLater")) {
				setFieldSurvey(wid, str.trim(), startDate,
					tools.multiLine(product.trim()),
					tools.multiLine(equipment.trim()),
					tools.multiLine(manage.trim()),
					tools.multiLine(staff.trim()),
					tools.multiLine(workplace.trim()),
					tools.multiLine(counterGuarantee.trim()),
					tools.multiLine(loausanalysis.trim()));
				result = "pass";
			} else if (sel.equals("refund")) {
				if (over.equals("")) {
					errorMsg = "选择项目终止时必须输入终止原因";
					log.error(errorMsg);
					throw new WarrantException(errorMsg);
				} else {
					result = "refund";
				}
			} else if (sel.equals("stop")) {
				if (over.equals("")) {
					errorMsg = "选择项目终止时必须输入终止原因";
					log.error(errorMsg);
					throw new WarrantException(errorMsg);
				} else {
					result = "stop";
				}
			} else {
				errorMsg = "选择处理方式错误";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			if ("refund".equals(result) || "stop".equals(result)) {
				TblWarrantinfo.setEndDate(date);
				TblWarrantinfo.setCause(over);
				warrantinfoDao.update(TblWarrantinfo);
				
				String bid = TblWarrantinfo.getBank();
				TblCfgBankinfo bank = bankinfoDao.findBankinfoByBidAndDate(bid, sdf.format(date));
				if (bank != null) {
					quota = bank.getQuota();
					remaining = bank.getRemaining() + TblWarrantinfo.getPracticalMoney();
					if (remaining >= quota)
						remaining = quota;
					bank.setRemaining(remaining);
					bankinfoDao.update(bank);
				}
			}
			
			if ("refund".equals(result)) {
				chargeService.setTblCharge(refundMoney, wid, str, ChargeType.REFUND);
				history = "项目终止，退评审费";
			} else if ("stop".equals(result)) {
				history = "项目终止";
			} else if ("pass".equals(result)) {
				history = "提交到下一步（业务经理审核）处理";
			} else {
				history = "";
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("survey", result);
			if ("stop".equals(result) == false) {
				map.put("user", selValue);
			}
			taskBaseService.setTaskVar(taskid, "history", history);
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "现场调查业务流程处理失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	private void setFieldSurvey(String wid, String name, Date startDate,
			String product, String equipment, String manage, String staff,
			String workplace, String counterGuarantee, String loausanalysis) throws Exception {
		try {
			Date d = null;
			Date da = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d = sdf.parse(sdf.format(da));
			TblFieldsurvey tblFieldsurvey = new TblFieldsurvey();
			tblFieldsurvey.setWid(wid);
			tblFieldsurvey.setName(name);
			tblFieldsurvey.setStartDate(startDate);
			tblFieldsurvey.setEndDate(d);
			tblFieldsurvey.setProduct(product);
			tblFieldsurvey.setEquipment(equipment);
			tblFieldsurvey.setManage(manage);
			tblFieldsurvey.setStaff(staff);
			tblFieldsurvey.setWorkplace(workplace);
			tblFieldsurvey.setCounterGuarantee(counterGuarantee);
			tblFieldsurvey.setLoausanalysis(loausanalysis);
			fieldSurveyDao.save(tblFieldsurvey);
		} catch (Exception e) {
			errorMsg = "添加现场调查数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblFieldsurvey> getFieldSurvey(String wid) {
		List<TblFieldsurvey> li = new ArrayList<TblFieldsurvey>();

		li = fieldSurveyDao.findByProperty("wid", wid);
		return li;
	}

	public void setFieldSurveyDao(FieldSurveyDao fieldSurveyDao) {
		this.fieldSurveyDao = fieldSurveyDao;
	}

	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public void setBankinfoDao(BankinfoDao bankinfoDao) {
		this.bankinfoDao = bankinfoDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setChargeService(ChargeService chargeService) {
		this.chargeService = chargeService;
	}
}
