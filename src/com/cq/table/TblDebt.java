package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblDebt implements Serializable {
	private static final long serialVersionUID = -7673689629843730913L;
	
	private int kid;
	private String id;
	private String loaner;
	private Date startDate;
	private Date endDate;
	private double money;
	private double remaining;
	private String description;

	public TblDebt() {
	}

	public TblDebt(int kid, String id, String loaner, Date startDate, Date endDate,
			double money, double remaining) {
		this.kid = kid;
		this.id = id;
		this.loaner = loaner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.money = money;
		this.remaining = remaining;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoaner() {
		return this.loaner;
	}

	public void setLoaner(String loaner) {
		this.loaner = loaner;
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

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getRemaining() {
		return this.remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
