package com.cq.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.ProblemtrackDao;
import com.cq.dao.WarrantindexDao;
import com.cq.table.TblProblemtrack;
import com.cq.table.TblWarrantindex;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="问题跟踪信息", dataName="plt")
public class TblProblemtrackAction{
	static Logger log = Logger.getLogger(TblProblemtrackAction.class);
	private String errorMsg;
	
	private int kid;
	private String wid;
	private String state;
	private String name;
	private Date StartDate;
	private String person;
	private Date endData;
	private char type;
	private String description;
	private String explains;
	private TblProblemtrack plt;

	@Resource ProblemtrackDao problemtrackDao;
	@Resource WarrantindexDao warrantindexDao;

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblProblemtrack() throws Exception {
		Date date = null;
		Date s = null;
		SimpleDateFormat sdf = null;

		TblProblemtrack tblProblemtrack = null;

		try {
			wid = wid.substring(wid.lastIndexOf("w"));
			TblWarrantindex wi = warrantindexDao.findByWid(wid);
			int times = wi.getTimes();
			
			date = new Date();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			s = sdf.parse(sdf.format(date));
			StartDate = (Date) s;

			tblProblemtrack = new TblProblemtrack();
			tblProblemtrack.setWid(wid);
			tblProblemtrack.setState(state);
			tblProblemtrack.setName(name);
			tblProblemtrack.setStartDate(StartDate);
			tblProblemtrack.setPerson(person);
			tblProblemtrack.setEndDate(endData);
			tblProblemtrack.setType(type);
			tblProblemtrack.setDescription(tools.multiLine(description));
			tblProblemtrack.setExplains(tools.multiLine(explains));
			tblProblemtrack.setTimes(times);
			plt = tblProblemtrack;
			problemtrackDao.save(plt);
			tools.fillQueryInfo(0, wid, "TblProblemtrack");
		} catch (Exception e) {
			errorMsg = "保存项目问题跟踪信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblProblemtrack() throws Exception {
		StringBuffer outs = null;

		List<TblProblemtrack> list = problemtrackDao.findByProperty("wid", wid.substring(wid.lastIndexOf("w")));
		if (list == null || list.size() == 0) {
			log.warn("获取项目问题跟踪列表信息失败" + list);
			tools.outputInfo("");
			return;
		}

		outs = new StringBuffer();

		outs.append("<table width='100%' id='r1'>");

		outs.append("<tr>");
		outs.append("<th align='center' style='display: none;'>编号</th>");
		outs.append("<th align='center' style='display: none;'>担保项目编码</th>");
		outs.append("<th align='center' width='20%'>问题描述</th>");
		outs.append("<th align='center' width='11%'>问题提出人</th>");
		outs.append("<th align='center' width='11%'>问题责任人</th>");
		outs.append("<th align='center' width='12%'>问题提出阶段</th>");
		outs.append("<th align='center' style='display: none;'>问题类型</th>");
		outs.append("<th align='center' width='12%'>问题提出时间</th>");
		outs.append("<th align='center' width='12%'>问题解决时间</th>");
		outs.append("<th align='center' width='15%'>解决情况描述</th>");
		outs.append("<th align='center' width='5%'>操作</th>");
		outs.append("</tr>");

		for (int i = 0; i < list.size(); i++) {
			outs.append("<tr>");
			outs.append("<td style='display: none;'>"
					+ list.get(i).getKid());
			outs.append("</td>");
			outs.append("<td style='display: none;'>"
					+ list.get(i).getWid());
			outs.append("</td>");
			outs.append("<td align='center' style='word-break:break-all; word-wrap:break-word' onclick='updateProblemJs("
					+ '\"' + list.get(i).getKid() + '\"'
					+ ")'><a href='#'>"
					+ list.get(i).getDescription());
			outs.append("</a></td>");
			outs.append("<td align='center'>"
					+ list.get(i).getName());
			outs.append("</td>");
			outs.append("<td align='center'>"
					+ list.get(i).getPerson());
			outs.append("</td>");
			outs.append("<td align='center'>"
					+ list.get(i).getState());
			outs.append("</td>");
			outs.append("<td align='center'>"
					+ list.get(i).getStartDate());
			outs.append("</td>");
			outs.append("<td align='center'>" + "");
			outs.append("</td>");
			outs.append("<td align='center' style='word-break:break-all; word-wrap:break-word'>"
					+ list.get(i).getExplains());
			outs.append("</td>");
			outs.append("<td width='5%' onclick='deleteProblem("
					+ "\"" + list.get(i).getKid() + "\",\""
					+ list.get(i).getWid()
					+ "\")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</td>");
			outs.append("</tr>");
		}
		outs.append("</table>");

		tools.outputInfo(outs);
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblProblemtrack() throws Exception {
		try {
			plt = problemtrackDao.get(kid);
			problemtrackDao.delete(kid);
			this.selectAjaxTblProblemtrack();
		} catch (Exception e) {
			errorMsg = "删除项目问题跟踪信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblProblemtrack() throws Exception {
		plt = null;
		try {
			wid = wid.substring(wid.lastIndexOf("w"));
			plt = problemtrackDao.get(kid);
			plt.setState(state);
			plt.setName(name);
			plt.setPerson(person);
			plt.setType(type);
			plt.setDescription(tools.multiLine(description));
			plt.setExplains(tools.multiLine(explains));
			problemtrackDao.update(plt);
			tools.fillQueryInfo(0, wid, "TblProblemtrack");
		} catch (Exception e) {
			errorMsg = "修改项目问题跟踪信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblProblemtrack() throws Exception {
		TblProblemtrack bi = problemtrackDao.get(kid);
		
		if (bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到需要跟踪的问题" + kid);
			return;
		}
		tools.outputInfo(JSONObject.fromObject(bi, tools.getJsonConfig()));
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getEndData() {
		return endData;
	}

	public void setEndData(Date endData) {
		this.endData = endData;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public void setProblemtrackDao(ProblemtrackDao problemtrackDao) {
		this.problemtrackDao = problemtrackDao;
	}

	public void setWarrantindexDao(WarrantindexDao warrantindexDao) {
		this.warrantindexDao = warrantindexDao;
	}

	public TblProblemtrack getPlt() {
			return plt;
	}

	public void setPlt(TblProblemtrack plt) {
			this.plt = plt;
	}
}
