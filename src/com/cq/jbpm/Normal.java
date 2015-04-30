package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class Normal implements DecisionHandler {

	private static final long serialVersionUID = 447378746521478821L;

	@Override
	public String decide(OpenExecution execution) {
		String result = (String) execution.getVariable("normal");
		String str = null;
		if (result.equals("yes")) {
			str = "toreturnbail";
		} else if (result.equals("no")) {
			str = "tocompensatory";
		}
		return str;
	}

}
