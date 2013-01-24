package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetKeysByTxWeibo {
	
	@SuppressWarnings("unchecked")
public static void main(String[] args) throws IOException{
		 String url = "http://search.t.qq.com/index.php?k=%E5%88%98%E5%BE%B7%E5%8D%8E&pos=211&p=2";
		 Document doc = Jsoup.connect(url).get();
	     Elements content = doc.select("div.sosoBox div");
	     System.out.println(content);
	     Elements els = content.select(".msgCnt");
	     System.out.println(els);
//	     Elements mmm = content.select("div.mediaWrap");
//	     System.out.println(mmm);
//	     Elements nnn = mmm.select("div.picBox");
//	     
		 for(Element item:content){
			 
			Elements span=item.getElementsByClass("g");
			
			 Elements a=item.getElementsByTag("a");			
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

