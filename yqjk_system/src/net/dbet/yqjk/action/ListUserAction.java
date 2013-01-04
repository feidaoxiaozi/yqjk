package net.dbet.yqjk.action;

import java.util.Map;

import net.dbet.service.UserService;
import net.dbet.yqjk.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListUserAction extends ActionSupport{
	
	private User user;
	private UserService service;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	@Override
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("list", service.findAllUserxx());
		return SUCCESS;
	}

}
