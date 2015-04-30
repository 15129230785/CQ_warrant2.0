package com.cq.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.FieldSurveyService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblFieldsurvey;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class FieldSurveyAction {
	static Logger log = Logger.getLogger(FieldSurveyAction.class);
	private String errorMsg;
	
	@Resource TaskBaseService taskBaseService;
	@Resource FieldSurveyService fieldSurveyService;
	
	private String sel;
	private String wid;
	private Date startDate;
	private String product;
	private String equipment;
	private String manage;
	private String staff;
	private String workplace;
	private String counterGuarantee;
	private String loausanalysis;
	private String over;
	private String taskid;
	private String selValue;
	private double refundMoney;

	public String fieldSurvey() throws Exception {
		
		// Begin: Mod by Luke Chen on 2015/04/21, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/21, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			String s = taskBaseService.transfer(selValue, taskid);
			return s;
		}
		
		String temp = fieldSurveyService.fieldSurvey(taskid, sel, selValue,
				wid, over, startDate, product, equipment,
				manage, staff, workplace, counterGuarantee,
				loausanalysis, refundMoney);
		if("success".equals(temp) == false) {
			tools.returnError(log, "处理现场调查业务时系统出现错误");
			return "error";
		}
		return "success";
	}
	
	public void getFieldSurveyInfo() throws Exception {
		List<TblFieldsurvey> fsl = null;
		TblFieldsurvey fs = null;
		JsonConfig cfg = null;
		
		try {
			fsl = fieldSurveyService.getFieldSurvey(wid);
			
			if((fsl == null) || (fsl.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				return;
			}
			cfg = tools.getJsonConfig();
			JSONArray ja = new JSONArray();
			for(int i = 0; i < fsl.size(); i++) {
				fs = (TblFieldsurvey) fsl.get(i);
				ja.add(JSONObject.fromObject(fs, cfg));
			}
			JSONObject result = new JSONObject();
			result.put("fieldSurveyInfo", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "输出现场调查信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public String getLoausanalysis() {
		return loausanalysis;
	}

	public void setLoausanalysis(String loausanalysis) {
		this.loausanalysis = loausanalysis;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCounterGuarantee() {
		return counterGuarantee;
	}

	public void setCounterGuarantee(String counterGuarantee) {
		this.counterGuarantee = counterGuarantee;
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
