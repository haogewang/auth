/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年9月1日 下午3:48:29   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:2017年9月1日 下午3:48:29  
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.easted.edm.core.model.TAuthmanagement;
import cn.easted.edm.web.exception.MyException;

/**
 * @ClassName:ExcelUtil
 * @author:Wanghao
 * @date: 2017年9月1日 下午3:48:29
 */
public class ExcelUtil {

	public static void main(String[] args) {
		readExcelToObj("C:\\Users\\Administrator\\Desktop\\rf.xlsx");  
	}
	 
	/**  
	* 读取excel数据  
	* @param path  
	*/  
	public static void readExcelToObj(String path) {  
	  
	Workbook wb = null;  
	try {  
	wb = WorkbookFactory.create(new File(path));  
	readExcel(wb, 0, 2, 0);  
	
	} catch (InvalidFormatException e) {  
	e.printStackTrace();  
	} catch (IOException e) {  
	e.printStackTrace();  
	}  
	}  
	

	
	
	/**  
	 * 读取excel文件  
	 * @param wb   
	 * @param sheetIndex sheet页下标：从0开始  
	 * @param startReadLine 开始读取的行:从0开始  
	 * @param tailLine 去除最后读取的行  
	 */  
	public static TAuthmanagement readExcel(Workbook wb, int sheetIndex, int startReadLine, int tailLine) {  
		Sheet sheet = wb.getSheetAt(sheetIndex);  
		Row row = null;  
		String value = null;
		TAuthmanagement excel = new TAuthmanagement();
		for(int i = startReadLine; i < sheet.getLastRowNum() - tailLine + 1 ; i++) {  
			row = sheet.getRow(i);  
			 excel = new TAuthmanagement();
			for(int j = 0; j < row.getLastCellNum(); j++) {  
				switch (j) {
				case 0:
					 value = getValueByCellNumber(sheet, row, excel, i, j);  
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
					try {
						excel.setDate(sdf.parse(value));
					} catch (ParseException e) {
						throw new MyException("100", "时间格式不正确");
					}
					break;
				case 1:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setAclient(value);
					break;
				case 3:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setProduct(value);
					break;
				case 4:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setType(value);
					break;
				case 5:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setSuperveneNumber(value);
					break;
				case 6:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setSerinumber(value);
					break;
				case 7:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setAuthorizationcode(value);
					break;
				case 8:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setServernumber(value);
					break;
				case 9:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setBclientMachinecode(value);
					break;
				case 10:
					value = getValueByCellNumber(sheet, row, excel, i, j);  
					excel.setBauthSerilizenumber(value);
					break;

				default:
					break;
				}
			}  
			System.out.println(excel.toString());
		}
		return excel;  

	}

	/**
	 * @param sheet
	 * @param row
	 * @param excel
	 * @param i
	 * @param j  
	 */
	public static String getValueByCellNumber(Sheet sheet, Row row, TAuthmanagement excel, int i, int j) {
		boolean isMerge = isMergedRegion(sheet, i, j);  
		//判断是否具有合并单元格  
		String rs = null;
		if(isMerge) {  
			rs = getMergedRegionValue(sheet, row.getRowNum(), j);  
//			System.out.print(rs + "");  
//						cmap.put(Integer.valueOf(c.getColumnIndex()), c.toString());
//			excel.setDate(rs);
			
		}else {  
//						System.out.print(c.toString()+"");  
//						cmap.put(Integer.valueOf(c.getColumnIndex()), c.toString());
//			excel.setDate(rs);
			
//			rs = row.getCell(j).getStringCellValue();
			rs = getCellValue(row.getCell(j));
		}
		return rs;
	}  

