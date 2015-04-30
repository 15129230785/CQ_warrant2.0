package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cq.dao.ProjecthistoryDao;
import com.cq.service.ProjectHistoryService;
import com.cq.table.TblProjecthistory;
import com.cq.util.tools;

public class ProjectHistoryServiceImpl implements ProjectHistoryService {
	static Logger log = Logger.getLogger(ProjectHistoryServiceImpl.class);
	private String errorMsg;
	
	private ProjecthistoryDao projecthistoryDao;
	
	@Override
	public void addProcessHistory(String wid, String desc) throws Exception {
		String history = null;
		TblProjecthistory tph = null;

		try {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			history = sdf.format(now) + "：" + desc;
			
			tph = new TblProjecthistory();
			tph.setWid(wid);
			tph.setDescription(history);
			projecthistoryDao.save(tph);
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg = "添加项目处理记录时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	public List<TblProjecthistory> getProcessHistory(String wid) {
		DetachedCriteria dc = DetachedCriteria.forClass(TblProjecthistory.class);
		dc.add(Restrictions.eq("wid", wid));
		dc.addOrder(Order.asc("kid"));
		return projecthistoryDao.findByCriterias(dc);
	}
	
	public void setProjecthistoryDao(ProjecthistoryDao projecthistoryDao) {
		this.projecthistoryDao = projecthistoryDao;
	}
}
