package com.cq.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.cq.service.LossService;
import com.cq.service.TaskBaseService;
import com.cq.util.tools;

public class LossAction {
	static Logger log = Logger.getLogger(LossAction.class);
	private String errorMsg;
	
	private String wid;
	private String sel;
	private double LostMoney;
	private String selValue;
	private String taskid;
	
	@Resource TaskBaseService taskBaseService;
	@Resource LossService lossService;

	public String loss() throws Exception {
		String s = "error";
		
		if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
			return s;
		}
		
		s = lossService.lossConfirm(taskid, wid, LostMoney);
		if ("success".equals(s) == false) {
			tools.returnError(log, "处理核销损失业务时系统出现错误");
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

	public double getLostMoney() {
		return LostMoney;
	}

	public void setLostMoney(double lostMoney) {
		LostMoney = lostMoney;
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

}
