package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblInvest implements Serializable {
	private static final long serialVersionUID = 5218224425639998567L;
	
	private int kid;
	private String eid;
	private String name;
	private Date startDate;
	private Date endDate;
	private Character investMode;
	private double money;
	private double lastYearIncome;
	private double forecastIncome;
	
	public TblInvest() {
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Character getInvestMode() {
		return this.investMode;
	}

	public void setInvestMode(Character investMode) {
		this.investMode = investMode;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getLastYearIncome() {
		return this.lastYearIncome;
	}

	public void setLastYearIncome(double lastYearIncome) {
		this.lastYearIncome = lastYearIncome;
	}

	public double getForecastIncome() {
		return this.forecastIncome;
	}

	public void setForecastIncome(double forecastIncome) {
		this.forecastIncome = forecastIncome;
	}
}
