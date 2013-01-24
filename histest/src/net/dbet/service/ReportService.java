package net.dbet.service;

import java.util.List;
import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;

public interface ReportService {
	
	public abstract List<Report> findAllReportxx();
	
	public abstract Yqjkxx findByRoleId(int roleId);

	public abstract void insertReport(Report report);
}
