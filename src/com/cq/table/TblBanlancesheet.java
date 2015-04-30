package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblBanlancesheet implements Serializable {
	private static final long serialVersionUID = -2359829703174923861L;
	
	private int kid;
	private String eid;
	private Character type;
	private Date date;
	private Double totalAssets;
	private Double currentAssets;
	private Double moneyFunds;
	private Double temporaryInvestment;
	private Double noteReceivable;
	private Double receivables;
	private Double prepaidAccounts;
	private Double otherReceivables;
	private Double inventory;
	private Double unamortizedExpenditures;
	private Double longtermInvestments;
	private Double netFixedAssets;
	private Double intangibleandDeferredAssets;
	private Double totalIndebtedness;
	private Double currentLiabilities;
	private Double shorttermLoans;
	private Double notesPayable;
	private Double accountPayable;
	private Double depositReceived;
	private Double otherPayables;
	private Double ltldwoy;
	private Double longtermDebt;
	private Double longtermLoans;
	private Double bondPayable;
	private Double longtermPayables;
	private Double ownerEquity;
	private Double paidupCapital;
	private Double capitalReserve;
	private Double undistributedProfit;

	public TblBanlancesheet() {
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
		return this.type;
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

	public Double getTotalAssets() {
		return this.totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Double getCurrentAssets() {
		return this.currentAssets;
	}

	public void setCurrentAssets(Double currentAssets) {
		this.currentAssets = currentAssets;
	}

	public Double getMoneyFunds() {
		return this.moneyFunds;
	}

	public void setMoneyFunds(Double moneyFunds) {
		this.moneyFunds = moneyFunds;
	}

	public Double getTemporaryInvestment() {
		return this.temporaryInvestment;
	}

	public void setTemporaryInvestment(Double temporaryInvestment) {
		this.temporaryInvestment = temporaryInvestment;
	}

	public Double getNoteReceivable() {
		return this.noteReceivable;
	}

	public void setNoteReceivable(Double noteReceivable) {
		this.noteReceivable = noteReceivable;
	}

	public Double getReceivables() {
		return this.receivables;
	}

	public void setReceivables(Double receivables) {
		this.receivables = receivables;
	}

	public Double getPrepaidAccounts() {
		return this.prepaidAccounts;
	}

	public void setPrepaidAccounts(Double prepaidAccounts) {
		this.prepaidAccounts = prepaidAccounts;
	}

	public Double getOtherReceivables() {
		return this.otherReceivables;
	}

	public void setOtherReceivables(Double otherReceivables) {
		this.otherReceivables = otherReceivables;
	}

	public Double getInventory() {
		return this.inventory;
	}

	public void setInventory(Double inventory) {
		this.inventory = inventory;
	}

	public Double getUnamortizedExpenditures() {
		return this.unamortizedExpenditures;
	}

	public void setUnamortizedExpenditures(Double unamortizedExpenditures) {
		this.unamortizedExpenditures = unamortizedExpenditures;
	}

	public Double getLongtermInvestments() {
		return this.longtermInvestments;
	}

	public void setLongtermInvestments(Double longtermInvestments) {
		this.longtermInvestments = longtermInvestments;
	}

	public Double getNetFixedAssets() {
		return this.netFixedAssets;
	}

	public void setNetFixedAssets(Double netFixedAssets) {
		this.netFixedAssets = netFixedAssets;
	}

	public Double getIntangibleandDeferredAssets() {
		return this.intangibleandDeferredAssets;
	}

	public void setIntangibleandDeferredAssets(
			Double intangibleandDeferredAssets) {
		this.intangibleandDeferredAssets = intangibleandDeferredAssets;
	}

	public Double getTotalIndebtedness() {
		return this.totalIndebtedness;
	}

	public void setTotalIndebtedness(Double totalIndebtedness) {
		this.totalIndebtedness = totalIndebtedness;
	}

	public Double getCurrentLiabilities() {
		return this.currentLiabilities;
	}

	public void setCurrentLiabilities(Double currentLiabilities) {
		this.currentLiabilities = currentLiabilities;
	}

	public Double getShorttermLoans() {
		return this.shorttermLoans;
	}

	public void setShorttermLoans(Double shorttermLoans) {
		this.shorttermLoans = shorttermLoans;
	}

	public Double getNotesPayable() {
		return this.notesPayable;
	}

	public void setNotesPayable(Double notesPayable) {
		this.notesPayable = notesPayable;
	}

	public Double getAccountPayable() {
		return this.accountPayable;
	}

	public void setAccountPayable(Double accountPayable) {
		this.accountPayable = accountPayable;
	}

	public Double getDepositReceived() {
		return this.depositReceived;
	}

	public void setDepositReceived(Double depositReceived) {
		this.depositReceived = depositReceived;
	}

	public Double getOtherPayables() {
		return this.otherPayables;
	}

	public void setOtherPayables(Double otherPayables) {
		this.otherPayables = otherPayables;
	}

	public Double getLtldwoy() {
		return this.ltldwoy;
	}

	public void setLtldwoy(Double ltldwoy) {
		this.ltldwoy = ltldwoy;
	}

	public Double getLongtermDebt() {
		return this.longtermDebt;
	}

	public void setLongtermDebt(Double longtermDebt) {
		this.longtermDebt = longtermDebt;
	}

	public Double getLongtermLoans() {
		return this.longtermLoans;
	}

	public void setLongtermLoans(Double longtermLoans) {
		this.longtermLoans = longtermLoans;
	}

	public Double getBondPayable() {
		return this.bondPayable;
	}

	public void setBondPayable(Double bondPayable) {
		this.bondPayable = bondPayable;
	}

	public Double getLongtermPayables() {
		return this.longtermPayables;
	}

	public void setLongtermPayables(Double longtermPayables) {
		this.longtermPayables = longtermPayables;
	}

	public Double getOwnerEquity() {
		return this.ownerEquity;
	}

	public void setOwnerEquity(Double ownerEquity) {
		this.ownerEquity = ownerEquity;
	}

	public Double getPaidupCapital() {
		return this.paidupCapital;
	}

	public void setPaidupCapital(Double paidupCapital) {
		this.paidupCapital = paidupCapital;
	}

	public Double getCapitalReserve() {
		return this.capitalReserve;
	}

	public void setCapitalReserve(Double capitalReserve) {
		this.capitalReserve = capitalReserve;
	}

	public Double getUndistributedProfit() {
		return this.undistributedProfit;
	}

	public void setUndistributedProfit(Double undistributedProfit) {
		this.undistributedProfit = undistributedProfit;
	}
}
