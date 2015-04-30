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
import com.cq.dao.AntiwarrantDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.table.TblAntiwarrant;
import com.cq.table.TblWarrantinfo;
import com.cq.util.GlobalData;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="反担保措施", dataName="taw")
public class TblAntiwarrantAction {
	static Logger log = Logger.getLogger(TblAntiwarrantAction.class);
	private String errorMsg;
	private int kid;
	private String wid;
	private String type;
	private Date startDate;
	private Date endDate;
	private double value;
	private String description;
	
	private TblAntiwarrant taw;
	
	@Resource AntiwarrantDao antiwarrantDao;
	@Resource WarrantinfoDao warrantinfoDao;
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblAntiwarrant() throws Exception {
		try {
			TblAntiwarrant tblAntiwarrant = new TblAntiwarrant();
			tblAntiwarrant.setWid(wid);
			tblAntiwarrant.setType(type);
			tblAntiwarrant.setStartDate(startDate);
			tblAntiwarrant.setEndDate(endDate);
			tblAntiwarrant.setDescription(tools.multiLine(description));
			tblAntiwarrant.setValue(value);
			antiwarrantDao.save(tblAntiwarrant);
			taw = tblAntiwarrant;
			tools.fillQueryInfo(0, wid, "TblAntiwarrant");
		} catch (Exception e) {
			errorMsg = "添加反担保数据失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblAntiwarrant() throws Exception {
		List<TblAntiwarrant> listfdb = null;
		StringBuffer outs = new StringBuffer();
		
		listfdb = antiwarrantDao.findByProperty("wid", wid);
		if (listfdb != null && listfdb.size() > 0) {
			String desc = null;
			String sdate = null;
			String edate = null;
			String strType = null;
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			
			outs.append("<table width='100%'>");
			if (listfdb.size() != 0) {
				outs.append("<tr>");
				outs.append("<th width='20%'>反担保类型</th>");
				outs.append("<th width='12%'>反担保起始日期</th>");
				outs.append("<th width='12%'>反担保终止日期</th>");
				outs.append("<th width='12%'>反担保金额</th>");
				outs.append("<th width='36%'>反担保内容</th>");
				outs.append("<th width='8%'>操作</th>");
				outs.append("</tr>");
			}
			for (int i = 0; i < listfdb.size(); i++) {
				strType = GlobalData.antiWarrantTypes.get(listfdb.get(i).getType());
				
				if ("".equals(listfdb.get(i).getStartDate())
						|| null != listfdb.get(i).getStartDate()) {
					sdate = date.format(listfdb.get(i).getStartDate());
				} else {
					sdate = "";
				}
				if ("".equals(listfdb.get(i).getEndDate())
						|| null != listfdb.get(i).getEndDate()) {
					edate = date.format(listfdb.get(i).getEndDate());
				} else {
					edate = "";
				}
				DecimalFormat decimalFormat = new DecimalFormat("###0.00");
				desc = listfdb.get(i).getDescription();  
			
				outs.append("<tr>");
				outs.append("<td style='word-break:break-all; word-wrap:break-word'><a href='#' onclick='updateFdbJs("
						+ listfdb.get(i).getKid() + ")'>" + strType);
				outs.append("</td>");
				outs.append("<td>" + sdate);
				outs.append("</td>");
				outs.append("<td>" + edate);
				outs.append("</td>");
				outs.append("<td>" + decimalFormat.format(listfdb.get(i).getValue()));
				outs.append("</td>");
				outs.append("<td>" + desc);
				outs.append("</td>");
				outs.append("<td><a href='#' onclick='deleteListOne("
						+ listfdb.get(i).getKid() + ","
						+ "\"" + wid + "\")'>删除");	
				outs.append("</a></td>");
				outs.append("</tr>");
			}
			outs.append("</table>");
		}
		tools.outputInfo(outs);
	} 
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblAntiwarrant() throws Exception {
		try {
			taw = antiwarrantDao.get(kid);
			antiwarrantDao.delete(kid);
			this.selectAjaxTblAntiwarrant();
		} catch (Exception e) {
			errorMsg = "删除反担保数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblAntiwarrant() throws Exception {
		try {
			taw = antiwarrantDao.get(kid);
			taw.setType(type);
			taw.setStartDate(startDate);
			taw.setEndDate(endDate);
			taw.setValue(value);
			taw.setDescription(tools.multiLine(description));
			antiwarrantDao.update(taw);
			tools.fillQueryInfo(0, wid, "TblAntiwarrant");
		} catch (Exception e) {
			errorMsg = "修改反担保数据失败";
			tools.throwException(e, log, errorMsg);
		}
		
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectTblAntiwarrantYzWid() throws Exception{
		String str = "sf";
		
		try {
			TblWarrantinfo wi = warrantinfoDao.findWarrantinfoByWid(wid);
			if (wi != null) {
				str = wi.getWid();
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "获取担保信息时出现异常" + wid;
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void yzAntiwarrantPreserveAjaxZq() throws Exception{
		String str = "fdbsuc";
		
		try {
			List<TblAntiwarrant> awl = antiwarrantDao.findByProperty("wid", wid);
			if (awl != null && awl.size() > 0) {
				TblAntiwarrant aw = null;
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String desc = tools.multiLine(description);
				for (int i = 0; i < awl.size(); i++) {
					aw = awl.get(i);
					if ((type == aw.getType()) 
							&& (sdf.format(startDate).equals(sdf.format(aw.getStartDate()))) 
							&& (sdf.format(endDate).equals(sdf.format(aw.getEndDate())))
							&& (value == aw.getValue())
							&& (desc.equals(aw.getDescription()))) {
						str = aw.getWid();
						break;
					}
				}
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "获取反担保信息时发生异常" + wid;
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblAntiwarrant() throws Exception {
		TblAntiwarrant aw = antiwarrantDao.get(kid);
		
		if(aw == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到反担保数据" + kid);
			return;
		}
		
		tools.outputInfo(JSONObject.fromObject(aw, tools.getJsonConfig()));
	}
	
	public String getWid() {
		return wid;
	}
	
	public void setWid(String wid) {
		this.wid = wid;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getKid() {
		return kid;
	}
	
	public void setKid(int kid) {
		this.kid = kid;
	}

	public void setAntiwarrantDao(AntiwarrantDao antiwarrantDao) {
		this.antiwarrantDao = antiwarrantDao;
	}

	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public TblAntiwarrant getTaw() {
		return taw;
	}

	public void setTaw(TblAntiwarrant taw) {
		this.taw = taw;
	}
}
