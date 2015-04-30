package com.cq.service;

import java.util.List;

import com.cq.table.TblPersue;

public interface PersueService {
	public List<TblPersue> getTblPersue(String wid);
	public String persue(String taskid, String selValue, String wwid,
			String mode, String money, double persueMoney) throws Exception;
}
