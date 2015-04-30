package com.cq.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;

import com.cq.service.StationLetterService;
import com.cq.service.UserService;
import com.cq.table.CQUser;
import com.cq.util.GlobalData;
import com.cq.util.tools;

/**
 * @author qibo
 *	系统消息提醒;
 */
public class SystemNewRemind {
	static Logger log = Logger.getLogger(SystemNewRemind.class);
	private String errorMsg;
	
	private StationLetterService stationLetterService;
	private TaskService taskService;
	private UserService userService;
	
	//密码逾期提醒
	public void checkPswd() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			CQUser us = (CQUser) userService.getUserByName(tools.getLoginUser());
			
			int days = tools.daysPast(sdf.parse(us.getModdate()), new Date());
			
			String msg = null;
			if (days >= (GlobalData.passwordExpireDays - GlobalData.passwordReminderDays)
					&& days <= GlobalData.passwordExpireDays) {
				msg = "您的密码还有" + (GlobalData.passwordExpireDays - days) + "天到期,请及时修改";
			} else if (days > GlobalData.passwordExpireDays) {
				msg = "您的密码已经超期" + (days - GlobalData.passwordExpireDays) + "天,请尽快修改";
			} else {
				msg = "您的密码已经使用" + days + "天";
			}
			
			JSONObject result = new JSONObject();
			result.put("banks", msg);
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "检查密码是否超时时出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	//新邮件
	public void newLetter() throws Exception{
		int number = 0;
		
		try {
			number = stationLetterService.getStationLetterNumber(tools.getLoginUser());
			
			String msgLetter = null;
			JSONObject result = new JSONObject();
			if (number > 0) {
				msgLetter = "您有" + number + "封未读邮件";
			}
			result.put("banksLetter", msgLetter);
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "检查是否有新邮件时出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	//任务逾期提醒(任务只能停留一个月,提醒小于7天的任务记录数)
	public void taskOverdue() throws Exception{
		try {
			int i = 0;
			int j = 0;
			
			Object[] oList = GlobalData.taskNames.keySet().toArray();
			List<Task> taskList = taskService.findPersonalTasks(tools.getLoginUser());
			for (Task task : taskList) {
				long days = tools.daysPast(task.getCreateTime(), new Date());
				if (oList != null) {
					for (int i1 = 0; i1 < oList.length; i1++) {
						if (task.getActivityName().equals(oList[i1])) {
							if (days > GlobalData.taskExpireDays) {
								i++;
							} else if (days >= (GlobalData.taskExpireDays - GlobalData.taskReminderDays)
									&& days <= GlobalData.taskExpireDays) {
								j++;
							}
							break;
						}
					}
				}
			}
			
			String msgTask = null;
			JSONObject result = new JSONObject();
			if (i > 0 && j == 0) {
				msgTask = "您有" + i + "条任务已经超期(" + GlobalData.taskExpireDays + "天)，请尽快处理";
			} else if (i == 0 && j > 0) {
				msgTask = "您有" + j + "条任务即将超期(" + GlobalData.taskExpireDays + "天)，请尽快处理";
			} else if (i > 0 && j > 0) {
				msgTask = "您有" + i + "条任务已经超期<br />" + j + "条任务即将超期，请尽快处理";
			}
			result.put("banksTask", msgTask);
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "查询任务是否超期时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	//新任务提醒
	public void newTask() throws Exception {
		try {
			int j = 0;
			
			Object[] oList = null;
			oList = GlobalData.taskNames.keySet().toArray();
			List<Task> taskList = taskService.findPersonalTasks(tools.getLoginUser());
			for (Task task : taskList) {
				if (oList != null) {
					for (int i1 = 0; i1 < oList.length; i1++) {
						if (task.getActivityName().equals(oList[i1])) {
							j++;
						}
					}
				}
			}
			
			String msgNewTask = null;
			JSONObject result = new JSONObject();
			if (j > 0) {
				msgNewTask = "您有" + j + "条任务未处理";
			}
			result.put("banksNewTask", msgNewTask);
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "查询是否有新任务时出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setStationLetterService(StationLetterService stationLetterService) {
		this.stationLetterService = stationLetterService;
	}

 }
