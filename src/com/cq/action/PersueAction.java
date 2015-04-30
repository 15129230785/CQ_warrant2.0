package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.cq.service.PersueService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblPersue;
import com.cq.util.tools;

public class PersueAction {
	static Logger log = Logger.getLogger(PersueAction.class);
	private String errorMsg;
	
	private String wid;
	private String sel;
	private double persueMoney;
	private String money;
	private String mode;
	private String selValue;
	private String taskid;
	
	@Resource TaskBaseService taskBaseService;
	@Resource PersueService PersueService;

	public String persue() throws Exception {
		String s = "";
		if (sel.equals("transfer")) {
			s = taskBaseService.transfer(selValue, taskid);
			return s;
		}

		s = PersueService.persue(taskid, selValue, wid, mode, money, persueMoney);
		if ("success".equals(s) == false) {
			tools.returnError(log, "处理追偿业务时系统出现错误");
			return "error";
		}
		
		return "success";
	}
	
	public void getPersueInfo() throws Exception {
		List<TblPersue> pl = null;
		TblPersue persue = null;
		JsonConfig cfg = null;
		
		try {
			pl = PersueService.getTblPersue(wid);
			
			if((pl == null) || (pl.size() <= 0)) {
				log.warn("系统中没有项目" + wid +"的追偿信息");
				tools.outputInfo(JSONObject.fromObject(null));
				return;
			}
			cfg = tools.getJsonConfig();
			JSONArray ja = new JSONArray();
			for(int i = 0; i < pl.size(); i++) {
				persue = (TblPersue) pl.get(i);
				ja.add(JSONObject.fromObject(persue, cfg));
			}
			JSONObject result = new JSONObject();
			result.put("persueList", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "输出追偿信息时系统发生异常";
			tools.throwException(e, log, errorMsg);
		}
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

	public double getPersueMoney() {
		return persueMoney;
	}

	public void setPersueMoney(double persueMoney) {
		this.persueMoney = persueMoney;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
