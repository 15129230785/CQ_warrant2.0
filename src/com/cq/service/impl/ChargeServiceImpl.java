package com.cq.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.dao.ChargeDao;
import com.cq.service.ChargeService;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCharge;
import com.cq.util.ChargeType;
import com.cq.util.WarrantException;
import com.cq.util.tools;

@Transactional (propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
public class ChargeServiceImpl implements ChargeService {
	static Logger log = Logger.getLogger(ChargeServiceImpl.class);
	private String errorMsg;
	
	private ChargeDao chargeDao;
	private TaskBaseService taskBaseService;
	
	@Override
	public String charge(String taskid, String result, String selValue) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("review", result);
			map.put("user", selValue);
			taskBaseService.setTaskVar(taskid, "history", "提交到下一步（财务收款）处理");
			taskBaseService.nextStep(taskid, map);
		} catch (Exception e) {
			errorMsg = "流程操作失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	
	//0-保证金
	//1-担保费
	//2-评审费
	//3-代办费
	//4-评估费
	//5-退评审费
	//6-退保证金
	@Override
	public void setTblCharge(double money, String wid, String user, ChargeType ttype) throws Exception {
		String temp = null;
		
		try {
			TblCharge charge = new TblCharge();
			switch (ttype) {
			case GETBAIL:
				temp = "保证金";
				break;
			case GETWARRANT:
				temp = "担保费";
				break;
			case GETREVIEW:
				temp = "评审费";
				break;
			case GETAGENT:
				temp = "代办费";
				break;
			case GETEVALUATE:
				temp = "评估费";
				break;
			case REFUND:
				temp = "退评审费";
				break;
			case RETURNBAIL:
				temp = "退保证金";
				break;
			default:
				errorMsg = "费用类型错误";
				log.error(errorMsg);
				throw new WarrantException(errorMsg); 
			}
			charge.setWid(wid);
			charge.setType(String.valueOf(ttype.ordinal()).charAt(0));
			charge.setMoney(money);
			chargeDao.save(charge);
		} catch (Exception e) {
			errorMsg = "保存项目“" + temp + "”费用数据失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	@Transactional (propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<Double> getCharge(String wid) throws Exception {
		List<Double> ld = new ArrayList<Double>();
		
		for (int i = 0; i < ChargeType.values().length; i++) {
			ld.add(0.0);
		}
		
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(TblCharge.class);
			dc.add(Restrictions.eq("wid", wid));
			dc.addOrder(Order.asc("type"));
			List<TblCharge> cl = chargeDao.findByCriterias(dc);
			if (cl != null && cl.size() > 0) {
				for (int i = 0; i < cl.size(); i++) {
					ld.set(Character.getNumericValue(cl.get(i).getType()), cl.get(i).getMoney());
				}
			} else {
				errorMsg = "没有查询到项目" + wid + "的收费信息";
				log.error(errorMsg);
			}
		} catch (Exception e) {
			errorMsg = "查询项目收费金额失败";
			tools.throwException(e, log, errorMsg);
		}
		return ld;
	}

	@Override
	public void updateChargeDate(String wid, ChargeType type) throws Exception {
		Date da = null;
		DateFormat df = null;
		Date tmpDate = null;
		
		try {
			TblCharge charge = this.findChargeInfo(wid, type);
			if (charge == null) {
				errorMsg = "查询项目收费信息失败";
				log.error(errorMsg);
				throw new WarrantException(errorMsg);
			}
			
			da = new Date();
			df = new SimpleDateFormat("yyyy-MM-dd");
			String temp = df.format(da);
			tmpDate = df.parse(temp);
			
			charge.setDate(tmpDate);
			chargeDao.update(charge);
		} catch (Exception e) {
			errorMsg = "修改项目收费日期失败";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	@Override
	public TblCharge findChargeInfo(String wid, ChargeType type) {
		TblCharge charge = null;
		
		DetachedCriteria dc = DetachedCriteria.forClass(TblCharge.class);
		dc.add(Restrictions.eq("wid", wid));
		dc.add(Restrictions.eq("type", String.valueOf(type.ordinal()).charAt(0)));
		
		List<TblCharge> cl = chargeDao.findByCriterias(dc);
		if (cl != null && cl.size() == 1) {
			charge = cl.get(0);
		} else {
			log.error("没有查询到项目" + wid + "的收费信息");
		}
		return charge;
	}

	public void setChargeDao(ChargeDao chargeDao) {
		this.chargeDao = chargeDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

}
