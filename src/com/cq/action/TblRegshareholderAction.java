package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.RegshareholderDao;
import com.cq.table.TblRegshareholder;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业注册股东信息", dataName="rshr")
public class TblRegshareholderAction {
	static Logger log = Logger.getLogger(TblRegshareholderAction.class);
	private String errorMsg;

	private int kid;
	private String rid;
	private char type;
	private String name;
	private String sid;
	private double share;
	private TblRegshareholder rshr;

	@Resource
	RegshareholderDao regshareholderDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String savaTblRegshareholder() throws Exception {
		try {
			TblRegshareholder tblRegshareholder = new TblRegshareholder();
			tblRegshareholder.setRid(rid);
			tblRegshareholder.setType(type);
			tblRegshareholder.setName(name);
			tblRegshareholder.setSid(sid);
			tblRegshareholder.setShare(share);
			rshr = tblRegshareholder;
			regshareholderDao.save(rshr);
			tools.fillQueryInfo(2, rid, "TblRegshareholder");
		} catch (Exception e) {
			errorMsg = "保存企业注册股东信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void outDeleteTblRegshareholder() throws Exception {
		try {
			rshr = regshareholderDao.get(kid);
			regshareholderDao.delete(kid);
			this.selectAjaxTblRegshareholder();
		} catch (Exception e) {
			errorMsg = "删除企业注册股东信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void selectAjaxTblRegshareholder() throws Exception {
		String type2 = null;
		String name1 = null;
		StringBuffer outs = null;

		List<TblRegshareholder> listTblRegshareholder = regshareholderDao.findByProperty("rid", rid);
		if (listTblRegshareholder == null || listTblRegshareholder.size() == 0) {
			log.warn("没有查询到企业注册股东信息");
			return;
		}

		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='25%'>股东名称</th>");
		outs.append("<th width='20%'>股东类型</th>");
		outs.append("<th width='25%'>股东编码</th>");
		outs.append("<th width='20%'>所占股份比例</th>");
		outs.append("<th width='10%'>操作</th>");
		outs.append("</tr>");

		for (int i = 0; i < listTblRegshareholder.size(); i++) {
			char type1 = listTblRegshareholder.get(i).getType();
			if (type1 == '0') {
				type2 = "法人股东";
			} else if (type1 == '1') {
				type2 = "自然人股东";
			} else {
				type2 = "";
			}
			name1 = listTblRegshareholder.get(i).getName();

			outs.append("<tr>");
			outs.append("<td onclick='updateRegshareholderJs("
					+ listTblRegshareholder.get(i).getKid()
					+ ")'><a href='#'>" + name1);
			outs.append("</td>");
			outs.append("<td>" + type2);
			outs.append("</td>");
			outs.append("<td>"
					+ listTblRegshareholder.get(i).getSid());
			outs.append("</td>");
			outs.append("<td>"
					+ listTblRegshareholder.get(i).getShare());
			outs.append("</td>");
			outs.append("<td onclick='regshareholderListOne("
					+ listTblRegshareholder.get(i).getKid() + ',' + '\"'
					+ listTblRegshareholder.get(i).getRid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");

		tools.outputInfo(outs);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public String updateTblRegshareholder() throws Exception {
		try {
			rshr = regshareholderDao.get(kid);

			rshr.setType(type);
			rshr.setName(name);
			rshr.setSid(sid);
			rshr.setShare(share);

			regshareholderDao.update(rshr);
			tools.fillQueryInfo(2, rid, "TblRegshareholder");
		} catch (Exception e) {
			errorMsg = "修改企业注册股东信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblRegshareholder() throws Exception {
		TblRegshareholder bi = regshareholderDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到注册股东信息" + kid);
			return;
		}
		tools.outputInfo(JSONObject.fromObject(bi));
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}

	public void setRegshareholderDao(RegshareholderDao regshareholderDao) {
		this.regshareholderDao = regshareholderDao;
	}

	public TblRegshareholder getRshr() {
		return rshr;
	}

	public void setRshr(TblRegshareholder rshr) {
		this.rshr = rshr;
	}
}
