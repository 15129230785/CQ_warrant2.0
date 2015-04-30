package com.cq.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.CominfoDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCominfo;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业基本信息", dataName="cf")
public class TblCominfoAction {
	static Logger log = Logger.getLogger(TblCominfoAction.class);
	private String errorMsg;
	
	private String taskid;
	private String Eid;
	private String name;
	private String type;
	private String address;
	private String nature;
	private Date FoundDate;
	private String contacts;
	private String phone;
	private String fax;
	private String website;
	private String email;
	private String postCode;
	private String manageArea;
	private String basicBankName;
	private String basicAccount;
	private String mainBusiness;
	private String qualification;
	private TblCominfo cf;
	
	@Resource CominfoDao cominfoDao;
	@Resource TaskBaseService taskBaseService;
	@Resource WarrantinfoDao warrantinfoDao;
	
	// 校验公司信息
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getComInfo() throws Exception {
		TblCominfo te = cominfoDao.findCominfoByEid(Eid);
		if (null == te || "".equals(te)) {
			te = null;
		}
		tools.outputInfo(JSONObject.fromObject(te, tools.getJsonConfig()));
	}
	
	// 验证公司编码是否存在
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void cominfoeid() throws Exception {
		String str = "sf";
		
		try {
			TblCominfo cominfo = cominfoDao.findCominfoByEid(Eid);
			if (cominfo != null) {
				str = "sd";
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "验证公司编码失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void cominname() throws Exception {
		String str = "fh";
		try {
			List<TblCominfo> listTblCominfo = cominfoDao.findByProperty("name", name);
			if (listTblCominfo.size() == 0) {
				str = "hf";
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "验证公司名称失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void savaTblCominfo() throws Exception {
		TblCominfo tblCominfo = null;

		try {
			tblCominfo = new TblCominfo();
			tblCominfo.setEid(Eid);
			tblCominfo.setName(name);
			tblCominfo.setType(type);
			tblCominfo.setAddress(address);
			tblCominfo.setNature(nature);
			tblCominfo.setFoundDate(FoundDate);
			tblCominfo.setContacts(contacts);
			tblCominfo.setPhone(phone);
			tblCominfo.setFax(fax);
			tblCominfo.setWebsite(website);
			tblCominfo.setEmail(email);
			tblCominfo.setPostCode(postCode);
			tblCominfo.setManageArea(manageArea);
			tblCominfo.setBasicBankName(basicBankName);
			tblCominfo.setBasicAccount(basicAccount);
			tblCominfo.setMainBusiness(tools.multiLine(mainBusiness));
			tblCominfo.setQualification(tools.multiLine(qualification));
			
			cf = tblCominfo;
			cominfoDao.save(tblCominfo);
			if (taskid != null) {
				taskBaseService.setTaskVar(taskid, "Eid", Eid);
			}
		} catch (Exception e) {
			errorMsg = "保存公司基本信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void updateTblCominfo() throws Exception {
		TblCominfo tblCominfo = null;
		
		try {
			tblCominfo = cominfoDao.findCominfoByEid(Eid);
			
			tblCominfo.setName(name);
			tblCominfo.setType(type);
			tblCominfo.setAddress(address);
			tblCominfo.setNature(nature);
			tblCominfo.setFoundDate(FoundDate);
			tblCominfo.setContacts(contacts);
			tblCominfo.setPhone(phone);
			tblCominfo.setFax(fax);
			tblCominfo.setWebsite(website);
			tblCominfo.setEmail(email);
			tblCominfo.setPostCode(postCode);
			tblCominfo.setManageArea(manageArea);
			tblCominfo.setBasicBankName(basicBankName);
			tblCominfo.setBasicAccount(basicAccount);
			tblCominfo.setMainBusiness(mainBusiness);
			tblCominfo.setQualification(qualification);

			cf = tblCominfo; 
			cominfoDao.update(tblCominfo);
			
			taskBaseService.setTaskVar(taskid, "Eid", Eid);
		} catch (Exception e) {
			errorMsg = "修改公司基本信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	/**
	 * Add by Luke on 2015/04/03, for modifying basic information of company which has no tasks.
	 * 
	 * @throws Exception
	 */
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void updateCompanyBasicInfo() throws Exception {
		TblCominfo tblCominfo = null;
		
		try {
			tblCominfo = cominfoDao.findCominfoByEid(Eid);
			
			tblCominfo.setAddress(address);
			tblCominfo.setContacts(contacts);
			tblCominfo.setPhone(phone);
			tblCominfo.setFax(fax);
			tblCominfo.setWebsite(website);
			tblCominfo.setEmail(email);
			tblCominfo.setPostCode(postCode);
			tblCominfo.setManageArea(manageArea);
			tblCominfo.setMainBusiness(mainBusiness);
			tblCominfo.setQualification(qualification);

			cf = tblCominfo; 
			cominfoDao.update(tblCominfo);
			
		} catch (Exception e) {
			errorMsg = "修改公司基本信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	/**
	 * 
	 * @Title: findCompInfoIsOrNot
	 * @Description:(到数据库查询企业基本信息表，看该条数据是否已被保存到数据库)
	 * @return 返回类型 void
	 * @author cfe
	 * @throws Exception 
	 * @date 2014年7月4日 上午10:39:48
	 */
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void findCompInfoIsOrNot() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String eid = request.getParameter("eid");
		int number = 0;
		
		cf = cominfoDao.findCominfoByEid(eid); 
		if (cf != null) {
			number = 1;
		}
		tools.outputInfo(number);
	}

	public String getEid() {
		return Eid;
	}

	public void setEid(String eid) {
		Eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Date getFoundDate() {
		return FoundDate;
	}

	public void setFoundDate(Date foundDate) {
		FoundDate = foundDate;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getManageArea() {
		return manageArea;
	}

	public void setManageArea(String manageArea) {
		this.manageArea = manageArea;
	}

	public String getBasicBankName() {
		return basicBankName;
	}

	public void setBasicBankName(String basicBankName) {
		this.basicBankName = basicBankName;
	}

	public String getBasicAccount() {
		return basicAccount;
	}

	public void setBasicAccount(String basicAccount) {
		this.basicAccount = basicAccount;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public void setCominfoDao(CominfoDao cominfoDao) {
		this.cominfoDao = cominfoDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public TblCominfo getCf() {
		return cf;
	}
	public void setCf(TblCominfo cf) {
		this.cf = cf;
	}
}
