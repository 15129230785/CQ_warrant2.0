package com.cq.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.FileService;
import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class FileAction {
	static Logger log = Logger.getLogger(FileAction.class);
	private String errorMsg;
	
	private String sel;
	private String result;
	private String wid;
	private String selValue;
	private String taskid;
	private String checkbox;
	
	@Resource TaskBaseService taskBaseService;
	@Resource FileService fileService;

	public String file() throws Exception {
		
		// Begin: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/22, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			String s = taskBaseService.transfer(selValue, taskid);
			return s;
		}
		
		String temp = fileService.file(taskid, sel, selValue, wid, checkbox);
		if ("success".equals(temp) == false) {
			tools.returnError(log, "处理资料归档业务时系统出现错误");
			return "error";
		}
		return temp;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
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

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

}
