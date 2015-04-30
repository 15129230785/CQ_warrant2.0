package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.AnalysisindexDao;
import com.cq.table.TblCfgAnalysisindex;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="分析类指标参数", dataName="cai")
public class TblCfgAnalysisindexAction {
	static Logger log = Logger.getLogger(TblCfgAnalysisindexAction.class);
	private String errorMsg;
	
	private int iid;
	private String name;
	private String cname;
	private double ratio;
	private TblCfgAnalysisindex cai;
	
	@Resource AnalysisindexDao analysisindexDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String add() throws Exception {
		TblCfgAnalysisindex ai = null;
		
		ai = analysisindexDao.findOnlyByProperty("name", name);
		if (ai != null) {
			log.warn("分析型指标中已经有重复名称的数据" + name);
			tools.returnError(null, "分析型指标中已经有重复名称的数据" + name);
			return "error";
		}
		
		ai = analysisindexDao.findOnlyByProperty("cname", cname);
		if (ai != null) {
			log.warn("分析型指标中已经有重复中文名称的数据" + cname);
			tools.returnError(null, "分析型指标中已经有重复中文名称的数据" + cname);
			return "error";
		}

		try {
			cai = ai;
			cai.setName(name);
			cai.setCname(cname);
			cai.setRatio(ratio);
			analysisindexDao.save(cai);
		} catch (Exception e) {
			errorMsg = "添加分析型指标数据失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void delete() throws Exception {
		try {
			cai = analysisindexDao.get(iid);
			analysisindexDao.delete(iid);
			this.list();
		} catch (Exception e) {
				errorMsg = "删除分析型指标数据失败";
				tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String update() throws Exception {
		try {
			cai = analysisindexDao.get(iid);
			cai.setRatio(ratio);
			analysisindexDao.update(cai);
		} catch (Exception e) {
			errorMsg = "修改分析型指标数据失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void list() throws Exception {
		List<TblCfgAnalysisindex> ail = null;
		StringBuffer outs = new StringBuffer();
		
		ail = analysisindexDao.list();

		if ((ail == null) || !(ail.size() > 0)) {
			tools.outputInfo(new StringBuffer("<p>没有配置分析类指标系数信息，请点击添加分析类指标系数按钮添加。</p>"));
		} else {
			outs.append("<table width='100%' border='0' align='center'>");
			outs.append("<tr>");
			outs.append("<td width='30%'>指标名称</td>");
			outs.append("<td width='15%'>系数</td>");
			outs.append("<td width='15%'>操作</td>");
			outs.append("</tr>");
			for (int i = 0; i < ail.size(); i++) {
				iid = ail.get(i).getKid();
				name = ail.get(i).getName();
				cname = ail.get(i).getCname();
				ratio = ail.get(i).getRatio();

				outs.append("<tr>");
				outs.append("<td width='30%'><a href='#' onclick='updateAnalysisindexJs("
						+ '\"' + name + '\"' + ','
						+ '\"' + cname + '\"' + ','
						+ ratio + ',' + iid + ")'>" + cname);
				outs.append("</td>");
				outs.append("<td width='15%'>" + ratio);
				outs.append("</td>");
				outs.append("<td width='10%'><a href='#' onclick='deleteAnalysisindexJs("
						+ iid + ")'>删除");
				outs.append("</a></td>");
				outs.append("</tr>");
			}
			outs.append("</table>");
		}
		
		tools.outputInfo(outs);
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblCfgAnalysisindex> getTblCfgAnalysisindex() {
		return analysisindexDao.list();
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public void setAnalysisindexDao(AnalysisindexDao analysisindexDao) {
		this.analysisindexDao = analysisindexDao;
	}

	public TblCfgAnalysisindex getCai() {
		return cai;
	}

	public void setCai(TblCfgAnalysisindex cai) {
		this.cai = cai;
	}
}
