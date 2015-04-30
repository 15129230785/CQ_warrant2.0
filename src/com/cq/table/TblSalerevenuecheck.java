package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblSalerevenuecheck implements Serializable {
	private static final long serialVersionUID = 3349726370147054684L;
	
	private int kid;
	private String eid;
	private Character type;
	private Date date;
	private double revenueBasedForm;
	private double revenueBasedTax;
	private double revenueNoTax;
	private double lenderSum;

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

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getRevenueBasedForm() {
		return revenueBasedForm;
	}

	public void setRevenueBasedForm(double revenueBasedForm) {
		this.revenueBasedForm = revenueBasedForm;
	}

	public double getRevenueBasedTax() {
		return revenueBasedTax;
	}

	public void setRevenueBasedTax(double revenueBasedTax) {
		this.revenueBasedTax = revenueBasedTax;
	}

	public double getRevenueNoTax() {
		return revenueNoTax;
	}

	public void setRevenueNoTax(double revenueNoTax) {
		this.revenueNoTax = revenueNoTax;
	}

	public double getLenderSum() {
		return lenderSum;
	}

	public void setLenderSum(double lenderSum) {
		this.lenderSum = lenderSum;
	}
}
