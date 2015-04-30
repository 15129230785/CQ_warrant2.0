package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.bean.CompanyType;
import com.cq.dao.SrvchkDao;
import com.cq.table.TblCfgSrvchk;
import com.cq.util.GlobalData;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="业务检查参数", dataName="cs")
public class TblCfgSrvchkAction {
	static Logger log = Logger.getLogger(TblCfgSrvchkAction.class);
	private String errorMsg;
	
	private int id;
	private String comtype;
	private double comrevenue;
	private int employee;
	private int year;
	private double mortgage;
	private String address;
	private String vocation;
	private double income;
	private double personmortgage;
	
	private TblCfgSrvchk cs;
	
	@Resource SrvchkDao srvchkDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String update() throws Exception {
		List<TblCfgSrvchk> scl = null;
		TblCfgSrvchk sc = null;
		
		try {
			scl = srvchkDao.list();
			if (scl == null || scl.size() == 0) {
				tools.returnError(log, "系统中没有要修改的数据");
				return "error";
			} else {
				cs = sc;
				cs = scl.get(0);
				
				cs.setComtype(comtype);
				cs.setComrevenue(comrevenue);
				cs.setEmployee(employee);
				cs.setYear(year);
				cs.setMortgage(mortgage);
				cs.setAddress(address);
				cs.setVocation(vocation);
				cs.setIncome(income);
				cs.setPersonmortgage(personmortgage);
				
				srvchkDao.update(cs);
			}
		} catch (Exception e) {
			errorMsg = "修改失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void list() throws Exception {
		StringBuffer outs = null;

		TblCfgSrvchk sc = null;
		List<TblCfgSrvchk> scl = null;

		scl = srvchkDao.list();
		if (scl == null || scl.size() == 0) {
			tools.outputInfo(new StringBuffer("<p>没有配置业务检查参数信息。</p>"));
		} else {
			outs = new StringBuffer();
			sc = scl.get(0);
			comtype = sc.getComtype();
			comrevenue = sc.getComrevenue();
			employee = sc.getEmployee();
			year = sc.getYear();
			mortgage = sc.getMortgage();
			address = sc.getAddress();
			vocation = sc.getVocation();
			income = sc.getIncome();
			personmortgage = sc.getPersonmortgage();

			String chnComtype = changeEngToChn(comtype);

			outs.append("<p>企业客户业务参数</p>");
			outs.append("<table width='100%' border='0' align='center'>");
			outs.append("<tr>");
			outs.append("<td width='150px'>允许担保的行业</td>");
			outs.append("<td width='150px'>企业营业收入</td>");
			outs.append("<td width='150px'>企业从业人数</td>");
			outs.append("<td width='150px'>企业连续经营年限</td>");
			outs.append("<td width='150px'>企业可抵押资产占比</td>");
			outs.append("</tr>");
			outs.append("<tr>");
			outs.append("<td width='150px'><a href='#'  onclick='updateSrvChkJs("
					+ '\"' + comtype + '\"' + ',' + comrevenue + ',' + employee
					+ ',' + year + ',' + mortgage + ',' + '\"' + address + '\"'
					+ ',' + '\"' + vocation + '\"' + ',' + income + ','
					+ personmortgage + ")'>" + chnComtype);
			outs.append("</td>");
			outs.append("<td width='150px'>" + comrevenue);
			outs.append("</td>");
			outs.append("<td width='150px'>" + employee);
			outs.append("</td>");
			outs.append("<td width='150px'>" + year);
			outs.append("</td>");
			outs.append("<td width='150px'>" + mortgage);
			outs.append("</td>");
			outs.append("</tr>");
			outs.append("</table>");

			outs.append("<p>个人客户业务参数</p>");
			outs.append("<table>");
			outs.append("<tr>");
			outs.append("<td width='150px'>户口所在地</td>");
			outs.append("<td width='150px'>职业</td>");
			outs.append("<td width='150px'>年收入情况</td>");
			outs.append("<td width='150px'>个人可抵押资产占比</td>");
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td width='150px'>" + address);
			outs.append("</td>");
			outs.append("<td width='150px'>" + vocation);
			outs.append("</td>");
			outs.append("<td width='150px'>" + income);
			outs.append("</td>");
			outs.append("<td width='150px'>" + personmortgage);
			outs.append("</td>");
			outs.append("</tr>");
			outs.append("</table>");
			
			tools.outputInfo(outs);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	private String changeEngToChn(String comtype) {
		String cString = "";
		String temp = null;

		String[] name = comtype.split(",");

		int ctlen = GlobalData.companyTypes.size(); 
		for (int i = 0; i < name.length; i++) {
			temp = "";
			for (int j = 0; j < ctlen; j++) {
				CompanyType ct = GlobalData.companyTypes.get(j);
				if (ct.getName().equals(name[i])) {
					temp = ct.getCname();
				}
			}
			
			if (!StringUtils.isBlank(temp)) {
				cString += temp;
				cString += ",";
			}
		}
		if (cString.length() > 1)
			cString = cString.substring(0, cString.length() - 1);

		return cString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComtype() {
		return comtype;
	}

	public void setComtype(String comtype) {
		this.comtype = comtype;
	}

	public double getComrevenue() {
		return comrevenue;
	}

	public void setComrevenue(double comrevenue) {
		this.comrevenue = comrevenue;
	}

	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMortgage() {
		return mortgage;
	}

	public void setMortgage(double mortgage) {
		this.mortgage = mortgage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getPersonmortgage() {
		return personmortgage;
	}

	public void setPersonmortgage(double personmortgage) {
		this.personmortgage = personmortgage;
	}

	public void setSrvchkDao(SrvchkDao srvchkDao) {
		this.srvchkDao = srvchkDao;
	}

	public TblCfgSrvchk getCs() {
		return cs;
	}

	public void setCs(TblCfgSrvchk cs) {
		this.cs = cs;
	}
}
