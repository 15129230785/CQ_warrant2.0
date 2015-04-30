package com.cq.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.GuarantyService;
import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class SignAction extends TaskBaseAction{
	static Logger log = Logger.getLogger(SignAction.class);
	private String errorMsg;
	
	private String sel;
	private String selValue;
	private String taskid;
	private String startDate;
	private String endDate;
	private String noticeDate;
	private String wid;
	
	@Resource TaskBaseService taskBaseService;
	@Resource GuarantyService guarantyService;

	public String sign() throws Exception {
		String s = "error";
		
		// Begin: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("nextLater")) {
			String temp = guarantyService.guaranty(taskid, sel, selValue,
					wid, startDate, endDate, noticeDate);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", selValue);
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（发担保函）处理");
			taskBaseService.nextStep(taskid, map); 
			s = temp;
		} else if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
		}
		if (s.equals("success") == false) {
			tools.returnError(log, "处理签订合同业务时系统出现错误");
			return "error";
		}
		return s;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}
}
