package com.cq.table;

import java.io.Serializable;

public class TblVendor implements Serializable {
	private static final long serialVersionUID = 4749813562663317787L;
	
	private int kid;
	private String eid;
	private String name;
	private int yearsOfCooperation;
	private Double annualVolume;
	private Double proportion;
	
	public TblVendor() {
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
	
	public int getYearsOfCooperation() {
		return yearsOfCooperation;
	}

	public void setYearsOfCooperation(int yearsOfCooperation) {
		this.yearsOfCooperation = yearsOfCooperation;
	}

	public Double getProportion() {
		return proportion;
	}

	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}

	public void setYearsOfCooperation(Character yearsOfCooperation) {
		this.yearsOfCooperation = yearsOfCooperation;
	}

	public Double getAnnualVolume() {
		return this.annualVolume;
	}

	public void setAnnualVolume(Double annualVolume) {
		this.annualVolume = annualVolume;
	}
}
