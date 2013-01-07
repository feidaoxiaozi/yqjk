package net.dbet.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GetNewsByKeys {
	public String getNews() throws IOException {
		
		String line = "";
		FileWriter out=new FileWriter(new File("D:"+File.separator+"aaa.txt"));
		for (int i = 0; i <= 1000; i += 20) {
			String str = URLEncoder.encode("»ÆÏþÃ÷", "gb2312");
			URL url = new URL(
					"http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=gb2312&ct=1&word="+str+"&pn="
							+ i + "&cl=2");
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
						temp.append(line+"$\r\n");
					}
					flags[2]=!flags[2];
				    }
	
				if(flags[0]==false&&flags[1]==false&&flags[2]==false){					
					if(temp.length()>5){
						temp = temp.append("\r\n");
						out.write(temp.toString());
						System.out.println(temp);
					}
					temp.delete(0,temp.length()-1);
				}
				
				}
				
		}
		return line;
	}
	
}
