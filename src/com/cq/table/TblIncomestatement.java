package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblIncomestatement implements Serializable {
	private static final long serialVersionUID = 6347121832159153548L;
	
	private int kid;
	private String eid;
	private Character type;
	private Date date;
	private Double salesRevenue;
	private Double costofSales;
	private Double mainBusinessProfit;
	private Double sellingExpenses;
	private Double managementExpenses;
	private Double financingExpenses;
	private Double totalProfits;
	private Double netProfit;

	public TblIncomestatement() {
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

	public Double getSalesRevenue() {
		return this.salesRevenue;
	}

	public void setSalesRevenue(Double salesRevenue) {
		this.salesRevenue = salesRevenue;
	}

	public Double getCostofSales() {
		return this.costofSales;
	}

	public void setCostofSales(Double costofSales) {
		this.costofSales = costofSales;
	}

	public Double getMainBusinessProfit() {
		return this.mainBusinessProfit;
	}

	public void setMainBusinessProfit(Double mainBusinessProfit) {
		this.mainBusinessProfit = mainBusinessProfit;
	}

	public Double getSellingExpenses() {
		return this.sellingExpenses;
	}

	public void setSellingExpenses(Double sellingExpenses) {
		this.sellingExpenses = sellingExpenses;
	}

	public Double getManagementExpenses() {
		return this.managementExpenses;
	}

	public void setManagementExpenses(Double managementExpenses) {
		this.managementExpenses = managementExpenses;
	}

	public Double getFinancingExpenses() {
		return this.financingExpenses;
	}

	public void setFinancingExpenses(Double financingExpenses) {
		this.financingExpenses = financingExpenses;
	}

	public Double getTotalProfits() {
		return this.totalProfits;
	}

	public void setTotalProfits(Double totalProfits) {
		this.totalProfits = totalProfits;
	}

	public Double getNetProfit() {
		return this.netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}
}