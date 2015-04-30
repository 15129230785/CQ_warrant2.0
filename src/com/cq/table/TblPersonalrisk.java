package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblPersonalrisk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int kid;
	private String wid;
	private String user;
	private Date startDate;
	private Date endDate;
	private int age;// 个人年龄；
	private int ducationLevel;// 最高学历
	private int martialStatus;// 婚姻状况
	private int liveTime;// 本地居住时间
	private int socialSecurity;// 社保
	private int job;// 职业
	private double familyIncome;// 家庭总收入
	private int numb;// 家庭人数
	private double grossDebt;// 家庭总负债
	private double totalAssets;// 总资产
	private int housSituation;// 住房情况
	private String reimbursement;// 还款能力分析
	private String cguemeforianaly;// 反担保风险分析
	private int purpos;// 贷款用途分析
	
	public TblPersonalrisk() {
		super();
	}

	public int getKid() {
		return kid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPurpos() {
		return purpos;
	}

	public void setPurpos(int purpos) {
		this.purpos = purpos;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public int getId() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDucationLevel() {
		return ducationLevel;
	}

	public void setDucationLevel(int ducationLevel) {
		this.ducationLevel = ducationLevel;
	}

	public int getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(int martialStatus) {
		this.martialStatus = martialStatus;
	}

	public int getLiveTime() {
		return liveTime;
	}

	public void setLiveTime(int liveTime) {
		this.liveTime = liveTime;
	}

	public int getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(int socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}

	public void setHousSituation(int housSituation) {
		this.housSituation = housSituation;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

	public double getGrossDebt() {
		return grossDebt;
	}

	public void setGrossDebt(double grossDebt) {
		this.grossDebt = grossDebt;
	}

	public double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public int getHousSituation() {
		return housSituation;
	}

	public String getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(String reimbursement) {
		this.reimbursement = reimbursement;
	}

	public String getCguemeforianaly() {
		return cguemeforianaly;
	}

	public void setCguemeforianaly(String cguemeforianaly) {
		this.cguemeforianaly = cguemeforianaly;
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
}
