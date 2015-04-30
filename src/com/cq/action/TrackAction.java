package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.ProjectMonitorService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblProjectmonitor;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class TrackAction {
	static Logger log = Logger.getLogger(TrackAction.class);
	private String errorMsg;
	
	private String sel;
	private String finance;
	private String wid;
	private String work;	
	private String fund;
	private String antiwarrant;
	private String matter;
	private String conclusion;
	private String issue;
	private String selValue;
	private String taskid;
	private String WarrantLoanDate;
	private String loanDate;
	
	@Resource TaskBaseService taskBaseService;
	@Resource ProjectMonitorService projectMonitorService;
	
	public String track() throws Exception {
		String s = "error";
		String temp = "success";
		
		// Begin: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			return taskBaseService.transfer(selValue, taskid);
		} else if (sel.equals("nextLater")) {
			if (!StringUtils.isBlank(WarrantLoanDate)) {
				if (!WarrantLoanDate.equals(loanDate)) {
					temp = projectMonitorService.loanDateWarrant(taskid, wid, loanDate, antiwarrant);					
				}
			} else {
				if (!StringUtils.isBlank(loanDate)) {
					temp = projectMonitorService.loanDateWarrant(taskid, wid, loanDate, antiwarrant);					
				}
			}
			s = projectMonitorService.projectTrack(taskid, selValue, wid, finance,
					work, fund, antiwarrant, matter, conclusion, issue);
			if ("success".equals(s) == false || "success".equals(temp) == false) {
				tools.returnError(log, "处理项目跟踪业务时系统出现错误");
				return "error";
			}
		} else {
			tools.returnError(log, "必须选择下一步处理");
			return "error";
		}
		return "success";
	}
	
	public void getTrackInfo() throws Exception {
		List<TblProjectmonitor> pml = null;
		TblProjectmonitor pm = null;
		JsonConfig cfg = null;
		
		try {
			pml = projectMonitorService.getTblProjectmonitor(wid);
			
			if((pml == null) || (pml.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				log.warn("获取项目跟踪信息失败" + pml);
				return;
			}
			cfg = tools.getJsonConfig();
			JSONArray ja = new JSONArray();
			for(int i = 0; i < pml.size(); i++) {
				pm = (TblProjectmonitor) pml.get(i);
				ja.add(JSONObject.fromObject(pm, cfg));
			}
			JSONObject result = new JSONObject();
			result.put("trackInfoList", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "输出项目跟踪信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getFinance() {
		return finance;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getFund() {
		return fund;
	}

	public void setFund(String fund) {
		this.fund = fund;
	}

	public String getAntiwarrant() {
		return antiwarrant;
	}

	public void setAntiwarrant(String antiwarrant) {
		this.antiwarrant = antiwarrant;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getConclution() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getConclusion() {
		return conclusion;
	}

	public String getWarrantLoanDate() {
		return WarrantLoanDate;
	}

	public void setWarrantLoanDate(String warrantLoanDate) {
		WarrantLoanDate = warrantLoanDate;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setProjectMonitorService(ProjectMonitorService projectMonitorService) {
		this.projectMonitorService = projectMonitorService;
	}
}
