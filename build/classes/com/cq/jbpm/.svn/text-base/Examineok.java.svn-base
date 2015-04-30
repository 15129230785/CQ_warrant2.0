package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class Examineok implements DecisionHandler {

	private static final long serialVersionUID = 3103455311093424425L;

	@Override
	public String decide(OpenExecution execution) {
		String result = (String) execution.getVariable("examine");
		String str = "";
		if (result.equals("ok")) {
			str = "tofield-survey";
		} else if (result.equals("refund")) {
			str = "torefund";
		} else if (result.equals("stop")) {
			str = "toend_cancel";
		}
		return str;
	}

}
