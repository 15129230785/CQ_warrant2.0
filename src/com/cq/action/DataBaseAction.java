package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.cq.dao.CominfoDao;
import com.cq.dao.PersonDao;
import com.cq.dao.ReginfoDao;
import com.cq.table.TblCominfo;
import com.cq.table.TblPerson;
import com.cq.table.TblReginfo;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class DataBaseAction {
	static Logger log = Logger.getLogger(DataBaseAction.class);
	private String errorMsg;
	
	private String rid;
	private String eid;
	private String personid;
	
	@Resource CominfoDao cominfoDao;
	@Resource PersonDao personDao;
	@Resource ReginfoDao reginfoDao;

	public void CheckEID() throws Exception {
		try {
			TblCominfo cominfo = cominfoDao.findCominfoByEid(eid);
			
			if(cominfo == null) {
				tools.outputInfo("0");
			} else {
				tools.outputInfo(eid);
			}
		} catch (Exception e) {
			errorMsg = "查询企业基本信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void CheckRID() throws Exception {
		List<TblReginfo> reginfo = reginfoDao.findByProperty("rid", rid);
		
		try {
			if(reginfo == null || reginfo.size() == 0) {
				tools.outputInfo("0");
			} else if (reginfo.size() == 1) {
				tools.outputInfo(rid);
			} else {
				errorMsg = "有注册代码重复的公司信息";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
		} catch (Exception e) {
			errorMsg = "查询企业注册信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void CheckPerID() throws Exception {
		try {
			TblPerson person = personDao.findPersonByID(personid);
			
			if(person == null) {
				tools.outputInfo("0");
			} else {
				tools.outputInfo(personid);
			}
		} catch (Exception e) {
			errorMsg = "查询个人信息表时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}
	
	public void setCominfoDao(CominfoDao cominfoDao) {
		this.cominfoDao = cominfoDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void setReginfoDao(ReginfoDao reginfoDao) {
		this.reginfoDao = reginfoDao;
	}
}
