package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblStartSign implements Serializable {
	private static final long serialVersionUID = -3481668010535266072L;
	
	private int kid;
	private String wid;
	private String name;
	private Date date;
	private String checks;

	public TblStartSign() {
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
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getChecks() {
		return checks;
	}

	public void setChecks(String checks) {
		this.checks = checks;
	}

}
