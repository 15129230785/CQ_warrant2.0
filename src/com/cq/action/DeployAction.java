package com.cq.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cq.service.DeployService;

public class DeployAction {
	static Logger log = Logger.getLogger(DeployAction.class);
	private String errorMsg;
	
	@Resource DeployService deployService;
	
	public String deploy() throws Exception {
		String rets = "success";
		String msg = "";
		
		deployService.deploy();
		
		msg = "业务部署成功";
		ServletActionContext.getRequest().getSession().setAttribute("msg", msg);
		return rets;
	}
	
	public String loadData() throws Exception {
		deployService.loadConfigData();
		
		return "success";
	}

}
