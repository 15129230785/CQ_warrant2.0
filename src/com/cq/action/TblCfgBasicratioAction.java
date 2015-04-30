package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.BasicratioDao;
import com.cq.table.TblCfgBasicratio;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="基本系数", dataName="cbc")
public class TblCfgBasicratioAction {
	static Logger log = Logger.getLogger(TblCfgBasicratioAction.class);
	private String errorMsg;
	
	private double br0;
	private double br1;
	private double br2;
	private double br3;
	private double br4;
	private double br5;
	private double br6;
	private double br7;
	private double br8;
	private TblCfgBasicratio cbc;

	@Resource BasicratioDao basicratioDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String update() throws Exception {
		List<TblCfgBasicratio> brl = null;
		TblCfgBasicratio br = null;
		
		try {
			brl = basicratioDao.list();
			if (brl == null || brl.size() == 0) {
				tools.returnError(log, "系统中没有要修改的数据");
				return "error";
			}
            cbc = br;
            cbc = brl.get(0);

            cbc.setBr0(br0);
            cbc.setBr1(br1);
            cbc.setBr2(br2);
            cbc.setBr3(br3);
            cbc.setBr4(br4);
            cbc.setBr5(br5);
            cbc.setBr6(br6);
            cbc.setBr7(br7);
            cbc.setBr8(br8);

			basicratioDao.update(cbc);
		} catch (Exception e) {
			errorMsg = "修改失败";
			tools.throwException(e, log, errorMsg);
		}
		
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void list() throws Exception {
		StringBuffer outs = null;
	
		List<TblCfgBasicratio> brl = null;
		TblCfgBasicratio br = null;
		
		brl = basicratioDao.list();
		if (brl == null || brl.size() == 0) {
			tools.outputInfo(new StringBuffer("<p>没有配置基本系数信息。</p>"));
		} else {
			outs = new StringBuffer();
			br = brl.get(0);
			
			br0 = br.getBr0();
			br1 = br.getBr1();
			br2 = br.getBr2();
			br3 = br.getBr3();
			br4 = br.getBr4();
			br5 = br.getBr5();
			br6 = br.getBr6();
			br7 = br.getBr7();
			br8 = br.getBr8();

			outs.append("<p>基本系数配置</p>");
			outs.append("<table width='100%' border='0' align='center'>");
			outs.append("<tr>");
			outs.append("<td width='150px'></td>");
			outs.append("<td width='150px'>AAA信用等级企业反担保(%)</td>");
			outs.append("<td width='150px'>AA信用等级企业反担保(%)</td>");
			outs.append("<td width='150px'>A信用等级企业反担保(%)</td>");
			outs.append("<td width='150px'>一般信用等级企业反担保(%)</td>");
			outs.append("<td width='150px'>可转让动产抵押(%)</td>");
			outs.append("<td width='150px'>可转让不动产抵押(%)</td>");
			outs.append("<td width='150px'>权利质押(%)</td>");
			outs.append("<td width='150px'>股权和个人反担保(%)</td>");
			outs.append("<td width='150px'>信誉(%)</td>");
			outs.append("</tr>");
			outs.append("<tr>");
			outs.append("<td width='150px'><a href='#'  onclick='updateBasicRatioJs("
					+ br0 + ',' + br1 + ','
					+ br2 + ',' + br3 + ','
					+ br4 + ',' + br5 + ','
					+ br6 + ',' + br7 + ','
					+ br8 + ")'>" + "修改");
			outs.append("</td>");
			outs.append("<td width='150px'>" + br0);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br1);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br2);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br3);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br4);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br5);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br6);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br7);
			outs.append("</td>");
			outs.append("<td width='150px'>" + br8);
			outs.append("</td>");
			outs.append("</tr>");
			outs.append("</table>");
			
			tools.outputInfo(outs);
		}
	}

	public double getBr0() {
		return br0;
	}

	public void setBr0(double br0) {
		this.br0 = br0;
	}

	public double getBr1() {
		return br1;
	}

	public void setBr1(double br1) {
		this.br1 = br1;
	}

	public double getBr2() {
		return br2;
	}

	public void setBr2(double br2) {
		this.br2 = br2;
	}

	public double getBr3() {
		return br3;
	}

	public void setBr3(double br3) {
		this.br3 = br3;
	}

	public double getBr4() {
		return br4;
	}

	public void setBr4(double br4) {
		this.br4 = br4;
	}

	public double getBr5() {
		return br5;
	}

	public void setBr5(double br5) {
		this.br5 = br5;
	}

	public double getBr6() {
		return br6;
	}

	public void setBr6(double br6) {
		this.br6 = br6;
	}

	public double getBr7() {
		return br7;
	}

	public void setBr7(double br7) {
		this.br7 = br7;
	}

	public double getBr8() {
		return br8;
	}

	public void setBr8(double br8) {
		this.br8 = br8;
	}

	public void setBasicratioDao(BasicratioDao basicratioDao) {
		this.basicratioDao = basicratioDao;
	}

	public TblCfgBasicratio getCbc() {
		return cbc;
	}

	public void setCbc(TblCfgBasicratio cbc) {
		this.cbc = cbc;
	}
}
