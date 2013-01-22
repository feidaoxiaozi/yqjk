package net.dbet.excel;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import jxl.Cell;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelFileUtil {
	//文件存放目录
	private static String FILE_DIRECTORY = "d:\\Excel";

	static {
		// 创建目录
		boolean exists = (new File(ExcelFileUtil.FILE_DIRECTORY)).exists();
		if (!exists) {
			new File(ExcelFileUtil.FILE_DIRECTORY).mkdir();
		}
	}

	/**
	 * 创建临时的文�?
	 * @return File
	 */
	public static File createTempFile() {
		String fileName = ExcelFileUtil.FILE_DIRECTORY + File.separator + Calendar.getInstance().getTimeInMillis() + ".xls";
		File file = new File(fileName);
		return file;
	}
	
	/**
	 * 将List生成Excel文件,并返回Excel文件的输出流
	 * @param title 标题
	 * @param list  要成才excel对象
	 * @param c     �?要生成的对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  final File write(String title, List list,Class c) {

		if (list == null || list.size() == 0 || c == null) {
			return null;
		}
		Refect refect = new RefectImpl();
		
		File file = ExcelFileUtil.createTempFile();
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 字体设置
		WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		int sheetNum = 0;

		WritableSheet sheet = workbook.createSheet("Sheet" + sheetNum, 0);
		Label titleLabel = new Label(0, 0, title, cellFormat);
		try {
			if (titleLabel != null)
				sheet.addCell(titleLabel);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

		// 写文�?
		String[] rowNames = refect.getFieldAnnotation(c);
		//首行显示
		for(int i = 0;i < rowNames.length;i++){
			Label label = null;
			label = new Label(i,1,rowNames[i],cellFormat);
			try {
				if (label != null)
					sheet.addCell(label);
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
		
		int row = 2;
		//数据显示
		for(int i = 0;i < list.size();i++){
			Object obj = list.get(i);
			List columnValues = refect.getFieldValue(obj);
			for(int j = 0;j < columnValues.size();j++){
				Label label = null;
				//超过5000条数据就再建�?个sheet，这里设置为3用于测试
				if (row > 100) {
					sheetNum++;
					sheet = workbook.createSheet("Sheet" + sheetNum, sheetNum);
					row = 1;
					WritableSheet newSheet = workbook.getSheet(0);
					Cell[] cells = newSheet.getRow(1);
					for (int k = 0; k < cells.length; k++) {
						Label newLabel = new Label(k, 0, cells[k].getContents(), cellFormat);
						try {
							sheet.addCell(newLabel);
						} catch (RowsExceededException e) {
							e.printStackTrace();
						} catch (WriteException e) {
							e.printStackTrace();
						}
					}
				}
					
				label = new Label(j, row, columnValues.get(j).toString());
				try {
					if (label != null)
						sheet.addCell(label);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
			row++;
		}

		// 保存
		try {
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
