package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsByTieba {
	public static void main(String[] args) throws IOException {
		for(int i=0;i<=1000;i+=50){
		 String url = "http://tieba.baidu.com/f?ie=utf-8&kw=2013%E6%98%A5%E6%99%9A#/pn=i";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div.threadlist_li_right");
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.getElementsByClass("c");
			 
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
