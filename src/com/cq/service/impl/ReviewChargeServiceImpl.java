package com.cq.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.service.ChargeService;
import com.cq.service.ReviewChargeService;
import com.cq.service.TaskBaseService;
import com.cq.util.ChargeType;
import com.cq.util.GlobalData;
import com.cq.util.tools;

public class ReviewChargeServiceImpl implements ReviewChargeService {
	static Logger log = Logger.getLogger(ReviewChargeServiceImpl.class);
	private String errorMsg;
	
	private ChargeService chargeService;
	private TaskBaseService taskBaseService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String reviewCharge(String taskid, String selValue, String wwid, double money) throws Exception {
		String wid = wwid.substring(wwid.lastIndexOf("w"));
		String user = tools.getLoginUser();

		try {
			chargeService.setTblCharge(money, wid, user, ChargeType.GETREVIEW);
			
			if (GlobalData.reviewChargeToRecieve) {
				String tn = taskBaseService.getTask(taskid).getName();
				taskBaseService.setTaskVar(taskid, "reviewChargeToReceive", "yes");
				taskBaseService.manualTaskOut(wid, tn, "receive");
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("user", selValue);
				taskBaseService.setTaskVar(taskid, "history", "提交到下一步（资料收集）处理");
				taskBaseService.nextStep(taskid, map);
			}
		} catch (Exception e) {
			errorMsg = "评审收费业务流程失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setChargeService(ChargeService chargeService) {
		this.chargeService = chargeService;
	}

}
