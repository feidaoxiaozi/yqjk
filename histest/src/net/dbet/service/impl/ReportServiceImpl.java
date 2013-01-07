package net.dbet.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import net.dbet.service.ReportService;
import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;
import net.dbet.yqjkdao.ReportDao;

public class ReportServiceImpl implements ReportService {
	private ReportDao reportDao;

	public List<Report> findAllReportxx() {
		
		return this.reportDao.findAllReportxx();
	}

	public ReportDao getReportDao() {
		return reportDao;
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	public void insertReport(Report report) {
		this.reportDao.insertReport(report);
		
	}
	public Yqjkxx findByRoleId(int roleId) {		
		return this.findByRoleId(roleId);
	}
	public InputStream getInputStream() {
		HSSFWorkbook hf = new HSSFWorkbook();

		HSSFSheet sheet = hf.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("类型");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("标题");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("来源");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("发表时间");
		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("转载量");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("点击数");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("回复数");
		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("URL");

		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("作者");

		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("搜索时间");
		row = sheet.createRow(1);
		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("引擎名称");
		
		List<Report> list = this.reportDao.findAllReportxx();

		for (int i = 0; i < list.size(); i++) {
			Report report= list.get(i);
			row = sheet.createRow(i + 1);
//			cell = row.createCell((short) 0);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getType());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(report.getTitle());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(report.getResource());

//			cell = row.createCell((short) 3);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getPublished_time());
//			
//			cell = row.createCell((short) 4);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getReprinted_volume());

//			cell = row.createCell((short) 5);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getClick_number());
//
//			cell = row.createCell((short) 6);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getBack_number());

			cell = row.createCell((short) 7);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(report.getUrl());
			
//			cell = row.createCell((short) 8);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getAuthor());

//			cell = row.createCell((short) 9);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getSeach_time());

//			cell = row.createCell((short) 10);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(report.getEngineName());
						
		}
		File file = new File("report.xls");
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			hf.write(os);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       InputStream is = null;
       
       try {
		is = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return is;
}

	
}