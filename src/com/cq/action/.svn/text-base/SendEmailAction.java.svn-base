package com.cq.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cq.util.WarrantException;
import com.cq.util.sendEmail;

public class SendEmailAction {
	static Logger log = Logger.getRootLogger();
	private String errorMsg;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public String sendEmail() throws IOException {
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("name");// 获取本用户邮箱地址;
		String password = request.getParameter("password");// 获取本用户邮箱密码
		String tacceptAddress = request.getParameter("acceptAddress");// 获取收件人邮箱地址
		String temailtitle = request.getParameter("emailtitle");// 获取邮件主题
		String temailtype = request.getParameter("emailtype");// 获取email类型
		String tcontent = request.getParameter("content");// 获取邮件内容
		try {
			
			sendEmail.send(email, password, tacceptAddress, temailtitle,temailtype, tcontent);

		} catch (Exception e) {
			errorMsg = "邮件发送失败";
			log.error(e.getMessage());
			throw new WarrantException(errorMsg);
		}

		return "sendSuccess";
	}

}