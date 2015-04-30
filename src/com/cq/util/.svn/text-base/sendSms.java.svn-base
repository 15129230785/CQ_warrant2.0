package com.cq.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

public class sendSms {
	static Logger log = Logger.getRootLogger();
	static String errorMsg;

	public static void sendmsm(String user, String Keyword, String smsPeple,
			String smsText) {
		try {
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
			NameValuePair[] data = { 
					new NameValuePair("Uid", user),
					new NameValuePair("Key", Keyword),
					new NameValuePair("smsMob", smsPeple),
					new NameValuePair("smsText", smsText) 
					};//设置 账号 接口密码  收信人  信件内容
			post.setRequestBody(data);
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:" + statusCode);
			for (Header h : headers) {
				System.out.println(h.toString());
			}
			String result = new String(post.getResponseBodyAsString().getBytes("ISO-8859-1"));
			System.out.println(result);
			post.releaseConnection();

		} catch (Exception e) {
			errorMsg = "短信发送失败";
			log.error(e.getMessage());
			throw new WarrantException(errorMsg);
		}

	}
}
