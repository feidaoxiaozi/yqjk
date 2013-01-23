package net.dbet.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetKeysByTxWeibo {
	
	@SuppressWarnings("unchecked")
public static void main(String[] args) throws IOException{
		 String url = "http://search.t.qq.com/index.php?k=%E7%8E%8B%E5%8A%9B%E5%AE%8F&pos=211&p=6";
		 Document doc = Jsoup.connect(url).get();
	     Elements content = doc.select("div.main div");
	     //Elements els = content.select("div.msgCnt");
	     Elements mmm = content.select("div.mediaWrap");
	     System.out.println(mmm);
	     Elements nnn = mmm.select("div.picBox");
	     
		 for(Element item:nnn){
			 
			 Elements span=item.getElementsByClass("msgCnt");
			
			 Elements a=item.getElementsByTag("a");
			 for(Element item_a:a){				 
				 String href=item_a.attr("href");
				 String text=item_a.text();
				 System.out.println(text);
				 System.out.println(href);
				 
			 }
			 for(Element item_span:span){				 
				 String text=item_span.text();
				 //System.out.println(text);
			 }
		 }

		 }
	}
	
