package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.DeptinfoDao;
import com.cq.table.TblDeptinfo;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="企业内部部门信息", dataName="dtf")
public class TblDeptinfoAction {
	static Logger log = Logger.getLogger(TblDeptinfoAction.class);
	private String errorMsg;
	
	private int kid;
	private String eid;
	private String name;
	private String duty;
	private TblDeptinfo dtf;
	
	@Resource DeptinfoDao deptinfoDao;

	// 验证部门名称是否存在
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void applyYanZhengdparname() throws Exception {
		String str = "depart";
		
		try {
			List<TblDeptinfo> listTblTblDeptinfo = deptinfoDao.findDeptinfoByEidAndName(eid, name);
			if (listTblTblDeptinfo != null && listTblTblDeptinfo.size() > 0) {
				str = listTblTblDeptinfo.get(0).getEid();
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "查询机构名称失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblDeptinfo() throws Exception {
		TblDeptinfo tblDeptinfo = null;

		try {
			tblDeptinfo = new TblDeptinfo();
			tblDeptinfo.setKid(kid);
			tblDeptinfo.setEid(eid);
			tblDeptinfo.setName(name);
			tblDeptinfo.setDuty(tools.multiLine(duty));
            dtf = tblDeptinfo;
			deptinfoDao.save(tblDeptinfo);
			tools.fillQueryInfo(1, eid, "TblDeptinfo");
		} catch (Exception e) {
			errorMsg = "保存企业部门信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		
		return "success";
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblDeptinfo() throws Exception {
		try {
			dtf = deptinfoDao.get(kid);
			deptinfoDao.delete(kid);
			this.selectAjaxTblDeptinfo();
		} catch (Exception e) {
			errorMsg = "删除失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblDeptinfo() throws Exception {
		String name1 = null;
		String duty1 = null;
		StringBuffer outs = null;
		
		List<TblDeptinfo> listTblDeptinfo = deptinfoDao.findByProperty("eid", eid);
		if (listTblDeptinfo == null || listTblDeptinfo.size() == 0) {
			return;
		}
		
		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='40%'>部门名称</th>");
		outs.append("<th width='45%'>部门职能</th>");
		outs.append("<th width='15%'>操作</th>");
		outs.append("</tr>");
		for (int i = 0; i < listTblDeptinfo.size(); i++) {
			name1 = listTblDeptinfo.get(i).getName();
			duty1 = listTblDeptinfo.get(i).getDuty();
			
			outs.append("<tr>");
			outs.append("<td onclick='updateInEnterpriseJs("
					+ listTblDeptinfo.get(i).getKid()
					+ ")'><a href='#'>" + name1);
			outs.append("</td>");
			outs.append("<td>" + duty1);
			outs.append("</td>");
			outs.append("<td onclick='inEnterpriseListOne("
					+ listTblDeptinfo.get(i).getKid() + ','
					+ '\"' + listTblDeptinfo.get(i).getEid() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblDeptinfo() throws Exception {
		try {
			dtf = deptinfoDao.get(kid);
			dtf.setName(name);
			dtf.setDuty(tools.multiLine(duty));
			tools.fillQueryInfo(1, eid, "TblDeptinfo");
			deptinfoDao.update(dtf);
		} catch (Exception e) {
			errorMsg = "修改失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblDeptinfo() throws Exception {
		TblDeptinfo bi = deptinfoDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到公司部门信息" + kid);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public void setDeptinfoDao(DeptinfoDao deptinfoDao) {
		this.deptinfoDao = deptinfoDao;
	}

	public TblDeptinfo getDtf() {
		return dtf;
	}

	public void setDtf(TblDeptinfo dtf) {
		this.dtf = dtf;
	}
}
