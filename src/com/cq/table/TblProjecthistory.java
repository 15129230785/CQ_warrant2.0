package com.cq.table;

import java.io.Serializable;

public class TblProjecthistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int kid;
	private String wid;
	private String description;

	public TblProjecthistory() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
