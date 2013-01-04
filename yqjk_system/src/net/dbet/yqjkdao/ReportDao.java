package net.dbet.yqjkdao;

import java.util.List;

import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;

public interface ReportDao {
	
	public abstract List<Report> findAllReportxx();
	
	public abstract void insertReport(Report report);
	
	public abstract Yqjkxx findByRoleId(int roleId);

}
