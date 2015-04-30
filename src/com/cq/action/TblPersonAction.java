package com.cq.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.PersonDao;
import com.cq.service.TaskBaseService;
import com.cq.table.TblPerson;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="个人基本信息", dataName="person")
public class TblPersonAction {
	static Logger log = Logger.getLogger(TblPersonAction.class);
	private String errorMsg;
	
	private String taskid;
	private String perID;
	private String name;
	private char gender;
	private String birthday;
	private String address;
	private String registerAddress;
	private String vocation;
	private String mobile;
	private String fix;
	private String email;
	private String description;
	private TblPerson person;
	
	@Resource PersonDao personDao;
	@Resource TaskBaseService taskBaseService;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void savaTblPerson() throws Exception {
		DateFormat df = null;
		TblPerson tp = null;

		try {
			df = new SimpleDateFormat("yyyy-MM-dd");

			tp = new TblPerson();
			tp.setId(perID);
			tp.setName(name);
			tp.setGender(gender);
			tp.setBirthday(df.parse(birthday));
			tp.setAddress(address);
			tp.setRegisterAddress(registerAddress);
			tp.setVocation(vocation);
			tp.setMobile(mobile);
			tp.setFix(fix);
			tp.setEmail(email);
			tp.setDescription(tools.multiLine(description));
			
			person = tp;
			personDao.save(tp);
			
			if (taskid != null) {
				taskBaseService.setTaskVar(taskid, "PerID", perID);
			}
		} catch (Exception e) {
			errorMsg = "添加个人基本信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void updateTblPerson() throws Exception {
		DateFormat df = null;
		TblPerson tp = null;

		try {
			df = new SimpleDateFormat("yyyy-MM-dd");
			tp = personDao.findPersonByID(perID);

			tp.setName(name);
			tp.setGender(gender);
			tp.setBirthday(df.parse(birthday));
			tp.setAddress(address);
			tp.setRegisterAddress(registerAddress);
			tp.setVocation(vocation);
			tp.setMobile(mobile);
			tp.setFix(fix);
			tp.setEmail(email);
			tp.setDescription(tools.multiLine(description));

			person = tp;
			personDao.update(tp);
			
			taskBaseService.setTaskVar(taskid, "PerID", perID);
		} catch (Exception e) {
			errorMsg = "修改个人基本信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	/**
	 * Add by Luke on 2015/04/03, for modifying person information which has no tasks
	 * 
	 * @throws Exception
	 */
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void updatePersonBasicInfo() throws Exception {
		TblPerson tp = null;

		try {
			tp = personDao.findPersonByID(perID);

			tp.setAddress(address);
			tp.setRegisterAddress(registerAddress);
			tp.setVocation(vocation);
			tp.setMobile(mobile);
			tp.setFix(fix);
			tp.setEmail(email);
			tp.setDescription(tools.multiLine(description));

			person = tp;
			personDao.update(tp);
		} catch (Exception e) {
			errorMsg = "修改个人基本信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getPersonInfo() throws Exception {
		try {
			TblPerson person = null;
			person = personDao.findPersonByID(perID);

			if (person != null) {
				tools.outputInfo(JSONObject.fromObject(person, tools.getJsonConfig()));
			} else {
				tools.outputInfo(JSONObject.fromObject(null));
			}
		} catch (Exception e) {
			errorMsg = "获取个人基本信息失败";
			tools.throwException(e, log, errorMsg);
		}
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPerID() {
		return perID;
	}

	public void setPerID(String perID) {
		this.perID = perID;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public TblPerson getPerson() {
		return person;
	}

	public void setPerson(TblPerson person) {
		this.person = person;
	}
}