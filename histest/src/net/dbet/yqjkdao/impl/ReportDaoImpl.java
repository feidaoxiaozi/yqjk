package net.dbet.yqjkdao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.dbet.util.DBConn;
import net.dbet.util.GetNewsBy163;
import net.dbet.util.GetNewsByBaidu;
import net.dbet.util.GetNewsBySina;
import net.dbet.util.GetNewsBySohu;
import net.dbet.util.GetNewsBySoso;
import net.dbet.yqjk.Report;
import net.dbet.yqjk.Yqjkxx;

import net.dbet.yqjkdao.ReportDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

public class ReportDaoImpl extends HibernateDaoSupport implements ReportDao {
	DBConn db = new DBConn();
	Connection con  = db.getConn();
	PreparedStatement ps = null,ps1=null,ps2=null;
	ResultSet rs = null;
	BufferedReader br = null;
	@SuppressWarnings("unchecked")
	public List<Report> findAllReportxx() {
		String hql = "from Report";
		return (List<Report>)this.getHibernateTemplate().find(hql);
	}
	
//		public void getFile(){		
//			loadBaiduData("D:"+File.separator+"aaa.txt");
//		}
//		public void getSosoFile(){		
//			loadBaiduData("D:"+File.separator+"newsdata"+File.separator+"soso.txt");
//		}
		public boolean loadBaiduData(String file){
			
			try {
				
			    br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
				String line ="";
                String sql ="insert into yqjk_report (reportId,title,url,resource,roleId)values(?,?,?,?,?)";
				try {
					con.setAutoCommit(false);
					ps = (PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
							
					int n=0,index=1,road=1 ;
					try {						
						while ((line = br.readLine()) != null) {
						int reportId = index++;	
						String title=line.substring(0, line.indexOf("~")+1).replace("~", "");					
						String url=line.substring(line.indexOf("~")+1, line.indexOf("#")+1).replace("#", "");
						String resource=line.substring(line.indexOf("#")+1, line.indexOf("$")+1).replace("$","");
						int roleId = road++;							
						    ps.setInt(1,reportId);
							ps.setString(2, title);
							ps.setString(3, url);
							ps.setString(4, resource);
							ps.setInt(5, roleId);
							ps.addBatch();
							n++;
							if(n>1000){
								ps.executeBatch();
								n=0;
							}				                       
							ps.executeBatch();							
							con.commit();
						}
						
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
	public boolean loadNewsData(String file){
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
			String line ="";
            String sql ="insert into yqjk_report (reportId,title,url,resource,roleId)values(?,?,?,?,?)";
            try {
				con.setAutoCommit(false);
				ps = (PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				int n=0,index=1,road=1 ;
				try {
					while ((line = br.readLine()) != null) {
						int reportId = index++;	
						String title=line.substring(0, line.indexOf("@")+1).replace("@", "");						
						String url=line.substring(line.indexOf("@")+1, line.indexOf("$")+1).replace("$", "");
						String resource=line.substring(line.indexOf("$")+1, line.indexOf("#")+1).replace("#", "");
						int roleId = road++;							
						    ps.setInt(1,reportId);
							ps.setString(2, title);
							ps.setString(3, url);
							ps.setString(4, resource);
							ps.setInt(5, roleId);
							ps.addBatch();
							n++;
							if(n>1000){
								ps.executeBatch();
								n=0;
							}				                       
							ps.executeBatch();							
							con.commit();
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
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
		
	public void insertReport(Report report){
		
		ArrayList<Yqjkxx> resource = getNewsResources();
		
		for(Yqjkxx yqjkxx: resource){
		String newsResource = yqjkxx.getNewsResource();
        String newsState = yqjkxx.getRoleState();
        System.out.println("newsState="+newsState);
		if(newsResource.contains("新闻")&& newsState.equals("启用")){
				GetNewsByBaidu gnbk = new GetNewsByBaidu();
				GetNewsBySoso gnbs = new GetNewsBySoso();
				GetNewsBy163 wangyi = new GetNewsBy163();
				GetNewsBySina sina = new GetNewsBySina();
				GetNewsBySohu sohu = new GetNewsBySohu();
				try {					
											try {
												gnbk.getNews();
												loadBaiduData("D:"+File.separator+"newsbaidu.txt");
												gnbs.getSosoNews();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}									
											wangyi.get163News();
											sina.getnewsBySina();
											sohu.getSohuNews();
											loadNewsData("D:"+File.separator+"news.txt");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}else if (newsState.equals("停用")) {
				System.out.println("此项已停用");
			}
	}	
	}
	public Yqjkxx findByRoleId(int roleId) {
		Yqjkxx yqjkxx = (Yqjkxx) this.getHibernateTemplate().get(Yqjkxx.class, roleId);
		return yqjkxx;		
	}
	
	public ArrayList<Yqjkxx> getNewsResources(){
	     DBConn db = new DBConn();
	     Statement st = null;
		 ResultSet rs = null;
		 Connection con = null;
	  	ArrayList<Yqjkxx> al = new ArrayList<Yqjkxx>();
	  	
	  	con = db.getConn();
	  	String sql = "select * from yqjk_task";
	  	try {
	  			st = con.createStatement();
				rs = (ResultSet)st.executeQuery(sql);		
				while(rs.next()){
				Yqjkxx yqjkxx = new Yqjkxx();
				yqjkxx.setRoleId(rs.getInt(1));
				yqjkxx.setRoleName(rs.getString(2));
				yqjkxx.setNewsResource(rs.getString(3));
				yqjkxx.setFindStyle(rs.getString(4));
				yqjkxx.setCollectDate(rs.getString(5));
				yqjkxx.setCollectCondition(rs.getString(6));
				yqjkxx.setContentMate(rs.getString(7));
				yqjkxx.setSite_collection(rs.getString(8));
				yqjkxx.setRoleState(rs.getString(9));
				al.add(yqjkxx);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.close();
			}
	  	return al;
	  }
}
