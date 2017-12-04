package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Writetoexcel {
	
	public static XSSFWorkbook wwb;
	public static XSSFSheet wsh;
	public static XSSFCell wCell;
	public static XSSFRow Row;
	
	
	  @Test
  public void Writetoexcel(int row,int col) throws Exception

  {	
  	FileInputStream fin;

  		fin = new FileInputStream(new File("C:\\Kripa\\Rating model v8.3 SF.xlsm"));
  		
  		wwb=new XSSFWorkbook(OPCPackage.open(fin));
  		wsh=wwb.getSheet("table rater") ;
  		FormulaEvaluator evaluator = wwb.getCreationHelper().createFormulaEvaluator();
  		wCell=null;
  		wCell=wsh.getRow(row).getCell(col);
  	   String  i="250";
  	    Row=wsh.getRow(23);
  	    wCell=Row.getCell(8);
  		//wCell.setCellValue(i);
  		CellValue value = evaluator.evaluate( wCell ) ;
  		System.out.println(value);
  		fin.close();
  		
  		FileOutputStream output_file =new FileOutputStream(new File ("C:\\Kripa\\Rating model v8.3 SF.xlsm"));  
          
          wwb.write(output_file); //write changes
            
          output_file.close();  //close the stream   

	  	
  	
  }

 


  }

  

