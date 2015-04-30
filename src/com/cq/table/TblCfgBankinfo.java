package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblCfgBankinfo implements Serializable {
	private static final long serialVersionUID = -3758953106320142082L;
	
	private int kid;
	private String bid;
	private Date startdate;
	private Date enddate;
	private String name;
	private double quota;
	private double remaining;

	public TblCfgBankinfo() {
	}

	public TblCfgBankinfo(String bid, Date startDate, Date endDate,
			double money, String name, double quota, double remaining) {
		this.bid = bid;
		this.startdate = startDate;
		this.enddate = endDate;
		this.name = name;
		this.quota = quota;
		this.remaining = remaining;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuota() {
		return quota;
	}

	public void setQuota(double quota) {
		this.quota = quota;
	}

	public double getRemaining() {
		return remaining;
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

	
}
