package com.cq.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.ReceiveService;
import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ReceiveAction {
	static Logger log = Logger.getLogger(ReceiveAction.class);
	private String errorMsg;
	
	private String wid;
	private String sel;
	private String check;
	private String taskid;
	private String selValue;
	
	@Resource TaskBaseService taskBaseService;
	@Resource ReceiveService receiveService;

	public String receive() throws Exception {
		String s = "error";
		
		// Begin: Mod by Luke Chen on 2015/04/21, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/21, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
			return s;
		}
		
		if (!"on".equals(check)) {
			errorMsg = "必须确认收到相关费用才可以提交";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		s = receiveService.receive(taskid, selValue, wid);
		if ("success".equals(s) == false) {
			tools.returnError(log, "处理收费业务时系统出现错误");
			return "error";
		}
		return "success";
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
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
