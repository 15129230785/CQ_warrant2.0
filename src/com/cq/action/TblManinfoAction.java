package com.cq.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.ManinfoDao;
import com.cq.table.TblManinfo;
import com.cq.util.GlobalData;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业管理人员信息", dataName="mif")
public class TblManinfoAction {
	static Logger log = Logger.getLogger(TblManinfoAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private String name;
	private char type;
	private char gender;
	private char maritalStatus;
	private Date birthday;
	private String country;
	private char education;
	private String manId;
	private Character yearsOfManager;
	private Character yearsOfVocation;
	private String record;
	private TblManinfo mif;
	
	@Resource ManinfoDao maninfoDao;

	// 验证所有manager信息
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void yzmanagerfhx() throws Exception {
		String sql = null;
		String str = "suc";

		try {
			sql = "from TblManinfo mi where mi.Eid = '" + eid
					+ "' and mi.Name = '" + name
					+ "' and mi.Type = '" + type
					+ "' and mi.ManId = '" + manId + "'";
			List<TblManinfo> listTblManinfo = maninfoDao.findManinfoBySql(sql);
			if (listTblManinfo != null && listTblManinfo.size() > 0) {
				str ="eid";
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "查询企业管理人员信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void applyYanZheng3() throws Exception {
		String str = "mana";
		
		try {
			String sql = "from TblManinfo mi where mi.Eid = '" + eid
					+ "' and mi.Name = '" + name+ "' and mi.Type in('0', '1', '2', '3', '4')";
			
			List<TblManinfo> listTblManinfo = maninfoDao.findManinfoBySql(sql);
			if (listTblManinfo != null && listTblManinfo.size() > 0) {
				str ="eid";
			}
			
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "验证信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblManinfo() throws Exception {
		TblManinfo tblManinfo = null;
		
		try {
			tblManinfo = new TblManinfo();
			tblManinfo.setKid(kid);
			tblManinfo.setEid(eid);
			tblManinfo.setType(type);
			tblManinfo.setName(name);
			tblManinfo.setGender(gender);
			tblManinfo.setMaritalStatus(maritalStatus);
			tblManinfo.setBirthday(birthday);
			tblManinfo.setCountry(country);
			tblManinfo.setEducation(education);
			tblManinfo.setManId(manId);
			tblManinfo.setYearsOfManager(yearsOfManager);
			tblManinfo.setYearsOfVocation(yearsOfVocation);
			tblManinfo.setRecord(tools.multiLine(record));
			tools.fillQueryInfo(1, eid, "TblManinfo");
			mif = tblManinfo;
			maninfoDao.save(tblManinfo);
		} catch (Exception e) {
			errorMsg = "保存企业管理人员信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblManinfo() throws Exception {
		try {
			mif = maninfoDao.get(kid);
			maninfoDao.delete(kid);
			this.selectAjaxTblManinfo();
		} catch (Exception e) {
			errorMsg = "删除企业管理人员信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblManinfo() throws Exception {
		String name1 = null;
		String type2 = null;
		String gender2 = null;
		String maritalStatus2 = null;
		String education2 = null;
		StringBuffer outs = null;
		
		List<TblManinfo> listTblManinfo = maninfoDao.findByProperty("eid", eid);
		if (listTblManinfo == null || listTblManinfo.size() == 0) {
			log.warn("没有查询到企业管理人员信息");
			return;
		}
		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='8%'>姓名</th>");
		outs.append("<th width='15%'>身份证号码</th>");
		outs.append("<th width='8%'>职务类型</th>");
		outs.append("<th width='8%'>性别</th>");
		outs.append("<th width='8%'>婚姻状况</th>");
		outs.append("<th width='8%'>出生日期</th>");
		outs.append("<th width='8%'>国籍</th>");
		outs.append("<th width='8%'>学历</th>");
		outs.append("<th width='8%'>管理经验年限</th>");
		outs.append("<th width='8%'>行业经验年限</th>");
		outs.append("<th width='8%'>主要履历</th>");
		outs.append("<th width='5%'>操作</th>");
		outs.append("</tr>");
		for (int i = 0; i < listTblManinfo.size(); i++) {
			name1 = listTblManinfo.get(i).getName();
			type2 = GlobalData.dutys.get(
					Character.toString(listTblManinfo.get(i).getType()));
			gender2 = GlobalData.gender.get(
					Character.toString(listTblManinfo.get(i).getGender()));
			maritalStatus2 = GlobalData.maritalStatus.get(
					Character.toString(listTblManinfo.get(i).getMaritalStatus()));
			education2 = GlobalData.education.get(
					Character.toString(listTblManinfo.get(i).getEducation()));
				
			outs.append("<tr>");
			outs.append("<td width='8%' onclick='updateManagerJs("
					+ listTblManinfo.get(i).getKid()
					+ ")'><a href='#'>"
					+ name1);
			outs.append("</td>");
			outs.append("<td>" + listTblManinfo.get(i).getManId());
			outs.append("</td>");
			outs.append("<td>" + type2);
			outs.append("</td>");
			outs.append("<td>" + gender2);
			outs.append("</td>");
			outs.append("<td>" + maritalStatus2);
			outs.append("</td>");
			outs.append("<td>"
					+ listTblManinfo.get(i).getBirthday());
			outs.append("</td>");
			outs.append("<td>"
					+ listTblManinfo.get(i).getCountry());
			outs.append("</td>");
			outs.append("<td>" + education2);
			outs.append("</td>");
			outs.append("<td>"
					+ listTblManinfo.get(i).getYearsOfManager());
			outs.append("</td>");
			outs.append("<td>"
					+ listTblManinfo.get(i).getYearsOfVocation());
			outs.append("</td>");
			outs.append("<td>"
					+ listTblManinfo.get(i).getRecord());
			outs.append("</td>");
			outs.append("<td onclick='managerListOne("
					+ listTblManinfo.get(i).getKid() + ','
					+ '\"' + listTblManinfo.get(i).getEid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblManinfo() throws Exception {
		try {
			mif = maninfoDao.get(kid);
			mif.setType(type);
			mif.setName(name);
			mif.setGender(gender);
			mif.setMaritalStatus(maritalStatus);
			mif.setBirthday(birthday);
			mif.setCountry(country);
			mif.setEducation(education);
			mif.setManId(manId);
			mif.setYearsOfManager(yearsOfManager);
			mif.setYearsOfVocation(yearsOfVocation);
			mif.setRecord(tools.multiLine(record));
			tools.fillQueryInfo(1, eid, "TblManinfo");
			maninfoDao.update(mif);
		} catch (Exception e) {
			errorMsg = "修改企业管理人员信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblManinfo() throws Exception {
		TblManinfo bi = maninfoDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到企业管理人员信息" + kid);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public char getEducation() {
		return education;
	}

	public void setEducation(char education) {
		this.education = education;
	}

	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public Character getYearsOfManager() {
		return yearsOfManager;
	}

	public void setYearsOfManager(Character yearsOfManager) {
		this.yearsOfManager = yearsOfManager;
	}

	public Character getYearsOfVocation() {
		return yearsOfVocation;
	}

	public void setYearsOfVocation(Character yearsOfVocation) {
		this.yearsOfVocation = yearsOfVocation;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public void setManinfoDao(ManinfoDao maninfoDao) {
		this.maninfoDao = maninfoDao;
	}

	public TblManinfo getMif() {
		return mif;
	}

	public void setMif(TblManinfo mif) {
		this.mif = mif;
	}
}
