package com.cq.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.BankinfoDao;
import com.cq.dao.DatareviewDao;
import com.cq.dao.DocchklistDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.ChargeService;
import com.cq.service.ReviewDataService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCfgBankinfo;
import com.cq.table.TblDatareview;
import com.cq.table.TblDocchklist;
import com.cq.table.TblWarrantinfo;
import com.cq.util.ChargeType;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ReviewDataServiceImpl implements ReviewDataService {
	static Logger log = Logger.getLogger(ReviewDataServiceImpl.class);
	private String errorMsg;
	
	private BankinfoDao bankinfoDao;
	private ChargeService chargeService;
	private DatareviewDao datareviewDao;
	private DocchklistDao docchklistDao;
	private WarrantinfoDao warrantinfoDao;
	private TaskBaseService taskBaseService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String reviewData(String taskid, String sel, String selValue,
			String wwid, String checkbox, String over, Date startDate, Date endDate,
			String account, String revenue, String assets, String dateMortgage,
			String ownerShip, String debt, String warrant, String acceptance, String credit,
			String assetValue, String forecasting, String peerSurvey, String explains,
			String serviceType, double refundMoney) throws Exception {
		String result = null;
		String history = null;
		String wid = wwid.substring(wwid.lastIndexOf("w"));
		TblWarrantinfo TblWarrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
		if (TblWarrantinfo == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		Date nowDate = null;
		String strDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			nowDate = sdf.parse(sdf.format(new Date()));
			strDate = sdf.format(nowDate);
		} catch (ParseException e2) {
			errorMsg = "日期格式处理出现错误";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		String name = tools.getLoginUser();
		try {
			if (sel.equals("nextLater")) {
				if (checkbox != null) {
					String[] string = checkbox.split(",");
					setComdoclistComplete(wid, string);
				}

				if (startDate == null) {
					startDate = nowDate;
				}
				if (serviceType.equals("0")) {
					setReviewData(wid, name, startDate, nowDate,
						tools.multiLine(account), tools.multiLine(revenue),
						tools.multiLine(assets),
						tools.multiLine(dateMortgage),
						tools.multiLine(ownerShip), tools.multiLine(debt),
						tools.multiLine(warrant),
						tools.multiLine(acceptance),
						tools.multiLine(credit),
						tools.multiLine(assetValue),
						tools.multiLine(forecasting),
						tools.multiLine(peerSurvey),
						tools.multiLine(explains));
				}
				result = "ok";
			} else if (sel.equals("refund")) {
				if (over.equals("")) {
					errorMsg = "退评审费后项目会终止，这里需要填写项目终止的原因";
					log.error(errorMsg);
					throw new WarrantException(errorMsg);
				} else {
					result = "refund";
				}
			} else if (sel.equals("stop")) {
				if (over.equals("")) {
					errorMsg = "项目终止需要填写项目终止的原因";
					log.error(errorMsg);
					throw new WarrantException(errorMsg);
				} else {
					result = "stop";
				}
			}
			
			if (("stop".equals(result)) || ("refund".equals(result))) {
				String bid = TblWarrantinfo.getBank();
				TblCfgBankinfo bank = bankinfoDao.findBankinfoByBidAndDate(bid, strDate);
				if (bank != null) {
					double quota = bank.getQuota();
					double refundremaning = bank.getRemaining()
							+ TblWarrantinfo.getPracticalMoney();
					if (refundremaning >= quota)
						refundremaning = quota;
					
					bank.setRemaining(refundremaning);
					bankinfoDao.update(bank);
				}
				
				TblWarrantinfo.setEndDate(nowDate);
				TblWarrantinfo.setCause(over);
				warrantinfoDao.update(TblWarrantinfo);
			}
			
			if ("refund".equals(result)) {
				chargeService.setTblCharge(refundMoney, wid, name, ChargeType.REFUND);
				history = "项目终止，退评审费";
			} else if ("stop".equals(result)) {
				history = "项目终止";
			} else if (("ok".equals(result))) {
				history = "提交到下一步（现场调查）处理";
			} else {
				history = "";
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("examine", result);
			if ("stop".equals(result) == false) {
				map.put("user", selValue);
			}
			taskBaseService.setTaskVar(taskid, "history", history);
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "资料审查业务流程处理失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void setComdoclistSave(String wid, String[] did) throws Exception {
		List<TblDocchklist> ld = null;
		TblDocchklist dc = null;

		try {
			ld = docchklistDao.findByProperty("wid", wid);
			if (ld == null || ld.size() == 0) {
				errorMsg = "获取文档审查列表信息失败";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			for (int i = 0; i < did.length; i++) {
				dc = ld.get(i);
				for (int j = 0; j < did.length; j++) {
					if (dc.getDid().equals(did[i].trim())) {
						dc.setSave("1");
						docchklistDao.update(dc);
					}
				}
			}
		} catch (Exception e) {
			errorMsg = "修改担保信息中担保开始时间、结束时间、通知时间失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblDatareview> getReviewData(String wid) {
		List<TblDatareview> ld = null;

		ld = datareviewDao.findByProperty("wid", wid);
		return ld;
	}
	
	private void setComdoclistComplete(String wid, String[] did) throws Exception {
		List<TblDocchklist> ld = null;
		TblDocchklist dc = null;
		String gd = "";
		String d = "";

		try {
			ld = docchklistDao.findByProperty("wid", wid);
			if (ld == null || ld.size() == 0) {
				errorMsg = "获取文档检查列表信息失败" + ld;
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			for (int i = 0; i < ld.size(); i++) {
				dc = ld.get(i);
				gd = dc.getDid();
				for (int j = 0; j < did.length; j++) {
					d = did[j].trim();
					if (gd.equals(d)) {
						dc.setComplete("1");
						docchklistDao.update(dc);
					}
				}
			}
		} catch (Exception e) {
			errorMsg = "修改文件完整标志失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	private void setReviewData(String wid, String name, Date startDate,
			Date endDate, String account, String revenue, String assets,
			String mortgage, String ownerShip, String debt, String warrant,
			String acceptance, String credit, String assetValue,
			String forecasting, String peerSurvey, String explains) throws Exception {
		try {
			TblDatareview tblDatareview = new TblDatareview();
			tblDatareview.setWid(wid);
			tblDatareview.setName(name);
			tblDatareview.setStartDate(startDate);
			tblDatareview.setEndDate(endDate);
			tblDatareview.setAccount(account);
			tblDatareview.setRevenue(revenue);
			tblDatareview.setAssets(assets);
			tblDatareview.setMortgage(mortgage);
			tblDatareview.setOwnership(ownerShip);
			tblDatareview.setDebt(debt);
			tblDatareview.setWarrant(warrant);
			tblDatareview.setAcceptance(acceptance);
			tblDatareview.setCredit(credit);
			tblDatareview.setAssetValue(assetValue);
			tblDatareview.setForecasting(forecasting);
			tblDatareview.setPeerSurvey(peerSurvey);
			tblDatareview.setExplains(explains);
		
			datareviewDao.save(tblDatareview);
		} catch (Exception e) {
			errorMsg = "增加资料审查数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void setDatareviewDao(DatareviewDao datareviewDao) {
		this.datareviewDao = datareviewDao;
	}

	public void setDocchklistDao(DocchklistDao docchklistDao) {
		this.docchklistDao = docchklistDao;
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
