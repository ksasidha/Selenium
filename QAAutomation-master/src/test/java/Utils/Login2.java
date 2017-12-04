package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login2 {

	 WebDriver driver;
  
@DataProvider(name="Authentication")
public  Object[][] Userdata() throws Exception

{
	
	Object[][] data=testdata("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx",0);
    return data;
}

public  Object[][] testdata(String path,int SheetNum) throws Exception{
       // Read rd=new Read();
     //Object[][] testObjArray = rd.getExcelData("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx","Sheet1");
	Object[][] testObjArray=null;
   ExcelRead er=new ExcelRead(path);
   int rowcount=er.getrowcount(SheetNum);
   int columncount=er.getcolumncount(SheetNum);
   
   testObjArray = new Object [rowcount][columncount];
   for (int i=1 ;i<=rowcount;i++)
		 
	 {
		 for (int j=0;j<columncount;j++)
		 {
			
			 
			 testObjArray[i-1][j]=er.getCelldata(SheetNum, i, j);
			 	//System.out.println(arrayExcelData[i-1][j]);
			
				// TODO Auto-generated catch block
				
		 
		 }
	 }return testObjArray;

	}
	  
	  @Test(dataProvider="Authentication")
	 public void  Login2(String email,String pass)
	 {    
		  
		  System.out.println(email);
		  System.out.println(pass);
		  String e=email.toString();
		  String p=pass.toString();
		  driver=new ChromeDriver();
		  driver.get("https://qa.doverbayadmin.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  		  
		  driver.findElement(By.id("Email")).sendKeys(e);
		  driver.findElement(By.id("Password")).sendKeys(p);
		  driver.findElement(By.id("btnEnter")).click();
		  driver.close();
             
	
	 }
	  public Login2()
	  {
		 
		  
	  }

}