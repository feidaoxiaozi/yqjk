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

public class GetNewsBySohu {
	
	public String getSohuNews() throws IOException {//static void main(String[] args) throws IOException {
		FileWriter out = new FileWriter(new File("D:"+File.separator+"news.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){	
		for(int i=0;i<=10;i++){
		 String url = "http://news.sogou.com/news?mode=2&manual=&query="+URLEncoder.encode(y.getRoleName(), "gb2312")+"&time=0&sort=0&page=i&w=03009900&dr=1&_asf=news.sogou.com&_ast=1358737536";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div.results h3");
		 for(Element item:content){
			 Elements a=item.select("a.pp");
			 Elements span=item.select("cite");
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