package com.cq.table;

import java.io.Serializable;
import java.util.Date;

public class TblPersonalwarrant implements Serializable {
	private static final long serialVersionUID = -3739019332256765777L;
	
	private int kid;
	private String id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Character mode;
	private double money;
	private double remaining;
	private String description;

	public TblPersonalwarrant() {
	}

	public TblPersonalwarrant(int kid, String id, Date startDate, Date endDate,
			double money, double remaining) {
		this.kid = kid;
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.money = money;
		this.remaining = remaining;
	}

	public TblPersonalwarrant(int kid, String id, Date startDate, Date endDate,
			Character mode, double money, double remaining, String description) {
		this.kid = kid;
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mode = mode;
		this.money = money;
		this.remaining = remaining;
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Character getMode() {
		return this.mode;
	}

	public void setMode(Character mode) {
		this.mode = mode;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getRemaining() {
		return this.remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
