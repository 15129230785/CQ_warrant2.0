package com.cq.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.bean.Warrantinfo;
import com.cq.dao.BankinfoDao;
import com.cq.dao.WarrantindexDao;
import com.cq.dao.WarrantinfoDao;
import com.cq.service.TaskBaseService;
import com.cq.table.TblCfgBankinfo;
import com.cq.table.TblWarrantindex;
import com.cq.table.TblWarrantinfo;
import com.cq.util.ExportExcel;
import com.cq.util.tools;

@CQAnnotationOperlog(tableName = "担保基本信息", dataName = "wtf")
public class TblWarrantinfoAction {
	static Logger log = Logger.getLogger(TblWarrantinfoAction.class);
	private String errorMsg;

	private String taskid;
	private String wid;
	private String name;
	private Date startDate;
	private double money;
	private String bank;
	private String usages;
	private String description;
	private String paySource;
	private String payPlan;
	private Integer deadline;
	private TblWarrantinfo wtf;
	private String type;
	private String loanDateFilter;
	private String bankFilter;
	private InputStream excelStream;
	private String fileName;
	private String exportBatch;
	private String savePath;
	private File[] upload;
	private String[] uploadFileName;
	private List<TblWarrantindex> lt = new ArrayList<TblWarrantindex>();
	private static List<TblWarrantinfo> twi;
	@Resource
	WarrantinfoDao warrantinfoDao;
	@Resource
	TaskBaseService taskBaseService;
	@Resource
	WarrantindexDao warrantindexDao;
	@Resource
	BankinfoDao bankinfoDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void savaTblWarrantinfo() throws Exception {
		TblWarrantinfo tblWarrantinfo = null;

		try {
			tblWarrantinfo = warrantinfoDao.findWarrantinfoByWid(wid);
			if (tblWarrantinfo != null) {
				tblWarrantinfo.setName(name);
				tblWarrantinfo.setStartDate(startDate);
				tblWarrantinfo.setPracticalMoney(money);
				tblWarrantinfo.setBank(bank);
				tblWarrantinfo.setDeadline(deadline);
				tblWarrantinfo.setUsages(tools.multiLine(usages.trim()));
				tblWarrantinfo.setDescription(tools.multiLine(description
						.trim()));
				tblWarrantinfo.setPaySource(tools.multiLine(paySource.trim()));
				tblWarrantinfo.setPayPlan(tools.multiLine(payPlan.trim()));

				warrantinfoDao.update(tblWarrantinfo);
			} else {
				tblWarrantinfo = new TblWarrantinfo();
				tblWarrantinfo.setWid(wid.trim());
				tblWarrantinfo.setName(name.trim());
				tblWarrantinfo.setStartDate(startDate);
				tblWarrantinfo.setPracticalMoney(money);
				tblWarrantinfo.setBank(bank.trim());
				tblWarrantinfo.setDeadline(deadline);
				tblWarrantinfo.setUsages(tools.multiLine(usages.trim()));
				tblWarrantinfo.setDescription(tools.multiLine(description
						.trim()));
				tblWarrantinfo.setPaySource(tools.multiLine(paySource.trim()));
				tblWarrantinfo.setPayPlan(tools.multiLine(payPlan.trim()));

				warrantinfoDao.save(tblWarrantinfo);
			}
			wtf = tblWarrantinfo;
			taskBaseService.setTaskVar(taskid, "qyname", name);
		} catch (Exception e) {
			errorMsg = "添加担保申请信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void updateTblWarrantinfo() throws Exception {
		TblWarrantinfo wi = null;

		try {
			wi = warrantinfoDao.findWarrantinfoByWid(wid);
			wi.setName(name);
			wi.setStartDate(startDate);
			wi.setPracticalMoney(money);
			wi.setBank(bank);
			wi.setDeadline(deadline);
			wi.setUsages(tools.multiLine(usages.trim()));
			wi.setDescription(tools.multiLine(description.trim()));
			wi.setPaySource(tools.multiLine(paySource.trim()));
			wi.setPayPlan(tools.multiLine(payPlan.trim()));

			taskBaseService.setTaskVar(taskid, "qyname", name);

			warrantinfoDao.update(wi);
			wtf = wi;
		} catch (Exception e) {
			errorMsg = "修改担保申请信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void selectTblWarrantinfoYz() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = null;

		String str = "sf";

		try {
			name = new String(request.getParameter("name")
					.getBytes("iso8859-1"), "utf-8");

			List<TblWarrantinfo> listTblWarrantinfo = warrantinfoDao
					.findByProperty("name", name);
			if (listTblWarrantinfo == null || listTblWarrantinfo.size() == 0) {
				str = "sd";
			}
			tools.outputInfo(str);
		} catch (Exception e) {
			errorMsg = "查询企业担保申请信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void getTblWarrantinfo() throws Exception {
		wtf = null;

		try {
			wtf = warrantinfoDao.findWarrantinfoByWid(wid);
			if (wtf == null) {
				tools.outputInfo(JSONObject.fromObject(null));
			} else {
				tools.outputInfo(JSONObject.fromObject(wtf,
						tools.getJsonConfig()));
			}
		} catch (Exception e) {
			errorMsg = "验证信息失败";
			tools.throwException(e, log, errorMsg);
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void getTblWarrantinfoList() throws Exception {
		TblWarrantinfo wi = null;
		List<TblWarrantindex> lt = null;

		try {
			lt = warrantindexDao.findByProperty("type", type);
			if ((lt == null) || (lt.size() <= 0)) {
				tools.outputInfo("");
				log.warn("获取企业项目列表信息失败" + lt);
				return;
			}
			twi = new ArrayList<TblWarrantinfo>();
			for (int j = 0; j < lt.size(); j++) {
				wi = warrantinfoDao.findWarrantinfoByWid(lt.get(j).getWid());
				Character wistate = wi.getState();
				if (wistate != null && wistate == '1') {
					twi.add(wi);
				} else {
					continue;
				}
			}
			tools.outputInfo(JSONArray.fromObject(twi, tools.getJsonConfig()));
		} catch (Exception e) {
			errorMsg = "获取企业项目信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	// Begin: Add searching history project by bank or date, by Luke Chen on 2015/04/14
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void getTblWarrantinfoListWithConditions() throws Exception {

		try {
			lt = warrantindexDao.findByProperty("type", type);

			if ((lt == null) || (lt.size() <= 0)) {
				tools.outputInfo("");
				log.warn("获取项目列表信息失败" + lt);
				return;
			}

			twi = new ArrayList<TblWarrantinfo>();

			for (int j = 0; j < lt.size(); j++) {
				DetachedCriteria dc = DetachedCriteria.forClass(TblWarrantinfo.class);
				dc.add(Restrictions.eq("wid", lt.get(j).getWid()));

				if (StringUtils.isNotBlank(bankFilter)) {
					dc.add(Restrictions.like("bank", bankFilter, MatchMode.ANYWHERE));
				}

				if (StringUtils.isNotBlank(loanDateFilter)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date d = sdf.parse(loanDateFilter);
					dc.add(Restrictions.eq("warrantLoanDate", d));
				}

				List<TblWarrantinfo> list = new ArrayList<TblWarrantinfo>();
				list = warrantinfoDao.findByCriterias(dc);

				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Character wistate = list.get(i).getState();
						if (wistate != null && wistate == '1') {
							twi.add(list.get(i));
						} else {
							continue;
						}
					}
				}
			}

			tools.outputInfo(JSONArray.fromObject(twi, tools.getJsonConfig()));
		} catch (Exception e) {
			errorMsg = "获取企业项目信息时发生异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	// End: Add searching history project by bank or date, by Luke Chen on 2015/04/14

	// Begin: Add exporting history projects' excel, by Luke Chen on 2015/04/24
	// 导出个人台账
	public String download() throws Exception {
		return "success";
	}

	private void workbookInputStream(HSSFWorkbook workbook) throws Exception {
		try {
			this.setFileName(URLEncoder.encode("业务台账", "UTF-8"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			baos.flush();
			byte[] aa = baos.toByteArray();
			this.excelStream = new ByteArrayInputStream(aa, 0, aa.length);
			baos.close();
		} catch (Exception e) {
			errorMsg = "生成excel表格时，转换出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}

	public InputStream getExcelStream() throws Exception {
		try {
			String[] headers = { "序号", "名称", "贷款行", "担保金额（万元）", "担保期限", "放款日期", "合计" };
			List<Warrantinfo> dataset = new ArrayList<Warrantinfo>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			
			if (twi != null && twi.size() > 0) {
				for (int i = 0; i < twi.size(); i++) {
					Warrantinfo wa = new Warrantinfo();
					wa.setKid(i + 1);// 序号

					if (twi.get(i).getName() != null) {
						wa.setName(twi.get(i).getName());// 项目名称
					} else {
						wa.setName("");
					}

					if (twi.get(i).getBank() != null) {
						wa.setBank(getBankNameById(twi.get(i).getBank())); // 贷款行
					} else {
						wa.setBank("");
					}

					wa.setMoney(Double.toString(twi.get(i).getMoney())); // 担保金额

					if (twi.get(i).getWarrantStartDate() != null && twi.get(i).getWarrantStartDate() != null) {
						String start = sdf.format(twi.get(i).getWarrantStartDate());
						String end = sdf.format(twi.get(i).getWarrantEndDate());
						wa.setDueTime(start + "-" + end);// 担保期限
					} else {
						wa.setDueTime("-");
					}

					if (twi.get(i).getWarrantLoanDate() != null) {
						wa.setLoanDate(sdf.format(twi.get(i).getWarrantLoanDate()));// 放款日期
					} else {
						wa.setLoanDate("");
					}

					dataset.add(wa);
				}
			}

			ExportExcel<Warrantinfo> ex = new ExportExcel<Warrantinfo>();
			HSSFWorkbook workbook = ex.exportExcel(headers, dataset);
			if (workbook != null) {
				this.workbookInputStream(workbook);
			}
		} catch (Exception e) {
			errorMsg = "打印业务台账表时出现异常";
			tools.throwException(e, log, errorMsg);
			System.out.println("生成excel表格时出现异常!");
		}
		return excelStream;
	}

	public String getBankNameById(String bid) throws Exception {
		TblCfgBankinfo tbl = bankinfoDao.findOnlyByProperty("bid", bid);
		if (tbl != null) {
			return tbl.getName();
		}
		return "";
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	/*
	 * public BigDecimal getRate() { return rate; } public void
	 * setRate(BigDecimal rate) { this.rate = rate; }
	 */
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getUsages() {
		return usages;
	}

	public void setUsages(String usages) {
		this.usages = usages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaySource() {
		return paySource;
	}

	public void setPaySource(String paySource) {
		this.paySource = paySource;
	}

	public String getPayPlan() {
		return payPlan;
	}

	public void setPayPlan(String payPlan) {
		this.payPlan = payPlan;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public void setWarrantinfoDao(WarrantinfoDao warrantinfoDao) {
		this.warrantinfoDao = warrantinfoDao;
	}

	public void setTaskBaseService(TaskBaseService taskBaseService) {
		this.taskBaseService = taskBaseService;
	}

	public TblWarrantinfo getWtf() {
		return wtf;
	}

	public void setWtf(TblWarrantinfo wtf) {
		this.wtf = wtf;
	}

	public void setWarrantindexDao(WarrantindexDao warrantindexDao) {
		this.warrantindexDao = warrantindexDao;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLoanDateFilter() {
		return loanDateFilter;
	}

	public void setLoanDateFilter(String loanDateFilter) {
		this.loanDateFilter = loanDateFilter;
	}

	public String getBankFilter() {
		return bankFilter;
	}

	public void setBankFilter(String bankFilter) {
		this.bankFilter = bankFilter;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExportBatch() {
		return exportBatch;
	}

	public void setExportBatch(String exportBatch) {
		this.exportBatch = exportBatch;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public String getSavePath(String bid) {
		return ServletActionContext.getServletContext().getRealPath(bid);
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setBankinfoDao(BankinfoDao bankinfoDao) {
		this.bankinfoDao = bankinfoDao;
	}

}
