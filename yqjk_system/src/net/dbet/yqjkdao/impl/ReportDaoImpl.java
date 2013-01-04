package net.dbet.yqjkdao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import net.dbet.util.GetNewsByKeys;
import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;
import net.dbet.yqjkdao.ReportDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class ReportDaoImpl extends HibernateDaoSupport implements ReportDao {
	@SuppressWarnings("unchecked")
	public List<Report> findAllReportxx() {
		String hql = "from Report";
		return (List<Report>)this.getHibernateTemplate().find(hql);
	}
	
	public Connection getConnection(){
		System.out.println("connection是否已获得");
		Connection con = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/yqjk";
				con = (Connection) DriverManager.getConnection(url, "root", "123456");
			}catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		public void getFile(){
			System.out.println("*****getFile()已执行");
		  loadData("D:"+File.separator+"data.txt");
		}
      //数据记录导入
		public boolean loadData(String file){
			System.out.println("####loadData()已执行");
			Connection con = getConnection();
			try {
				PreparedStatement ps = null,ps1=null,ps2=null;
				ResultSet rs = null;
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
				String line ="";
				String sql = "insert into yqjk_report values(?,?,?,?,?,?,?,?,?,?)";
				try {
					con.setAutoCommit(false);
					ps = (PreparedStatement)con.prepareStatement(sql);
					int n = 0;
					try {
						//while((line=br.readLine())!=null){
						String type = line.trim();	
						ps.setString(1, type);
						
						ps.addBatch();
						n++;
						if(n>1000){
							ps.executeBatch();
							n=0;
						}
						//}
						ps.executeBatch();
						con.commit();
					//} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}finally{
						if(null!=rs){
							rs.close();
						}
						if(null!=ps){
							ps.close();
						}
						if(null!=ps2){
							ps2.close();
						}
						if(null!=ps1){
							ps1.close();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	public void insertReport(Report report) {
		
		GetNewsByKeys gnbk = new GetNewsByKeys();
			try {
				
				gnbk.getNews();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			getFile();
	}
	
	public Yqjkxx findByRoleId(int roleId) {
		Yqjkxx yqjkxx = (Yqjkxx) this.getHibernateTemplate().get(Yqjkxx.class, roleId);
		return yqjkxx;		
	}
}
