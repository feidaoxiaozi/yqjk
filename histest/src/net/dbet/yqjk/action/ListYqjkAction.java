package net.dbet.yqjk.action;

import java.util.Map;
import net.dbet.service.YqjkService;
import net.dbet.yqjk.Yqjkxx;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListYqjkAction extends ActionSupport {
    
	private Yqjkxx yqjkxx;
	private YqjkService service;
    private String[] newsResource;
	
	public String[] getNewsResource() {
		return newsResource;
	}

	public void setNewsResource(String[] newsResource) {
		this.newsResource = newsResource;
	}

	public YqjkService getService() {
		return service;
	}

	public void setService(YqjkService service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");		
		request.put("list", service.findAllYqjkxx());
		
		
		return SUCCESS;
	}

	public Yqjkxx getYqjkxx() {
		return yqjkxx;
	}

	public void setYqjkxx(Yqjkxx yqjkxx) {
		this.yqjkxx = yqjkxx;
	}
	
}
