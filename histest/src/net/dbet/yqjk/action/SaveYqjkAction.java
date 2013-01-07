package net.dbet.yqjk.action;

import net.dbet.service.YqjkService;
import net.dbet.yqjk.Yqjkxx;
import com.opensymphony.xwork2.ActionSupport;

public class SaveYqjkAction extends ActionSupport {

	private Yqjkxx yqjkxx;

	private YqjkService service;

	public YqjkService getService() {
		return service;
	}

	public void setService(YqjkService service) {
		this.service = service;
	}

	public String execute() throws Exception {
        
		this.service.saveYqjk(yqjkxx);

		return SUCCESS;
	}

	public Yqjkxx getYqjkxx() {
		return yqjkxx;
	}

	public void setYqjkxx(Yqjkxx yqjkxx) {
		this.yqjkxx = yqjkxx;
	}

}
