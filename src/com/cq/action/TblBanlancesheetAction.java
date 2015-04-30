package com.cq.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.BanlanceSheetDao;
import com.cq.table.TblBanlancesheet;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业资产负债表信息", dataName="blch")
public class TblBanlancesheetAction {
	static Logger log = Logger.getLogger(TblBanlancesheetAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private char type;
	private String date;
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
	private TblBanlancesheet blch;

	@Resource BanlanceSheetDao banlanceSheetDao;
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblBanlancesheet() throws Exception{
		TblBanlancesheet tblBanlancesheet = null;
		Date tmpDate = null;
		
		try {
			tblBanlancesheet = new TblBanlancesheet();

			tblBanlancesheet.setEid(eid);
			tblBanlancesheet.setType(type);
			
			if (type == '0') {
				tmpDate = new SimpleDateFormat("yyyy").parse(date);
			} else {
				tmpDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			tblBanlancesheet.setDate(tmpDate);
			
			tblBanlancesheet.setTotalAssets(totalAssets);
			tblBanlancesheet.setCurrentAssets(currentAssets);
			tblBanlancesheet.setMoneyFunds(moneyFunds);
			tblBanlancesheet.setTemporaryInvestment(temporaryInvestment);
			tblBanlancesheet.setNoteReceivable(noteReceivable);
			tblBanlancesheet.setReceivables(receivables);
			tblBanlancesheet.setPrepaidAccounts(prepaidAccounts);
			tblBanlancesheet.setOtherReceivables(otherReceivables);
			tblBanlancesheet.setInventory(inventory);
			tblBanlancesheet
					.setUnamortizedExpenditures(unamortizedExpenditures);
			tblBanlancesheet.setLongtermInvestments(longtermInvestments);
			tblBanlancesheet.setNetFixedAssets(netFixedAssets);
			tblBanlancesheet
					.setIntangibleandDeferredAssets(intangibleandDeferredAssets);
			tblBanlancesheet.setTotalIndebtedness(totalIndebtedness);
			tblBanlancesheet.setCurrentLiabilities(currentLiabilities);
			tblBanlancesheet.setShorttermLoans(shorttermLoans);
			tblBanlancesheet.setNotesPayable(notesPayable);
			tblBanlancesheet.setAccountPayable(accountPayable);
			tblBanlancesheet.setDepositReceived(depositReceived);
			tblBanlancesheet.setOtherPayables(otherPayables);
			tblBanlancesheet.setLtldwoy(ltldwoy);
			tblBanlancesheet.setLongtermDebt(longtermDebt);
			tblBanlancesheet.setLongtermLoans(longtermLoans);
			tblBanlancesheet.setBondPayable(bondPayable);
			tblBanlancesheet.setLongtermPayables(longtermPayables);
			tblBanlancesheet.setOwnerEquity(ownerEquity);
			tblBanlancesheet.setPaidupCapital(paidupCapital);
			tblBanlancesheet.setCapitalReserve(capitalReserve);
			tblBanlancesheet.setUndistributedProfit(undistributedProfit);
            blch = tblBanlancesheet;
			tools.fillQueryInfo(1, eid, "TblBanlancesheet");
			
			banlanceSheetDao.save(tblBanlancesheet);
		} catch (Exception e) {
			errorMsg = "添加资产负债表数据失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblBanlancesheet() throws Exception {
		try {
			blch = banlanceSheetDao.get(kid);
			banlanceSheetDao.delete(kid);
			this.selectAjaxTblBanlancesheet();
		} catch (Exception e) {
			errorMsg = "删除资产负债表数据失败";
			tools.throwException(e, log, errorMsg);
		}	
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblBanlancesheet() throws Exception {
		String date1 = null;
		String type2 = null;
		StringBuffer outs = new StringBuffer();
		char type1;
		
		List<TblBanlancesheet> listTblBanlancesheet = banlanceSheetDao.findByProperty("eid", eid);
		if((listTblBanlancesheet == null)
			|| !(listTblBanlancesheet.size() > 0)) {
			log.warn("没有查询到资产负债表数据");
			return;
		}
		
		outs.append("<table>");
		outs.append("<tr><th width='20%'>报表日期</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			type1 = tblBanlancesheet.getType();
			if ('0' == type1) {
				date1 = new SimpleDateFormat("yyyy").format(tblBanlancesheet.getDate());
			} else {
				date1 = new SimpleDateFormat("yyyy-MM-dd").format(tblBanlancesheet.getDate());
			}
			outs.append("<td onclick='updateBanlancesheetJs("
					+ tblBanlancesheet.getKid()	+ ")'><a href='#'>" + date1);
			outs.append("</td>");
		}
		outs.append("</tr>");
		
		outs.append("<tr>");
		outs.append("<th width='20%'>报表类型</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			type1 = tblBanlancesheet.getType();
			if ('0' == type1) {
				type2 = "年度报表";
			} else {
				type2 = "最新报表";
			}
			type2 = new String(type2.getBytes("utf-8"), "utf-8");
			outs.append("<td>" + type2);
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>总资产</th>");
		DecimalFormat decimalFormat=new DecimalFormat("###0.00");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getTotalAssets()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>流动资产</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getCurrentAssets()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>货币资金</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>" +decimalFormat.format(tblBanlancesheet.getMoneyFunds()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>短期投资</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getTemporaryInvestment()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>应收票据</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getNoteReceivable()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>应收账款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getReceivables()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>预付账款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getPrepaidAccounts()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>其它应收款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getOtherReceivables()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>存货</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>" + decimalFormat.format(tblBanlancesheet.getInventory()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>待摊费用</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getUnamortizedExpenditures()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>长期投资</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getLongtermInvestments()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>固定资产净值</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getNetFixedAssets()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>无形及递延资产</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getIntangibleandDeferredAssets()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>负债总额</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getTotalIndebtedness()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>流动负债</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getCurrentLiabilities()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>短期借款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getShorttermLoans()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>应付票据</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getNotesPayable()));
			outs.append("</td>");
		}
		outs.append("</tr>");
		
		outs.append("<tr>");
		outs.append("<th width='20%'>应付账款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getAccountPayable()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>预收账款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getDepositReceived()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>其它应付款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getOtherPayables()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>一年内到期的长期负债</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>" + decimalFormat.format(tblBanlancesheet.getLtldwoy()));
			outs.append("</td>");
		}
		outs.append("</tr>");
		
		outs.append("<tr>");
		outs.append("<th width='20%'>长期负债</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getLongtermDebt()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>长期借款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getLongtermLoans()));
			outs.append("</td>");
		}
		outs.append("</tr>");
		
		outs.append("<tr>");
		outs.append("<th width='20%'>应付债券</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getBondPayable()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>长期应付款</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getLongtermPayables()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>所有者权益</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getOwnerEquity()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>实收资本</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getPaidupCapital()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>资本公积</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getCapitalReserve()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<th width='20%'>未分配利润</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td>"
					+ decimalFormat.format(tblBanlancesheet.getUndistributedProfit()));
			outs.append("</td>");
		}
		outs.append("</tr>");

		outs.append(" <tr>");
		outs.append("<th width='20%'>操作</th>");
		for (TblBanlancesheet tblBanlancesheet : listTblBanlancesheet) {
			outs.append("<td onclick='banlancesheetListOne("
					+ tblBanlancesheet.getKid() +',' + '\"'
					+ tblBanlancesheet.getEid() + '\"'
					+ ")'><a href='#' >删除");
			outs.append("</a></td>");
		}
		outs.append("</tr>");
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblBanlancesheet() throws Exception {
		Date tmpDate = null;
		
		try {
			blch = banlanceSheetDao.get(kid);
			blch.setType(type);
			if (type == '0') {
				tmpDate = new SimpleDateFormat("yyyy").parse(date);
			} else {
				tmpDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			blch.setDate(tmpDate);
				
			blch.setTotalAssets(totalAssets);
			blch.setCurrentAssets(currentAssets);
			blch.setMoneyFunds(moneyFunds);
			blch.setTemporaryInvestment(temporaryInvestment);
			blch.setNoteReceivable(noteReceivable);
			blch.setReceivables(receivables);
			blch.setPrepaidAccounts(prepaidAccounts);
			blch.setOtherReceivables(otherReceivables);
			blch.setInventory(inventory);
			blch.setUnamortizedExpenditures(unamortizedExpenditures);
			blch.setLongtermInvestments(longtermInvestments);
			blch.setNetFixedAssets(netFixedAssets);
			blch.setIntangibleandDeferredAssets(intangibleandDeferredAssets);
			blch.setTotalIndebtedness(totalIndebtedness);
			blch.setCurrentLiabilities(currentLiabilities);
			blch.setShorttermLoans(shorttermLoans);
			blch.setNotesPayable(notesPayable);
			blch.setAccountPayable(accountPayable);
			blch.setDepositReceived(depositReceived);
			blch.setOtherPayables(otherPayables);
			blch.setLtldwoy(ltldwoy);
			blch.setLongtermDebt(longtermDebt);
			blch.setLongtermLoans(longtermLoans);
			blch.setBondPayable(bondPayable);
			blch.setLongtermPayables(longtermPayables);
			blch.setOwnerEquity(ownerEquity);
			blch.setPaidupCapital(paidupCapital);
			blch.setCapitalReserve(capitalReserve);
			blch.setUndistributedProfit(undistributedProfit);
			
			banlanceSheetDao.update(blch);
			tools.fillQueryInfo(1, eid, "TblBanlancesheet");
		} catch (Exception e) {
			errorMsg = "修改资产负债表数据失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblBanlancesheet() throws Exception {
		TblBanlancesheet bi = banlanceSheetDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到资产负债数据" + kid);
			return;
		}
		tools.outputInfo(JSONObject.fromObject(bi, tools.getJsonConfig()));
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

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Double getCurrentAssets() {
		return currentAssets;
	}

	public void setCurrentAssets(Double currentAssets) {
		this.currentAssets = currentAssets;
	}

	public Double getMoneyFunds() {
		return moneyFunds;
	}

	public void setMoneyFunds(Double moneyFunds) {
		this.moneyFunds = moneyFunds;
	}

	public Double getTemporaryInvestment() {
		return temporaryInvestment;
	}

	public void setTemporaryInvestment(Double temporaryInvestment) {
		this.temporaryInvestment = temporaryInvestment;
	}

	public Double getNoteReceivable() {
		return noteReceivable;
	}

	public void setNoteReceivable(Double noteReceivable) {
		this.noteReceivable = noteReceivable;
	}

	public Double getReceivables() {
		return receivables;
	}

	public void setReceivables(Double receivables) {
		this.receivables = receivables;
	}

	public Double getPrepaidAccounts() {
		return prepaidAccounts;
	}

	public void setPrepaidAccounts(Double prepaidAccounts) {
		this.prepaidAccounts = prepaidAccounts;
	}

	public Double getOtherReceivables() {
		return otherReceivables;
	}

	public void setOtherReceivables(Double otherReceivables) {
		this.otherReceivables = otherReceivables;
	}

	public Double getInventory() {
		return inventory;
	}

	public void setInventory(Double inventory) {
		this.inventory = inventory;
	}

	public Double getUnamortizedExpenditures() {
		return unamortizedExpenditures;
	}

	public void setUnamortizedExpenditures(Double unamortizedExpenditures) {
		this.unamortizedExpenditures = unamortizedExpenditures;
	}

	public Double getLongtermInvestments() {
		return longtermInvestments;
	}

	public void setLongtermInvestments(Double longtermInvestments) {
		this.longtermInvestments = longtermInvestments;
	}

	public Double getNetFixedAssets() {
		return netFixedAssets;
	}

	public void setNetFixedAssets(Double netFixedAssets) {
		this.netFixedAssets = netFixedAssets;
	}

	public Double getIntangibleandDeferredAssets() {
		return intangibleandDeferredAssets;
	}

	public void setIntangibleandDeferredAssets(Double intangibleandDeferredAssets) {
		this.intangibleandDeferredAssets = intangibleandDeferredAssets;
	}

	public Double getTotalIndebtedness() {
		return totalIndebtedness;
	}

	public void setTotalIndebtedness(Double totalIndebtedness) {
		this.totalIndebtedness = totalIndebtedness;
	}

	public Double getCurrentLiabilities() {
		return currentLiabilities;
	}

	public void setCurrentLiabilities(Double currentLiabilities) {
		this.currentLiabilities = currentLiabilities;
	}

	public Double getShorttermLoans() {
		return shorttermLoans;
	}

	public void setShorttermLoans(Double shorttermLoans) {
		this.shorttermLoans = shorttermLoans;
	}

	public Double getNotesPayable() {
		return notesPayable;
	}

	public void setNotesPayable(Double notesPayable) {
		this.notesPayable = notesPayable;
	}

	public Double getAccountPayable() {
		return accountPayable;
	}

	public void setAccountPayable(Double accountPayable) {
		this.accountPayable = accountPayable;
	}

	public Double getDepositReceived() {
		return depositReceived;
	}

	public void setDepositReceived(Double depositReceived) {
		this.depositReceived = depositReceived;
	}

	public Double getOtherPayables() {
		return otherPayables;
	}

	public void setOtherPayables(Double otherPayables) {
		this.otherPayables = otherPayables;
	}

	public Double getLtldwoy() {
		return ltldwoy;
	}

	public void setLtldwoy(Double ltldwoy) {
		this.ltldwoy = ltldwoy;
	}

	public Double getLongtermDebt() {
		return longtermDebt;
	}

	public void setLongtermDebt(Double longtermDebt) {
		this.longtermDebt = longtermDebt;
	}

	public Double getLongtermLoans() {
		return longtermLoans;
	}

	public void setLongtermLoans(Double longtermLoans) {
		this.longtermLoans = longtermLoans;
	}

	public Double getBondPayable() {
		return bondPayable;
	}

	public void setBondPayable(Double bondPayable) {
		this.bondPayable = bondPayable;
	}

	public Double getLongtermPayables() {
		return longtermPayables;
	}

	public void setLongtermPayables(Double longtermPayables) {
		this.longtermPayables = longtermPayables;
	}

	public Double getOwnerEquity() {
		return ownerEquity;
	}

	public void setOwnerEquity(Double ownerEquity) {
		this.ownerEquity = ownerEquity;
	}

	public Double getPaidupCapital() {
		return paidupCapital;
	}

	public void setPaidupCapital(Double paidupCapital) {
		this.paidupCapital = paidupCapital;
	}

	public Double getCapitalReserve() {
		return capitalReserve;
	}

	public void setCapitalReserve(Double capitalReserve) {
		this.capitalReserve = capitalReserve;
	}

	public Double getUndistributedProfit() {
		return undistributedProfit;
	}

	public void setUndistributedProfit(Double undistributedProfit) {
		this.undistributedProfit = undistributedProfit;
	}

	public void setBanlanceSheetDao(BanlanceSheetDao banlanceSheetDao) {
		this.banlanceSheetDao = banlanceSheetDao;
	}

	public TblBanlancesheet getBlch() {
		return blch;
	}

	public void setBlch(TblBanlancesheet blch) {
		this.blch = blch;
	}
}
