package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsBy163 {
	public static void main(String[] args) throws IOException {
		for(int i=0;i<=200;i+=10){
		 String url = "http://news.youdao.com/search?q=2013%E6%98%A5%E6%99%9A&start="+i+"&length=10&s=byrelevance&tr=no_range&keyfrom=search.page&suser=user163&site=163.com";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div#resc h3");
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.getElementsByTag("nobr");
			 
			 for(Element item_a:a){				 
				 String href=item_a.attr("href");
				 String text=item_a.text();
				 System.out.println(text);
				 System.out.println(href);
				 
			 }
			 for(Element item_span:span){				 
				 String text=item_span.text();
				 System.out.println(text);
			 }
		 }

		 }
	}
}
