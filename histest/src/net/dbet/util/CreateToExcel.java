package net.dbet.util;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import net.dbet.yqjk.Report;
import net.dbet.yqjk.User;
import net.dbet.yqjk.Yqjkxx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CreateToExcel {
	 private static Log log = LogFactory.getLog(CreateToExcel.class);

	 public String writeExcel(List listtitle, List listtype, List listcontent,
	   String filedirpath,String filesavename, String title, int titlesize) {
	  
	  File filepath = new File("listreport.jsp");
	  if (filepath.exists()) {
	   log.info("路径已经存在！<br/>");
	  } else {
	   filepath.mkdir();
	  }
	  String sCurrPath = filedirpath + "/" + filesavename + ".xls";
	  //String myfilepath = request.getRealPath(sCurrPath);
	  File file = new File(sCurrPath);
	  try {
	   file.createNewFile();
	   //获取文件的URL地址
	  } catch (Exception e) {
	   log.error("创建文件失败！");
	  }
	  //以下开始输出到EXCEL
	  try {
	   /************创建工作簿*************/
	   WritableWorkbook workbook = Workbook.createWorkbook(new File(
	     sCurrPath));

	   /************创建工作表*************/

	   WritableSheet sheet = workbook.createSheet("报表系统", 0);
	   //sheet.setPageSetup(5,true);

	   /************设置纵横打印（默认为纵打）、打印纸******************/
	   //sheet.setPageSetup(PageOrientation.LANDSCAPE.LANDSCAPE,0,0);
	   //sheet.setPageSetup(PageOrientation.LANDSCAPE.LANDSCAPE,PaperSize.A4,0,0);
	   //sheet.addRowPageBreak(12);
	   jxl.SheetSettings sheetset = sheet.getSettings();
	   sheetset.setProtected(false);

	   //sheet.setColumnView(0,5);
	   //sheet.setColumnView(1,12);

	   /**************设置单元格字体***************/
	   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
	   WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 14,
	     WritableFont.BOLD);

	   /**************以下设置几种格式的单元格*************/
	   //用于正文居左
	   WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
	   wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); //线条
	   wcf_left.setVerticalAlignment(VerticalAlignment.TOP); //文字垂直对齐
	   wcf_left.setAlignment(Alignment.LEFT); //文字水平对齐
	   wcf_left.setWrap(false); //文字是否换行

	   //用于正文居右
	   WritableCellFormat wcf_right = new WritableCellFormat(NormalFont);
	   wcf_right.setBorder(Border.ALL, BorderLineStyle.THIN); //线条
	   wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE); //文字垂直对齐
	   wcf_right.setAlignment(Alignment.RIGHT); //文字水平对齐
	   wcf_right.setWrap(false); //文字是否换行

	   //用于正文居中
	   WritableCellFormat wcf_center = new WritableCellFormat(NormalFont);
	   wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); //线条
	   wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); //文字垂直对齐
	   wcf_center.setAlignment(Alignment.CENTRE); //文字水平对齐
	   wcf_center.setWrap(false); //文字是否换行

	   //用于跨行
	   WritableCellFormat wcf_merge = new WritableCellFormat(BoldFont);
	   wcf_merge.setBorder(Border.ALL, BorderLineStyle.THICK); //线条
	   wcf_merge.setVerticalAlignment(VerticalAlignment.CENTRE); //文字垂直对齐
	   wcf_merge.setAlignment(Alignment.CENTRE); //文字水平对齐
	   wcf_merge.setWrap(false); //文字是否换行

	   /**************单元格格式设置完成*******************/

	   /*****************以下是定单内容**********************/

	   sheet.mergeCells(0, 0, titlesize, 0);
	   sheet.addCell(new Label(0, 0, title, wcf_center));

	   for (int i = 0; i < listtitle.size(); i++) {
	    sheet.addCell(new Label(i, 1, (String) listtitle.get(i),
	      wcf_left));
	   }

	   for (int i = 0; i < listcontent.size(); i++) {
	    
	    //写入数据
	    List contentlist =(List)listcontent.get(i);
	    
	    for(int j=0;j < contentlist.size();j++)
	    {
	     String datatype = (String) listtype.get(j);
	      if ("string".equals(datatype))
	       sheet.addCell(new Label(j, i + 2, (String) contentlist
	         .get(j), wcf_center)); //第0行
	      else if("float".equals(datatype)){
	       jxl.write.Number labelN = new jxl.write.Number(j, i + 2,
	         new BigDecimal((String) contentlist.get(j))
	           .setScale(2, BigDecimal.ROUND_HALF_UP)
	           .doubleValue());
	       sheet.addCell(labelN);
	      }
	    }
	   }

	   /************以上所写的内容都是写在缓存中的，下一句将缓存的内容写到文件中*********/
	   workbook.write();
	   /***********关闭文件**************/
	   workbook.close();

	  } catch (Exception e) {
	   e.printStackTrace();
	   log.error("在输出到EXCEL的过程中出现错误，错误原因：" + e.toString());
	  }

	  return filesavename;
	 }
       public static void main(String[] args) {
    	   ArrayList<User> userlist = new ArrayList<User>();
    	   ArrayList<Report> reportlist = new ArrayList<Report>();
    	   ArrayList<Yqjkxx> tasklist = new ArrayList<Yqjkxx>();
    	   CreateToExcel cte = new CreateToExcel();
    	   cte.writeExcel(userlist, reportlist, tasklist, "listreport.jsp", "bbb", "hfshjd", 50);
	}


}
