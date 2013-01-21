package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsBySina {
	
	public static void main(String[] args) throws IOException {
		for(int i=0;i<=10;i++){
		 String url = "http://search.sina.com.cn/?q=2013%B4%BA%CD%ED&c=news&from=channel&page=2&pf=2131425489&ps=2132080888&dpc=i";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div.r-info h2");
		
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.getElementsByClass("fgreen time");			 
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
