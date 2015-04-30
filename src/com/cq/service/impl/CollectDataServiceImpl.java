package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.DocchklistDao;
import com.cq.dao.WarrantindexDao;
import com.cq.service.CollectDataService;
import com.cq.table.TblDocchklist;
import com.cq.table.TblWarrantindex;
import com.cq.util.WarrantException;
import com.cq.util.tools;

@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
public class CollectDataServiceImpl implements CollectDataService {
	static Logger log = Logger.getLogger(CollectDataServiceImpl.class);
	private String errorMsg;
	
	private DocchklistDao docchklistDao;
	private WarrantindexDao warrantindexDao;

	@Override
	public String collectData(String taskid, String wid, String checkbox) throws Exception {
		String tempwid = wid.substring(wid.lastIndexOf("w"));
		String[] str = checkbox.split(",");
		
		TblWarrantindex wi = warrantindexDao.findByWid(tempwid);
		if (wi == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
	
		try {
			int number = wi.getTimes() + 1;
			wi.setTimes(number);
			warrantindexDao.update(wi);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String user = tools.getLoginUser();
			collectPreserve(str, sdf.parse(sdf.format(date)), tempwid, user, number);
		} catch (Exception e) {
			errorMsg = "资料收集业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	private void collectPreserve(String[] str, Date d, String wid, String user, int number) throws Exception {
		if (str == null || str.length == 0) {
			errorMsg = "启动担保业务流程失败" + str;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		try {
			for (int i = 0; i < str.length; i++) {
				TblDocchklist tblDocchklist = new TblDocchklist();
				tblDocchklist.setWid(wid);
				tblDocchklist.setName(user);
				tblDocchklist.setDate(d);
				tblDocchklist.setState(1);
				tblDocchklist.setDid(str[i].trim());
				tblDocchklist.setComplete("0");
				tblDocchklist.setSave("0");
				tblDocchklist.setPath("");
				tblDocchklist.setTimes(number);
				docchklistDao.save(tblDocchklist);
			}
		} catch (Exception e) {
			errorMsg = "保存企业需要收集的资料列表时失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	public void setDocchklistDao(DocchklistDao docchklistDao) {
		this.docchklistDao = docchklistDao;
	}

	public void setWarrantindexDao(WarrantindexDao warrantindexDao) {
		this.warrantindexDao = warrantindexDao;
	}

}
