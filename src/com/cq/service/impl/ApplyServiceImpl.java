package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.BankinfoDao;
import com.cq.dao.CominfoDao;
import com.cq.dao.PersonDao;
import com.cq.dao.WarrantindexDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.ApplyService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCfgBankinfo;
import com.cq.table.TblCominfo;
import com.cq.table.TblPerson;
import com.cq.table.TblWarrantindex;
import com.cq.table.TblWarrantinfo;
import com.cq.util.WarrantException;
import com.cq.util.tools;

@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
public class ApplyServiceImpl implements ApplyService {
	static Logger log = Logger.getLogger(ApplyServiceImpl.class);
	private String errorMsg;
	
	private BankinfoDao bankinfoDao;
	private CominfoDao cominfoDao;
	private ExecutionService executionService;
	private PersonDao personDao;
	private TaskBaseService taskBaseService;
	private WarrantindexDao warrantindexDao;
	private WarrantinfoDao warrantinfoDao;
	
	@Override
	public Task startProcess() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Task task = null;

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", tools.getLoginUser());
			ProcessInstance processInstance = executionService.startProcessInstanceByKey("warrant", map);
			String pid = processInstance.getId();

			Date dt = new Date();
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
			String wid = pid + matter1.format(dt);
			
			task = taskBaseService.taskQuery()
					.processInstanceId(processInstance.getId()).uniqueResult();
			taskBaseService.setTaskVar(task.getId(), "Wid", wid);

			request.getRequestDispatcher("/" + task.getFormResourceName()
				+ "?id=" + task.getId()
				+ "&wid=" + wid+"&xpid="+pid).forward(request, response);
		} catch (Exception e) {
			errorMsg = "启动担保业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return task;
	}
	
	@Override
	public void startApply(String taskid, String apply, String pid) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String str1 = tools.getLoginUser();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("applyzq", apply);
			map.put("user", str1);
			taskBaseService.nextStep(taskid, map, "toapplyjudge");
			
			Task taskx = null;
			if (pid != null) {
				taskx = taskBaseService.taskQuery().processInstanceId(pid).uniqueResult();
			}
			if (taskx != null) {
				request.setAttribute("taskidx", taskx.getId());
			}
		} catch (Exception e) {
			errorMsg = "启动担保业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	public String submitCompanyApply(String taskid, String wid, String eid,
			String selValue, String result, char type) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		TblWarrantinfo warrantinfo = null;

		warrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
		if (warrantinfo == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		TblWarrantindex tblWarrantindex = null;
		TblCominfo cominfo = null;

		try {
			cominfo = cominfoDao.findCominfoByEid(eid);

			if (cominfo != null) {
				long n = warrantindexDao.getCountByTypeAndId(wid, type, eid);
				if (n != 0) {
					errorMsg = "系统中已经存在担保项目索引信息";
					log.error(errorMsg);
					throw new WarrantException(errorMsg);
				}

				tblWarrantindex = new TblWarrantindex();
				tblWarrantindex.setWid(wid);
				tblWarrantindex.setType(type);
				tblWarrantindex.setId(eid);
				tblWarrantindex.setName(cominfo.getName());
				tblWarrantindex.setTimes(0);
				warrantindexDao.save(tblWarrantindex);
			} else {
				errorMsg = "请先保存公司基本信息，再提交";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			String bid = warrantinfo.getBank();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			TblCfgBankinfo bank = bankinfoDao.findBankinfoByBidAndDate(bid, sdf.format(date));
			if (bank == null) {
				errorMsg = "请选择正确的贷款银行";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			double practicalMoney = warrantinfo.getPracticalMoney();
			double remaining = bank.getRemaining();
			double money = 0;
			if ((remaining - practicalMoney) >= 0) {
				money = remaining - practicalMoney;
			} else {
				errorMsg = "请选择有足够授信额度的贷款银行";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			bank.setRemaining(money);
			bankinfoDao.update(bank);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("apply_pass", result);
			map.put("user", selValue);
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（评审收费）处理");
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "启动担保业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Override
	public String submitPersonApply(String taskid, String wid, String pid,
			String selValue, String result, char type) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		TblWarrantinfo warrantinfo=null;
		warrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
		if (warrantinfo == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		TblWarrantindex tblWarrantindex = null;
		TblPerson person = null;

		try {
			person = personDao.findPersonByID(pid);

			if (person != null) {
				long n = warrantindexDao.getCountByTypeAndId(wid, type, pid);
				if (n != 0) {
					errorMsg = "系统中已经存在担保项目索引信息";
					log.error(errorMsg);
					throw new WarrantException(errorMsg);
				}

				tblWarrantindex = new TblWarrantindex();
				tblWarrantindex.setWid(wid);
				tblWarrantindex.setType(type);
				tblWarrantindex.setId(pid);
				tblWarrantindex.setName(person.getName());
				tblWarrantindex.setTimes(0);
				warrantindexDao.save(tblWarrantindex);
			} else {
				errorMsg = "请先保存个人基本信息，再提交";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			String bid = warrantinfo.getBank();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			TblCfgBankinfo bank = bankinfoDao.findBankinfoByBidAndDate(bid, sdf.format(date));
			if (bank == null) {
				errorMsg = "请选择正确的贷款银行";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			double practicalMoney = warrantinfo.getPracticalMoney();
			double remaining = bank.getRemaining();
			double money = 0;
			if ((remaining - practicalMoney) >= 0) {
				money = remaining - practicalMoney;
			} else {
				errorMsg = "请选择有足够授信额度的贷款银行";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			bank.setRemaining(money);
			bankinfoDao.update(bank);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("apply_pass", result);
			map.put("user", selValue);
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（评审收费）处理");
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "启动担保业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public String checkCompanyApply(String wid, String eid) {
		TblWarrantinfo wi = null;
		TblCominfo cominfo = null;
		wi = warrantinfoDao.findWarrantinfoByWid(wid);
		cominfo = cominfoDao.findCominfoByEid(eid);
		if (wi != null && cominfo != null) {
			return "suc";
		} else {
			return "sf";
		}
	}
	
	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public String checkPersonApply(String wid, String pid) {
		TblWarrantinfo wi = null;
		TblPerson person = null;
		wi = warrantinfoDao.findWarrantinfoByWid(wid);
		person = personDao.findPersonByID(pid);
		if (wi != null && person != null) {
			return "suc";
		} else {
			return "sf";
		}
	}
	
	public void setExecutionService(ExecutionService executionService) {
		this.executionService = executionService;
	}

	public void setCominfoDao(CominfoDao cominfoDao) {
		this.cominfoDao = cominfoDao;
	}
	
	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public void setWarrantindexDao(WarrantindexDao warrantindexDao) {
		this.warrantindexDao = warrantindexDao;
	}

	public void setBankinfoDao(BankinfoDao bankinfoDao) {
		this.bankinfoDao = bankinfoDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

}
