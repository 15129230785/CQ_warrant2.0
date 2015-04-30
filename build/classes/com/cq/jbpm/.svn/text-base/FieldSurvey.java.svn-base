package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class FieldSurvey implements DecisionHandler {

	private static final long serialVersionUID = -8209832119255045778L;

	@Override
	public String decide(OpenExecution execution) {
		String result = (String) execution.getVariable("survey");
		String str = null;
		if (result.equals("pass")) {
			str = "toconsideration";
		} else if (result.equals("refund")) {
			str = "torefund";
		} else if (result.equals("stop")) {
			str = "toend_cancel";
		}
		return str;
	}

}
