package net.dbet.yqjk.action;

import java.util.ArrayList;
import java.util.List;

import net.dbet.service.UserService;
import net.dbet.yqjk.User;

import com.opensymphony.xwork2.ActionSupport;

public class SaveUserAction extends ActionSupport{
	private User user;
	private UserService service;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String execute() throws Exception {
		this.service.insertUserxx(user);
		return SUCCESS;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
//	public void validate() {
//		if (null == user.getUsername() || user.getUsername().length() < 6 || user.getUsername().length() > 10) {
//			List list = new ArrayList();
//			list.add(user.getUsername());
//			addActionError(getText("username.invalid",list)); 
//			this.addFieldError("username", "用户名输入不合法");
//		}
//		if (null == user.getPassword() || user.getPassword().length() < 6 || user.getPassword().length() > 10) {
//			this.addFieldError("password", "密码输入不合法"); 
//		}if (null == user.getRepassword() || user.getRepassword().length() < 6
//				|| user.getRepassword().length() > 10) {
//			this.addFieldError("repassword", "重复密码输入错误");
//		} else if (!user.getRepassword().equals(user.getPassword())) {
//			this.addFieldError("repassword", "两次输入必须一致");
//		}
//		if (user.getAge() > 100 || user.getAge() < 1) {
//			this.addFieldError("age", "年龄输入不合法");
//		}
//		if(("!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/").equals(user.getEmail())){
//			
//		}
//}
}