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

public class GetNewsBy360 {
	
	public String get360News() throws IOException {//static void main(String[] args)throws IOException {//
		FileWriter out = new FileWriter(new File("D:"+File.separator+"news.txt"));
		GetNewsByBaidu gnbb = new GetNewsByBaidu(); 
		ArrayList<Yqjkxx> list = gnbb.getRoleName();
		for(Yqjkxx y: list){	
		for(int i=0;i<=3;i++){
		 String url = "http://news.so.com/ns?q="+URLEncoder.encode(y.getRoleName(), "gb2312")+"&pn=i&tn=news";
		 Document doc = Jsoup.connect(url).get();
		 Elements content = doc.select("div#container h3");
		 
		 for(Element item:content){
			 Elements a=item.getElementsByTag("a");
			 Elements span=item.select("span");
			 String href= null;
			 String text= null;
			 String spantext= null;
			 String mm = null;
			 String nn = null;
			 for(Element item_a:a){				 
				 href=item_a.attr("href");
				 text=item_a.text();
				 out.write(text+"@");
				 out.write(href+"$");
			 }
			 for(Element item_span:span){				 
				 spantext=item_span.text();
				 String[] ss = spantext.split("\\s");
				 mm = ss[0];				 
				 nn = ss[1]+" "+ss[2];				 					
					out.write(mm+"#");
					out.write(nn+"&"+"\r\n");							
                 System.out.println(mm);
                 System.out.println(nn);
			 }
			// out.write(text+"@"+href+"$"+mm+"#"+nn+"&"+"\r\n");
		 }
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
	}
		return null;
}
}