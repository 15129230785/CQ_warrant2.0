package com.cq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.bean.CompanyProperty;
import com.cq.bean.CompanyType;
import com.cq.service.CompanyService;
import com.cq.util.GlobalData;

@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
public class CompanyServiceImpl implements CompanyService{
	static Logger log = Logger.getLogger(CompanyServiceImpl.class);
	private String errorMsg;
	
	//private CompanyDao companyDao;
	
	//fhx 通过查询tbl_cfg_companytype获取行业行为
	@Override
	public List<CompanyType> comtypelist() throws Exception {
		List<CompanyType> bnlist = null;
		//List<CompanyType> tmplist = companyDao.listCompanyType();
		List<CompanyType> tmplist = GlobalData.companyTypes;
		int i, j = 0;

		if (tmplist == null || tmplist.size() == 0) {
			log.warn("没有查询到企业类型配置信息");
			return null;
		}
		
		bnlist = new ArrayList<CompanyType>();
		int flag = 0;
		for (i = 0; i < tmplist.size(); i++) {
			flag = 0;
			for (j = 0; j < bnlist.size(); j++) {
				if ( Integer.toString(tmplist.get(i).getKid()).equals(bnlist.get(j).getKid())) {
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
	public List<CompanyProperty> compotylist() throws Exception {
		//fhx 通过查询tbl_cfg_comproperty对象查询行业性质 
		List<CompanyProperty> bnlist = null;
		//List<CompanyProperty> tmplist = companyDao.listCompanyProperty();
		List<CompanyProperty> tmplist = GlobalData.companyPropertys;
		int i, j = 0;
		
		if (tmplist == null || tmplist.size() == 0) {
			log.warn("没有查询到企业性质配置信息");
			return null;
		}
		
		bnlist = new ArrayList<CompanyProperty>();
		int flag = 0;
		for (i = 0; i < tmplist.size(); i++) {
			flag = 0;
			for (j = 0; j < bnlist.size(); j++) {
				if ( Integer.toString(tmplist.get(i).getKid()).equals(bnlist.get(j).getKid())) {
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

	/*public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}*/

}

