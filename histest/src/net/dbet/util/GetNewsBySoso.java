package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsBySoso {
	
	public static void main(String[] args) throws IOException {
		for(int i=0;i<=10;i++){
		 String url = "http://www.soso.com/q?w=2013%B4%BA%CD%ED&lr=&sc=web&ch=w.p&num=10&gid=&cin=&site=news.qq.com&sf=0&sd=0&nf=0&pg="+i+"";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div#result h3");
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.getElementsByClass("url");
			 
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
