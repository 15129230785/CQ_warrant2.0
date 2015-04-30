package com.cq.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.service.ReviewChargeService;
import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ReviewChargeAction {
	static Logger log = Logger.getLogger(ReviewChargeAction.class);
	private String errorMsg;
	
	private String sel;
	private double money;
	private String wid;
	private String taskid;
	private String selValue;
	
	@Resource TaskBaseService taskBaseService;
	@Resource ReviewChargeService reviewChargeService;

	public String reviewCharge() throws Exception {
		String s = "error";
		
		// Begin: Mod by Luke Chen on 2015/04/20, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定下一步处理人，若无处理人可选，请检查用户权限配置人";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/20, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
			return s;
		} else if (sel.equals("nextLater")) {
			s = reviewChargeService.reviewCharge(taskid, selValue, wid, money);
		}
		if (s.equals("success") == false) {
			tools.returnError(log, "处理评审收费业务时系统出现错误");
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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
