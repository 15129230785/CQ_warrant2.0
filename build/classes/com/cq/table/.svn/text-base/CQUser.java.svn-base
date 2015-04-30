package com.cq.table;

import java.io.Serializable;

import org.jbpm.api.identity.User;

public class CQUser implements Serializable, User {
	private static final long serialVersionUID = 1L;
	
	private long kid;
	private String id;
	private String name;
	private String password;
	private String moddate;
	private String sex;
	private String email;
	
	public CQUser() {
		
	}
	
	public long getKid() {
		return kid;
	}
	
	public void setKid(long kid) {
		this.kid = kid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getBusinessEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public String getFamilyName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getGivenName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
}
