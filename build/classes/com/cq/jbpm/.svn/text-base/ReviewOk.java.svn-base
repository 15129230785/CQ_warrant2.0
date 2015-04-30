package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class ReviewOk implements DecisionHandler {

	private static final long serialVersionUID = 8343738079858694697L;

	@Override
	public String decide(OpenExecution oe) {
		String result = (String) oe.getVariable("result");
		String str = null;
		if (result.equals("yes")) {
			str = "tofork1";
		} else if (result.equals("refund")) {
			str = "torefund";
		} else if (result.equals("anew")) {
			str = "tocollect-data";
		} else if (result.equals("stop")) {
			str = "toend_cancel";
		}
		return str;
	}
}
