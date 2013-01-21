package net.dbet.util;

//import java.io.IOException;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class GetNewsByFengH {
//	
//	public static void main(String[] args) throws IOException {
//		for(int i=0;i<=10;i++){
//		 String url = "http://search.ifeng.com/sofeng/search.action?q=%E4%B8%AD%E6%97%A5%E5%85%B3%E7%B3%BB&c=1&p=2";
//		 Document doc = Jsoup.connect(url).get();
//		 Elements content = doc.select("div.mainM div");
//		 Elements els = content.select("p");		 
//		 for(Element item:els){
//			 Elements a=item.getElementsByTag("a");
//			 Elements span= item.getElementsByTag("p");
//
//			 for(Element item_a:a){				 
//				 String href=item_a.attr("href");
//				 String text=item_a.text();
//				 System.out.println(text);
//				 System.out.println(href);
//				 
//			 }
//			 for(Element item_span:span){				 
//				 String text=item_span.text();
//				 System.out.println(text);
//			 }
//		 }
//
//		 }
//	}
//}
