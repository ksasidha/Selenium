package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	XSSFWorkbook wb=null;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell cell;
	int rowcount;
	int columncount;
	
	
 
  public ExcelRead(String path) throws IOException
  {
	  
	  FileInputStream fis=new FileInputStream(path) ;
	  wb=new XSSFWorkbook(fis);
	 
	 
		   	  
  }
  
  

public String getCelldata(int sheetIndex,int rownum,int columnum)
  {
	 sh=wb.getSheetAt(sheetIndex);
	  cell=sh.getRow(rownum).getCell(columnum);
	  if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return "";
		}
	  /*String data=cell.getStringCellValue();
	  return data;*/
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


