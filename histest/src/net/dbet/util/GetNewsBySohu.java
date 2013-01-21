package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsBySohu {
	
	public static void main(String[] args) throws IOException {
		for(int i=0;i<=10;i++){
		 String url = "http://news.sogou.com/news?mode=2&manual=&query=2013%B4%BA%CD%ED&time=0&sort=0&page=i&w=03009900&dr=1&_asf=news.sogou.com&_ast=1358737536";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div.results h3");
		 for(Element item:content){
			 Elements a=item.select("a.pp");
			 Elements span=item.select("cite");
			 
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
