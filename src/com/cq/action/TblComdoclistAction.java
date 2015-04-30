package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.bean.DocList;
import com.cq.service.ComdoclistService;
import com.cq.table.TblCfgComdoclist;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="资料清单", dataName="ccdl")
public class TblComdoclistAction {
	static Logger log = Logger.getLogger(TblComdoclistAction.class);
	private String errorMsg;
	
	@Resource ComdoclistService comdoclistService;

	private String DID;
	private String name;
	private String description;
	private String file;
	private String renew;
	private TblCfgComdoclist ccdl;
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getComdocList() throws Exception {
		List<DocList> docList = null;
		
		DocList doc = null;
		JsonConfig cfg = null;
		
		try {
			
			docList = comdoclistService.getDocList();
			
			if((docList == null) || (docList.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				return;
			}
			
			cfg = tools.getJsonConfig();
			JSONArray ja = new JSONArray();
			for(int i = 0; i < docList.size(); i++) {
				doc = (DocList) docList.get(i);
				ja.add(JSONObject.fromObject(doc, cfg));
			}
			JSONObject result = new JSONObject();
			result.put("comdocList", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "获取资料失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String addDocList() throws Exception {
		try {
			comdoclistService.addDocList(name, file, description);
		} catch (Exception e) {
			errorMsg = "添加失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateDocList() throws Exception {
		try {
			comdoclistService.updDocList(DID, renew);
		} catch (Exception e) {
			errorMsg = "修改失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	public String getDID() {
		return DID;
	}

	public void setDID(String dID) {
		DID = dID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getRenew() {
		return renew;
	}

	public void setRenew(String renew) {
		this.renew = renew;
	}

	public void setComdoclistService(ComdoclistService comdoclistService) {
		this.comdoclistService = comdoclistService;
	}
	public TblCfgComdoclist getCcdl() {
		return ccdl;
	}

	public void setCcdl(TblCfgComdoclist ccdl) {
		this.ccdl = ccdl;
	}
}
