package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class BankPass implements DecisionHandler {

	private static final long serialVersionUID = 379797019036292275L;

	@Override
	public String decide(OpenExecution execution) {
		String result = (String) execution.getVariable("bank");
		String str = null;
		if (result.equals("pass")) {
			str = "tocharge";
		} else if (result.equals("refund")) {
			str = "torefund";
		} else if (result.equals("stop")) {
			str = "toend_cancel";
		}
		return str;
	}

}
