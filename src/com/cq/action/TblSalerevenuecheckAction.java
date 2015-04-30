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
import com.cq.dao.SalerevenuecheckDao;
import com.cq.table.TblSalerevenuecheck;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="销售收入核查信息", dataName="srck")
public class TblSalerevenuecheckAction {
	static Logger log = Logger.getLogger(TblSalerevenuecheckAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private char type;
	private String date;
	private double revenueBasedForm;
	private double revenueBasedTax;
	private double revenueNoTax;
	private double lenderSum;
	private TblSalerevenuecheck srck;
	
	@Resource SalerevenuecheckDao salerevenuecheckDao;
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblSalerevenuecheck() throws Exception{
		TblSalerevenuecheck tblSalerevenuecheck = null;
		Date tmpDate = null;
		
		try {
			tblSalerevenuecheck = new TblSalerevenuecheck();
			tblSalerevenuecheck.setEid(eid);
			tblSalerevenuecheck.setType(type);
			
			if (type == '0') {
				tmpDate = new SimpleDateFormat("yyyy").parse(date);
			} else {
				tmpDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			tblSalerevenuecheck.setDate(tmpDate);
			
			tblSalerevenuecheck.setRevenueBasedForm(revenueBasedForm);
			tblSalerevenuecheck.setRevenueBasedTax(revenueBasedTax);
			tblSalerevenuecheck.setRevenueNoTax(revenueNoTax);
			tblSalerevenuecheck.setLenderSum(lenderSum);
            srck = tblSalerevenuecheck;
			salerevenuecheckDao.save(srck);
			tools.fillQueryInfo(1, eid, "TblSalerevenuecheck");
		} catch (Exception e) {
			errorMsg = "保存企业销售收入核查信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblSalerevenuecheck() throws Exception {
		try {
			srck = salerevenuecheckDao.get(kid);
			salerevenuecheckDao.delete(kid);
			this.selectAjaxTblSalerevenuecheck();
		} catch (Exception e) {
			errorMsg = "删除企业销售收入核查信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblSalerevenuecheck() throws Exception {
		String date1 = null;
		String Type2 = null;
		StringBuffer outs = null;
		
		List<TblSalerevenuecheck> listTblSalerevenuecheck = salerevenuecheckDao.findByProperty("eid", eid);
		
		if((listTblSalerevenuecheck == null)
				|| !(listTblSalerevenuecheck.size() > 0)) {
			log.warn("没有查询到企业销售收入核查信息");
			return;
		}
		
		outs = new StringBuffer();
		
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='16%'>报表日期</th>");
		outs.append("<th width='16%'>报表类型</th>");
		outs.append("<th width='16%'>财报销售收入</th>");
		outs.append("<th width='16%'>对比相关税务凭证返算收入</th>");
		outs.append("<th width='16%'>未纳税营业收入</th>");
		outs.append("<th width='16%'>重要账户对账单贷方总额</th>");
		outs.append("<th width='4%'>操作</th>");
		outs.append("</tr>");
			
		for (int i = 0; i < listTblSalerevenuecheck.size(); i++) {
			char Type = listTblSalerevenuecheck.get(i).getType();
			if (Type == '0') {
				Type2 = "年度报表";
				date1 = new SimpleDateFormat("yyyy").format(listTblSalerevenuecheck.get(i).getDate());
			} else {
				Type2 = "最新报表";
				date1 = new SimpleDateFormat("yyyy-MM-dd").format(listTblSalerevenuecheck.get(i).getDate());
			}
			DecimalFormat decimalFormat=new DecimalFormat("###0.00");
			
			outs.append("<tr>");
			outs.append("<td onclick='updateSalerevenuecheckJs("
					+ listTblSalerevenuecheck.get(i).getKid()
					+ ")'><a href='#'>" + date1);
			outs.append("</td>");
			outs.append("<td>" + Type2);
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblSalerevenuecheck.get(i).getRevenueBasedForm()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblSalerevenuecheck.get(i).getRevenueBasedTax()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblSalerevenuecheck.get(i).getRevenueNoTax()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblSalerevenuecheck.get(i).getLenderSum()));
			outs.append("</td>");
			outs.append("<td onclick='salerevenuecheckListOne("
					+ listTblSalerevenuecheck.get(i).getKid() + ','
					+ '\"' + listTblSalerevenuecheck.get(i).getEid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblSalerevenuecheck() throws Exception {
		Date tmpDate = null;
		srck = null;
		
		try {
			srck = salerevenuecheckDao.get(kid);
			srck.setType(type);
			if (type == '0') {
				tmpDate = new SimpleDateFormat("yyyy").parse(date);
			} else {
				tmpDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			srck.setDate(tmpDate);
			srck.setRevenueBasedForm(revenueBasedForm);
			srck.setRevenueBasedTax(revenueBasedTax);
			srck.setRevenueNoTax(revenueNoTax);
			srck.setLenderSum(lenderSum);
			tools.fillQueryInfo(1, eid, "TblSalerevenuecheck");
			salerevenuecheckDao.update(srck);
		} catch (Exception e) {
			errorMsg = "修改企业销售收入核查信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblSalerevenuecheck() throws Exception {
		TblSalerevenuecheck bi = salerevenuecheckDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到销售收入核查信息" + kid);
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

	public void setSalerevenuecheckDao(SalerevenuecheckDao salerevenuecheckDao) {
		this.salerevenuecheckDao = salerevenuecheckDao;
	}

	public TblSalerevenuecheck getSrck() {
		return srck;
	}

	public void setSrck(TblSalerevenuecheck srck) {
		this.srck = srck;
	}
}
