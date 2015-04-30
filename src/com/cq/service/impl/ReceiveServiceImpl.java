package com.cq.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.service.ChargeService;
import com.cq.service.ReceiveService;
import com.cq.service.TaskBaseService;
import com.cq.util.ChargeType;
import com.cq.util.tools;

public class ReceiveServiceImpl implements ReceiveService {
	static Logger log = Logger.getLogger(ReceiveServiceImpl.class);
	private String errorMsg;
	
	private ChargeService chargeService;
	private TaskBaseService taskBaseService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String receive(String taskid, String selValue,
			String wid) throws Exception {
		String result = "";

		try {
			String chgToRcv = (String) taskBaseService.getTaskVar(taskid, "reviewChargeToReceive");
			if (chgToRcv != null && "yes".equals(chgToRcv)) {
				chargeService.updateChargeDate(wid, ChargeType.GETREVIEW);
				String tn = taskBaseService.getTask(taskid).getName();
				taskBaseService.manualTaskOut(wid, tn, "collect-data");
			} else {
				chargeService.updateChargeDate(wid, ChargeType.GETAGENT);
				chargeService.updateChargeDate(wid, ChargeType.GETBAIL);
				chargeService.updateChargeDate(wid, ChargeType.GETEVALUATE);
				chargeService.updateChargeDate(wid, ChargeType.GETWARRANT);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("bank", result);
				map.put("user", selValue);
				taskBaseService.setTaskVar(taskid, "history", "提交到下一步（合同签订）处理");
				taskBaseService.nextStep(taskid, map);
			}
		} catch (Exception e) {
			errorMsg = "财务收费业务流程处理失败";
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
