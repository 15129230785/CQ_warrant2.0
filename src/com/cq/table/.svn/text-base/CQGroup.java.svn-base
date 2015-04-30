package com.cq.table;

import java.io.Serializable;

import org.jbpm.api.identity.Group;

public class CQGroup implements Serializable, Group {
	private static final long serialVersionUID = 1L;
	
	private long kid;
	private String id;
	private String name;
	private CQUser leader;
	
	public CQGroup() {
		
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

	public CQUser getLeader() {
		return leader;
	}

	public void setLeader(CQUser leader) {
		this.leader = leader;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
