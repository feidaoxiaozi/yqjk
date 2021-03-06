package net.dbet.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;


public class VerificationCode {
	 private ByteArrayInputStream image;// 图像   
	    private String str;// 验证码   
	    private static final int WIDTH = 80;   
	    private static final int HEIGHT = 20;   
	   
	    public static void main(String[] arg) {   
	        VerificationCode vcu = VerificationCode.Instance();   
	        System.err.println(vcu.getVerificationCodeValue());   
	    }

	    public String getVerificationCodeValue() {
	        return this.getStr();
	    }

		public static VerificationCode Instance() {
			// TODO Auto-generated method stub
			return new VerificationCode();

		}

		public void initLetterAndNumVerificationCode(BufferedImage image) {   
	    	   
	        Random random = new Random(); // 生成随机类   
	        Graphics g = initImage(image, random);   
	        String[] letter = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",   
	                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",   
	                "W", "X", "Y", "Z" };   
	        String sRand = "";   
	        for (int i = 0; i < 4; i++) {   
	            String tempRand = "";   
	            if (random.nextBoolean()) {   
	                tempRand = String.valueOf(random.nextInt(10));   
	            } else {   
	                tempRand = letter[random.nextInt(25)];   
	                if (random.nextBoolean()) {// 随机将该字母变成小写   
	                    tempRand = tempRand.toLowerCase();   
	                }   
	            }   
	            sRand += tempRand;   
	            g.setColor(new Color(20 + random.nextInt(10), 20 + random   
	                    .nextInt(110), 20 + random.nextInt(110)));   
	            g.drawString(tempRand, 13 * i + 6, 16);   
	        }   
	        this.setStr(sRand);/* 赋值验证码 */   
	        g.dispose(); // 图象生效   
	        this.setImage(drawImage(image));   
	    }

		 public ByteArrayInputStream drawImage(BufferedImage image) {   
		        ByteArrayInputStream input = null;   
		        ByteArrayOutputStream output = new ByteArrayOutputStream();   
		        try {   
		            ImageOutputStream imageOut = ImageIO   
		                    .createImageOutputStream(output);   
		            ImageIO.write(image, "JPEG", imageOut);   
		            imageOut.close();   
		            input = new ByteArrayInputStream(output.toByteArray());   
		        } catch (Exception e) {   
		            System.out.println("验证码图片产生出现错误：" + e.toString());   
		        }   
		        return input;   
		    }   


		 public void setStr(String str) {   
		        this.str = str;   
		    }   

		public String getStr() {   
		        return str;   
		}   
		 public void setImage(ByteArrayInputStream image) {
		        this.image = image;
		    }
		 public ByteArrayInputStream getImage() {
		        return this.image;
		    }



		 public Graphics initImage(BufferedImage image, Random random) {   
		        Graphics g = image.getGraphics(); // 获取图形上下文   
		        g.setColor(getRandColor(200, 250));// 设定背景色   
		        g.fillRect(0, 0, WIDTH, HEIGHT);   
		        g.setFont(new Font("Times New Roman", Font.PLAIN, 14));// 设定字体   
		        g.setColor(getRandColor(160, 200)); // 随机产生165条干扰线，使图象中的认证码不易被其它程序探测到   
		        for (int i = 0; i < 165; i++) {   
		            int x = random.nextInt(WIDTH);   
		            int y = random.nextInt(HEIGHT);   
		            int xl = random.nextInt(12);   
		            int yl = random.nextInt(12);   
		            g.drawLine(x, y, x + xl, y + yl);   
		        }   
		        return g;   
		    }

		private Color getRandColor(int fc, int bc) {
			   Random random = new Random();   
		        if (fc > 255)   
		            fc = 255;   
		        if (bc > 255)   
		            bc = 255;   
		        int r = fc + random.nextInt(bc - fc);   
		        int g = fc + random.nextInt(bc - fc);   
		        int b = fc + random.nextInt(bc - fc);   
		        return new Color(r, g, b);   

		}   
		



}

