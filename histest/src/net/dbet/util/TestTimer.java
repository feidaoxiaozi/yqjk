package net.dbet.util;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
//	    public static void main(String[] args) {
//	    	
//	    	 
//
//	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	       Timer timer = null;
//	       try {
//	         Date datetime = sdf .parse("2007/07/31 23:59:00");
//	         timer = new Timer();
//	         System.out.println("-----------定时间器已经启动。。。。。。");
//	         timer.scheduleAtFixedRate(new TimerTask() {
//	             @Override
//	             public void run() {
//	                System.out.println("抓取中。。。。。。");
//	             }
//	         }, datetime , 5*1000);
//	     } catch (ParseException e) {
//	        e.printStackTrace();
//	     }
//	  }

		 
	    static Timer timer = null; 
	    public void useTimer(){//static void main(String[] args) {
	        timer = new Timer();
	           System.out.println("-----------定时间器已经启动。。。。。。");
	           timer.schedule(new TimerTask() {
	              @Override
	              public void run() {
	              System.out.println("抓取中！！！");
	           }
	        }, 0, 5*1000);
	    }
	}


