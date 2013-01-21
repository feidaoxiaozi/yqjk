package net.dbet.yqjk;
import java.util.Set;

public class Yqjkxx{
  
	private int roleId;
	
	private String roleName;
	
	private String newsResource;
	
	private String findStyle;
    
	private String collectDate;
	
	private String collectCondition;
	
	private String contentMate;
	
	private String Site_collection;

    private String roleState;
    
    private Set<Report> report; 

	public Set<Report> getReport() {
		return report;
	}

	public void setReport(Set<Report> report) {
		this.report = report;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNewsResource() {
		return newsResource;
	}

	public void setNewsResource(String newsResource) {
		this.newsResource = newsResource;
	}

	public String getFindStyle() {
		return findStyle;
	}

	public void setFindStyle(String findStyle) {
		this.findStyle = findStyle;
	}

	public String getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}

	public String getCollectCondition() {
		return collectCondition;
	}

	public void setCollectCondition(String collectCondition) {
		this.collectCondition = collectCondition;
	}

	public String getContentMate() {
		return contentMate;
	}

	public void setContentMate(String contentMate) {
		this.contentMate = contentMate;
	}

	

	public String getRoleState() {
		return roleState;
	}

	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}

	public String getSite_collection() {
		return Site_collection;
	}

	public void setSite_collection(String site_collection) {
		Site_collection = site_collection;
	}
	
	
}
