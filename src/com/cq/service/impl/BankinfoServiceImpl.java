package com.cq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.bean.BankName;
import com.cq.dao.BankinfoDao;
import com.cq.service.BankinfoService;
import com.cq.table.TblCfgBankinfo;
import com.cq.util.tools;

@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
public class BankinfoServiceImpl implements BankinfoService {
	static Logger log = Logger.getLogger(BankinfoServiceImpl.class);
	private String errorMsg;
	
	private BankinfoDao bankinfoDao;
	
	@Override
	public List<BankName> getBilist() throws Exception {
		List<BankName> bnlist = new ArrayList<BankName>();
		List<BankName> tmplist = new ArrayList<BankName>();
		TblCfgBankinfo bi = null;
		int i, j = 0;

		try {
			List<TblCfgBankinfo> bnl = bankinfoDao.list();
			if (bnl == null || bnl.size() == 0) {
				log.warn("数据库查询银行信息失败" + bnl);
				return null;
			}
			
			for (i = 0; i < bnl.size(); i++) {
				bi = bnl.get(i);
				BankName d = new BankName();
				d.setBid(bi.getBid());
				d.setBankName(bi.getName());
				tmplist.add(d);
			}
		} catch (Exception e) {
			errorMsg = "获取银行名称失败";
			tools.throwException(e, log, errorMsg);
		}
		
		int flag = 0;
		for (i = 0; i < tmplist.size(); i++) {
			flag = 0;
			for (j = 0; j < bnlist.size(); j++) {
				if (tmplist.get(i).getBid().equals(bnlist.get(j).getBid())) {
					flag = 1;
					break;
				}
			}
			if (0 == flag) {
				bnlist.add(tmplist.get(i));
			}
		}
		return bnlist;
	}

	@Override
	public List<TblCfgBankinfo> getBankInfo() throws Exception {
		List<TblCfgBankinfo> ctlist = null;
		
		try {
			ctlist = bankinfoDao.list();
		} catch (Exception e) {
			errorMsg = "查询银行信息失败";
			tools.throwException(e, log, errorMsg);
		}
		return ctlist;
	}
	
	@Override
	public List<TblCfgBankinfo> getBankInfoName(String id) throws Exception {
		List<TblCfgBankinfo> ctlist = null;
		
		try {
			ctlist = bankinfoDao.findByProperty("bid", id);
		} catch (Exception e) {
			errorMsg = "根据银行编码查询银行信息失败";
			tools.throwException(e, log, errorMsg);
		}
		return ctlist;
	}

	public void setBankinfoDao(BankinfoDao bankinfoDao) {
		this.bankinfoDao = bankinfoDao;
	}

}
