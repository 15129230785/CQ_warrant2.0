package com.cq.table;

import java.io.Serializable;

public class TblCfgTaskgroup implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int kid;
	private String taskid;
	private int seq;
	private String groupid;
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
}
