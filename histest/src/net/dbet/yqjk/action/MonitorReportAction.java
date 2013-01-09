package net.dbet.yqjk.action;

import javax.servlet.http.HttpServletResponse;
import net.dbet.excel.ExcelTest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MonitorReportAction extends ActionSupport{
		
	@Override
	public String execute() throws Exception {
		ExcelTest et = new ExcelTest();
		et.getNewsExcel();
		ActionContext.getContext().getActionInvocation().getProxy().setExecuteResult(false);

		// 取得 HttpServletResponse
		HttpServletResponse response = ServletActionContext.getResponse();
		response.encodeRedirectURL("D:\\Excel");
	
		return SUCCESS;
	}

}
