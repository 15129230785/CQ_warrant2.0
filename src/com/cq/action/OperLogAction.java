package com.cq.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.cq.service.OperlogService;
import com.cq.table.TblOperlog;
import com.cq.util.tools;

public class OperLogAction {
	static Logger log = Logger.getLogger(OperLogAction.class);
	private String errorMsg;

	@Resource
	protected OperlogService operlogService;

	private String userName;
	private String startDate;
	private String endDate;
	private String opMode;
	private int firstResult;
	private int countPage;
	
	public void getOperlogList() throws Exception {
		List<TblOperlog> operlist = null;
		TblOperlog oper = null;
		
		try {
			operlist = operlogService.getOperlog(userName, startDate, endDate, opMode, firstResult);
			countPage = operlogService.getCountPage(userName, startDate, endDate, opMode, firstResult);
			if ((operlist == null) || (operlist.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				return;
			}
			JSONArray ja = new JSONArray();
			for (int i = 0; i < operlist.size(); i++) {
				oper = operlist.get(i);
				if (!(oper.getOpMode().equals("登录") || oper.getOpMode().equals("文件"))
						&& !oper.getLog().equals("null")) {
					JSONObject jo = JSONObject.fromObject(oper.getLog());
					String temp = "";
					Iterator<?> iter = jo.keys();
					if (iter.hasNext()) {
						while (iter.hasNext()) {
							String key = iter.next().toString();
							temp += key;
							temp += ":";
							temp += jo.get(key).toString();
							temp += "<br>";
						}
					}
					if (!temp.equals("")) {
						oper.setLog(temp);
					}
				}
				ja.add(JSONObject.fromObject(oper));
			}
			
			JSONObject result = new JSONObject();
			result.put("operlogList", ja.toString());
			result.put("countPage", countPage);
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "获取日志信息时系统发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getOpMode() {
		return opMode;
	}

	public void setOpMode(String opMode) {
		this.opMode = opMode;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	
}
