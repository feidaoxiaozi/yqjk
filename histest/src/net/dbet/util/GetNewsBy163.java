package net.dbet.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.dbet.yqjk.Yqjkxx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsBy163 {
	public String get163News() throws IOException {//static void main(String[] args)throws IOException {
		Date sysTime = null;
		String comeTime = null;
		Date curTime = null;
		FileWriter out = new FileWriter(new File("D:"+File.separator+"news.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){		
		for(int i=0;i<=500;i+=10){
		 String url = "http://news.youdao.com/search?q="+URLEncoder.encode(y.getRoleName(), "gb2312")+"&start="+i+"&length=10&s=byrelevance&tr=no_range&keyfrom=search.page&suser=user163&site=163.com";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div#resc h3");
		 String href = null;
		 String text= null;
		 String spantext= null;
		 String res = null;
		 String time = null;
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.getElementsByTag("nobr");
			 
			 for(Element item_a:a){				 
				 href=item_a.attr("href");
				 text=item_a.text();
				 out.write(text+"@");
				 out.write(href+"$");				
			 }
			 for(Element item_span:span){				 
				 spantext=item_span.text();
				 String[] resAtm = spantext.split("\\s");
				 if(resAtm.length==1){
					 res = resAtm[0]; 
				 }
				 if(resAtm.length==2){
					 res = resAtm[0];
					 time = resAtm[1]; 
				 }	
				 out.write(res+"#");	
				 System.out.println(resAtm.length);

			 }
			 comeTime = y.getCollectDate();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				     //boolean b = time.equals("");
					try {
						sysTime = df.parse(getNowTime());
						//if(!b){
							curTime = df.parse(time);
						//}
						
						//chaTime = (sysTime.getTime()-df.parse("1970-01-01 00:00:00").getTime())/1000/3600/24/365;
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
                     System.out.println("bigDate6="+bigDate6);
                    System.out.println(sysTime.getTime());
                     Date smallDate6 = df.parse(df.format(sysTime.getTime()-24*15*3600*1000));
                     System.out.println("smallDate6="+smallDate6);
                     System.out.println(sysTime.getTime()-24*29*3600*1000);
                    
                     System.out.println("sysTime564="+sysTime.getTime());
                     System.out.println("sysTime123456="+(sysTime.getTime()+24*15*3600*1000));
                     if(comeTime.equals("五小时内")){
							System.out.println("此处无飘过&*&*&&*");
						
							if(curTime.before(bigDate1)&&curTime.after(smallDate1)){
                         	 
								 System.out.println("time1="+time);
							
							System.out.println("############此处飘过1");
							out.write(time+"&"+"\r\n");
							}
							if(time.equals(null)||time.equals(" ")){
								out.write(time+""+"\r\n");
							}
						}
						if(comeTime.equals("十小时内")){
							if(curTime.before(bigDate2)&&curTime.after(smallDate2)){
                         	
								 System.out.println("time2="+time);
							
							System.out.println("############此处飘过2");
							out.write(time+"&"+"\r\n");
						}
							if(time.equals(null)||time.equals(" ")){
								out.write(time+""+"\r\n");
							}
						}
                     if(comeTime.equals("当天")){
							System.out.println("漂不漂亮");
							System.out.println("sysTime="+sysTime);
							System.out.println("curTime="+curTime);
							
							 if(curTime.before(bigDate3)&curTime.after(smallDate3)){
                         	
								 System.out.println("time3="+time);
							
							System.out.println("############此处飘过1");
							out.write(time+"&"+"\r\n");
							 }
							 if(time.equals(null)||time.equals(" ")){
								 out.write(time+""+"\r\n");
								}
						}
						if(comeTime.equals("三天内")){
							if(curTime.before(bigDate4)&&curTime.after(smallDate4)){
                         	
								 System.out.println("time4="+time);
							
							System.out.println("############此处飘过4");
							out.write(time+"&"+"\r\n");
							}
							if(time.equals(null)||time.equals(" ")){
								out.write(time+""+"\r\n");
							}
						}
						if(comeTime.equals("一周内")){
							if(curTime.before(bigDate5)&&curTime.after(smallDate5)){
                         	
								 System.out.println("time5="+time);
							
							System.out.println("############此处飘过5");
							out.write(time+"&"+"\r\n");
							}
							if(time.equals(null)||time.equals(" ")){
								out.write(time+""+"\r\n");
							}
						}
						if(comeTime.equals("半个月内")){
							System.out.println("sysTime="+sysTime);
							System.out.println("curTime="+curTime);
							
							
							if(curTime.before(bigDate6)&&curTime.after(smallDate6)){
								System.out.println("############此处飘过6");
								 System.out.println("time6="+time);
								 out.write(time+"&"+"\r\n");
							
							}
							if(time.equals(null)||time.equals(" ")){
								out.write(time+""+"\r\n");
							}
						}
			 //out.write(text+"@"+href+"$"+res+"#"+time+"&"+"\r\n");
		 //}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();								
			}
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
	}
		
		}
		return null;
		
}

	private String getNowTime() {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		 String nowDate = dfs.format(new Date());
			
		 return nowDate;
	}
	
}