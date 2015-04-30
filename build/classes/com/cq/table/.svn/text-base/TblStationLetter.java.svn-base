package com.cq.table;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cq.bean.StationLetterReciever;

/**
 * @author qibo
 *	站内信
 */
public class TblStationLetter {
	private int kid;
	private String sendID;  //发送者编号
	private String recID;  //接收方编号
	private String caption;	//标题
	private String message; //内容
	private Date sendDate;     //发送时间
	private int sendStatus; 	//用来记录发送方状态 1000--正常  1001--回收站  1002--删除 
	private int userType;		//标记(判别点-点，群)  0--个人邮件 1--群组邮件
	//private Map<String, Integer> recList = new HashMap<String, Integer>();  //群组邮件时,保存接收方用户名称、状态
	private Set<StationLetterReciever> recList = new HashSet<StationLetterReciever>();
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getSendID() {
		return sendID;
	}
	public void setSendID(String sendID) {
		this.sendID = sendID;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	/*public Map<String, Integer> getRecList() {
		return recList;
	}
	public void setRecList(Map<String, Integer> recList) {
		this.recList = recList;
	}*/
	public int getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(int sendStatus) {
		this.sendStatus = sendStatus;
	}
	public String getRecID() {
		return recID;
	}
	public void setRecID(String recID) {
		this.recID = recID;
	}
	public Set<StationLetterReciever> getRecList() {
		return recList;
	}
	public void setRecList(Set<StationLetterReciever> recList) {
		this.recList = recList;
	}
}