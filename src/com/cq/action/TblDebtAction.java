package com.cq.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.DebtDao;
import com.cq.table.TblDebt;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="个人债务信息", dataName="db")
public class TblDebtAction {
	static Logger log = Logger.getLogger(TblDebtAction.class);
	private String errorMsg;
	
	private int kid;
	private String id;
	private String loaner;
	private String startDate;
	private String endDate;
	private double money;
	private double remaining;
	private String description;
	private TblDebt db;
	
	@Resource DebtDao debtDao;
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblDebt() throws Exception{
		Date tmpDate = null;
		TblDebt td = null;
		
		try {
			td = new TblDebt();
			
			td.setId(id);
			td.setLoaner(loaner);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = df.parse(startDate);
			td.setStartDate(tmpDate);
			tmpDate = df.parse(endDate);
			td.setEndDate(tmpDate);
			
			td.setMoney(money);
			td.setRemaining(remaining);
			td.setDescription(tools.multiLine(description));
            db = td;
			debtDao.save(db);
			tools.fillQueryInfo(3, id, "TblDebt");
		} catch (Exception e) {
			errorMsg = "保存个人债务信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblDebt() throws Exception {
		try {
			db = debtDao.get(kid);
			debtDao.delete(kid);
			this.selectAjaxTblDebt();
		} catch (Exception e) {
			errorMsg = "删除失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblDebt() throws Exception {
		TblDebt td = null;
		
		String startDate1 = null;
		String endDate1 = null;
		StringBuffer outs = null;
		
		List<TblDebt> listTblDebt = debtDao.findByProperty("id", id);
		if (listTblDebt == null || listTblDebt.size() == 0) {
			log.warn("没有查询到个人债务信息");
			return;
		}
		
		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='15%'>债权人</th>");
		outs.append("<th width='15%'>债务起始日期</th>");
		outs.append("<th width='15%'>债务终止日期</th>");
		outs.append("<th width='12%'>金额</th>");
		outs.append("<th width='12%'>余额</th>");
		outs.append("<th width='20%'>说明</th>");
		outs.append("<th width='9%'>操作</th>");
		outs.append("</tr>");
			
		for (int i = 0; i < listTblDebt.size(); i++) {
			td = listTblDebt.get(i);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			startDate1 = df.format(td.getStartDate());
			endDate1 = df.format(td.getEndDate());
			
			outs.append("<tr>");
			outs.append("<td onclick='updateDebtJs("
					+ td.getKid()
					+ ")'><a href='#'>" + td.getLoaner());
			outs.append("</td>");
			outs.append("<td>" + startDate1);
			outs.append("</td>");
			outs.append("<td>" + endDate1);
			outs.append("</td>");
			outs.append("<td>" + td.getMoney());
			outs.append("</td>");
			outs.append("<td>" + td.getRemaining());
			outs.append("</td>");
			outs.append("<td>" + td.getDescription());
			outs.append("</td>");
			outs.append("<td onclick='debtListOne("
					+ td.getKid() + ','
					+ '\"' + td.getId() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblDebt() throws Exception {
		Date tmpDate = null;
		try {
			db = debtDao.get(kid);

			db.setLoaner(loaner);
				
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = df.parse(startDate);
			db.setStartDate(tmpDate);
			tmpDate = df.parse(endDate);
			db.setEndDate(tmpDate);
				
			db.setMoney(money);
			db.setRemaining(remaining);
			db.setDescription(tools.multiLine(description));
			tools.fillQueryInfo(3, id, "TblDebt");
			debtDao.update(db);
		} catch (Exception e) {
			errorMsg = "修改失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblDebt() throws Exception {
		TblDebt bi = debtDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到个人债务信息" + kid);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoaner() {
		return loaner;
	}

	public void setLoaner(String loaner) {
		this.loaner = loaner;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDebtDao(DebtDao debtDao) {
		this.debtDao = debtDao;
	}

	public TblDebt getDb() {
		return db;
	}

	public void setDb(TblDebt db) {
		this.db = db;
	}
}
