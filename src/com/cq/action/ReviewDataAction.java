package com.cq.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.ReviewDataService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblDatareview;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ReviewDataAction extends TaskBaseAction {
	static Logger log = Logger.getLogger(ReviewDataAction.class);
	private String errorMsg;
	
	private String sel;
	private String wid;
	private String checkbox;
	private Date startDate;
	private Date endDate;
	private String account;
	private String revenue;
	private String assets;
	private String dateMortgage;
	private String ownerShip;
	private String debt;
	private String warrant;
	private String acceptance;
	private String credit;
	private String assetValue;
	private String forecasting;
	private String peerSurvey;
	private String explains;
	private String serviceType;
	private String over;
	private String taskid;
	private String selValue;
	private double refundMoney;
	
	@Resource TaskBaseService taskBaseService;
	@Resource ReviewDataService reviewDataService;

	public String reviewdata() throws Exception {
		String s = "error";
		
		// Begin: Mod by Luke Chen on 2015/04/21, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/21, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
			return s;
		}
		
		s = reviewDataService.reviewData(taskid, sel, selValue,
				wid, checkbox, over, startDate, endDate,
				account, revenue, assets, dateMortgage,
				ownerShip, debt, warrant, acceptance, credit,
				assetValue, forecasting, peerSurvey, explains,
				serviceType, refundMoney);
		if ("success".equals(s) == false) {
			tools.returnError(log, "处理资料审查业务时系统出现错误");
			return "error";
		}
		return "success";
	}
	
	public void getReviewDataInfo() throws Exception {
		List<TblDatareview> rdl = null;
		TblDatareview rd = null;
		JsonConfig cfg = null;
		
		try {
			rdl = reviewDataService.getReviewData(wid);
			
			if((rdl == null) || (rdl.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				log.warn("获取资料审查信息失败" + rdl);
				return;
			}
			cfg = tools.getJsonConfig();
			JSONArray ja = new JSONArray();
			for(int i = 0; i < rdl.size(); i++) {
				rd = (TblDatareview) rdl.get(i);
				ja.add(JSONObject.fromObject(rd, cfg));
			}
			JSONObject result = new JSONObject();
			result.put("reviewDataInfo", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "输出资料审查信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public String getDateMortgage() {
		return dateMortgage;
	}

	public void setDateMortgage(String dateMortgage) {
		this.dateMortgage = dateMortgage;
	}

	public String getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}

	public String getDebt() {
		return debt;
	}

	public void setDebt(String debt) {
		this.debt = debt;
	}

	public String getWarrant() {
		return warrant;
	}

	public void setWarrant(String warrant) {
		this.warrant = warrant;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(String assetValue) {
		this.assetValue = assetValue;
	}

	public String getForecasting() {
		return forecasting;
	}

	public void setForecasting(String forecasting) {
		this.forecasting = forecasting;
	}

	public String getPeerSurvey() {
		return peerSurvey;
	}

	public void setPeerSurvey(String peerSurvey) {
		this.peerSurvey = peerSurvey;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

	public double getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(double refundMoney) {
		this.refundMoney = refundMoney;
	}
}
