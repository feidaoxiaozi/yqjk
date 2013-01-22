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

public class GetNewsBySina {
	
	public String getnewsBySina() throws IOException {
		FileWriter out = new FileWriter(new File("D:"+File.separator+"news.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){			
		for(int i=0;i<=10;i++){
		 String url = "http://search.sina.com.cn/?q="+URLEncoder.encode(y.getRoleName(), "gb2312")+"&c=news&from=channel&page=2&pf=2131425489&ps=2132080888&dpc=i";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div.r-info h2");
		
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.getElementsByTag("span"); 
			 String href=null;
			 String text=null;
			 String spantext=null;
			 for(Element item_a:a){				 
				 href=item_a.attr("href");
				 text=item_a.text();
//				 System.out.println(text);
//				 System.out.println(href);
				 
			 }
			 for(Element item_span:span){				 
				 spantext=item_span.text();
				 System.out.println(spantext);
			 }
			 out.write(text+"@"+href+"$"+spantext+"#"+"\r\n");
		 }

		 }
	}
		return null;
}
}