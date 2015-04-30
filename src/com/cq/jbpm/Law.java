package com.cq.jbpm;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;

public class Law implements AssignmentHandler {
	private static final long serialVersionUID = 1L;

	@Override
	public void assign(Assignable assignable, OpenExecution oe)
			throws Exception {
		String law = (String) oe.getVariable("law");
		String user = (String) oe.getVariable("user");
		if (!"".equals(law)) {
			assignable.setAssignee(law);
		} else {
			law = user;
			assignable.setAssignee(law);
		}
	}
}
