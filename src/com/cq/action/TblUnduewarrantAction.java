package com.cq.action;

import java.text.DateFormat;
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
import com.cq.dao.UnduewarrantDao;
import com.cq.table.TblUnduewarrant;
import com.cq.util.GlobalData;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业未到期对外担保信息", dataName="uw")
public class TblUnduewarrantAction {
	static Logger log = Logger.getLogger(TblUnduewarrantAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private String warrantor;
	private String warrantee;
	private String startDate;
	private String endDate;
	private String bank;
	private char mode;
	private double money;
	private double remaining;
	private String Relation;
	private TblUnduewarrant uw;
	
	@Resource UnduewarrantDao unduewarrantDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblUnduewarrant() throws Exception {
		Date tmpDate = null;

		try {
			TblUnduewarrant tblUnduewarrant = new TblUnduewarrant();
			tblUnduewarrant.setEid(eid);
			tblUnduewarrant.setWarrantor(warrantor);
			tblUnduewarrant.setWarrantee(warrantee);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = df.parse(startDate);
			tblUnduewarrant.setStartDate(tmpDate);
			tmpDate = df.parse(endDate);
			tblUnduewarrant.setEndDate(tmpDate);
			
			tblUnduewarrant.setBank(bank);
			tblUnduewarrant.setMode(mode);
			tblUnduewarrant.setMoney(money);
			tblUnduewarrant.setRemaining(remaining);
			tblUnduewarrant.setRelation(tools.multiLine(Relation));
            uw = tblUnduewarrant;
			unduewarrantDao.save(tblUnduewarrant);
			tools.fillQueryInfo(1, eid, "TblUnduewarrant");
		} catch (Exception e) {
			errorMsg = "保存企业对外担保信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblUnduewarrant() throws Exception {
		try {
			uw = unduewarrantDao.get(kid);
			unduewarrantDao.delete(kid);
			this.selectAjaxTblUnduewarrant();
		} catch (Exception e) {
			errorMsg = "删除企业对外担保信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblUnduewarrant() throws Exception {
		String warrantee1 = null;
		String startDate1 = null;
		String endDate1 = null;
		String bank1 = null;
		String mode2 = null;
		String relation1 = null;
		StringBuffer outs = null;
		
		List<TblUnduewarrant> listTblUnduewarrant = unduewarrantDao.findByProperty("eid", eid);
		if ((listTblUnduewarrant == null)
				|| !(listTblUnduewarrant.size() > 0)) {
				log.warn("没有查询到企业对外担保信息");
				return;
		}
		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th>被担保人</th>");
		outs.append("<th>担保人</th>");
		outs.append("<th>担保起始日期</th>");
		outs.append("<th>担保终止日期</th>");
		outs.append("<th>贷款行</th>");
		outs.append("<th>担保方式</th>");
		outs.append("<th>担保金额</th>");
		outs.append("<th>目前余额</th>");
		outs.append("<th>双方关系</th>");
		outs.append("<th width='7%'>操作</th>");
		outs.append("</tr>");
		
		for (int i = 0; i < listTblUnduewarrant.size(); i++) {
			warrantee1 = listTblUnduewarrant.get(i).getWarrantee();
			DecimalFormat decimalFormat = new DecimalFormat("###0.00");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			startDate1 = df.format(listTblUnduewarrant.get(i).getStartDate());
			endDate1 = df.format(listTblUnduewarrant.get(i).getEndDate());
			
			bank1 = listTblUnduewarrant.get(i).getBank();
			mode2 = GlobalData.warrantModes.get(
					 Character.toString(listTblUnduewarrant.get(i).getMode()));

			relation1 = listTblUnduewarrant.get(i).getRelation();
			
			outs.append("<tr>");
			outs.append("<td onclick='updateUnduewarrantJs("
					+ listTblUnduewarrant.get(i).getKid()
					+ ")'><a href='#'>" + warrantee1);
			outs.append("</td>");
			outs.append("<td>"
					+ listTblUnduewarrant.get(i).getWarrantor());
			outs.append("</td>");
			outs.append("<td>" + startDate1);
			outs.append("</td>");
			outs.append("<td>" + endDate1);
			outs.append("</td>");
			outs.append("<td>" + bank1);
			outs.append("</td>");
			outs.append("<td>" + mode2);
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblUnduewarrant.get(i).getMoney()));
			outs.append("</td>");
			outs.append("<td>"
					+ decimalFormat.format(listTblUnduewarrant.get(i).getRemaining()));
			outs.append("</td>");
			outs.append("<td>" + relation1);
			outs.append("</td>");
			outs.append("<td onclick='unduewarrantListOne("
					+ listTblUnduewarrant.get(i).getKid() + ','	+ '\"'
					+ listTblUnduewarrant.get(i).getEid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");

		tools.outputInfo(outs);
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblUnduewarrant() throws Exception {
		Date tmpDate = null;

		try {
			uw = unduewarrantDao.get(kid);
			uw.setWarrantor(warrantor);
			uw.setWarrantee(warrantee);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = df.parse(startDate);
			uw.setStartDate(tmpDate);
			tmpDate = df.parse(endDate);
			uw.setEndDate(tmpDate);
			
			uw.setBank(bank);
			uw.setMode(mode);
			uw.setMoney(money);
			uw.setRemaining(remaining);
			uw.setRelation(tools.multiLine(Relation));

			unduewarrantDao.update(uw);
			tools.fillQueryInfo(1, eid, "TblUnduewarrant");
		} catch (Exception e) {
			errorMsg = "保存企业对外担保信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblUnduewarrant() throws Exception {
		TblUnduewarrant bi = unduewarrantDao.get(kid);
		
		if (bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到企业未到期对外担保信息" + kid);
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

	public String getWarrantor() {
		return warrantor;
	}

	public void setWarrantor(String warrantor) {
		this.warrantor = warrantor;
	}

	public String getWarrantee() {
		return warrantee;
	}

	public void setWarrantee(String warrantee) {
		this.warrantee = warrantee;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Character getMode() {
		return mode;
	}

	public void setMode(Character mode) {
		this.mode = mode;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public String getRelation() {
		return Relation;
	}

	public void setRelation(String relation) {
		Relation = relation;
	}

	public void setMode(char mode) {
		this.mode = mode;
	}

	public void setUnduewarrantDao(UnduewarrantDao unduewarrantDao) {
		this.unduewarrantDao = unduewarrantDao;
	}

	public TblUnduewarrant getUw() {
		return uw;
	}

	public void setUw(TblUnduewarrant uw) {
		this.uw = uw;
	}
}
