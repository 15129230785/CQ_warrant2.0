package com.cq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.bean.DocList;
import com.cq.dao.ComdoclistDao;
import com.cq.dao.WarrantindexDao;
import com.cq.service.ComdoclistService;
import com.cq.table.TblCfgComdoclist;
import com.cq.table.TblWarrantindex;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ComdoclistServiceImpl implements ComdoclistService {
	static Logger log = Logger.getLogger(ComdoclistServiceImpl.class);
	private String errorMsg;
	
	private ComdoclistDao comdoclistDao;
	private WarrantindexDao warrantindexDao;
	
	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<DocList> getDocListByWid(String wid) throws Exception {
		String x = "";
		List<DocList> ld = new ArrayList<DocList>();

		TblWarrantindex tw = warrantindexDao.findByWid(wid);
		if (tw != null) {
			x = Character.toString(tw.getType());
		}
	
		try {
			List<TblCfgComdoclist> cdl = comdoclistDao.findDocByType(x);
			TblCfgComdoclist cd = null;
			if (cdl == null || cdl.size() == 0) {
				errorMsg = "查询文档列表失败" + cdl;
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			for (int i = 0; i < cdl.size(); i++) {
				cd = cdl.get(i);
				DocList d = new DocList();
				d.setDID(cd.getDid());
				d.setName(cd.getName());
				d.setFILE("" + cd.getFile());
				d.setCollectTime("" + cd.getCollectTime());
				d.setFileTime("" + cd.getFileTime());
				d.setDescription(cd.getDescription());
				ld.add(d);
			}
		} catch (Exception e) {
			errorMsg = "输出文档列表发生错误";
			tools.throwException(e, log, errorMsg);
		}
		return ld;
	}

	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<DocList> getDocList() throws Exception {
		List<DocList> ld = new ArrayList<DocList>();

		try {
			List<TblCfgComdoclist> cdl = comdoclistDao.list();
			TblCfgComdoclist cd = null;
			if (cdl == null || cdl.size() == 0) {
				errorMsg = "查询文档列表失败" + cdl;
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			for (int i = 0; i < cdl.size(); i++) {
				cd = cdl.get(i);
				DocList d = new DocList();
				d.setDID(cd.getDid());
				d.setName(cd.getName());
				d.setFILE("" + cd.getFile());
				d.setCollectTime("" + cd.getCollectTime());
				d.setFileTime("" + cd.getFileTime());
				d.setDescription(cd.getDescription());
				ld.add(d);
			}
		} catch (Exception e) {
			errorMsg = "输出文档列表发生错误";
			tools.throwException(e, log, errorMsg);
		}
		return ld;
	}

	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void addDocList(String name, String file,
			String description) throws Exception {
		String did = null;
		
		try {
			did = getMaxDid(file);
			TblCfgComdoclist cd = new TblCfgComdoclist();
			cd.setDid(did);
			cd.setName(name);
			cd.setFile(file);
			cd.setDescription(description);
			cd.setCollectTime("0");
			cd.setFileTime("0");
			comdoclistDao.save(cd);
		} catch (Exception e) {
			errorMsg = "增加文档列表数据时发生错误";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void updDocList(String DID, String num) throws Exception {
		try {
			TblCfgComdoclist cd = comdoclistDao.findDocByDid(DID);
			cd.setCollectTime(num);
			comdoclistDao.update(cd);
		} catch (Exception e) {
			errorMsg = "修改文档列表信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	private String getMaxDid(String dataType) {
		List<TblCfgComdoclist> cdl = comdoclistDao.findDocByType(dataType);
		String did = null;
		if (cdl == null || cdl.size() == 0) {
			errorMsg = "获取文档列表时失败" + cdl;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
//		System.out.println(cdl.get(cdl.size()-1).getDid());
		String temp = cdl.get(cdl.size()-1).getDid();
		//System.out.println(temp);
		int number = Integer.parseInt(temp);
		did = String.format("%04d", number + 1);
		return did;
	}

	public void setWarrantindexDao(WarrantindexDao warrantindexDao) {
		this.warrantindexDao = warrantindexDao;
	}

	public void setComdoclistDao(ComdoclistDao comdoclistDao) {
		this.comdoclistDao = comdoclistDao;
	}

}
