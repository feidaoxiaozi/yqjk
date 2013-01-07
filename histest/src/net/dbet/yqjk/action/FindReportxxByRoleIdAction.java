package net.dbet.yqjk.action;

import net.dbet.service.ReportService;
import net.dbet.yqjk.Yqjkxx;

import com.opensymphony.xwork2.ActionSupport;

public class FindReportxxByRoleIdAction extends ActionSupport {
   
	private Yqjkxx yqjkxx;
	
	private ReportService service;
	
	@Override
	public String execute() throws Exception {
		yqjkxx = this.service.findByRoleId(yqjkxx.getRoleId());
		return SUCCESS;
	}

	public Yqjkxx getYqjkxx() {
		return yqjkxx;
	}

	public ReportService getService() {
		return service;
	}

	public void setService(ReportService service) {
		this.service = service;
	}

	public void setYqjkxx(Yqjkxx yqjkxx) {
		this.yqjkxx = yqjkxx;
	}
}
