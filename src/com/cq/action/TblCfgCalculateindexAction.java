package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.CalculateindexDao;
import com.cq.table.TblCfgCalculateindex;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="计算类指标参数", dataName="cci")
public class TblCfgCalculateindexAction {
	static Logger log = Logger.getLogger(TblCfgCalculateindexAction.class);
	private String errorMsg;
	
	private int iid;
	private String name;
	private String cname;
	private double floor;
	private double ceil;
	private double indexvalue;
	private double ratio;
	private TblCfgCalculateindex cci;
	
	@Resource CalculateindexDao calculateindexDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String add() throws Exception {
		TblCfgCalculateindex ci = new TblCfgCalculateindex();
		try {
			ci.setName(name);
			ci.setCname(cname);
			ci.setFloor(floor);
			ci.setCeil(ceil);
			ci.setIndexvalue(indexvalue);
			ci.setRatio(ratio);
			cci = ci;
			calculateindexDao.save(ci);
		} catch (Exception e) {
			errorMsg = "添加失败";
			tools.throwException(e, log, errorMsg);
		}
		
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void delete() throws Exception {
		try {
			cci = calculateindexDao.get(iid);
			calculateindexDao.delete(iid);
			this.list();
		} catch (Exception e) {
			errorMsg = "删除失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String update() throws Exception {
		try {
			cci=calculateindexDao.get(iid);
			cci.setFloor(floor);
			cci.setCeil(ceil);
			cci.setIndexvalue(indexvalue);
			cci.setRatio(ratio);
			
			calculateindexDao.update(cci);
		} catch (Exception e) {
			errorMsg = "修改失败";
			tools.throwException(e, log, errorMsg);
		}
	
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void list() throws Exception {
		StringBuffer outs = null;
		List<TblCfgCalculateindex> cil = null;
		
		cil = calculateindexDao.list();
		if ((cil == null) || !(cil.size() > 0)) {
			tools.outputInfo(new StringBuffer("<p>没有配置计算类指标系数信息，请点击添加计算类指标系数按钮添加。</p>"));
		} else {
			outs = new StringBuffer();
			outs.append("<table width='100%' border='0' align='center'>");
			outs.append("<tr>");
			outs.append("<td width='30%'>指标名称</td>");
			outs.append("<td width='15%'>指标下限</td>");
			outs.append("<td width='15%x'>指标上限</td>");
			outs.append("<td width='15%x'>指标分值</td>");
			outs.append("<td width='15%'>系数</td>");
			outs.append("<td width='10%'>操作</td>");
			outs.append("</tr>");
			for (int i = 0; i < cil.size(); i++) {
				iid = cil.get(i).getKid();
				name = cil.get(i).getName();
				cname = cil.get(i).getCname();
				floor = cil.get(i).getFloor();
				ceil = cil.get(i).getCeil();
				indexvalue = cil.get(i).getIndexvalue();
				ratio = cil.get(i).getRatio();

				outs.append("<tr>");
				outs.append("<td width='30%'><a href='#' onclick='updateCalculateindexJs("
						+ '\"' + name  + '\"' + ','
						+ '\"' + cname + '\"' + ','
						+ floor + ',' + ceil + ','
						+ indexvalue + ',' + ratio
						+ ',' + iid + ")'>" + cname);
				outs.append("</td>");
				outs.append("<td width='15%'>" + floor);
				outs.append("</td>");
				outs.append("<td width='15%'>" + ceil);
				outs.append("</td>");
				outs.append("<td width='15%'>" + indexvalue);
				outs.append("</td>");
				outs.append("<td width='15%'>" + ratio);
				outs.append("</td>");
				outs.append("<td width='10%'><a href='#' onclick='deleteCalculateindexJs("
						+ iid + ")'>删除");
				outs.append("</a></td>");
				outs.append("</tr>");
			}
			outs.append("</table>");
			
			tools.outputInfo(outs);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<TblCfgCalculateindex> getTblCfgCalculateindex() throws Exception {
		List<TblCfgCalculateindex> tcc = null;
		try {
			tcc = calculateindexDao.list();
		} catch (Exception e) {
			errorMsg = "从数据库中获取计算类指标系数失败";
			tools.throwException(e, log, errorMsg);
		}
		return tcc;
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

	public double getFloor() {
		return floor;
	}

	public void setFloor(double floor) {
		this.floor = floor;
	}

	public double getCeil() {
		return ceil;
	}

	public void setCeil(double ceil) {
		this.ceil = ceil;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public double getIndexvalue() {
		return indexvalue;
	}

	public void setIndexvalue(double indexvalue) {
		this.indexvalue = indexvalue;
	}

	public void setCalculateindexDao(CalculateindexDao calculateindexDao) {
		this.calculateindexDao = calculateindexDao;
	}

	public TblCfgCalculateindex getCci() {
		return cci;
	}

	public void setCci(TblCfgCalculateindex cci) {
		this.cci = cci;
	}
}
