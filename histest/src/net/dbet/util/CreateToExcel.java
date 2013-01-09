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
	   log.info("·���Ѿ����ڣ�<br/>");
	  } else {
	   filepath.mkdir();
	  }
	  String sCurrPath = filedirpath + "/" + filesavename + ".xls";
	  //String myfilepath = request.getRealPath(sCurrPath);
	  File file = new File(sCurrPath);
	  try {
	   file.createNewFile();
	   //��ȡ�ļ���URL��ַ
	  } catch (Exception e) {
	   log.error("�����ļ�ʧ�ܣ�");
	  }
	  //���¿�ʼ�����EXCEL
	  try {
	   /************����������*************/
	   WritableWorkbook workbook = Workbook.createWorkbook(new File(
	     sCurrPath));

	   /************����������*************/

	   WritableSheet sheet = workbook.createSheet("����ϵͳ", 0);
	   //sheet.setPageSetup(5,true);

	   /************�����ݺ��ӡ��Ĭ��Ϊ�ݴ򣩡���ӡֽ******************/
	   //sheet.setPageSetup(PageOrientation.LANDSCAPE.LANDSCAPE,0,0);
	   //sheet.setPageSetup(PageOrientation.LANDSCAPE.LANDSCAPE,PaperSize.A4,0,0);
	   //sheet.addRowPageBreak(12);
	   jxl.SheetSettings sheetset = sheet.getSettings();
	   sheetset.setProtected(false);

	   //sheet.setColumnView(0,5);
	   //sheet.setColumnView(1,12);

	   /**************���õ�Ԫ������***************/
	   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
	   WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 14,
	     WritableFont.BOLD);

	   /**************�������ü��ָ�ʽ�ĵ�Ԫ��*************/
	   //�������ľ���
	   WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
	   wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); //����
	   wcf_left.setVerticalAlignment(VerticalAlignment.TOP); //���ִ�ֱ����
	   wcf_left.setAlignment(Alignment.LEFT); //����ˮƽ����
	   wcf_left.setWrap(false); //�����Ƿ���

	   //�������ľ���
	   WritableCellFormat wcf_right = new WritableCellFormat(NormalFont);
	   wcf_right.setBorder(Border.ALL, BorderLineStyle.THIN); //����
	   wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE); //���ִ�ֱ����
	   wcf_right.setAlignment(Alignment.RIGHT); //����ˮƽ����
	   wcf_right.setWrap(false); //�����Ƿ���

	   //�������ľ���
	   WritableCellFormat wcf_center = new WritableCellFormat(NormalFont);
	   wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); //����
	   wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); //���ִ�ֱ����
	   wcf_center.setAlignment(Alignment.CENTRE); //����ˮƽ����
	   wcf_center.setWrap(false); //�����Ƿ���

	   //���ڿ���
	   WritableCellFormat wcf_merge = new WritableCellFormat(BoldFont);
	   wcf_merge.setBorder(Border.ALL, BorderLineStyle.THICK); //����
	   wcf_merge.setVerticalAlignment(VerticalAlignment.CENTRE); //���ִ�ֱ����
	   wcf_merge.setAlignment(Alignment.CENTRE); //����ˮƽ����
	   wcf_merge.setWrap(false); //�����Ƿ���

	   /**************��Ԫ���ʽ�������*******************/

	   /*****************�����Ƕ�������**********************/

	   sheet.mergeCells(0, 0, titlesize, 0);
	   sheet.addCell(new Label(0, 0, title, wcf_center));

	   for (int i = 0; i < listtitle.size(); i++) {
	    sheet.addCell(new Label(i, 1, (String) listtitle.get(i),
	      wcf_left));
	   }

	   for (int i = 0; i < listcontent.size(); i++) {
	    
	    //д������
	    List contentlist =(List)listcontent.get(i);
	    
	    for(int j=0;j < contentlist.size();j++)
	    {
	     String datatype = (String) listtype.get(j);
	      if ("string".equals(datatype))
	       sheet.addCell(new Label(j, i + 2, (String) contentlist
	         .get(j), wcf_center)); //��0��
	      else if("float".equals(datatype)){
	       jxl.write.Number labelN = new jxl.write.Number(j, i + 2,
	         new BigDecimal((String) contentlist.get(j))
	           .setScale(2, BigDecimal.ROUND_HALF_UP)
	           .doubleValue());
	       sheet.addCell(labelN);
	      }
	    }
	   }

	   /************������д�����ݶ���д�ڻ����еģ���һ�佫���������д���ļ���*********/
	   workbook.write();
	   /***********�ر��ļ�**************/
	   workbook.close();

	  } catch (Exception e) {
	   e.printStackTrace();
	   log.error("�������EXCEL�Ĺ����г��ִ��󣬴���ԭ��" + e.toString());
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
