package net.dbet.yqjk;
import net.dbet.excel.ExcelAnnotation;

public class Report {
	@SuppressWarnings("unused")
	@ExcelAnnotation(name = "ID")
	private int reportId;
	
	//private String type;
	@SuppressWarnings("unused")
	@ExcelAnnotation(name = "标题")
	private String title;
	@SuppressWarnings("unused")
	@ExcelAnnotation(name = "URL")
	private String url;
	@SuppressWarnings("unused")
	@ExcelAnnotation(name = "新闻来源和时间")
	private String resource;
	@SuppressWarnings("unused")
	@ExcelAnnotation(name = "任务ID")
	//private String published_time; 
	
//	private int reprinted_volume;
//	
//	private int click_number;
//	
//	private int back_number;
//	
//	
//	private String author;
	
	//private String seach_time;
	
//	private String engineName;
//	
	private int roleId;

//	public Report(int reportId, String title, String url, String resource) {
//		super();
//		this.reportId = reportId;
//		this.title = title;
//		this.url = url;
//		this.resource = resource;
//	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

//	public int getReprinted_volume() {
//		return reprinted_volume;
//	}
//
//	public void setReprinted_volume(int reprinted_volume) {
//		this.reprinted_volume = reprinted_volume;
//	}
//
//	public int getClick_number() {
//		return click_number;
//	}
//
//	public void setClick_number(int click_number) {
//		this.click_number = click_number;
//	}
//
//	public int getBack_number() {
//		return back_number;
//	}
//
//	public void setBack_number(int back_number) {
//		this.back_number = back_number;
//	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public String getEngineName() {
//		return engineName;
//	}
//
//	public void setEngineName(String engineName) {
//		this.engineName = engineName;
//	}
//
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

//	public String getPublished_time() {
//		return published_time;
//	}
//
//	public void setPublished_time(String published_time) {
//		this.published_time = published_time;
//	}
//
//	public void setSeach_time(String seach_time) {
//		this.seach_time = seach_time;
//	}
//
//	public String getSeach_time() {
//		return seach_time;
//	}

}
