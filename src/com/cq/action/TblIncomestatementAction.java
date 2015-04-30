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
import com.cq.dao.IncomestatementDao;
import com.cq.table.TblIncomestatement;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业损益表信息", dataName="icsm")
public class TblIncomestatementAction {
	static Logger log = Logger.getLogger(TblIncomestatementAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private char type;
	private String date;
	private Double salesRevenue;
	private Double costofSales;
	private Double mainBusinessProfit;
	private Double sellingExpenses;
	private Double managementExpenses;
	private Double financingExpenses;
	private Double totalProfits;
	private Double netProfit;
	private TblIncomestatement icsm;
	
	@Resource IncomestatementDao incomestatementDao;
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblIncomestatement() throws Exception {
		TblIncomestatement tblIncomestatement = null;
		Date tmpDate = null;
		
		try {
			tblIncomestatement = new TblIncomestatement();
			tblIncomestatement.setEid(eid);
			tblIncomestatement.setType(type);
			if (type == '0') {
				tmpDate = new SimpleDateFormat("yyyy").parse(date);
			} else {
				tmpDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			tblIncomestatement.setDate(tmpDate);
			
			tblIncomestatement.setSalesRevenue(salesRevenue);
			tblIncomestatement.setCostofSales(costofSales);
			tblIncomestatement.setMainBusinessProfit(mainBusinessProfit);
			tblIncomestatement.setSellingExpenses(sellingExpenses);
			tblIncomestatement.setManagementExpenses(managementExpenses);
			tblIncomestatement.setSellingExpenses(sellingExpenses);
			tblIncomestatement.setManagementExpenses(managementExpenses);
			tblIncomestatement.setFinancingExpenses(financingExpenses);
			tblIncomestatement.setTotalProfits(totalProfits);
			tblIncomestatement.setNetProfit(netProfit);
			icsm = tblIncomestatement;
			incomestatementDao.save(icsm);
			tools.fillQueryInfo(1, eid, "TblIncomestatement");
		} catch (Exception e) {
			errorMsg = "保存企业损益表信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblIncomestatement() throws Exception {
		try {
			icsm = incomestatementDao.get(kid);
			incomestatementDao.delete(kid);
			this.selectAjaxTblIncomestatement();
		} catch (Exception e) {
			errorMsg = "删除企业损益表信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblIncomestatement() throws Exception {
		String date1 = null;
		String Type2 = null;
		StringBuffer outs = null;
		
		List<TblIncomestatement> listTblIncomestatement = incomestatementDao.findByProperty("eid", eid);
		
		if((listTblIncomestatement == null)
				|| !(listTblIncomestatement.size() > 0)) {
			log.warn("没有查询到企业损益表信息");
			return;
		}
		
		outs = new StringBuffer();
		
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='9%'>报表日期</th>");
		outs.append("<th width='9%'>报表类型</th>");
		outs.append("<th width='9%'>产品销售收入</th>");
		outs.append("<th width='9%'>销售成本</th>");
		outs.append("<th width='9%'>主营业务利润</th>");
		outs.append("<th width='9%'>销售费用</th>");
		outs.append("<th width='9%'>管理费用</th>");
		outs.append("<th width='9%'>账务费用</th>");
		outs.append("<th width='9%'>利润总额</th>");
		outs.append("<th width='9%'>净利润</th>");
		outs.append("<th width='10%'>操作</th>");
		outs.append("</tr>");
		
		for (int i = 0; i < listTblIncomestatement.size(); i++) {
			char Type = listTblIncomestatement.get(i).getType();
			if (Type == '0') {
				Type2 = "年度报表";
				date1 = new SimpleDateFormat("yyyy").format(listTblIncomestatement.get(i).getDate());
			} else {
				Type2 = "最新报表";
				date1 = new SimpleDateFormat("yyyy-MM-dd").format(listTblIncomestatement.get(i).getDate());
			}
			DecimalFormat decimalFormat = new DecimalFormat("###0.00");
			
			outs.append("<tr>");
			outs.append("<td width='13%' onclick='updateIncomestatementJs("
					+ listTblIncomestatement.get(i).getKid() 
					+ ")'><a href='#'>" + date1);
			outs.append("</td>");
			outs.append("<td>" + Type2);
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getSalesRevenue()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getCostofSales()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getMainBusinessProfit()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getSellingExpenses()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getManagementExpenses()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getFinancingExpenses()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getTotalProfits()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblIncomestatement.get(i).getNetProfit()));
			outs.append("</td>");
			outs.append("<td onclick='incomestatementListOne("
					+ listTblIncomestatement.get(i).getKid() + ','
					+ '\"' + listTblIncomestatement.get(i).getEid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblIncomestatement() throws Exception {
		Date tmpDate = null;
		
		try {
			icsm = incomestatementDao.get(kid);
			
			if (type == '0') {
				tmpDate = new SimpleDateFormat("yyyy").parse(date);
			} else {
				tmpDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			icsm.setType(type);
			icsm.setDate(tmpDate);
			icsm.setSalesRevenue(salesRevenue);
			icsm.setCostofSales(costofSales);
			icsm.setMainBusinessProfit(mainBusinessProfit);
			icsm.setSellingExpenses(sellingExpenses);
			icsm.setManagementExpenses(managementExpenses);
			icsm.setFinancingExpenses(financingExpenses);
			icsm.setTotalProfits(totalProfits);
			icsm.setNetProfit(netProfit);
			
			tools.fillQueryInfo(1, eid, "TblIncomestatement");
			incomestatementDao.update(icsm);
		} catch (Exception e) {
			errorMsg = "修改企业损益表信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblIncomestatement() throws Exception {
		TblIncomestatement bi = incomestatementDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到企业损益表信息" + kid);
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

	public Double getSalesRevenue() {
		return salesRevenue;
	}

	public void setSalesRevenue(Double salesRevenue) {
		this.salesRevenue = salesRevenue;
	}

	public Double getCostofSales() {
		return costofSales;
	}

	public void setCostofSales(Double costofSales) {
		this.costofSales = costofSales;
	}

	public Double getMainBusinessProfit() {
		return mainBusinessProfit;
	}

	public void setMainBusinessProfit(Double mainBusinessProfit) {
		this.mainBusinessProfit = mainBusinessProfit;
	}

	public Double getSellingExpenses() {
		return sellingExpenses;
	}

	public void setSellingExpenses(Double sellingExpenses) {
		this.sellingExpenses = sellingExpenses;
	}

	public Double getManagementExpenses() {
		return managementExpenses;
	}

	public void setManagementExpenses(Double managementExpenses) {
		this.managementExpenses = managementExpenses;
	}

	public Double getFinancingExpenses() {
		return financingExpenses;
	}

	public void setFinancingExpenses(Double financingExpenses) {
		this.financingExpenses = financingExpenses;
	}

	public Double getTotalProfits() {
		return totalProfits;
	}

	public void setTotalProfits(Double totalProfits) {
		this.totalProfits = totalProfits;
	}

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}

	public void setIncomestatementDao(IncomestatementDao incomestatementDao) {
		this.incomestatementDao = incomestatementDao;
	}

	public TblIncomestatement getIcsm() {
		return icsm;
	}

	public void setIcsm(TblIncomestatement icsm) {
		this.icsm = icsm;
	}
}
