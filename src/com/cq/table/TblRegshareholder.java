package com.cq.table;

import java.io.Serializable;

public class TblRegshareholder implements Serializable {
	private static final long serialVersionUID = 3349726370147054684L;
	
	private int kid;
	private String rid;
	private Character type;
	private String name;
	private String sid;
	private Double share;
	
	public TblRegshareholder() {
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Character getType() {
		return this.type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Double getShare() {
		return share;
	}

	public void setShare(Double share) {
		this.share = share;
	}
}
