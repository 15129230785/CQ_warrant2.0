package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblManaudit implements Serializable {
	private static final long serialVersionUID = -1205710227085315623L;
	
	private int kid;
	private String wid;
	private String name;
	private Date date;
	private String result;
	
	public TblManaudit() {
		
	}

	public TblManaudit(int kid, String wid, String name, Date date, String result) {
		super();
		this.kid = kid;
		this.wid = wid;
		this.name = name;
		this.date = date;
		this.result = result;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
