package net.dbet.service;

import java.io.InputStream;
import java.util.List;

import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;

public interface ReportService {
	
	public abstract List<Report> findAllReportxx();
	
	public abstract Yqjkxx findByRoleId(int roleId);
	
	public abstract InputStream getInputStream();

	public abstract void insertReport(Report report);
}
