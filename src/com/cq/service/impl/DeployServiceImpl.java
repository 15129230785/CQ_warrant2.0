package com.cq.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jbpm.api.IdentityService;
import org.jbpm.api.RepositoryService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.AnalysisindexDao;
import com.cq.dao.BasicratioDao;
import com.cq.dao.CalculateindexDao;
import com.cq.dao.ComdoclistDao;
import com.cq.dao.OverratioDao;
import com.cq.dao.SrvchkDao;
import com.cq.service.DeployService;
import com.cq.table.TblCfgAnalysisindex;
import com.cq.table.TblCfgBasicratio;
import com.cq.table.TblCfgCalculateindex;
import com.cq.table.TblCfgComdoclist;
import com.cq.table.TblCfgOverratio;
import com.cq.table.TblCfgSrvchk;
import com.cq.util.tools;

public class DeployServiceImpl implements DeployService {
	static Logger log = Logger.getLogger(DeployServiceImpl.class);
	private String errorMsg;
	
	private AnalysisindexDao analysisindexDao;
	private BasicratioDao basicratioDao;
	private CalculateindexDao calculateindexDao;
	private ComdoclistDao comdoclistDao;
	private IdentityService identityService;
	private OverratioDao overratioDao;
	private RepositoryService repositoryService;
	private SrvchkDao srvchkDao;
	
	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void deploy() throws Exception {
		int flag = 0;
		
		try {
			repositoryService.createDeployment()
					.addResourceFromClasspath("warrant.jpdl.xml").deploy();

			if (identityService.findGroupById("管理员") == null) {
				identityService.createGroup("管理员");
			}
			if (identityService.findUserById("root") == null) {
				identityService.createUser("root", null, null, null);
			}

			List<String> lstGroup = identityService.findGroupIdsByUser("root");
			for (int i = 0; i < lstGroup.size(); i++) {
				if ("管理员".equals(lstGroup.get(i))) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				identityService.createMembership("root", "管理员");
			}
		} catch (Exception e) {
			errorMsg = "业务部署失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void loadConfigData() throws Exception {
		try {
			getDefaultConfigFromXML();
		} catch (Exception e) {
			errorMsg = "数据加载失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	private void getDefaultConfigFromXML() throws Exception {
		comdoclistDao.deleteComdocList();
		basicratioDao.deleteBasicratioList();
		overratioDao.deleteOverratioList();
		srvchkDao.deleteSrvchkList();
		analysisindexDao.deleteAnalysisindexList();
		calculateindexDao.deleteCalculateindexList();
		
		getGlobalConfig();
	}
	
	private void getGlobalConfig() throws Exception {
		Resource cpr = new ClassPathResource("warrant.cfg.xml");
		SAXReader sr = new SAXReader();
		sr.setEncoding("utf-8");
		Document doc = sr.read(cpr.getFile());
		
		List<?> list = null;
		Iterator<?> iterator = null;
		Element rootele = doc.getRootElement();
		Element firstEle = null;
		
		try {
			firstEle = rootele.element("analysisindexs");
			list = firstEle.elements("analysisindex");
			iterator = list.iterator();
			
			while(iterator.hasNext()) {
				Element ele = (Element) iterator.next();
				
				TblCfgAnalysisindex ai = new TblCfgAnalysisindex();
				ai.setName(ele.attributeValue("name"));
				ai.setCname(ele.attributeValue("cname"));
				ai.setRatio(Double.parseDouble(ele.attributeValue("ratio")));
				analysisindexDao.save(ai);
			}
			firstEle.detach();
		} catch (Exception e) {
			errorMsg = "通过配置获取分析类指标系数失败";
			tools.throwException(e, log, errorMsg);
		}
		
		try {
			firstEle = rootele.element("calculateindexs");
			list = firstEle.elements("calculateindex");
			iterator = list.iterator();
			
			while(iterator.hasNext()) {
				Element ele = (Element) iterator.next();
				
				TblCfgCalculateindex ci = new TblCfgCalculateindex();
				ci.setName(ele.attributeValue("name"));
				ci.setCname(ele.attributeValue("cname"));
				ci.setFloor(Double.parseDouble(ele.attributeValue("floor")));
				ci.setCeil(Double.parseDouble(ele.attributeValue("ceil")));
				ci.setIndexvalue(Double.parseDouble(ele.attributeValue("indexvalue")));
				ci.setRatio(Double.parseDouble(ele.attributeValue("ratio")));
				calculateindexDao.save(ci);
			}
			firstEle.detach();
		} catch (Exception e) {
			errorMsg = "通过配置获取计算指标系数失败";
			tools.throwException(e, log, errorMsg);
		}
		
		try {
			firstEle = rootele.element("basicratio");
			
			TblCfgBasicratio br = new TblCfgBasicratio();
			br.setBr0(Double.parseDouble(firstEle.attributeValue("br0")));
			br.setBr1(Double.parseDouble(firstEle.attributeValue("br1")));
			br.setBr2(Double.parseDouble(firstEle.attributeValue("br2")));
			br.setBr3(Double.parseDouble(firstEle.attributeValue("br3")));
			br.setBr4(Double.parseDouble(firstEle.attributeValue("br4")));
			br.setBr5(Double.parseDouble(firstEle.attributeValue("br5")));
			br.setBr6(Double.parseDouble(firstEle.attributeValue("br6")));
			br.setBr7(Double.parseDouble(firstEle.attributeValue("br7")));
			br.setBr8(Double.parseDouble(firstEle.attributeValue("br8")));
			
			basicratioDao.save(br);
			firstEle.detach();
		} catch (Exception e) {
			errorMsg = "通过配置获取基本系数失败";
			tools.throwException(e, log, errorMsg);
		}
		
		try {
			firstEle = rootele.element("overratio");
			
			TblCfgOverratio or = new TblCfgOverratio();
			
			or.setOr0(Double.parseDouble(firstEle.attributeValue("or0")));
			or.setOr1(Double.parseDouble(firstEle.attributeValue("or1")));
			or.setOr2(Double.parseDouble(firstEle.attributeValue("or2")));
			
			overratioDao.save(or);
			firstEle.detach();
		} catch (Exception e) {
			errorMsg = "通过配置获取过度系数失败";
			tools.throwException(e, log, errorMsg);
		}
		
		try {
			firstEle = rootele.element("srvchk");
			
			TblCfgSrvchk srvchk = new TblCfgSrvchk();
			
			srvchk.setComtype(firstEle.attributeValue("comtype"));
			srvchk.setComrevenue(Double.parseDouble(firstEle.attributeValue("comrevenue")));
			srvchk.setEmployee(Integer.parseInt(firstEle.attributeValue("employee")));
			srvchk.setYear(Integer.parseInt(firstEle.attributeValue("year")));
			srvchk.setMortgage(Double.parseDouble(firstEle.attributeValue("mortgage")));
			srvchk.setAddress(firstEle.attributeValue("address"));
			srvchk.setVocation(firstEle.attributeValue("vocation"));
			srvchk.setIncome(Double.parseDouble(firstEle.attributeValue("income")));
			srvchk.setPersonmortgage(Double.parseDouble(firstEle.attributeValue("personmortgage")));
			
			srvchkDao.save(srvchk);
			firstEle.detach();
		} catch (Exception e) {
			errorMsg = "通过配置获取业务检查参数失败";
			tools.throwException(e, log, errorMsg);
		}
		
		try {
			firstEle = rootele.element("comdoclist");
			list = firstEle.elements("comdoc");
			iterator = list.iterator();
			
			while(iterator.hasNext()) {
				Element ele = (Element) iterator.next();
				Element desc = ele.element("description");
				
				TblCfgComdoclist cc = new TblCfgComdoclist();
				cc.setDid(ele.attributeValue("DID"));
				cc.setName(ele.attributeValue("Name"));
				cc.setFile(ele.attributeValue("FILE"));
				cc.setCollectTime(ele.attributeValue("CollectTime"));
				cc.setFileTime(ele.attributeValue("FileTime"));
				cc.setDescription(desc.getTextTrim());
				
				comdoclistDao.save(cc);
			}
			firstEle.detach();
		} catch (Exception e) {
			errorMsg = "通过配置获取文档列表失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void setAnalysisindexDao(AnalysisindexDao analysisindexDao) {
		this.analysisindexDao = analysisindexDao;
	}

	public void setBasicratioDao(BasicratioDao basicratioDao) {
		this.basicratioDao = basicratioDao;
	}

	public void setCalculateindexDao(CalculateindexDao calculateindexDao) {
		this.calculateindexDao = calculateindexDao;
	}

	public void setComdoclistDao(ComdoclistDao comdoclistDao) {
		this.comdoclistDao = comdoclistDao;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

	public void setOverratioDao(OverratioDao overratioDao) {
		this.overratioDao = overratioDao;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public void setSrvchkDao(SrvchkDao srvchkDao) {
		this.srvchkDao = srvchkDao;
	}
}
