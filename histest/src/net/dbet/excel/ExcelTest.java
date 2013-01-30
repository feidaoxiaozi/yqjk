package net.dbet.excel;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.dbet.util.DBConn;
import net.dbet.yqjk.Report;

public class ExcelTest {

	/**
	 * @param args
	 */
	 
	public void getNewsExcel() {
		 DBConn db = new DBConn();
	     Statement st = null;
		 ResultSet rs = null;
		 Connection con = null;
		 ExcelFileUtil excel = new ExcelFileUtil();
		//数据初始化
		List<Report> al = new ArrayList<Report>();
		con = db.getConn();
	  	String sql = "select * from yqjk_report order by published_time desc";
		try {
  			st = con.createStatement();
			rs = st.executeQuery(sql);			
			while(rs.next()){
			Report report = new Report();
			report.setReportId(rs.getInt(1));
			report.setTitle(rs.getString(2));
			report.setUrl(rs.getString(3));
			report.setResource(rs.getString(4));
			report.setPublished_time(rs.getString(5));
			al.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		
		File file = excel.write("新闻信息", al, Report.class);
		System.out.println("文件存放路径为：" + file.getPath());
		
	}
	

}
