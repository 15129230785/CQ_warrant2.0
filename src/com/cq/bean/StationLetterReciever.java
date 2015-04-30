package com.cq.bean;

import java.io.Serializable;

public class StationLetterReciever implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int status;
	private int readFlag;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(int readFlag) {
		this.readFlag = readFlag;
	}
}
