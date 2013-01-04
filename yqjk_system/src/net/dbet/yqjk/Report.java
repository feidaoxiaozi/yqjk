package net.dbet.yqjk;

import java.util.Date;

public class Report {
	private int reportId;
	
	private String type;
	
	private String title;
	
	private String resource;
	
	private Date published_time; 
	
	private int reprinted_volume;
	
	private int click_number;
	
	private int back_number;
	
	private String url;
	
	private String author;
	
	private Date seach_time;
	
	private String engineName;
	
	private int roleId;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public Date getPublished_time() {
		return published_time;
	}

	public void setPublished_time(Date published_time) {
		this.published_time = published_time;
	}

	public int getReprinted_volume() {
		return reprinted_volume;
	}

	public void setReprinted_volume(int reprinted_volume) {
		this.reprinted_volume = reprinted_volume;
	}

	public int getClick_number() {
		return click_number;
	}

	public void setClick_number(int click_number) {
		this.click_number = click_number;
	}

	public int getBack_number() {
		return back_number;
	}

	public void setBack_number(int back_number) {
		this.back_number = back_number;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getSeach_time() {
		return seach_time;
	}

	public void setSeach_time(Date seach_time) {
		this.seach_time = seach_time;
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
