package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblFamily implements Serializable {
	private static final long serialVersionUID = 3014579856105951633L;
	
	private int kid;
	private String id;
	private String sid;
	private String name;
	private Character gender;
	private Date birthday;
	private String vocation;
	private String relationship;
	private String description;

	public TblFamily() {
	}

	public TblFamily(int kid, String id, String sid, String name, Character gender,
			Date birthday, String vocation, String relationship) {
		this.kid = kid;
		this.id = id;
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.vocation = vocation;
		this.relationship = relationship;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getVocation() {
		return this.vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
