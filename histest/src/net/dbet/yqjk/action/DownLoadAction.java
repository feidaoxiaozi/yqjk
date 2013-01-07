package net.dbet.yqjk.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {
	public InputStream getDownLoadFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				"listreport.jsp");
	}

	public String execute() throws Exception {

		return SUCCESS;
	}
}
