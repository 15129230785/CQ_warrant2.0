package com.cq.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class sendEmail {
	static Logger log = Logger.getRootLogger();
	static String errorMsg;

	public static void send(String email, String password,String tacceptAddress, String temailtitle,
			String temailtype,String tcontent) throws IOException {
		String a[] = email.split("@");
		String host = a[1];// 截取邮箱后缀名
		String user = a[0];// 截取邮箱名
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp." + host);
			props.put("mail.smtp.auth", "true");
			Session s = Session.getInstance(props);
			s.setDebug(true);
			MimeMessage message = new MimeMessage(s);
			// 给消息对象设置发件人/收件人/主题/发信时间
			InternetAddress from = new InternetAddress(user + "@" + host);
			message.setFrom(from);
			InternetAddress to = new InternetAddress(tacceptAddress);
			message.setRecipient(Message.RecipientType.TO, to);
			message.setSubject(temailtitle);
			message.setSentDate(new Date());
			Multipart mm = new MimeMultipart();// 新建一个MimeMultipart对象用来存放多个BodyPart对象
			// 设置信件文本内容
			BodyPart mdp = new MimeBodyPart();// 新建一个存放信件内容的BodyPart对象
			mdp.setContent(tcontent, temailtype + ";charset=utf-8");// 给BodyPart对象设置内容和格式/编码方式
			mm.addBodyPart(mdp);// 将含有信件内容的BodyPart加入到MimeMultipart对象中
			message.setContent(mm);// 把mm作为消息对象的内容
			message.saveChanges();
			Transport transport = s.getTransport("smtp");
			transport.connect("smtp." + host, user, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			errorMsg = "邮件发送失败";
			log.error(e.getMessage());
			throw new WarrantException(errorMsg);
		}

	}
}
