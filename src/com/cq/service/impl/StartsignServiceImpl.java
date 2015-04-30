package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.StartsignDao;
import com.cq.service.StartsignService;
import com.cq.service.TaskBaseService;
import com.cq.service.UserService;
import com.cq.table.TblStartSign;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class StartsignServiceImpl implements StartsignService {
	static Logger log = Logger.getLogger(StartsignServiceImpl.class);
	private String errorMsg;
	
	private StartsignDao startsignDao;
	private TaskBaseService taskBaseService;
	private UserService userService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String startSign(String taskid, String wid, String name, String checkbox, String check) throws Exception {
		if (checkbox == null) {
			errorMsg = "需要选择项目评审委员";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		try {
			setTblStartSign(wid, name, tools.multiLine(check));
			
			String[] str1 = checkbox.split(",");
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < str1.length; i++) {
				list.add(str1[i].trim());
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("judges", list);
			map.put("judge_number", list.size());
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（评委会签）处理");
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "项目发起评审会签流程处理失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly=true)
	public List<String> getSignNameList() throws Exception {
		List<String> uE = null;

		try {
			uE = userService.findReviewUser();
		} catch (Exception e) {
			errorMsg = "查找项目评审会签委员名单失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		return uE;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblStartSign> getTblStartSign(String wid) {
		List<TblStartSign> ld = new ArrayList<TblStartSign>();

		ld = startsignDao.findByProperty("wid", wid);
		return ld;
	}
	
	private void setTblStartSign(String wid, String name, String check) throws Exception{
		Date d = null;
		
		try {
			Date da = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d = sdf.parse(sdf.format(da));
		} catch (Exception e) {
			errorMsg = "日期格式处理错误";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		try {
			TblStartSign tblStartSign = new TblStartSign();
			tblStartSign.setWid(wid);
			tblStartSign.setName(name);
			tblStartSign.setDate(d);
			tblStartSign.setChecks(check);
			startsignDao.save(tblStartSign);
		} catch (Exception e) {
			errorMsg = "增加项目评审数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	public void setStartsignDao(StartsignDao startsignDao) {
		this.startsignDao = startsignDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
