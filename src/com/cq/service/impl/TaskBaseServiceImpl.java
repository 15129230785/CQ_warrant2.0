package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.TaskService;
import org.jbpm.api.identity.User;
import org.jbpm.api.model.Transition;
import org.jbpm.api.task.Participation;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.model.TransitionImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.service.ProjectHistoryService;
import com.cq.service.TaskBaseService;
import com.cq.util.GlobalData;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class TaskBaseServiceImpl implements TaskBaseService {
	static Logger log = Logger.getLogger(TaskBaseServiceImpl.class);
	private String errorMsg;
	
	private ExecutionService executionService;
	private IdentityService identityService;
	private ProjectHistoryService projectHistoryService;
	private RepositoryService repositoryService;
	private TaskService taskService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String transfer(String selValue, String taskid) throws Exception {
		boolean flag = false;
		
		String user = tools.getLoginUser();
		
		this.addHistory(taskid, selValue);
		
		if (StringUtils.isBlank(selValue) || selValue.equals(user)) {
			errorMsg = "任务委托其他人处理必须选择委托人";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		List<User> userList = null;
		try {
			userList = identityService.findUsers();
		} catch (Exception e) {
			errorMsg = "查询系统用户数据出错";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		String newUser = null;
		Task task = taskService.getTask(taskid.trim());
		for (User pd : userList) {
			if (selValue.equals(pd.getId())) {
				newUser = pd.getId();
				taskService.addTaskParticipatingUser(taskid.trim(),
						task.getAssignee(), Participation.REPLACED_ASSIGNEE);
				taskService.assignTask(taskid, newUser);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			return "success";
		} else {
			errorMsg = "委托人在系统用户数据中不存在";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void nextStep(String taskid, Map<String, Object> map) throws Exception {
		String tid = taskid.trim();
		try {
			this.addHistory(taskid);
			
			taskService.setVariables(tid, map);
			taskService.completeTask(tid);
		} catch (Exception e) {
			errorMsg = "业务提交下一步处理时失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void nextStep(String taskid, Map<String, Object> map, String out) throws Exception {
		try {
			this.addHistory(taskid);
			
			taskService.setVariables(taskid, map);
			taskService.completeTask(taskid, out);
		} catch (Exception e) {
			errorMsg = "业务提交下一步处理时失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Override
	public Object getTaskVar(String taskid, String varName) throws Exception {
		Object value = null;

		try {
			if((taskService == null) || (taskid == null) || (varName == null)) {
				errorMsg = "查询任务中变量时参数异常 " + taskService
						+ "--" + taskid + "--" + varName;
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			value = taskService.getVariable(taskid, varName);
		} catch (Exception e) {
			errorMsg = "获取任务中保存的变量数据失败";
			tools.throwException(e, log, errorMsg);
		}
		return value;
	}
	
	@Override
	public void setTaskVar(String taskid, String varName, Object value)
			throws Exception {
		try {
			if((taskService == null) || (taskid == null)
					|| (varName == null) || (value == null)) {
				errorMsg = "查询任务中变量时参数异常 " + taskService
						+ "--" + taskid + "--" + varName
						+ "--" + value;
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(varName, value);
			taskService.setVariables(taskid, map);
		} catch (Exception e) {
			errorMsg = "在任务中保存变量数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	public Task getTask(String taskid) {
		return taskService.getTask(taskid);
	}
	
	@Override
	public StringBuffer getMyTaskList() throws Exception {
		String username = tools.getLoginUser();
		StringBuffer outs = null;

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(date);
		Date d = sdf.parse(s);
		Long ld = d.getTime();

		List<Task> taskList2 = null;
		Object[] oList = null;
		try {
	 		oList = GlobalData.taskNames.keySet().toArray();
	 		taskList2 = taskService.findPersonalTasks(username);
		} catch (Exception e) {
			errorMsg = "获取我的任务列表失败";
			tools.throwException(e, log, errorMsg);
		}
		
		if (taskList2 != null && 0 < taskList2.size()) {
			outs = new StringBuffer();

			outs.append("<li><table><tr>");
			outs.append("<td width='40%'>担保项目名称</td>");
			outs.append("<td width='40%'>当前任务名称</td>");
			outs.append("<td width='20%'>停留天数</td>");
			outs.append("</tr></table></li>");
			for (Task task : taskList2) {
				String in = task.getCreateTime().toString();
				Date dd = sdf.parse(in);
				Long ls = dd.getTime();
				long days = (ld - ls) / (24 * 60 * 60 * 1000);
				if (oList != null) {
					for (int i = 0; i < oList.length; i++) {
						if (task.getActivityName().equals(oList[i])) {
							String cname = GlobalData.taskNames.get(oList[i]);
							outs.append("<li><table><tr>");
							outs.append("<td width='40%'><a href='IsTaskExist.action?"
									+ "wid=" + taskService.getVariable(task.getId(), "Wid")
									+ "&taskid=" + task.getId()
									+ "&task=" + cname
									+ "' target='c'>" + taskService.getVariable(task.getId(), "qyname")
									+ "</a></td>");
							outs.append("<td width='40%'>" + cname + "</td>");
							outs.append("<td width='20%'>" + days + "</td>");
							outs.append("</tr></table></li>");
							break;
						}
					}
				}
			}
		} else {
			log.warn("获取任务列表失败" + taskList2);
		}
		return outs;
	}
	
	@Override
	public TaskQuery taskQuery() {
		return taskService.createTaskQuery();
	}
	
	@Override
	public void manualTaskOut(String wid, final String srcTaskName, final String destTaskName) throws Exception {
		String pid = null;
		ProcessInstance pi = null;
		ProcessDefinition pd = null;
		List<Task> taskList = null;
		
		try {
			pid = wid.substring(0, wid.length() - 8);
			taskList = taskService.createTaskQuery().processInstanceId(pid).list();
			Task task = null;
			for (int i = 0; i < taskList.size(); i++) {
				if (srcTaskName.equals(taskList.get(i).getName())) {
					task = taskList.get(i);
					break;
				}
			}
			if (task == null) {
				log.warn("项目流程中没有名称为(" + srcTaskName + ")的任务");
				return;
			}
			
			String history = tools.getLoginUser() + "提交（"
					+ GlobalData.taskNames.get(srcTaskName) + "）任务，提交到下一步（"
					+ GlobalData.taskNames.get(destTaskName) + "）处理";
			projectHistoryService.addProcessHistory(wid, history);
			
			pi = executionService.createProcessInstanceQuery().processInstanceId(pid).uniqueResult();
			String pdid = pi.getProcessDefinitionId();
			pd = repositoryService.createProcessDefinitionQuery()
					.processDefinitionId(pdid).uniqueResult();
	
			addOutTransition((ProcessDefinitionImpl)pd, srcTaskName, destTaskName);
			Execution execution = pi.findActiveExecutionIn(srcTaskName);
			executionService.signalExecutionById(execution.getId(), "to" + destTaskName);
			deleteOutTransition((ProcessDefinitionImpl)pd, srcTaskName, destTaskName);
		} catch (Exception e) {
			errorMsg = "动态建立任务之间的连接时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	private void addOutTransition(ProcessDefinitionImpl pdi,
			String sourceActivityName, String destActivityName) {
		ActivityImpl sourceActivity = null;
		ActivityImpl destActivity = null;
		
		sourceActivity = pdi.findActivity(sourceActivityName);
		destActivity = pdi.findActivity(destActivityName);
		
		TransitionImpl transition = sourceActivity.createOutgoingTransition();
		transition.setName("to" + destActivityName);
		transition.setDestination(destActivity);
		
		sourceActivity.addOutgoingTransition(transition);
	}
	
	private void deleteOutTransition(ProcessDefinitionImpl pdi,
			String sourceActivityName, String destActivityName) {
		ActivityImpl sourceActivity = null;
		List<Transition> transitionList = null;
		
		sourceActivity = pdi.findActivity(sourceActivityName);
		transitionList = (List<Transition>) sourceActivity.getOutgoingTransitions();
		for (Transition transition : transitionList) {
			if (destActivityName.equals(transition.getDestination().getName())) {
				transitionList.remove(transition);
				break;
			}
		}
	}
	
	private void addHistory(String taskid) throws Exception {
		String history = null;
		String taskname = GlobalData.taskNames
				.get(taskService.getTask(taskid).getName());
		
		history = tools.getLoginUser() + "提交（"
				+ taskname	+ "）任务，";
		history += (String) getTaskVar(taskid,	"history");
		
		projectHistoryService.addProcessHistory((String) getTaskVar(taskid,
				"Wid"), history);
	}
	
	private void addHistory(String taskid, String user) throws Exception {
		String taskname = GlobalData.taskNames
				.get(taskService.getTask(taskid).getName());
		
		projectHistoryService.addProcessHistory((String) getTaskVar(taskid,
				"Wid"), tools.getLoginUser() + "将任务（"
						+ taskname
						+ "）委托给" + user + "处理");
	}
	
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

	public void setProjectHistoryService(ProjectHistoryService projectHistoryService) {
		this.projectHistoryService = projectHistoryService;
	}

	public void setExecutionService(ExecutionService executionService) {
		this.executionService = executionService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
}
