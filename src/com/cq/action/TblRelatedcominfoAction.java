package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.RelatedcominfoDao;
import com.cq.table.TblRelatedcominfo;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="关联企业信息", dataName="rtci")
public class TblRelatedcominfoAction {
	static Logger log = Logger.getLogger(TblRelatedcominfoAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private String relatedID;
	private String name;
	private TblRelatedcominfo rtci;
	
	@Resource RelatedcominfoDao relatedcominfoDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblRelatedcominfo() throws Exception {
		TblRelatedcominfo tblRelatedcominfo = null;

		try {
			tblRelatedcominfo = new TblRelatedcominfo();
			tblRelatedcominfo.setKid(kid);
			tblRelatedcominfo.setEid(eid);
			tblRelatedcominfo.setRelatedID(relatedID);
			tblRelatedcominfo.setName(name);
            rtci = tblRelatedcominfo;
			relatedcominfoDao.save(rtci);
			tools.fillQueryInfo(1, eid, "TblRelatedcominfo");
		} catch (Exception e) {
			errorMsg = "保存企业关联企业信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblRelatedcominfo() throws Exception {
		try {
			rtci = relatedcominfoDao.get(kid);
			relatedcominfoDao.delete(kid);
			this.selectAjaxTblRelatedcominfo();
		} catch (Exception e) {
			errorMsg = "保存企业关联企业信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblRelatedcominfo() throws Exception {
		String name1 = null;
		StringBuffer outs = null;
		
		List<TblRelatedcominfo> listTblRelatedcominfo = relatedcominfoDao.findByProperty("eid", eid);
		if (listTblRelatedcominfo == null || listTblRelatedcominfo.size() == 0) {
			log.warn("没有查询到企业的关联企业信息");
			return;
		}
		
		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='35%'>关联企业代码</th>");
		outs.append("<th width='45%'>关联企业名称</th>");
		outs.append("<th width='20%'>操作</th>");
		outs.append("</tr>");
			
		for (int i = 0; i < listTblRelatedcominfo.size(); i++) {
			name1 = listTblRelatedcominfo.get(i).getName();
			
			outs.append("<tr>");
			outs.append("<td onclick='updateRelatedcominfoJs("
					+ listTblRelatedcominfo.get(i).getKid()
					+ ")'><a href='#'>"
					+ listTblRelatedcominfo.get(i).getRelatedID());
			outs.append("</td>");
			outs.append("<td>" + name1);
			outs.append("</td>");
			outs.append("<td onclick='relatedcominfoListOne("
					+ listTblRelatedcominfo.get(i).getKid() + ','
					+ '\"' + listTblRelatedcominfo.get(i).getEid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");

		tools.outputInfo(outs);
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblRelatedcominfo() throws Exception {
		try {
			rtci = relatedcominfoDao.get(kid);
			
			rtci.setRelatedID(relatedID);
			rtci.setName(name);

			relatedcominfoDao.update(rtci);
			tools.fillQueryInfo(1, eid, "TblRelatedcominfo");
		} catch (Exception e) {
			errorMsg = "修改企业关联企业信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblRelatedcominfo() throws Exception {
		TblRelatedcominfo bi = relatedcominfoDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到关联企业信息" + kid);
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

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getRelatedID() {
		return relatedID;
	}

	public void setRelatedID(String relatedID) {
		this.relatedID = relatedID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRelatedcominfoDao(RelatedcominfoDao relatedcominfoDao) {
		this.relatedcominfoDao = relatedcominfoDao;
	}

	public TblRelatedcominfo getRtci() {
		return rtci;
	}

	public void setRtci(TblRelatedcominfo rtci) {
		this.rtci = rtci;
	}
}
