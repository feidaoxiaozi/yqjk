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

public class GetNewsByTieba {
	public String getTiebaNews() throws IOException {
		FileWriter out = new FileWriter(new File("D:"+File.separator+"tieba.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){		
		for(int i=0;i<=100;i+=50){
		 String url = "http://tieba.baidu.com/f?kw="+URLEncoder.encode(y.getRoleName(), "gb2312")+"&ie=utf-8&fr=wwwt#/pn=i";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div.threadlist_li_right div");
		 Elements els = content.select("div.threadlist_lz");		 		
		 Elements ment = els.select(".threadlist_text");		 
		 for(Element item:ment){
			 Elements a=item.getElementsByTag("a");
			 for(Element item_a:a){				 
				 String href=item_a.attr("href");
				 String text=item_a.text();
				 System.out.println(text);
				 System.out.println(href.replace("/", ""));	
				 out.write(text+"@"+href+"$"+""+"#"+"\r\n");
			 }
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
