package com.cq.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.AnalysisindexDao;
import com.cq.dao.BankinfoDao;
import com.cq.dao.CalculateindexDao;
import com.cq.dao.DecisionDao;
import com.cq.dao.FinanceestDao;
import com.cq.dao.PersonalriskDao;
import com.cq.dao.RiskestDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.ChargeService;
import com.cq.service.DecisionService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCfgAnalysisindex;
import com.cq.table.TblCfgBankinfo;
import com.cq.table.TblCfgCalculateindex;
import com.cq.table.TblDecision;
import com.cq.table.TblFinanceest;
import com.cq.table.TblPersonalrisk;
import com.cq.table.TblRiskest;
import com.cq.table.TblWarrantinfo;
import com.cq.util.ChargeType;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class DecisionServiceImpl implements DecisionService {
	static Logger log = Logger.getLogger(DecisionServiceImpl.class);
	private String errorMsg;
	
	private AnalysisindexDao analysisindexDao;
	private BankinfoDao bankinfoDao;
	private CalculateindexDao calculateindexDao;
	private ChargeService chargeService;
	private DecisionDao decisionDao;
	private FinanceestDao financeestDao;
	private PersonalriskDao personalriskDao;
	private RiskestDao riskestDao;
	private TaskBaseService taskBaseService;
	private WarrantinfoDao warrantinfoDao;

	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public StringBuffer personCreditGrade(String wwid) throws Exception {
		int age = 0;// 个人年龄；
		int ducationLevel = 0;// 最高学历
		int martialStatus = 0;// 婚姻状况
		int liveTime = 0;// 本地居住时间
		int socialSecurity = 0;// 社保
		int job = 0;// 职业
		double familyIncome = 0;// 家庭总收入
		int numb = 0;// 家庭人数
		double grossDebt = 0;// 家庭总负债
		double totalAssets = 0;// 总资产
		int housSituation = 0;// 住房情况
		double db = 0;//被除数为0时，比较用值
		double xs = 0;//被除数为0时，显示用值

		String wid = wwid.substring(wwid.lastIndexOf("w"));

		String xl = null;
		String martStatu = null;
		String socSecurit = null;
		String jobb = null;
		String hous = null;
		Map<String, String> m = new HashMap<String, String>();
		m.put("1", "极差");
		m.put("2", "较差");
		m.put("3", "一般");
		m.put("4", "良好");
		m.put("5", "优秀");

		double max = 0;
		double min = 0;
		TblWarrantinfo s = warrantinfoDao.findWarrantinfoByWid(wid);
		if (s == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		List<TblPersonalrisk> perl = personalriskDao.findByProperty("wid", wid);
		if (perl == null || perl.size() == 0) {
			errorMsg = "获取个人风险评估信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		List<TblCfgCalculateindex> tcc = calculateindexDao.list();
		if (tcc == null || tcc.size() == 0) {
			errorMsg = "获取计算类指标信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		StringBuffer outs = new StringBuffer();

		age = perl.get(0).getAge();
		ducationLevel = perl.get(0).getDucationLevel();
		martialStatus = perl.get(0).getMartialStatus();
		liveTime = perl.get(0).getLiveTime();
		socialSecurity = perl.get(0).getSocialSecurity();
		job = perl.get(0).getJob();
		familyIncome = perl.get(0).getFamilyIncome();
		numb = perl.get(0).getNumb();
		grossDebt = perl.get(0).getGrossDebt();
		totalAssets = perl.get(0).getTotalAssets();
		housSituation = perl.get(0).getHousSituation();

		double money = s.getPracticalMoney();
		double zc = 0;
		double zc1 = 0;
		double zc2 = 0;
		double zc3 = 0;
		double zc4 = 0;
		double zc5 = 0;
		double zc6 = 0;
		double zc7 = 0;
		double zc8 = 0;
		double zc9 = 0;

		if (0 == ducationLevel) {
			xl = "高中/中专、技校";
		} else if (1 == ducationLevel) {
			xl = "大专";
		} else if (2 == ducationLevel) {
			xl = "本科";
		} else if (3 == ducationLevel) {
			xl = "硕士以上";
		} else if (4 == ducationLevel) {
			xl = "其它";
		} else {
			xl = "";
		}

		if (0 == martialStatus) {
			martStatu = "已婚";
		} else if (1 == martialStatus) {
			martStatu = "未婚";
		} else {
			martStatu = "";
		}

		if (0 == socialSecurity) {
			socSecurit = "是";
		} else if (1 == socialSecurity) {
			socSecurit = "否";
		} else {
			socSecurit = "";
		}

		if (0 == job) {
			jobb = "企事业单位负责人";
		} else if (1 == job) {
			jobb = "专业技术人员";
		} else if (2 == job) {
			jobb = "基层服务人员";
		} else if (3 == job) {
			jobb = "个体工商户及其他";
		} else {
			jobb = "";
		}

		if (0 == housSituation) {
			hous = "无负债自有住房";
		} else if (1 == housSituation) {
			hous = "按揭住房";
		} else if (2 == housSituation) {
			hous = "租住房";
		} else if (3 == housSituation) {
			hous = "其它";
		} else {
			hous = "";
		}

		outs.append("<table border='1'width='100%'>");
		outs.append("<tr>");
		outs.append("<td >项目</td>");
		outs.append("<td>项目值</td>");
		outs.append("<td>分值</td>");
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<tr>");
		outs.append("<td >年龄</td>");
		outs.append("<td>" + age + "</td>");
		max = getTblCfgCalculateindexMax("age");
		min = getTblCfgCalculateindexMin("age");

		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("age")) {
				if (age >= max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"age", max);
					zc = cc.getIndexvalue();
					outs.append("<td>" + zc + "</td>");
					break;
				} else if (age < min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"age", min);
					zc = cc.getIndexvalue();
					outs.append("<td>" + zc + "</td>");
					break;
				} else if (tcc.get(i).getFloor() <= age
						&& tcc.get(i).getCeil() > age) {
					zc = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >最高学历</td>");
		outs.append("<td>" + xl + "</td>");
		max = getTblCfgCalculateindexMax("xueli");
		min = getTblCfgCalculateindexMin("xueli");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("xueli")) {
				if (ducationLevel == max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"xueli", max);
					zc6 = cc.getIndexvalue();
					outs.append("<td>" + zc6 + "</td>");
					break;
				} else if (ducationLevel == min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"xueli", min);
					zc6 = cc.getIndexvalue();
					outs.append("<td>" + zc6 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() == ducationLevel
						&& tcc.get(i).getCeil() == ducationLevel) {
					zc6 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc6 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >婚姻状况</td>");
		outs.append("<td>" + martStatu + "</td>");
		max = getTblCfgCalculateindexMax("hunyin");
		min = getTblCfgCalculateindexMin("hunyin");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("hunyin")) {
				if (martialStatus == max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"hunyin", max);
					zc5 = cc.getIndexvalue();
					outs.append("<td>" + zc5 + "</td>");
					break;
				} else if (martialStatus == min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"hunyin", min);
					zc5 = cc.getIndexvalue();
					outs.append("<td>" + zc5 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() == martialStatus
						&& tcc.get(i).getCeil() == martialStatus) {
					zc5 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc5 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >本地居住时间</td>");
		outs.append("<td>" + liveTime + "年</td>");
		max = getTblCfgCalculateindexMax("livetime");
		min = getTblCfgCalculateindexMin("livetime");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("livetime")) {
				if (liveTime >= max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"livetime", max);
					zc2 = cc.getIndexvalue();
					outs.append("<td>" + zc2 + "</td>");
					break;
				} else if (liveTime < min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"livetime", min);
					zc2 = cc.getIndexvalue();
					outs.append("<td>" + zc2 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() <= liveTime
						&& tcc.get(i).getCeil() > liveTime) {
					zc2 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc2 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >社保</td>");
		outs.append("<td>" + socSecurit + "</td>");
		max = getTblCfgCalculateindexMax("shebao");
		min = getTblCfgCalculateindexMin("shebao");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("shebao")) {
				if (socialSecurity == max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"shebao", max);
					zc7 = cc.getIndexvalue();
					outs.append("<td>" + zc7 + "</td>");
					break;
				} else if (socialSecurity == min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"shebao", min);
					zc7 = cc.getIndexvalue();
					outs.append("<td>" + zc7 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() == socialSecurity
						&& tcc.get(i).getCeil() == socialSecurity) {
					zc7 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc7 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >职业</td>");
		outs.append("<td>" + jobb + "</td>");
		max = getTblCfgCalculateindexMax("jb");
		min = getTblCfgCalculateindexMin("jb");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("jb")) {
				if (job == max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"jb", max);
					zc8 = cc.getIndexvalue();
					outs.append("<td>" + zc8 + "</td>");
					break;
				} else if (job == min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"jb", min);
					zc8 = cc.getIndexvalue();
					outs.append("<td>" + zc8 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() == job
						&& tcc.get(i).getCeil() == job) {
					zc8 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc8 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >人均收入</td>");
		max = getTblCfgCalculateindexMax("rjsr");
		min = getTblCfgCalculateindexMin("rjsr");
		db = 0;
		xs = 0;
		if (numb == 0) {
			db = max;
			xs = familyIncome;
		} else {
			db = (familyIncome / numb) * 100;
			xs = familyIncome / numb;
		}
		
			outs.append("<td>" +String.format("%.2f",xs)
					+ "¥</td>");
		
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("rjsr")) {
				if (db>= max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"rjsr", max);
					zc1 = cc.getIndexvalue();
					outs.append("<td>" + zc1 + "</td>");
					break;
				} else if (db< min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"rjsr", min);
					zc1 = cc.getIndexvalue();
					outs.append("<td>" + zc1 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() <= db
						&& tcc.get(i).getCeil() > db) {
					zc1 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc1 + "</td>");
					break;
				}
			}
		}
		
		max = getTblCfgCalculateindexMax("zcfb");
		min = getTblCfgCalculateindexMin("zcfb");
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >资产负债比</td>");
		db = 0;
		xs = 0;
		if (totalAssets == 0) {
			db = max;
			xs = 100;
		} else {
			db = (grossDebt / totalAssets) * 100;
			xs = (grossDebt / totalAssets) * 100;
		}
		outs.append("<td>"
				+ String.format("%.2f", xs)
				+ "%</td>");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("zcfb")) {
				if (db >= max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"zcfb", max);
					zc3 = cc.getIndexvalue();
					outs.append("<td>" + zc3 + "</td>");
					break;
				} else if (db < min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"zcfb", min);
					zc3 = cc.getIndexvalue();
					outs.append("<td>" + zc3 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() <= db
						&& tcc.get(i).getCeil() > db) {
					zc3 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc3 + "</td>");
					break;
				}
			}
		}

		max = getTblCfgCalculateindexMax("dzsb");
		min = getTblCfgCalculateindexMin("dzsb");
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >贷款占收入比例</td>");
		db = 0;
		xs = 0;
		if (familyIncome == 0) {
			db = max;
			xs = 100;
		} else {
			db = ((money*10000 )/ familyIncome) * 100;
			xs = ((money*10000 ) / familyIncome) * 100;
		}
		outs.append("<td>" + String.format("%.2f", xs)
				+ "%</td>");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("dzsb")) {
				if (db >= max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"dzsb", max);
					zc4 = cc.getIndexvalue();
					outs.append("<td>" + zc4 + "</td>");
					break;
				} else if (db < min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"dzsb", min);
					zc4 = cc.getIndexvalue();
					outs.append("<td>" + zc4 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() <= db
						&& tcc.get(i).getCeil() > db) {
					zc4 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc4 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");
		outs.append("<tr>");
		outs.append("<td >住房情况</td>");
		outs.append("<td>" + hous + "</td>");
		max = getTblCfgCalculateindexMax("zf");
		min = getTblCfgCalculateindexMin("zf");
		for (int i = 0; i < tcc.size(); i++) {
			if (tcc.get(i).getName().equals("zf")) {
				if (housSituation == max) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
							"zf", max);
					zc9 = cc.getIndexvalue();
					outs.append("<td>" + zc9 + "</td>");
					break;
				} else if (housSituation == min) {
					TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
							"zf", min);
					zc9 = cc.getIndexvalue();
					outs.append("<td>" + zc9 + "</td>");
					break;
				} else if (tcc.get(i).getFloor() == housSituation
						&& tcc.get(i).getCeil() == housSituation) {
					zc9 = tcc.get(i).getIndexvalue();
					outs.append("<td>" + zc9 + "</td>");
					break;
				}
			}
		}
		outs.append("</tr>");

		double sum = zc + zc1 + zc2 + zc3 + zc4 + zc5 + zc6 + zc7 + zc8 + zc9;
		String msg = "";

		if (60 > sum) {
			msg = "普通客户";
		} else if (60 <= sum && 70 > sum) {
			msg = "一星客户";
		} else if (70 <= sum && 80 > sum) {
			msg = "二星客户";
		} else if (80 <= sum) {
			msg = "三星客户";
		}

		outs.append("<tr>");
		outs.append("<td >客户等级</td>");
		outs.append("<td>" + msg + "</td>");
		outs.append("<td>" + sum + "</td>");
		outs.append("</tr>");
		outs.append("</table>");

		return outs;
	}

	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public StringBuffer companyCreditGrade(String wwid) throws Exception {
		String wid = wwid.substring(wwid.lastIndexOf("w"));

		Map<String, String> m = new HashMap<String, String>();
		m.put("1", "极差");
		m.put("2", "较差");
		m.put("3", "一般");
		m.put("4", "良好");
		m.put("5", "优秀");

		List<TblCfgCalculateindex> tcc = calculateindexDao.list();
		if (tcc == null || tcc.size() == 0) {
			errorMsg = "获取计算类指标信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		List<TblFinanceest> ltf = financeestDao.findByProperty("wid", wid);
		if (tcc == null || tcc.size() == 0) {
			errorMsg = "获取财务评估信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		List<TblCfgAnalysisindex> ltca = analysisindexDao.list();
		if (tcc == null || tcc.size() == 0) {
			errorMsg = "获取分析类指标信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		List<TblRiskest> ltr = riskestDao.findByProperty("wid", wid);
		if (tcc == null || tcc.size() == 0) {
			errorMsg = "获取风险评估信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		StringBuffer outs = new StringBuffer();

		double max = 0;
		double min = 0;

		double jk = 0;
		double cy = 0;
		double fz = 0;
		double zy = 0;
		double js = 0;
		double xy = 0;
		double zc = 0;
		double jzc = 0;
		double ld = 0;
		double xs = 0;
		double zzc = 0;
		double jxs = 0;
		double zcs = 0;
		double xsz = 0;
		double hzj = 0;
		int len = 0;

		outs.append("<table id='d' width='100%'>");

		if (null != tcc && 0 < tcc.size()) {
			len = ltf.size() - 1;
			outs.append("<table width='100%' class='money'>");
			outs.append("<tr>");
			outs.append("<td rowspan='2'>财务结构</td>");
			outs.append("<td>资产负债率</td>");
			double ga = ltf.get(len).getAsset();
			if (ga == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getDebt() / ga) < 1) {
					mon = (ltf.get(len).getDebt() / ga);
				}
				outs.append("<td>"
						+ String.format("%.2f",
								mon * 100) + "%</td>");
			}
			max = getTblCfgCalculateindexMax("zcfzl");
			min = getTblCfgCalculateindexMin("zcfzl");
			double zcfzl = max;

			if (ga != 0) {
				zcfzl = ltf.get(len).getDebt() / ga;
			}
			for (int i = 0; i < tcc.size(); i++) {
				if (tcc.get(i).getName().equals("zcfzl")) {
					if (zcfzl >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"zcfzl", max);
						zc = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + zc + "</td>");
						break;
					} else if (zcfzl < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"zcfzl", min);
						zc = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + zc + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= zcfzl
							&& tcc.get(i).getCeil() > zcfzl) {
						zc = tcc.get(i).getIndexvalue() * tcc.get(i).getRatio();
						outs.append("<td>" + zc + "</td>");
						break;
					}
				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td>净资产与年末贷款余额比率</td>");
			double glr = ltf.get(len).getLoanRemaining();
			if (glr == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getNetAsset() / glr) < 1) {
					mon = (ltf.get(len).getNetAsset() / glr);
				}
				outs.append("<td>"
						+ String.format("%.2f",
								mon * 100)
						+ "%</td>");
			}
			max = getTblCfgCalculateindexMax("jdb");
			min = getTblCfgCalculateindexMin("jdb");
			for (int i = 0; i < tcc.size(); i++) {
				double jzcynmdk = max;

				if (glr != 0) {
					jzcynmdk = (ltf.get(len).getNetAsset() / glr);
				}

				if (tcc.get(i).getName().equals("jdb")) {
					if (jzcynmdk >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"jdb", max);
						jzc = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + jzc + "</td>");
						break;
					} else if (jzcynmdk < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"jdb", min);
						jzc = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + jzc + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= jzcynmdk
							&& tcc.get(i).getCeil() > jzcynmdk) {
						jzc = tcc.get(i).getIndexvalue()
								* tcc.get(i).getRatio();
						outs.append("<td>" + jzc + "</td>");
						break;
					}

				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td rowspan='2'>偿债能力</td>");
			outs.append("<td>流动比率</td>");
			double gfd = ltf.get(len).getFlowDebt();
			if (gfd == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getFlowAsset() / gfd) < 1) {
					mon = (ltf.get(len).getFlowAsset() / gfd);
				}
				outs.append("<td>"
						+ String.format("%.2f",
								mon * 100)
						+ "%</td>");
			}

			for (int i = 0; i < tcc.size(); i++) {
				max = getTblCfgCalculateindexMax("ldbl");
				min = getTblCfgCalculateindexMin("ldbl");

				double ldbl = max;

				if (gfd != 0) {
					ldbl = (ltf.get(len).getFlowAsset() / gfd);
				}

				if (tcc.get(i).getName().equals("ldbl")) {
					if (ldbl >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"ldbl", max);
						ld = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + ld + "</td>");
						break;
					} else if (ldbl < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"ldbl", min);
						ld = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + ld + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= ldbl
							&& tcc.get(i).getCeil() > ldbl) {
						ld = tcc.get(i).getIndexvalue() * tcc.get(i).getRatio();
						outs.append("<td>" + ld + "</td>");
						break;
					}

				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td>销售现金流对债务覆盖比</td>");
			double gdd = ltf.get(len).getDueDebt();
			if (gdd == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getSaleCash() / gdd) < 1) {
					mon = (ltf.get(len).getSaleCash() / gdd);
				}
				outs.append("<td>"
						+ String.format("%.2f",
								mon * 100)
						+ "%</td>");
			}

			for (int i = 0; i < tcc.size(); i++) {
				max = getTblCfgCalculateindexMax("xzb");
				min = getTblCfgCalculateindexMin("xzb");

				double xsxjld = max;

				if (gdd != 0) {
					xsxjld = (ltf.get(len).getSaleCash() / gdd);
				}

				if (tcc.get(i).getName().equals("xzb")) {
					if (xsxjld >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"xzb", max);
						xs = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + xs + "</td>");
						break;
					} else if (xsxjld < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"xzb", min);
						xs = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + xs + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= xsxjld
							&& tcc.get(i).getCeil() > xsxjld) {
						xs = tcc.get(i).getIndexvalue() * tcc.get(i).getRatio();
						outs.append("<td>" + xs + "</td>");
						break;
					}
				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td>运营效率</td>");
			outs.append("<td>总资产周转比率</td>");
			double gma = ltf.get(len).getMeanAsset();
			if (gma == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getThisYearSale() / gma) < 1) {
					mon = (ltf.get(len).getThisYearSale() / gma);
				}
				outs.append("<td>"
						+ String.format("%.2f",
								mon * 100)
						+ "%</td>");
			}

			for (int i = 0; i < tcc.size(); i++) {
				max = getTblCfgCalculateindexMax("zzbl");
				min = getTblCfgCalculateindexMin("zzbl");

				double zzczz = max;

				if (gma != 0) {
					zzczz = (ltf.get(len).getThisYearSale() / gma);
				}

				if (tcc.get(i).getName().equals("zzbl")) {
					if (zzczz >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"zzbl", max);
						zzc = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + zzc + "</td>");
						break;
					} else if (zzczz < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"zzbl", min);
						zzc = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + zzc + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= zzczz
							&& tcc.get(i).getCeil() > zzczz) {
						zzc = tcc.get(i).getIndexvalue()
								* tcc.get(i).getRatio();
						outs.append("<td>" + zzc + "</td>");
						break;
					}

				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td rowspan='3'>盈利能力</td>");
			outs.append("<td>销售净利润率</td>");
			double gtys = ltf.get(len).getThisYearSale();
			if (gtys == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getNetProfit() / gtys) < 1) {
					mon = (ltf.get(len).getNetProfit() / gtys);
				}
				outs.append("<td>"
						+ String.format("%.2f", mon * 100)
						+ "%</td>");
			}

			for (int i = 0; i < tcc.size(); i++) {
				max = getTblCfgCalculateindexMax("jlrl");
				min = getTblCfgCalculateindexMin("jlrl");

				double xsjlr = max;

				if (gtys != 0) {
					xsjlr = (ltf.get(len).getNetProfit() / gtys);
				}

				if (tcc.get(i).getName().equals("jlrl")) {
					if (xsjlr >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"jlrl", max);
						jxs = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + jxs + "</td>");
						break;
					} else if (xsjlr < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"jlrl", min);
						jxs = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + jxs + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= xsjlr
							&& tcc.get(i).getCeil() > xsjlr) {
						jxs = tcc.get(i).getIndexvalue()
								* tcc.get(i).getRatio();
						outs.append("<td>" + jxs + "</td>");
						break;
					}

				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td>总资产收益率</td>");
			double ma = ltf.get(len).getMeanAsset();
			if (ma == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getNetProfit() / ma) < 1) {
					mon = ltf.get(len).getNetProfit() / ma;
				}
				outs.append("<td>"
						+ String.format("%.2f", mon * 100)
						+ "%</td>");
			}

			for (int i = 0; i < tcc.size(); i++) {
				max = getTblCfgCalculateindexMax("syl");
				min = getTblCfgCalculateindexMin("syl");

				double zzjsyl = max;

				if (ma != 0) {
					zzjsyl = (ltf.get(len).getNetProfit() / ma);
				}

				if (tcc.get(i).getName().equals("syl")) {
					if (zzjsyl >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"syl", max);
						zcs = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + zcs + "</td>");
						break;
					} else if (zzjsyl < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"syl", min);
						zcs = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + zcs + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= zzjsyl
							&& tcc.get(i).getCeil() > zzjsyl) {
						zcs = tcc.get(i).getIndexvalue()
								* tcc.get(i).getRatio();
						outs.append("<td>" + zcs + "</td>");
						break;
					}
				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td>销售增长比率</td>");
			double glys = ltf.get(len).getLastYearSale();
			if (glys == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if (((ltf.get(len).getThisYearSale() - ltf.get(len).getLastYearSale()) / glys) < 1) {
					mon = (ltf.get(len).getThisYearSale() - ltf.get(len).getLastYearSale()) / glys;
				}
				outs.append("<td>"
						+ String.format("%.2f", (mon * 100)) + "%</td>");
			}
			for (int i = 0; i < tcc.size(); i++) {
				double xszzbl = 0;

				if (glys != 0) {
					xszzbl = ((ltf.get(len).getThisYearSale() - ltf.get(len)
							.getLastYearSale()) / glys);
				} else {
					xszzbl = (ltf.get(len).getThisYearSale() - 0);
				}

				max = getTblCfgCalculateindexMax("xszzbl");
				min = getTblCfgCalculateindexMin("xszzbl");
				if (tcc.get(i).getName().equals("xszzbl")) {
					if (xszzbl >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"xszzbl", max);
						xsz = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + xsz + "</td>");
						break;
					} else if (xszzbl < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"xszzbl", min);
						xsz = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + xsz + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= xszzbl
							&& tcc.get(i).getCeil() > xszzbl) {
						xsz = tcc.get(i).getIndexvalue()
								* tcc.get(i).getRatio();
						outs.append("<td>" + xsz + "</td>");
						break;
					}

				}
			}
			outs.append("</tr>");

			outs.append("<tr>");
			outs.append("<td rowspan='2'>融资可行性</td>");
			outs.append("<td>还款资金来源及可靠性</td>");
			double gl = ltf.get(len).getLoan();
			if (gl == 0) {
				outs.append("<td>100.00%</td>");
			} else {
				double mon = 1;
				if ((ltf.get(len).getDueCash() / gl) < 1) {
					mon = ltf.get(len).getDueCash() / gl;
				}
				outs.append("<td>"
						+ String.format("%.2f",
								mon * 100)
						+ "%</td>");
			}

			for (int i = 0; i < tcc.size(); i++) {
				max = getTblCfgCalculateindexMax("hkkkx");
				min = getTblCfgCalculateindexMin("hkkkx");

				double rzkxx = max;

				if (gl != 0) {
					rzkxx = (ltf.get(len).getDueCash() / gl);
				}

				if (tcc.get(i).getName().equals("hkkkx")) {
					if (rzkxx >= max) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMaxRatio(
								"hkkkx", max);
						hzj = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + hzj + "</td>");
						break;
					} else if (rzkxx < min) {
						TblCfgCalculateindex cc = getTblCfgCalculateindexMinRatio(
								"hkkkx", min);
						hzj = cc.getIndexvalue() * cc.getRatio();
						outs.append("<td>" + hzj + "</td>");
						break;
					} else if (tcc.get(i).getFloor() <= rzkxx
							&& tcc.get(i).getCeil() > rzkxx) {
						hzj = tcc.get(i).getIndexvalue()
								* tcc.get(i).getRatio();
						outs.append("<td>" + hzj + "</td>");
						break;
					}

				}
			}
			outs.append("</tr>");
		}

		if (ltca != null && ltr != null) {
			if (ltca.size() != 0 && ltr.size() != 0) {
				len = ltr.size() - 1;
				for (int i = 0; i < ltca.size(); i++) {
					if (ltca.get(i).getCname().equals("借款资金用途")) {
						jk = Math.floor((ltr.get(len).getPurpose() * ltca
								.get(i).getRatio()));
						outs.append("<tr>");
						outs.append("<td>借款资金用途</td>");
						outs.append("<td>"
								+ m.get(String.valueOf(ltr.get(len)
										.getPurpose())));
						outs.append("</td>");
						outs.append("<td>" + jk);
						outs.append("</td>");
						outs.append("</tr>");
					}
					if (ltca.get(i).getCname().equals("从业经验")) {
						cy = Math.floor(ltr.get(len).getExperience()
								* ltca.get(i).getRatio());
						outs.append("<tr>");
						outs.append("<td rowspan='4'>经营能力</td>");
						outs.append("<td>从业经验</td>");
						outs.append("<td>"
								+ m.get(String.valueOf(ltr.get(len)
										.getExperience())));
						outs.append("</td>");
						outs.append("<td>" + cy);
						outs.append("</td>");
						outs.append("</tr>");
					}
					if (ltca.get(i).getCname().equals("发展前景")) {
						fz = Math.floor(ltr.get(len).getProspect()
								* ltca.get(i).getRatio());
						outs.append("<tr>");
						outs.append("<td>发展前景</td>");
						outs.append("<td>"
								+ m.get(String.valueOf(ltr.get(len)
										.getProspect())));
						outs.append("</td>");
						outs.append("<td>" + fz);
						outs.append("</td>");
						outs.append("</tr>");
					}
					if (ltca.get(i).getCname().equals("资源控制")) {
						zy = Math.floor(ltr.get(len).getResource()
								* ltca.get(i).getRatio());
						outs.append("<tr>");
						outs.append("<td>资源控制</td>");
						outs.append("<td>"
								+ m.get(String.valueOf(ltr.get(len)
										.getResource())));
						outs.append("</td>");
						outs.append("<td>" + zy);
						outs.append("</td>");
						outs.append("</tr>");
					}
					if (ltca.get(i).getCname().equals("技术")) {
						js = Math.floor(ltr.get(len).getSkill()
								* ltca.get(i).getRatio());
						outs.append("<tr>");
						outs.append("<td>技术</td>");
						outs.append("<td>"
								+ m.get(String.valueOf(ltr.get(len).getSkill())));
						outs.append("</td>");
						outs.append("<td>" + js);
						outs.append("</td>");
						outs.append("</tr>");
					}
					if (ltca.get(i).getCname().equals("信用记录")) {
						xy = Math.floor(ltr.get(len).getCredits()
								* ltca.get(i).getRatio());
						outs.append("<tr>");
						outs.append("<td>信用记录</td>");
						outs.append("<td>&nbsp;</td>");
						outs.append("<td>"
								+ m.get(String.valueOf(ltr.get(len)
										.getCredits())));
						outs.append("</td>");
						outs.append("<td>" + xy);
						outs.append("</td>");
						outs.append("</tr>");
					}
				}
			}
		}

		double maxNum = xy + jk + cy + fz + zy + js + zc + jzc + ld + xs + zzc
				+ jxs + zcs + xsz + hzj;
		String msg = "";
		if (75 > maxNum) {
			msg = "B";
		} else if (75 <= maxNum && 85 > maxNum) {
			msg = "A";
		} else if (85 <= maxNum && 95 > maxNum) {
			msg = "AA";
		} else if (95 <= maxNum) {
			msg = "AAA";
		}

		outs.append("<tr>");
		outs.append("<td colspan='2'>客户资信综合得分</td>");
		outs.append("<td>&nbsp;</td>");
		outs.append("<td>" + maxNum);
		outs.append("</td>");
		outs.append("</tr>");

		outs.append("<tr>");
		outs.append("<td colspan='2'>客户信用等级</td>");
		outs.append("<td>&nbsp;</td>");
		outs.append("<td>" + msg);
		outs.append("</td>");
		outs.append("</tr>");
		outs.append("</table>");

		return outs;
	}

	@Override
	@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public String projectDecision(String taskid, String sel, String selValue,
			String wwid, String decisionList, String explain, double money,
			double deposit, double assure, double commission, double evaluate,
			String cause, double rate, double refundMoney) throws Exception {
		String result = "";
		String history = "";
		String wid = wwid.substring(wwid.lastIndexOf("w"));
		String str = tools.getLoginUser();

		TblWarrantinfo TblWarrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
		if (TblWarrantinfo == null) {
			errorMsg = "获取担保项目信息失败";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		try {
			if (sel.equals("nextLater")) {
				switch (decisionList) {
				case "0":
					chargeService.setTblCharge(deposit, wid, str, ChargeType.GETBAIL);
					chargeService.setTblCharge(assure, wid, str, ChargeType.GETWARRANT);
					chargeService.setTblCharge(commission, wid, str, ChargeType.GETAGENT);
					chargeService.setTblCharge(evaluate, wid, str, ChargeType.GETEVALUATE);

					result = "pass";
					history = "提交到下一步（通知银行）处理";
					break;
				case "1":
					if (cause.equals("")) {
						errorMsg = "选择项目终止时，需要输入终止原因";
						log.error(errorMsg);
						throw new WarrantException(errorMsg);
					} else {
						result = "stop";
						history = "项目终止";
					}
					break;
				case "2":
					chargeService.setTblCharge(refundMoney, wid, str, ChargeType.REFUND);
					if (cause.equals("")) {
						errorMsg = "选择项目终止时，需要输入终止原因";
						log.error(errorMsg);
						throw new WarrantException(errorMsg);
					} else {
						result = "refund";
						history = "项目终止，退评审费";
					}
					break;
				case "3":
					result = "anew";
					history = "项目返回（资料收集）重新处理";
					break;
				default:
					return "error";
				}
			} else {
				errorMsg = "选择项项目处理方式错误";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}

			Date nowDate = null;
			String strNow = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				strNow = sdf.format(new Date());
				nowDate = sdf.parse(strNow);
			} catch (Exception e) {
				errorMsg = "变换日期格式时出现错误";
				tools.throwException(e, log, errorMsg);
			}

			String bid = TblWarrantinfo.getBank();
			TblCfgBankinfo bank = bankinfoDao.findBankinfoByBidAndDate(bid,
					strNow);

			double quota = 0;
			double anewremaining = 0;
			double remaining = 0;
			double refundremaining = 0;
			
			switch (result) {
			case "pass":
				setDecision(wid, decisionList.charAt(0),
						tools.multiLine(explain));
				BigDecimal bd = new BigDecimal(rate);
				TblWarrantinfo.setRate(bd);
				TblWarrantinfo.setMoney(money);
				TblWarrantinfo.setState('1');
				warrantinfoDao.update(TblWarrantinfo);

				if (bank != null) {
					anewremaining = bank.getRemaining();
					remaining = anewremaining
							+ (TblWarrantinfo.getPracticalMoney() - money);
					bank.setRemaining(remaining);
					bankinfoDao.update(bank);
				}
				break;
			case "refund":
			case "stop":
				setDecision(wid, decisionList.charAt(0),
						tools.multiLine(explain));

				TblWarrantinfo.setEndDate(nowDate);
				TblWarrantinfo.setCause(cause);
				TblWarrantinfo.setState('1');
				warrantinfoDao.update(TblWarrantinfo);

				if (bank != null) {
					quota = bank.getQuota();
					anewremaining = bank.getRemaining();
					refundremaining = anewremaining
							+ (TblWarrantinfo.getPracticalMoney());
					if (refundremaining >= quota) {
						refundremaining = quota;
					}
					bank.setRemaining(refundremaining);
					bankinfoDao.update(bank);
				}
				break;
			case "anew":
				setDecision(wid, decisionList.charAt(0),
						tools.multiLine(explain));
				break;
			default:
				break;
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", result);
			
			taskBaseService.setTaskVar(taskid, "history", history);
			if (!result.equals("stop")) {
				map.put("user", selValue);
			}
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "项目决策处理失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}

	private void setDecision(String wid, char result, String explain) throws Exception {
		try {
			Date da = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			d = sdf.parse(sdf.format(da));

			TblDecision tblDecision = new TblDecision();
			tblDecision.setWid(wid);
			tblDecision.setExplains(explain);
			tblDecision.setDate(d);
			tblDecision.setResult(result);

			decisionDao.save(tblDecision);
		} catch (Exception e) {
			errorMsg = "保存项目决策信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	private double getTblCfgCalculateindexMin(String s) {
		double temp = 0;
		List<TblCfgCalculateindex> cil = null;

		cil = calculateindexDao.findByProperty("name", s);
		if (cil == null || cil.size() == 0) {
			errorMsg = "获取计算类指标系数最小值失败" + cil;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		temp = cil.get(0).getFloor();
		for (int i = 1; i < cil.size(); i++) {
			if (temp > cil.get(i).getFloor()) {
				temp = cil.get(i).getFloor();
			}
		}
		return temp;
	}

	private double getTblCfgCalculateindexMax(String s) {
		List<TblCfgCalculateindex> cil = null;
		double temp = 0;

		cil = calculateindexDao.findByProperty("name", s);
		if (cil == null || cil.size() == 0) {
			errorMsg = "获取计算类指标系数最大值失败" + cil;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		temp = cil.get(0).getCeil();
		for (int i = 1; i < cil.size(); i++) {
			if (temp < cil.get(i).getCeil()) {
				temp = cil.get(i).getCeil();
			}
		}
		return temp;
	}

	private TblCfgCalculateindex getTblCfgCalculateindexMinRatio(String s,
			double f) {
		TblCfgCalculateindex tcc = null;
		List<TblCfgCalculateindex> cil = null;

		cil = calculateindexDao.findByProperty("name", s);
		if (cil == null || cil.size() == 0) {
			errorMsg = "获取计算类指标最小系数失败" + cil;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		for (int i = 0; i < cil.size(); i++) {
			if (f == cil.get(i).getFloor()) {
				tcc = cil.get(i);
				break;
			}
		}
		return tcc;
	}

	private TblCfgCalculateindex getTblCfgCalculateindexMaxRatio(String s,
			double c) {
		TblCfgCalculateindex tcc = null;
		List<TblCfgCalculateindex> cil = null;

		cil = calculateindexDao.findByProperty("name", s);
		if (cil == null || cil.size() == 0) {
			errorMsg = "获取计算类指标最大系数失败" + cil;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}

		for (int i = 0; i < cil.size(); i++) {
			if (c == cil.get(i).getCeil()) {
				tcc = cil.get(i);
				break;
			}
		}

		return tcc;
	}
	
	@Override
	public List<TblDecision> getTblDecision(String wid) throws Exception {
		List<TblDecision> dl = null;
		dl = decisionDao.findByProperty("wid", wid);
		return dl;
	}

	public void setDecisionDao(DecisionDao decisionDao) {
		this.decisionDao = decisionDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public void setChargeService(ChargeService chargeService) {
		this.chargeService = chargeService;
	}

	public void setBankinfoDao(BankinfoDao bankinfoDao) {
		this.bankinfoDao = bankinfoDao;
	}

	public void setCalculateindexDao(CalculateindexDao calculateindexDao) {
		this.calculateindexDao = calculateindexDao;
	}

	public void setAnalysisindexDao(AnalysisindexDao analysisindexDao) {
		this.analysisindexDao = analysisindexDao;
	}

	public void setFinanceestDao(FinanceestDao financeestDao) {
		this.financeestDao = financeestDao;
	}

	public void setPersonalriskDao(PersonalriskDao personalriskDao) {
		this.personalriskDao = personalriskDao;
	}

	public void setRiskestDao(RiskestDao riskestDao) {
		this.riskestDao = riskestDao;
	}

}
