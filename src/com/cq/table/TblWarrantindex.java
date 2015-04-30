package com.cq.table;

import java.io.Serializable;

public class TblWarrantindex implements Serializable {
	private static final long serialVersionUID = 5175457795375546229L;
	
	private int kid;
	private String wid;
	private Character type;
	private String name;
	private int times;
	private String id;
		
	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public TblWarrantindex() {
	}
	
	public TblWarrantindex(String wid ,int times) {
		this.wid = wid;
		this.times = times;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWid() {
		return this.wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public Character getType() {
		return this.type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
}
