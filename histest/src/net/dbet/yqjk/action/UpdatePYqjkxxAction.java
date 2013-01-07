package net.dbet.yqjk.action;

import net.dbet.service.YqjkService;
import net.dbet.yqjk.Yqjkxx;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePYqjkxxAction extends ActionSupport {
   
	private Yqjkxx yqjkxx;
	
	private YqjkService service;

	public YqjkService getService() {
		return service;
	}

	public void setService(YqjkService service) {
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception {
		yqjkxx = this.service.findById(yqjkxx.getRoleId());
		return SUCCESS;
	}

	public Yqjkxx getYqjkxx() {
		return yqjkxx;
	}

	public void setYqjkxx(Yqjkxx yqjkxx) {
		this.yqjkxx = yqjkxx;
	}
}
