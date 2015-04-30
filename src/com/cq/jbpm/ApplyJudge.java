package com.cq.jbpm;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class ApplyJudge implements DecisionHandler {

	private static final long serialVersionUID = -5251003062428471352L;

	@Override
	public String decide(OpenExecution oe) {
		String applyzq = (String) oe.getVariable("applyzq");
		String str = null;
		if (applyzq.equals("company")) {
			str = "tocompanyApply";
		} else if (applyzq.equals("person")) {
			str = "topensonApply";
		}
		return str;
	}
}
