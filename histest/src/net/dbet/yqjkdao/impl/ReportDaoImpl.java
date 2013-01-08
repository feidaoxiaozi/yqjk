package net.dbet.yqjkdao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.dbet.util.DBConn;
import net.dbet.util.GetNewsByKeys;
import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;
import net.dbet.yqjkdao.ReportDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ReportDaoImpl extends HibernateDaoSupport implements ReportDao {
	@SuppressWarnings("unchecked")
	public List<Report> findAllReportxx() {
		String hql = "from Report";
		return (List<Report>)this.getHibernateTemplate().find(hql);
	}
	
		public void getFile(){		
		  loadData("D:"+File.separator+"aaa.txt");
		}
      //数据记录导入
		public boolean loadData(String file){
			DBConn db = new DBConn();
			Connection con  = db.getConn();
			try {
				PreparedStatement ps = null,ps1=null,ps2=null;
				ResultSet rs = null;
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
				String line ="";
                String sql ="insert into yqjk_report (reportId,title,url,resource)values(?,?,?,?)";
				try {
					con.setAutoCommit(false);
					ps = (PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
							
					int n=0,index=1 ;
					
					try {						
						while ((line = br.readLine()) != null) {								
						//if(index%2==1){	
						int reportId=index++;	
						String title=line.substring(0, line.indexOf("~"));						
						String url=line.substring(line.indexOf("~")+1, line.indexOf("#"));
						String resource=line.substring(line.indexOf("#")+1, line.indexOf("$"));
													
						    ps.setInt(1,reportId);
							ps.setString(2, title);
							ps.setString(3, url);
							ps.setString(4, resource);
							ps.addBatch();
							n++;
							if(n>1000){
								ps.executeBatch();
								n=0;
							}				                       
							ps.executeBatch();
							//ps.executeUpdate();
							con.commit();
						}
						//}
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
			} catch (Exception e) {
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
