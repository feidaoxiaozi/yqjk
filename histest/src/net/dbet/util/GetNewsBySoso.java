package net.dbet.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import net.dbet.yqjk.Yqjkxx;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsBySoso {
	
	public String getSosoNews() throws IOException{
		
		FileWriter out = new FileWriter(new File("D:"+File.separator+"news.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){			
		for(int i=0;i<=50;i++){
		 String url = "http://www.soso.com/q?w="
		 		+URLEncoder.encode(y.getRoleName(), "gb2312")+"&lr=&sc=web&ch=w.p&num=10&gid=&cin=&site=news.qq.com&sf=0&sd=0&nf=0&pg="+i+"";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div#result h3");
		 
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 String href= null;
			 String text= null;
			 for(Element item_a:a){				 
				 href=item_a.attr("href");
				 text=item_a.text();								 				 				
			 }
			 out.write(text+"@"+href+"$"+""+"#"+"\r\n");				
			 System.out.println(text);
			 System.out.println(href);
		 }
         try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		
	}
		return null;
	}
}
