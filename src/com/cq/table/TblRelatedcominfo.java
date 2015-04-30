package com.cq.table;

import java.io.Serializable;

public class TblRelatedcominfo implements Serializable {
	private static final long serialVersionUID = 3349726370147054684L;
	
	private int kid;
	private String eid;
	private String relatedID;
	private String name;
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getRelatedID() {
		return relatedID;
	}
	public void setRelatedID(String relatedID) {
		this.relatedID = relatedID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
