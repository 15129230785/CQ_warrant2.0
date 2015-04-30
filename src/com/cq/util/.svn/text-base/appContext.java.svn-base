package com.cq.util;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class appContext {
	static Logger log = Logger.getLogger(appContext.class);
	
	private static final WebApplicationContext ac = buildAc();
	private static WebApplicationContext buildAc() {
		//System.out.println("Hello build ac");
		try {
			return (WebApplicationContextUtils
					.getWebApplicationContext(ServletActionContext
							.getServletContext()));
		} catch (Exception e) {
			if (e instanceof WarrantException) {
				throw e;
			} else {
				String errorMsg = "获取applicationcontext失败";
				log.error(e.getMessage());
				throw new WarrantException(errorMsg);
			}
		}
	}

	public static WebApplicationContext getAc() {
		return ac;
	}
}
