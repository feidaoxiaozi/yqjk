package net.dbet.yqjk.action;

import net.dbet.service.ReportService;
import net.dbet.yqjk.Report;

import com.opensymphony.xwork2.ActionSupport;

public class LoadReportAction extends ActionSupport{
	
	private Report report;
	private ReportService service;

	public ReportService getService() {
		return service;
	}

	public void setService(ReportService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		this.service.insertReport(report);
		
		return SUCCESS;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}