	/**   
	 * 获取合并单元格的值   
	 * @param sheet   
	 * @param row   
	 * @param column   
	 * @return   
	 */    
	public static String getMergedRegionValue(Sheet sheet ,int row, int column){    
		int sheetMergeCount = sheet.getNumMergedRegions();    

		for(int i = 0 ; i < sheetMergeCount ; i++){    
			CellRangeAddress ca = sheet.getMergedRegion(i);    
			int firstColumn = ca.getFirstColumn();    
			int lastColumn = ca.getLastColumn();    
			int firstRow = ca.getFirstRow();    
			int lastRow = ca.getLastRow();    
			if(row >= firstRow && row <= lastRow){    
				if(column >= firstColumn && column <= lastColumn){    
					Row fRow = sheet.getRow(firstRow);    
					Cell fCell = fRow.getCell(firstColumn);    
					return getCellValue(fCell) ;    
				}    
			}    
		}    
		return null ;    
	}    

	/**  
	 * 判断合并了行  
	 * @param sheet  
	 * @param row  
	 * @param column  
	 * @return  
	 */  
	public static boolean isMergedRow(Sheet sheet,int row ,int column) {  
		int sheetMergeCount = sheet.getNumMergedRegions();  
		for (int i = 0; i < sheetMergeCount; i++) {  
			CellRangeAddress range = sheet.getMergedRegion(i);  
			int firstColumn = range.getFirstColumn();  
			int lastColumn = range.getLastColumn();  
			int firstRow = range.getFirstRow();  
			int lastRow = range.getLastRow();  
			if(row == firstRow && row == lastRow){  
				if(column >= firstColumn && column <= lastColumn){  
					return true;  
				}  
			}  
		}  
		return false;  
	}  

	/**  
	 * 判断指定的单元格是否是合并单元格  
	 * @param sheet   
	 * @param row 行下标  
	 * @param column 列下标  
	 * @return  
	 */  
	public static boolean isMergedRegion(Sheet sheet,int row ,int column) {  
		int sheetMergeCount = sheet.getNumMergedRegions();  
		for (int i = 0; i < sheetMergeCount; i++) {  
			CellRangeAddress range = sheet.getMergedRegion(i);  
			int firstColumn = range.getFirstColumn();  
			int lastColumn = range.getLastColumn();  
			int firstRow = range.getFirstRow();  
			int lastRow = range.getLastRow();  
			if(row >= firstRow && row <= lastRow){  
				if(column >= firstColumn && column <= lastColumn){  
					return true;  
				}  
			}  
		}  
		return false;  
	}  

	/**  
	 * 判断sheet页中是否含有合并单元格   
	 * @param sheet   
	 * @return  
	 */  
	public boolean hasMerged(Sheet sheet) {  
		return sheet.getNumMergedRegions() > 0 ? true : false;  
	}  

	/**  
	 * 合并单元格  
	 * @param sheet   
	 * @param firstRow 开始行  
	 * @param lastRow 结束行  
	 * @param firstCol 开始列  
	 * @param lastCol 结束列  
	 */  
	public void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {  
		sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));  
	}  

	/**   
	 * 获取单元格的值   
	 * @param cell   
	 * @return   
	 */    
	public static String getCellValue(Cell cell){    

		if(cell == null) return "";    
		if(cell.getCellType() == Cell.CELL_TYPE_STRING){    
			return cell.getStringCellValue();    
		}else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){    
			return String.valueOf(cell.getBooleanCellValue());    
		}else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){ 
			try{
				return cell.getRichStringCellValue().toString() ; 
			}catch(Exception e){
				return "0" ; 
			}
			   
		}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			return String.valueOf(cell.getNumericCellValue());  
		}    
		return "";    
	}    
	/**
	 * 获取随机序列号
	 * @param length
	 * @return
	 */
	  public static String getDefaultSerialzNumber(int length){
	    	 StringBuffer str = new StringBuffer();
	    	 int i = 0;
	    	 while (i < 5){
	    		 if (i < 4){
	    			 str.append(LocalUtils.getRandomString(length) + "-");
	    		 }else {
	    			 str.append(LocalUtils.getRandomString(length));
	    		 }
	    		 i++;
	    	 }
			return str.toString();
	    }
	  
	  public static String getDefaultAuthCode(){
		  StringBuffer str = new StringBuffer();
		  int i = 0;
		  while (i < 2){
			  //(int)(1+Math.random()*10000)
			 str.append((int)(Math.random()*(9999 - 1000 + 1)) + 1000);
			 i++;
		  }
		return str.toString();
	  }
}
