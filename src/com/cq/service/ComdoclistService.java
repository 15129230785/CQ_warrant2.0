package com.cq.service;

import java.util.List;

import com.cq.bean.DocList;

public interface ComdoclistService {
	public List<DocList> getDocListByWid(String wid) throws Exception;
	public List<DocList> getDocList() throws Exception;
	public void addDocList(String name, String file, String description) throws Exception;
	public void updDocList(String DID, String num) throws Exception;
}
