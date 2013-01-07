package net.dbet.yqjk.action;

import java.util.Map;

import net.dbet.service.ReportService;
import net.dbet.yqjk.Report;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListReportAction extends ActionSupport {
	
	private Report report;
	
    private ReportService service;

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public ReportService getService() {
		return service;
	}

	public void setService(ReportService service) {
		this.service = service;
	}
	@Override
	@SuppressWarnings("unchecked")	
	public String execute() throws Exception {
		
    Map request = (Map) ActionContext.getContext().get("request");
						
		request.put("list", service.findAllReportxx());
        
		return SUCCESS;
	}
}
