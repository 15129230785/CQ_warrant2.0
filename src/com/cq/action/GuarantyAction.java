package com.cq.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;

public class GuarantyAction {
	static Logger log = Logger.getLogger(GuarantyAction.class);
	private String errorMsg;
	
	private String sel;
	private String taskid;
	private String wid;
	private String selValue;
	
	@Resource TaskBaseService taskBaseService;
	
	public String guaranty() throws Exception {
		String s = "error";
		
		// Begin: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
			return s;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", selValue);
		taskBaseService.setTaskVar(taskid, "history", "提交到下一步（资料归档）处理");
		taskBaseService.nextStep(taskid, map);
		s = "success";
		return s;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

}
