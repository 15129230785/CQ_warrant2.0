package com.cq.service;

import java.util.Map;

import org.jbpm.api.TaskQuery;
import org.jbpm.api.task.Task;

public interface TaskBaseService {
	public String transfer(String selValue, String taskid) throws Exception;
	public void nextStep(String taskid, Map<String, Object> map, String out) throws Exception;
	public void nextStep(String taskid, Map<String, Object> map) throws Exception;
	public Object getTaskVar(String taskid, String varName) throws Exception;
	public void setTaskVar(String taskid, String varName, Object value) throws Exception;
	
	public Task getTask(String taskid);
	public StringBuffer getMyTaskList() throws Exception;
	
	public TaskQuery taskQuery();
	public void manualTaskOut(String wid, final String srcTask, final String destTask) throws Exception;
}
