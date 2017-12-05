package com.MMP.project.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb=null;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell cell;
	int rowcount;
	int columncount;
	
	
 
  public void ExcelRead(String path) throws IOException
  {
	  
	  FileInputStream fis=new FileInputStream(path) ;
	  wb=new XSSFWorkbook(fis);
	 
	 
		   	  
  }
  public ExcelReader() 
  {
	  
	   
		   	  
  }
  

public String getCelldata(int sheetIndex,int rownum,int columnum)
  {
	 sh=wb.getSheetAt(sheetIndex);
	  cell=sh.getRow(rownum).getCell(columnum);
	  if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC ) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	          return  String.valueOf((dateFormat.format(cell.getDateCellValue())));
	        } else {
			return String.valueOf(cell.getNumericCellValue());}
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return "";
			
		}
	  /*String data=cell.getStringCellValue();
	  return data;
	  
	  */
	return null;
  }
  


public int getrowcount(int sheetIndex)
 {
	sh=wb.getSheetAt(sheetIndex);
	rowcount = sh.getLastRowNum();
	 return rowcount;
 }
public int getcolumncount(int sheetIndex)
{
	 sh=wb.getSheetAt(sheetIndex);
	 row=sh.getRow(0);
	 columncount=row.getLastCellNum();
	 return columncount;
}
}
