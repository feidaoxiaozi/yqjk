package net.dbet.yqjk.action;

import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

import net.dbet.service.ReportService;

public class GenerateReportExcelAction extends ActionSupport{
	
	private ReportService service;

	public ReportService getService() {
		return service;
	}

	public void setService(ReportService service) {
		this.service = service;
	}
	
	public InputStream getDownLoadFile(){
		return this.service.getInputStream();
	} 
  @Override
public String execute() throws Exception {
	
	  return SUCCESS;
}
}
