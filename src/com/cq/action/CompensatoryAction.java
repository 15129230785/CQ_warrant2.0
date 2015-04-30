package com.cq.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.cq.service.CompensatoryService;
import com.cq.service.TaskBaseService;
import com.cq.util.tools;

public class CompensatoryAction {
	static Logger log = Logger.getLogger(CompensatoryAction.class);
	private String errorMsg;
	
	@Resource TaskBaseService taskBaseService;
	@Resource CompensatoryService compensatoryService;
	
	private String sel;
	private String wid;
	private Date startDate;
	private double benjin;
	private double lixi;
	private double faxi;
	private double shouxu;
	private double zhixing;
	private double qita;
	private String mode;
	private String describe0;
	private String describe1;
	private String describe2;
	private String describe3;
	private String describe4;
	private String selValue;
	private String taskid;

	public String compensatory() throws Exception {
		wid = wid.substring(wid.lastIndexOf("w"));

		if (sel.equals("transfer")) {
			return taskBaseService.transfer(selValue, taskid);
		}
		
		String temp = compensatoryService.compensatoryProcess(taskid, wid, sel,
				selValue, mode, describe0, describe1, describe2, describe3,
				describe4, startDate, benjin, lixi, faxi, shouxu,
				zhixing, qita);
		if ("success".equals(temp) == false) {
			tools.returnError(log, "处理代偿业务时系统出现错误");
			return "error";
		}
		return "success";
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getBenjin() {
		return benjin;
	}

	public void setBenjin(double benjin) {
		this.benjin = benjin;
	}

	public double getLixi() {
		return lixi;
	}

	public void setLixi(double lixi) {
		this.lixi = lixi;
	}

	public double getFaxi() {
		return faxi;
	}

	public void setFaxi(double faxi) {
		this.faxi = faxi;
	}

	public double getShouxu() {
		return shouxu;
	}

	public void setShouxu(double shouxu) {
		this.shouxu = shouxu;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public double getZhixing() {
		return zhixing;
	}

	public void setZhixing(double zhixing) {
		this.zhixing = zhixing;
	}

	public double getQita() {
		return qita;
	}

	public void setQita(double qita) {
		this.qita = qita;
	}

	public String getDescribe0() {
		return describe0;
	}

	public void setDescribe0(String describe0) {
		this.describe0 = describe0;
	}

	public String getDescribe1() {
		return describe1;
	}

	public void setDescribe1(String describe1) {
		this.describe1 = describe1;
	}

	public String getDescribe2() {
		return describe2;
	}

	public void setDescribe2(String describe2) {
		this.describe2 = describe2;
	}

	public String getDescribe3() {
		return describe3;
	}

	public void setDescribe3(String describe3) {
		this.describe3 = describe3;
	}

	public String getDescribe4() {
		return describe4;
	}

	public void setDescribe4(String describe4) {
		this.describe4 = describe4;
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
