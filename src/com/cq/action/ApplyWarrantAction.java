package com.cq.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.cq.bean.CompanyProperty;
import com.cq.bean.CompanyType;
import com.cq.service.ApplyService;
import com.cq.service.CompanyService;
import com.cq.service.TaskBaseService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class ApplyWarrantAction {
	static Logger log = Logger.getLogger(ApplyWarrantAction.class);
	private String errorMsg;
	
	@Resource ApplyService applyService;
	@Resource TaskBaseService taskBaseService;
	@Resource CompanyService companyService;
	
	private String apply;
	private String sel;
	private String pid;
	private String taskid;
	private String wid;
	private String eid;
	private char type;
	private String xpid;
	private String selValue;

	public void runApply() throws Exception {
		applyService.startProcess();
	}

	// Mod by Luke on 2015/04/01, add personal manage loan apply
	public String applyWarrant() throws Exception {
		String str = apply;
		
		applyService.startApply(taskid, apply, xpid);
	
		if (str.equals("company")) {
			str = "company";
		} else if (str.equals("person")) {
			str = "person";
		} 
		
		return str;
	}

	public String applyPass() throws Exception {
		String result = "";
		
		// Begin: Mod by Luke Chen on 2015/04/20, for stop process going to next step if there's no role to haddle
		if (StringUtils.isBlank(selValue)) {
			errorMsg = "请指定处理人，若无处理人可选，请检查用户权限配置";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		// End: Mod by Luke Chen on 2015/04/20, for stop process going to next step if there's no role to haddle
		
		if (sel.equals("nextLater")) {
			result = "yes";
		} else if (sel.equals("transfer")) {
			return taskBaseService.transfer(selValue, taskid);
		} else {
			tools.returnError(log, "必须选择下一步处理");
			return "error";
		}
		
		if (type == '0') {
			return applyService.submitCompanyApply(taskid, wid, eid, selValue, result, type);
		} else if (type == '1') {
			return applyService.submitPersonApply(taskid, wid, pid, selValue, result, type);
		} else {
			tools.returnError(log, "必须选择企业担保或个人担保");
			return "error";
		}
	}

	public void applyCheckPersonData() throws Exception {
		String str1 = null;
		
		try {
			str1 = applyService.checkPersonApply(wid, pid);
			tools.outputInfo(str1);
		} catch (Exception e) {
			errorMsg = "对个人客户的担保申请进行业务检查时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void applyPassYz() throws Exception {
		String str1 = null;
		try {
			str1 = applyService.checkCompanyApply(wid, eid);
			tools.outputInfo(str1);
		} catch (Exception e) {
			errorMsg = "对企业客户的担保申请进行业务检查时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
//	public void applyYanZheng() throws IOException {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String msg = "";
//		
//		String id = request.getParameter("id");
//		String comtype = request.getParameter("text");
//		String[] c = comtype.split(",");
//		ServiceCheckServiceImpl sc = new ServiceCheckServiceImpl();
//		List<TblCfgSrvchk> ltcs = sc.getSrvchk();
//		BankinfoService bisi = new BankinfoServiceImpl();
//		List<TblCfgBankinfo> ltcbi = bisi.getBankInfoName(id);
//		int industry = 0;
//		String[] tcs = ltcs.get(0).getComtype().split(",");
//		for (int i = 0; i < tcs.length; i++) {
//			for (int j = 0; j < c.length; j++) {
//				if(tcs[i].equals(c[j])){
//					industry++;
//				}
//			}
//		}
//		if( industry < c.length){
//			msg = "对不起,没有所选行业信息\r\n";
//			out.print(msg);
//		}
//		
//		if (null == ltcs || null == ltcbi) {
//			out.print("0");
//		} else if ( 0 >= ltcs.size() || 0 >= ltcbi.size()){
//			out.print("0");
//		} else {
//			int u = 0;
//			int v = 0;
//			int x = 0;
//			int k = 0;
//			Double com = new Double(Double.parseDouble((request
//					.getParameter("com"))));
//			Double emp = Double.parseDouble(request.getParameter("emp"));
//			if (ltcs.get(0).getComrevenue() >= com
//					|| ltcs.get(0).getEmployee() >= emp) {
//				u = 1;
//			} else {
//				msg = msg + "对不起，您所输入的企业营业收入、企业从业人数 均超标，请从新填写\r\n";
//				u = 0;
//			}
//			int years = Integer.parseInt(request.getParameter("years"));
//			if (ltcs.get(0).getYear() <= years) {
//				v = 1;
//			} else {
//				msg = msg + "对不起，您所输入的 企业连续经营年限 过少，请重新填写\r\n";
//				v = 0;
//			}
//
//			Double mon = Double.parseDouble(request.getParameter("mon"));
//			Double cap = Double.parseDouble(request.getParameter("cap"));
//			Double month = Double.parseDouble(request.getParameter("comMon"));
//			if (ltcbi.get(0).getRemaining() >= mon) {
//				x = 1;
//				if ((mon * month) <= cap) {
//					x = x + 1;
//					if ((mon * month) <= com) {
//						x = x + 1;
//					} else {
//							msg = msg + "对不起，您所输入的 需担保金额 过多，请重新填写\r\n";
//					}
//				} else {
//					msg = msg + "对不起，您所输入的 需担保金额 过多，请重新填写\r\n";
//				}
//			} else {
//				msg = msg + "对不起，您所输入的 需担保金额 过多，请重新填写\r\n";
//			}
//
//			Double mor = Double.parseDouble(request.getParameter("mor"));
//			if (ltcs.get(0).getMortgage() <= (mor / mon) * 100) {
//				k = 1;
//			} else {
//				msg = msg + "对不起，您所输入的 可抵押资产金额 过少，请重新填写\r\n";
//			}
//
//			String str = "0";
//			if ((u + v + x + k) != 6) {
//				out.print(msg);
//			} else {
//				out.print(str);
//			}
//		}
//	}
//	
//	public void applyPerson() throws IOException {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String msg = "";
//		int num = 0;
//		String add = request.getParameter("add");
//		int inc = Integer.parseInt(request.getParameter("inc"));
//		int perMon = Integer.parseInt(request.getParameter("perMon"));
//		int perMor = Integer.parseInt(request.getParameter("perMor"));
//		String mar = request.getParameter("mar");
//		String perbank = request.getParameter("perbank");
//		int month = Integer.parseInt(request.getParameter("month"));
//		
//		ServiceCheckServiceImpl sc = new ServiceCheckServiceImpl();
//		List<TblCfgSrvchk> ltcs = sc.getSrvchk();
//		BankinfoService bisi = new BankinfoServiceImpl();
//		List<TblCfgBankinfo> ltcbi = bisi.getBankInfoName(perbank);
//		
//		if(add.equals("xian")){
//			if("1".equals(mar) || "2".equals(mar)){
//				if(perMor >= (perMon * month)){
//					num = num+1;
//				}else{
//					msg = msg + "对不起，您所输入的 可抵押资产金额 过少，请重新填写\r\n";
//				}
//			} else if(null != ltcs && 0 < ltcs.size()) {
//				if(ltcs.get(0).getMortgage() <= (perMor / perMon) * 100){
//					num = num+1;
//				}else{
//					msg = msg + "对不起，您所输入的 可抵押资产金额 过少，请重新填写\r\n";		
//				}
//			}
//			
//			if(null != ltcbi && 0 < ltcbi.size()){
//				if(ltcbi.get(0).getRemaining() >= perMon){
//					num = num+1;
//				}else{
//					msg = msg + "对不起，您的需要的需担保金额过多，不能提交\r\n";
//				}
//			}
//			if(inc >= (perMon * month)){
//				num = num+1;
//			}else{
//				msg = msg + "对不起，您的需要的需担保金额过多，不能提交\r\n";
//			}
//		}else{
//			msg = msg + "对不起，个人申请户口暂时只支持西安户口\r\n";
//		}
//		if(num == 3){
//			out.print("0");
//		}else{
//			out.print(msg);
//		}
//	}

	public void getCompanyType() throws Exception {
		List<CompanyType> ctlist = companyService.comtypelist();
		
		try {
			if((ctlist == null) || (ctlist.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				return;
			}
			JSONArray ja = new JSONArray();
			for(int i = 0; i < ctlist.size(); i++) {
				ja.add(JSONObject.fromObject(ctlist.get(i)));
			}
			JSONObject result = new JSONObject();
			result.put("ctList", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "获取企业类型时系统发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public void getCompanyProperty() throws Exception {
		List<CompanyProperty> cplit = companyService.compotylist();
		
		try {
			if((cplit == null) || (cplit.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				return;
			}
			JSONArray ja = new JSONArray();
			for(int i = 0; i < cplit.size(); i++) {
				ja.add(JSONObject.fromObject(cplit.get(i)));
			}
			JSONObject result = new JSONObject();
			result.put("cpList", ja.toString());
			tools.outputInfo(result);
		} catch (Exception e) {
			errorMsg = "获取企业性质时系统发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public String getApply() {
		return apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getXpid() {
		return xpid;
	}

	public void setXpid(String xpid) {
		this.xpid = xpid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}
}
