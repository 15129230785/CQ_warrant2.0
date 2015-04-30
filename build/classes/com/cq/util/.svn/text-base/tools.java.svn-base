package com.cq.util;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class tools {
	static Logger log = Logger.getLogger(tools.class);
	
	public static String md5(String pass) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		} catch (NoSuchAlgorithmException e) {
			log.error("系统不支持MD5算法算法");
		}
		return pass;
	}
	
	public static String multiLine(String o) {
		String str = "";
		
		if((o == null) || o.equals(""))
			return "";
		str = o.replace("\r\n", "<br>");
		str = str.replace("\n\r", "<br>");
		str = str.replace("\n", "<br>");
		str = str.replace(" ", "&nbsp;");

		return str;
	}
	
	public static String unMultiLine(String o) {
		String str = "";
		
		if((o == null) || o.equals(""))
			return "";
		str = o.replace("<br>", "\r\n");
		str = str.replace("<br>", "\n\r");
		str = str.replace("<br>", "\n");
		str = str.replace("&nbsp;", " ");

		return str;
	}
	
	public static <T> void outputInfo(T outs) throws Exception {
		PrintWriter out = null;
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			out.print(outs);
		} catch (Exception e) {
				String errorMsg = "输出数据到客户端时系统出现异常";
				tools.throwException(e, log, errorMsg);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
	
	public static JsonConfig getJsonConfig() {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(Date.class,
				new JsonDateProcess("yyyy-MM-dd"));
		cfg.registerJsonValueProcessor(Double.class, new JsonDoubleProcess("###0.00"));
		return cfg;
	}
	
	public static void fillQueryInfo(int type, String id, String className) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("tableType", Integer.toString(type));
		request.setAttribute("tableName", className);
		request.setAttribute("id", id);
	}
	
	public static void throwException(Exception e, Logger log, String errorMsg) throws Exception {
		if (e instanceof WarrantException) {
			throw e;
		} else {
			log.error(e.getMessage());
			throw new WarrantException(errorMsg);
		}
	}
	
	public static void returnError(Logger log, String errorMsg) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		if (log != null) {
			log.error(errorMsg);
		}
		session.removeAttribute("msg");
		session.setAttribute("msg", errorMsg);
	}
	
	public static String getLoginUser() {
		String user = null;
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null) {
			user = (String) session.getAttribute("user");
		}
		
		return user;
	}
	
	//日期带毫秒
	public static int daysPast(long startDate, long endDate) {
		long days = 0;
		
		if (startDate > endDate) {
			log.warn("起始日期大于终止日期");
		} else {
			days = (endDate - startDate) / (1000 * 3600 * 24);
		}
		return Integer.parseInt(String.valueOf(days));
	}
	
	//日期格式为yyyy-MM-dd
	public static int daysPast(Date startDate, Date endDate) throws Exception {
		long days = 0;

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long stime = cal.getTimeInMillis();
		cal.setTime(endDate);
		long etime = cal.getTimeInMillis();
		
		if (stime > etime) {
			log.warn("起始日期大于终止日期");
		} else {
			days = (etime - stime) / (1000 * 3600 * 24);
		}
		return Integer.parseInt(String.valueOf(days));
	}
	
	//日期格式为yyyy-MM-dd
	public static int daysPast(String startDate, String endDate) throws Exception {
		long days = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(sdf.format(startDate)));
		long stime = cal.getTimeInMillis();
		cal.setTime(sdf.parse(sdf.format(endDate)));
		long etime = cal.getTimeInMillis();
		
		if (stime > etime) {
			log.warn("起始日期大于终止日期");
		} else {
			days = (etime - stime) / (1000 * 3600 * 24);
		}
		return Integer.parseInt(String.valueOf(days));
	}
}
