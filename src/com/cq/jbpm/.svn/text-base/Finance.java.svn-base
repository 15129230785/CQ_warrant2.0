package com.cq.jbpm;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;

public class Finance implements AssignmentHandler {
	private static final long serialVersionUID = 1L;

	@Override
	public void assign(Assignable assignable, OpenExecution em)
			throws Exception {
		String finance = (String) em.getVariable("finance");
		String user = (String) em.getVariable("user");
		if (!"".equals(finance)) {
			assignable.setAssignee(finance);
		} else {
			finance = user;
			assignable.setAssignee(finance);

		}
	}
}
