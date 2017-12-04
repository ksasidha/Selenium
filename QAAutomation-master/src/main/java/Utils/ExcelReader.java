package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	
	XSSFWorkbook wb=null;
	static XSSFSheet sh;
	String SheetName;
	XSSFRow Row;
	static XSSFCell Cell;
	@Test
	public ExcelReader() throws IOException
	{
		
		//Create a work book
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\main\\java\\Utils\\Testdata.xls");
		
			wb=new XSSFWorkbook(fis);
		
			sh=wb.getSheet("Sheet1") ;
			
					
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 int Rowcount=sh.getLastRowNum()-sh.getFirstRowNum();
	 int columncount=Row.getLastCellNum();
	 System.out.println(Rowcount);
	 System.out.println(columncount);
	}
	
	
	public static String getCellData(int Rownum,int colnum)
	
	{
		
		Cell=sh.getRow(Rownum).getCell(colnum);
		String CellData=Cell.getStringCellValue();
		return CellData;
		
		
		
	}
	
	
	
	
	
}
