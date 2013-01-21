package net.dbet.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import net.dbet.yqjk.Yqjkxx;

public class GetNewsByBaidu {
	
	@SuppressWarnings("unchecked")
public String getNews() throws IOException {
		ArrayList<Yqjkxx> allKeyWords = getRoleName();
		String line = "";
		FileWriter out = new FileWriter(new File("D:"+File.separator+"aaa.txt"));
		for(Yqjkxx y: allKeyWords){
			for (int i = 0; i <= 500; i += 20) {
				URL url = new URL(
						"http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=gb2312&ct=1&word="
						+URLEncoder.encode(y.getRoleName(), "gb2312")+"&pn="+ i + "&cl=2");
			//	URL url1 = new URL("www.baidu.com");
				HttpURLConnection httpConn = (HttpURLConnection) url
						.openConnection();
				InputStreamReader input = new InputStreamReader(httpConn
						.getInputStream(), "gbk");
				BufferedReader bufReader = new BufferedReader(input);			
				StringBuffer temp=new StringBuffer();  
				boolean flags[]=new boolean[]{true,true,true};
				while ((line = bufReader.readLine()) != null) {				
					if(line.startsWith("title:")){
						line=line.substring(line.indexOf(":")+1).replace("<font color=#C60A00>", "").replace("</font>","").replace("'","").replace(",","").replace("*/", "");
						if(flags[0]){
							temp.append(line+"~");
						}
						flags[0]=!flags[0];
					}
					if(line.startsWith("url:")){
						line=line.substring(line.indexOf(":")+1).replace("<font color=#C60A00>", "").replace("</font>","").replace("'","").replace(",","");
						
						if(flags[1]){
							temp.append(line+"#");
						}
						flags[1]=!flags[1];
					}
					if(line.startsWith("source: ")){
						line=line.substring(line.indexOf(":")+1).replace("<font color=#C60A00>", "").replace("</font>","").replace("'","").replace(",","");
						if(flags[2]){
							temp.append(line+"$");
						}
						flags[2]=!flags[2];
					    }
		
					if(flags[0]==false&&flags[1]==false&&flags[2]==false){					
						if(temp.length()>5){
						    temp.append("\r\n");
							out.write(temp.toString());
							System.out.println(temp);
						}
						temp.delete(0,temp.length()-1);
					}
					
					}
					
			}
		}
		return line;
	}
	  @SuppressWarnings("unchecked")
  public ArrayList<Yqjkxx> getRoleName(){
     DBConn db = new DBConn();
     Statement st = null;
	 ResultSet rs = null;
	 Connection con = null;
  	ArrayList<Yqjkxx> al = new ArrayList<Yqjkxx>();
  	
  	con = db.getConn();
  	String sql = "select * from yqjk_task";
  	try {
  			st = con.createStatement();
			rs = st.executeQuery(sql);			
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
