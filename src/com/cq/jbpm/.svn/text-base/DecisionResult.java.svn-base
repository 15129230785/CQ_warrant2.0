package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class DecisionResult implements DecisionHandler {
	private static final long serialVersionUID = -8166374941146086294L;

	@Override
	public String decide(OpenExecution execution) {
		String result = (String) execution.getVariable("result");
		String str = null;
		if (result.equals("pass")) {
			str = "tobank";
		} else if (result.equals("anew")) {
			str = "tocollect-data";
		} else if (result.equals("stop")) {
			str = "toend_cancel";
		} else if (result.equals("refund")) {
			str = "torefund";
		}
		return str;
	}

}
