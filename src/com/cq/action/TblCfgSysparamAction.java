package com.cq.action;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.SysparamDao;
import com.cq.table.TblCfgSysparam;
import com.cq.util.GlobalData;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="系统参数", dataName="sp")
public class TblCfgSysparamAction {
	static Logger log = Logger.getLogger(TblCfgSysparamAction.class);
	private String errorMsg;
	
	private int kid;
	private int passwordReminderDays;
	private int passwordExpireDays;
	private int taskReminderDays;
	private int taskExpireDays;
	private int advancedReminderDays;
	private int projectTrackPeriod;
	private int maxLogResults;
	private String reviewGroupName;
	private String antiWarrantGroups;
	private String reviewChargeToReceive;
	
	private TblCfgSysparam sp;
	
	private SysparamDao sysparamDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblCfgSysparam() throws Exception {
		TblCfgSysparam tblsp = null;
		
		try {
			tblsp = sysparamDao.get(kid);
			if (tblsp == null) {
				tools.returnError(log, "系统中没有配置系统参数数据");
				return "error";
			} else {
				tblsp.setAdvancedReminderDays(advancedReminderDays);
				tblsp.setAntiWarrantGroups(antiWarrantGroups);
				tblsp.setMaxLogResults(maxLogResults);
				tblsp.setPasswordExpireDays(passwordExpireDays);
				tblsp.setPasswordReminderDays(passwordReminderDays);
				tblsp.setProjectTrackPeriod(projectTrackPeriod);
				tblsp.setReviewGroupName(reviewGroupName);
				tblsp.setTaskExpireDays(taskExpireDays);
				tblsp.setTaskReminderDays(taskReminderDays);
				tblsp.setReviewChargeToReceive(reviewChargeToReceive);
				
				sysparamDao.update(tblsp);
				sp = tblsp;
				
				GlobalData.advancedReminderDays = tblsp.getAdvancedReminderDays();
				
				String[] awg = tblsp.getAntiWarrantGroups().split(",");
				for (int i = 0; i < awg.length; i++) {
					GlobalData.antiWarrantGroups.add(awg[i]);
				}
				
				GlobalData.maxLogResults = tblsp.getMaxLogResults();
				GlobalData.passwordExpireDays = tblsp.getPasswordExpireDays();
				GlobalData.passwordReminderDays = tblsp.getPasswordReminderDays();
				GlobalData.projectTrackPeriod = tblsp.getProjectTrackPeriod();
				GlobalData.reviewGroupName = tblsp.getReviewGroupName();
				GlobalData.taskExpireDays = tblsp.getTaskExpireDays();
				GlobalData.taskReminderDays = tblsp.getTaskReminderDays();
				GlobalData.reviewChargeToRecieve = Boolean.parseBoolean(tblsp.getReviewChargeToReceive());
			}
		} catch (Exception e) {
			errorMsg = "修改系统参数失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblCfgSysparam() throws Exception {
		List <TblCfgSysparam> sysparam = null;

		sysparam = sysparamDao.list();
		if (sysparam == null || sysparam.size() == 0) {
			tools.outputInfo(JSONObject.fromObject(null));
		} else {
			tools.outputInfo(JSONObject.fromObject(sysparam.get(0)));
		}
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getPasswordReminderDays() {
		return passwordReminderDays;
	}

	public void setPasswordReminderDays(int passwordReminderDays) {
		this.passwordReminderDays = passwordReminderDays;
	}

	public int getPasswordExpireDays() {
		return passwordExpireDays;
	}

	public void setPasswordExpireDays(int passwordExpireDays) {
		this.passwordExpireDays = passwordExpireDays;
	}

	public int getTaskReminderDays() {
		return taskReminderDays;
	}

	public void setTaskReminderDays(int taskReminderDays) {
		this.taskReminderDays = taskReminderDays;
	}

	public int getTaskExpireDays() {
		return taskExpireDays;
	}

	public void setTaskExpireDays(int taskExpireDays) {
		this.taskExpireDays = taskExpireDays;
	}

	public int getAdvancedReminderDays() {
		return advancedReminderDays;
	}

	public void setAdvancedReminderDays(int advancedReminderDays) {
		this.advancedReminderDays = advancedReminderDays;
	}

	public int getProjectTrackPeriod() {
		return projectTrackPeriod;
	}

	public void setProjectTrackPeriod(int projectTrackPeriod) {
		this.projectTrackPeriod = projectTrackPeriod;
	}

	public int getMaxLogResults() {
		return maxLogResults;
	}

	public void setMaxLogResults(int maxLogResults) {
		this.maxLogResults = maxLogResults;
	}

	public String getReviewGroupName() {
		return reviewGroupName;
	}

	public void setReviewGroupName(String reviewGroupName) {
		this.reviewGroupName = reviewGroupName;
	}

	public String getAntiWarrantGroups() {
		return antiWarrantGroups;
	}

	public void setAntiWarrantGroups(String antiWarrantGroups) {
		this.antiWarrantGroups = antiWarrantGroups;
	}

	public TblCfgSysparam getSp() {
		return sp;
	}

	public void setSp(TblCfgSysparam sp) {
		this.sp = sp;
	}

	public void setSysparamDao(SysparamDao sysparamDao) {
		this.sysparamDao = sysparamDao;
	}

	public String getReviewChargeToReceive() {
		return reviewChargeToReceive;
	}

	public void setReviewChargeToReceive(String reviewChargeToReceive) {
		this.reviewChargeToReceive = reviewChargeToReceive;
	}
	
}
