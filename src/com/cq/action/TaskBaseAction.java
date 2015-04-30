package com.cq.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.jbpm.api.task.Task;

import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class TaskBaseAction {
	static Logger log = Logger.getLogger(TaskBaseAction.class);
	private String errorMsg;
	
	@Resource TaskBaseService taskBaseService;
	
	private String taskid;
	private String varName;

	public void isTaskExist() throws Exception {
		try {
			Task task = taskBaseService.getTask(taskid);
			if (task == null) {
				errorMsg = "此任务已经处理过";
				throw new WarrantException(errorMsg);
			} else {
				HttpServletResponse response = ServletActionContext.getResponse();
				HttpServletRequest request = ServletActionContext.getRequest();
				request.getRequestDispatcher("/" + task.getFormResourceName()
						+ "?id=" + taskid
						+ "&wid=" + request.getParameter("wid")
						+ "&task=" + request.getParameter("task")).forward(ServletActionContext.getRequest(), response);
			}
		} catch (Exception e) {
			errorMsg = "检查任务是否存在时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void getTaskVar() throws Exception {
		Object value = null;

		value = taskBaseService.getTaskVar(taskid, varName);
		
		try {
			if (value == null) {
				tools.outputInfo("null");
			} else { 
				tools.outputInfo(value.toString());
			}
		} catch (Exception e) {
			errorMsg = "输出任务中变量信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void getMyTaskList() throws Exception {
		StringBuffer outs = null;

		try {
			outs = taskBaseService.getMyTaskList();
			tools.outputInfo(outs);
		} catch (Exception e) {
			errorMsg = "输出我的任务列表信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

}
