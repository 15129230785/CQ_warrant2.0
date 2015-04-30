package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.cq.service.StartsignService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblStartSign;
import com.cq.util.tools;

public class StartSignAction {
	static Logger log = Logger.getLogger(StartSignAction.class);
	private String errorMsg;
	
	private String sel;
	private String wid;
	private String checkbox;
	private String check;
	private String selValue;
	private String taskid;
	
	@Resource TaskBaseService taskBaseService;
	@Resource StartsignService startsignService;

	public String startSign() throws Exception {
		if (sel.equals("transfer")) {
			return taskBaseService.transfer(selValue, taskid);
		}

		String temp = startsignService.startSign(taskid, wid,
				tools.getLoginUser(), checkbox, check);
		if ("success".equals(temp) == false) {
			tools.returnError(log, "处理发起会签业务时系统出现错误");
			return "error";
		}
		return "success";
	}
	
	public void getRiskReviewInfo() throws Exception {
		List<TblStartSign> ssl = null;
		
		TblStartSign ss = null;
		JsonConfig cfg = null;
		
		try {
			ssl = startsignService.getTblStartSign(wid);
			
			if((ssl == null) || (ssl.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				log.warn("获取风控部经理审核信息失败" + ssl);
				return;
			}
			cfg = tools.getJsonConfig();
			JSONArray ja = new JSONArray();
			for(int i = 0; i < ssl.size(); i++) {
				ss = (TblStartSign) ssl.get(i);
				ja.add(JSONObject.fromObject(ss, cfg));
			}
			JSONObject result = new JSONObject();
			result.put("riskReviewInfo", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "输出风控部经理审核信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void getReviewerList() throws Exception {
		List<String> rl = null;
		
		try {
			rl = startsignService.getSignNameList();
			
			if((rl == null) || (rl.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				log.warn("获取评审专家列表信息失败" + rl);
				return;
			}
			tools.outputInfo(JSONArray.fromObject(rl));
		} catch (Exception e) {
			errorMsg = "输出评审专家信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
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

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
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
