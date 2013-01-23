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

public class GetNewsBy360 {
	
	public String get360News() throws IOException {
		FileWriter out = new FileWriter(new File("D:"+File.separator+"news.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){	
		for(int i=0;i<=10;i++){
		 String url = "http://news.so.com/ns?q="+URLEncoder.encode(y.getRoleName(), "gb2312")+"&pn=i&tn=news";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div#container h3");
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.select("span");
			 String href= null;
			 String text= null;
			 String spantext= null;
			 for(Element item_a:a){				 
				 href=item_a.attr("href");
				 text=item_a.text();
				 System.out.println(text);
				 System.out.println(href);
				 
			 }
			 for(Element item_span:span){				 
				 spantext=item_span.text();
				 System.out.println(spantext);
			 }
			 out.write(text+"@"+href+"$"+spantext+"#"+"\r\n");
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