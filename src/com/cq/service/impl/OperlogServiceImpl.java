package com.cq.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.OperlogDao;
import com.cq.service.OperlogService;
import com.cq.table.TblOperlog;
import com.cq.util.GlobalData;

@Transactional
public   class OperlogServiceImpl implements OperlogService {
	static Logger log = Logger.getLogger(OperlogServiceImpl.class);
	private String errorMsg;

	private OperlogDao operlogDao;

	@Override
	@Transactional (propagation=Propagation.SUPPORTS, rollbackFor={Exception.class})
	public void logLogin(String user, String cause) {
		createOperlog(user, "登录", cause);
	}
	
	@Override
	@Transactional (propagation=Propagation.SUPPORTS, rollbackFor={Exception.class})
	public void logTableOperation(TblOperlog ol) throws Exception {
		operlogDao.save(ol);
	}
	
	@Override
	@Transactional (propagation=Propagation.SUPPORTS, rollbackFor={Exception.class})
	public void logFileOperation(String user, String desc) {
		createOperlog(user, "文件", desc);
	}

	private void createOperlog(String user, String opMode, String log) {
		TblOperlog operlog = new TblOperlog();
		operlog.setName(user);
		operlog.setOpDate(System.currentTimeMillis());
		operlog.setOpMode(opMode);
		operlog.setLog(log);
		operlogDao.save(operlog);
	}
	
	public void setOperlogDao(OperlogDao operlogDao) {
		this.operlogDao = operlogDao;
	}
	
	@Override
	public List<TblOperlog> getOperlog(String userName,  String startDate,
			String endDate, String opMode, int firstResult) throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(TblOperlog.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if (userName != null && !(userName.trim().equals(""))) {
			dc.add(Restrictions.eq("name", userName));
		}
		
		if (startDate != null && !(startDate.trim().equals(""))) {
			long sdate = sdf.parse(startDate).getTime();
			dc.add(Restrictions.gt("opDate", sdate));
		}
		if (endDate != null && !(endDate.trim().equals(""))) {
			long edate = sdf.parse(endDate).getTime();
			dc.add(Restrictions.lt("opDate", edate));
		}
		 
		if(opMode != null && !(opMode.trim().equals(""))) {
			String om = null;
			if (opMode.equals("1")) {
				om = "登录";
			} else if (opMode.equals("2")) {
				om = "添加";
			} else if (opMode.equals("3")) {
				om = "修改";
			} else if (opMode.equals("4")) {
				om = "删除";
			} else if (opMode.equals("5")) {
				om = "文件";
			} else {
				om = "";
			}
			dc.add(Restrictions.eq("opMode", om));
		}
		dc.addOrder(Order.asc("opDate"));
		if (firstResult == -1) {
			 List<TblOperlog> list = operlogDao.findByCriterias(dc);
			 firstResult = (int) Math.floor(list.size() / GlobalData.maxLogResults);
		} else {
			int startRecord = firstResult * GlobalData.maxLogResults;
			return operlogDao.findByCriterias(dc, startRecord, GlobalData.maxLogResults);
		}
		int startRecord = firstResult * GlobalData.maxLogResults;
		return operlogDao.findByCriterias(dc, startRecord, GlobalData.maxLogResults);
	}
	
	@Override
	public int getCountPage(String userName,  String startDate,
			String endDate, String opMode, int firstResult) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(TblOperlog.class);
		String om = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if (userName != null && !(userName.trim().equals(""))) {
			dc.add(Restrictions.eq("name", userName));
		}
		
		if (startDate != null && !(startDate.trim().equals(""))) {
			long sdate = sdf.parse(startDate).getTime();
			dc.add(Restrictions.gt("opDate", sdate));
		}
		if (endDate != null && !(endDate.trim().equals(""))) {
			long edate = sdf.parse(endDate).getTime();
			dc.add(Restrictions.lt("opDate", edate));
		}
		 
		if(opMode != null && !(opMode.trim().equals(""))) {
			if (opMode.equals("1")) {
				om = "登录";
			} else if (opMode.equals("2")) {
				om = "添加";
			} else if (opMode.equals("3")) {
				om = "修改";
			} else if (opMode.equals("4")) {
				om = "删除";
			} else if (opMode.equals("5")) {
				om = "文件";
			} else {
				om = "";
			}
			dc.add(Restrictions.eq("opMode", om));
		}
		dc.addOrder(Order.asc("opDate"));

		int countPage = 0;
		if (GlobalData.maxLogResults > 0) {
			countPage = operlogDao.countByCriterias(dc) / GlobalData.maxLogResults;
		}
		return countPage;
	}
}
