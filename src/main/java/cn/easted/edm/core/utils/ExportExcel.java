/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年9月19日 下午5:23:48   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.utils;

import java.io.BufferedOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 导出EXCEL
 * @ClassName:ExportExcel
 * @author:Wanghao
 * @date: 2017年9月19日 下午5:23:48
 */
public class ExportExcel<T> {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportExcel(String[] headers,Collection<T> dataset, String fileName, HttpServletResponse response) {  
        // 声明一个工作薄  
        XSSFWorkbook workbook = new XSSFWorkbook();  
        // 生成一个表格  
        XSSFSheet sheet = workbook.createSheet(fileName);  
        // 设置表格默认列宽度为15个字节  
        sheet.setDefaultColumnWidth((short) 50);  
        sheet.setColumnWidth(0,1024);  
        sheet.setColumnWidth(1,512);  
        sheet.setColumnWidth(2,10240);  
        sheet.setColumnWidth(3,10240);  
        sheet.setColumnWidth(4,1024);  
        sheet.setColumnWidth(5,5120);  
        sheet.setColumnWidth(6,2560);  
        sheet.setColumnWidth(7,2560);
        sheet.setColumnWidth(8,5120);  
        sheet.setColumnWidth(9,5120);  
        sheet.setColumnWidth(10,2560);  
        sheet.setColumnWidth(11,10240);  
        sheet.setColumnWidth(12,10240);  
        sheet.setColumnWidth(13,2560);  
        sheet.setColumnWidth(14,2560);  
        sheet.setColumnWidth(15,5120);  
        // 产生表格标题行  
        XSSFRow row = sheet.createRow(0);  
        XSSFCellStyle cellStyleTitle = workbook.createCellStyle();
        // 指定单元格居中对齐  
        cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 指定单元格垂直居中对齐  
        cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyleTitle.setDataFormat((short) 4);
        
        XSSFFont font = workbook.createFont();  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 250);  
        cellStyleTitle.setFont(font);  
        for (short i = 0; i < headers.length; i++) {  
            XSSFCell cell = row.createCell(i);  
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);  
            cell.setCellValue(text);
            cell.setCellStyle(cellStyleTitle);
        }  
        try {  
            // 遍历集合数据，产生数据行  
            Iterator<T> it = dataset.iterator();  
            int index = 0;  
            while (it.hasNext()) {  
                index++;  
                row = sheet.createRow(index);  
                T t = (T) it.next();  
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < headers.length; i++) {  
                    XSSFCell cell = row.createCell(i);
                    Field field = fields[i];  
                    String fieldName = field.getName();  
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);  
                    Class tCls = t.getClass();  
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = null;
                    if ("getStatus".equals(getMethod.getName())){
                    	 value = getMethod.invoke(t, new Object[] {}); 
                    	if (value != null  && value != "" && value == "1"){
                    		value = "授权未完成";
                    	} else{
                    		 value = "授权完成";  
                    	}
                    }else if ("getDate".equals(getMethod.getName())){
                    	value = getMethod.invoke(t, new Object[] {});
                    	DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    	value = formater.format(value);
                    }else{
                    	 value = getMethod.invoke(t, new Object[] {}); 
                    }
                    
                    // 判断值的类型后进行强制类型转换  
                    String textValue = null;  
                    // 其它数据类型都当作字符串简单处理  
                    if(value != null && value != ""){  
                        textValue = value.toString();  
                    }  
                    if (textValue != null) {  
                        XSSFRichTextString richString = new XSSFRichTextString(textValue);  
                        cell.setCellValue(richString);  
                    }  
                }  
            }  
            getExportedFile(workbook, fileName,response);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
    }  
      
    /** 
     *  
     * 指定路径下生成EXCEL文件 
     * @return 
     */  
    public void getExportedFile(XSSFWorkbook workbook, String name,HttpServletResponse response) throws Exception {  
        BufferedOutputStream fos = null;  
        try {  
            String fileName = name + ".xlsx";  
            response.setContentType("application/x-msdownload");  
            response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ));  
            fos = new BufferedOutputStream(response.getOutputStream());  
            workbook.write(fos);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (fos != null) {  
                fos.close();  
            }  
        }  
    }  
  
}
