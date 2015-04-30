package com.cq.table;

import java.io.Serializable;

public class TblCfgSysparam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int kid;
	
	//密码将要超期提前几天提醒，默认7天
	private int passwordReminderDays;
	//密码几天超期，默认90天
	private int passwordExpireDays;
	//任务将要超期提前几天提醒，默认7天
	private int taskReminderDays;
	//任务几天超期，默认30天
	private int taskExpireDays;
	//项目还款提前几天通知，默认7天
	private int advancedReminderDays;
	//项目跟踪周期，默认30天
	private int projectTrackPeriod;
	//每页最多显示多少条操作日志，默认30天
	private int maxLogResults;
	
	//评审收费至项目收款/资料收集的标志符，默认为“yes”
	private String reviewChargeToReceive;
	
	//评审专家组名称，默认为“评审委员会”
	private String reviewGroupName;
	//具有修改反担保措施权限的用户组，默认为“客户经理”
	private String antiWarrantGroups;
	
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
	public String getReviewChargeToReceive() {
		return reviewChargeToReceive;
	}
	public void setReviewChargeToReceive(String reviewChargeToReceive) {
		this.reviewChargeToReceive = reviewChargeToReceive;
	}
}
