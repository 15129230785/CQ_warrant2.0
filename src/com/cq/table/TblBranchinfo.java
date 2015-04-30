package com.cq.table;

import java.io.Serializable;

public class TblBranchinfo implements Serializable {
	private static final long serialVersionUID = -1205710227085315623L;
	
	private int kid;
    private String eid;
	private String name;
	private String description;

	public TblBranchinfo() {
	}

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
