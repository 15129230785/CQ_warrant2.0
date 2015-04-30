package com.cq.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.dao.FamilyDao;
import com.cq.table.TblFamily;
import com.cq.util.GlobalData;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName="家庭成员信息", dataName="family")
public class TblFamilyAction {
	static Logger log = Logger.getLogger(TblFamilyAction.class);
	private String errorMsg;
	
	private int kid;
	private String id;
	private String sid;
	private String name;
	private char gender;
	private String birthday;
	private String vocation;
	private String relationship;
	private String description;
	private TblFamily family;

	@Resource FamilyDao familyDao;
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String savaTblFamily() throws Exception{
		Date tmpDate = null;
		
		try {
			TblFamily tf = new TblFamily();
			tf.setKid(kid);
			tf.setId(id);
			tf.setSid(sid);
			tf.setName(name);
			tf.setGender(gender);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = df.parse(birthday);
			tf.setBirthday(tmpDate);
			
			tf.setVocation(vocation);
			tf.setRelationship(relationship);
			tf.setDescription(tools.multiLine(description));
			family = tf;
			familyDao.save(family);
			tools.fillQueryInfo(3, id, "TblFamily");
		} catch (Exception e) {
			errorMsg = "保存个人家庭信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void outDeleteTblFamily() throws Exception {		
		try {
			family = familyDao.get(kid);
			familyDao.delete(kid);
			this.selectAjaxTblFamily();
		} catch (Exception e) {
			errorMsg = "删除个人家庭信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void selectAjaxTblFamily() throws Exception {
		TblFamily tf = null;
		String gender2=null;
		String rlatinship2=null;
		String bd = null;
		StringBuffer outs = null;

		List<TblFamily> listTblFamily = familyDao.findByProperty("id", id);
		if (listTblFamily == null || listTblFamily.size() == 0) {
			log.warn("没有查询到个人家庭信息");
			return;
		}
		
		outs = new StringBuffer();
		outs.append("<table>");
		outs.append("<tr>");
		outs.append("<th width='10%'>姓名</th>");
		outs.append("<th width='20%'>身份证号码</th>");
		outs.append("<th width='7%'>性别</th>");
		outs.append("<th width='13%'>出生日期</th>");
		outs.append("<th width='11%'>职业</th>");
		outs.append("<th width='10%'>关系</th>");
		outs.append("<th width='22%'>说明</th>");
		outs.append("<th width='7%'>操作</th>");
		outs.append("</tr>");
		for (int i = 0; i < listTblFamily.size(); i++) {
			tf = listTblFamily.get(i);
			gender2 = GlobalData.gender.get(
					Character.toString(tf.getGender()));
			rlatinship2 = GlobalData.relationships.get(tf.getRelationship());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			bd = df.format(tf.getBirthday());
			
			outs.append("<tr>");
			outs.append("<td onclick='updateFamilyJs("
					+ tf.getKid()
					+ ")'><a href='#'>" + tf.getName());
			outs.append("</td>");
			outs.append("<td>" + tf.getSid());
			outs.append("</td>");
			outs.append("<td>" + gender2);
			outs.append("</td>");
			outs.append("<td>" + bd);
			outs.append("</td>");
			outs.append("<td>" + tf.getVocation());
			outs.append("</td>");
			outs.append("<td>" + rlatinship2);
			outs.append("</td>");
			outs.append("<td>" + tf.getDescription());
			outs.append("</td>");
			outs.append("<td onclick='familyListOne("
					+ tf.getKid() + ','
					+ '\"' + tf.getId() + '\"'
					+ ")'><a href='#'>删除");
			outs.append("</a></td>");
			outs.append("</tr>");
		}
		outs.append("</table>");
		
		tools.outputInfo(outs);
	}
	
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String updateTblFamily() throws Exception {
		Date tmpDate = null;

		try {
			family = familyDao.get(kid);
	
			family.setSid(sid);
			family.setName(name);
			family.setGender(gender);
	
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = df.parse(birthday);
			family.setBirthday(tmpDate);
	
			family.setVocation(vocation);
			family.setRelationship(relationship);
			family.setDescription(tools.multiLine(description));
			tools.fillQueryInfo(3, id, "TblFamily");
			familyDao.update(family);
		} catch (Exception e) {
			errorMsg = "修改个人家庭信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public void getTblFamily() throws Exception {
		TblFamily bi = familyDao.get(kid);
		
		if(bi == null) {
			tools.outputInfo(JSONObject.fromObject(""));
			log.warn("没有查询到个人家庭信息" + kid);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFamilyDao(FamilyDao familyDao) {
		this.familyDao = familyDao;
	}

	public TblFamily getFamily() {
		return family;
	}

	public void setFamily(TblFamily family) {
		this.family = family;
	}
}
