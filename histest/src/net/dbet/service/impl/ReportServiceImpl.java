package net.dbet.service.impl;

import java.util.List;
import net.dbet.service.ReportService;
import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;
import net.dbet.yqjkdao.ReportDao;

public class ReportServiceImpl implements ReportService {
	private ReportDao reportDao;

	public List<Report> findAllReportxx() {
		
		return this.reportDao.findAllReportxx();
	}

	public ReportDao getReportDao() {
		return reportDao;
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	public void insertReport(Report report) {
		this.reportDao.insertReport(report);
		
	}
	public Yqjkxx findByRoleId(int roleId) {		
		return this.findByRoleId(roleId);
	}
}