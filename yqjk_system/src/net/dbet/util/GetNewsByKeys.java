package net.dbet.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetNewsByKeys {
	public String getNews() throws IOException {
		System.out.println("!!!!!!getNews()ÒÑÖ´ÐÐ");
		String line = "";
		FileWriter out=new FileWriter(new File("D:"+File.separator+"data.txt"));
		for (int i = 0; i <= 200; i += 20) {
			
			URL url = new URL(
					"http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=gb2312&ct=1&word=%C6%BB%B9%FB%B5%E7%C4%D4&pn="
							+ i + "&cl=2");
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();
			InputStreamReader input = new InputStreamReader(httpConn
					.getInputStream(), "gbk");
			BufferedReader bufReader = new BufferedReader(input);			
		   
			//while ((line = bufReader.readLine()) != null) {
				
				if (line.startsWith("title:") || line.startsWith("url:")
						|| line.startsWith("source: ") ) {		
					
				line=line.substring(line.indexOf(":")+1).replace("<font color=#C60A00>", "").replace("</font>","").replace("'","").replace(",", "");
				out.write(line);
				System.out.println(line);
				}
			}
			
		//}
		return line;
	}
	
}
