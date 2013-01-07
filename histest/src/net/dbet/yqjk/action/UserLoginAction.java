package net.dbet.yqjk.action;

import net.dbet.service.UserService;
import net.dbet.yqjk.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{
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
	public String execute() throws Exception {
		
		if (service.verifyUser(user.getUsername(), user.getPassword())) {
			return SUCCESS;
		}
		return INPUT;
	}

}
