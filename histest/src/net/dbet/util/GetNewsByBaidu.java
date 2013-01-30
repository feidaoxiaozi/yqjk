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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.dbet.yqjk.Yqjkxx;

public class GetNewsByBaidu {
	
	@SuppressWarnings("unchecked")
public String getNews() throws IOException{
		Date sysTime = null;
		String comeTime = null;
		Date curTime = null;
		//long chaTime = 0;
		ArrayList<Yqjkxx> allKeyWords = getRoleName();
		String line = "";
		FileWriter out = new FileWriter(new File("D:"+File.separator+"newsbaidu.txt"));
		for(Yqjkxx y: allKeyWords){			
			for (int i = 0; i <= 100; i += 20) {
				URL url = new URL(
						"http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=gb2312&ct=1&word="
						+URLEncoder.encode(y.getRoleName(), "gb2312")+"&pn="+ i + "&cl=2");
			
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
						continue;
					}
					if(line.startsWith("url:")){
						line=line.substring(line.indexOf(":")+1).replace("<font color=#C60A00>", "").replace("</font>","").replace("'","").replace(",","").replace("\\", "");
						
						if(flags[1]){
							temp.append(line+"#");
						}
						flags[1]=!flags[1];
						continue;
					}					
					if(line.startsWith("source: ")){
						line=line.substring(line.indexOf(":")+1).replace("<font color=#C60A00>", "").replace("</font>","").replace("'","").replace(",","");						 
						String res = null;
						String time = null;
						if(flags[2]){
							
							String[] resAtm = line.split("\\s");
							
							if(resAtm.length==4){
								res = resAtm[1];								
								time = resAtm[2]+" "+resAtm[3];									
							}
							if(resAtm.length==3){
								res = resAtm[1];								
								time = resAtm[2];								
							}
							if(resAtm.length==2){
								res = "\\s";								
								time = "\\s";								
							}
							temp.append(res+"$");
						
							comeTime = y.getCollectDate();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
							     boolean b = time.equals("");						
								try {
									sysTime = df.parse(getNowTime());
									if(!b){
										curTime = df.parse(time);
									}								
									Date bigDate1 = df.parse(df.format(sysTime.getTime()));
	                                  
	                                Date smallDate1 = df.parse(df.format(sysTime.getTime()-5*3600*1000));
	                                  
	                                Date bigDate2 = df.parse(df.format(sysTime.getTime()));
	                                 
	                                Date smallDate2 = df.parse(df.format(sysTime.getTime()-10*3600*1000));
	                                   
									Date bigDate3 = df.parse(df.format(sysTime.getTime()));
									
                                    Date smallDate3 = df.parse(df.format(sysTime.getTime()-24*3600*1000));
                                  
                                    Date bigDate4 = df.parse(df.format(sysTime.getTime()));
                                   
                                    Date smallDate4 = df.parse(df.format(sysTime.getTime()-24*3*3600*1000));
                                    
                                    
                                    Date bigDate5 = df.parse(df.format(sysTime.getTime()));
                                   
                                    Date smallDate5 = df.parse(df.format(sysTime.getTime()-24*7*3600*1000));
                                   
                                    Date bigDate6 = df.parse(df.format(sysTime.getTime()));
                                    Date smallDate6 = df.parse(df.format(sysTime.getTime()-24*15*3600*1000));

                                    if(comeTime.equals("五小时内")){																			
										if(curTime.before(bigDate1)&&curTime.after(smallDate1)){	                                    
										temp.append(time+"^");
										}
										if(time.equals(null)||time.equals(" ")){
											temp.append("mmk "+"^");
										}
									}
									if(comeTime.equals("十小时内")){
										if(curTime.before(bigDate2)&&curTime.after(smallDate2)){
										temp.append(time+"^");
									}
										if(time.equals(null)||time.equals(" ")){
											temp.append("mmk "+"^");
										}
									}
                                    if(comeTime.equals("当天")){																		
										 if(curTime.before(bigDate3)&curTime.after(smallDate3)){
										
										temp.append(time+"^");
										 }
										 if(time.equals(null)||time.equals(" ")){
												temp.append("mmk "+"^");
											}
									}
									if(comeTime.equals("三天内")){
										if(curTime.before(bigDate4)&&curTime.after(smallDate4)){
										temp.append(time+"^");
										}
										if(time.equals(null)||time.equals(" ")){
											temp.append(" mmk"+"^");
										}
									}
									if(comeTime.equals("一周内")){
										if(curTime.before(bigDate5)&&curTime.after(smallDate5)){
											System.out.println("bigDate5="+bigDate5);
											System.out.println("smallDate5="+smallDate5);
	                                    System.out.println("飘过5");
										temp.append(time+"^");
										}
										if(time.equals(null)||time.equals(" ")){
											temp.append(" mmk"+"^");
										}
									}
									if(comeTime.equals("半个月内")){																			
										if(curTime.before(bigDate6)&&curTime.after(smallDate6)){					
										temp.append(time+"^");
										  System.out.println("飘过6");
										  System.out.println("bigDate6="+bigDate6);
											System.out.println("smallDate6="+smallDate6);
										}
										else{
											temp.append("时间不符合要求"+"^");
										}
									}
									
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();								
						}
						}
						flags[2]=!flags[2];
						continue;
					}
					
					if(flags[0]==false&&flags[1]==false&&flags[2]==false){					
						if(temp.length()>7){							
							out.write(temp.toString()+"\r\n");
							System.out.println(temp);
						}
						temp.delete(0,temp.length());
					}
					
					}
				  try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		return line;
	}
	public String getNowTime() { 
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				
		 String nowDate = df.format(new Date());
			
		 return nowDate;
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
