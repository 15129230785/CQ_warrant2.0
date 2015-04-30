package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.CountersignDao;
import com.cq.dao.WarrantindexDao;
import com.cq.service.CountersignService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCountersign;
import com.cq.table.TblWarrantindex;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class CountersignServiceImpl implements CountersignService {
	static Logger log = Logger.getLogger(CountersignServiceImpl.class);
	private String errorMsg;
	
	private CountersignDao countersignDao;
	private TaskBaseService taskBaseService;
	private WarrantindexDao warrantindexDao;
	
	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String counterSign(String taskid, String wid, String decisionList,
			String cause) throws Exception {
		String user = tools.getLoginUser();
		
		if (decisionList.equals("1") && cause.trim().equals("")) {
			errorMsg = "会签选择不同意时，需要填写情况说明";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		try {
			setTblCountersign(wid, user, decisionList.charAt(0),
					tools.multiLine(cause));

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", user);
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（项目决策）处理");
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "专家评审会签流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	private void setTblCountersign(String wid, String name,
			char result, String description) throws Exception {
		try {
			TblWarrantindex wi = warrantindexDao.findByWid(wid);
			int number = wi.getTimes();
			
			Date da = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(sdf.format(da));
		
			TblCountersign tblCountersign = new TblCountersign();
			tblCountersign.setWid(wid);
			tblCountersign.setName(name);
			tblCountersign.setDate(d);
			tblCountersign.setResult(result);
			tblCountersign.setDescription(description);
			tblCountersign.setNumber(number);
			
			countersignDao.save(tblCountersign);
		} catch (Exception e) {
			errorMsg = "添加会签数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblCountersign> getTblCountersign(String wid) {
		List<TblCountersign> ld = null;
		
		ld = countersignDao.findByProperty("wid", wid);
		return ld;
	}

	public void setCountersignDao(CountersignDao countersignDao) {
		this.countersignDao = countersignDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setWarrantindexDao(WarrantindexDao warrantindexDao) {
		this.warrantindexDao = warrantindexDao;
	}
}
