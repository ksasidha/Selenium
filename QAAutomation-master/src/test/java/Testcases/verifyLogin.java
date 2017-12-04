package Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.Login;
import Utils.ExcelRead;

public class verifyLogin {

  WebDriver driver=null;
	Login l;
	HomePage hp;
	@BeforeTest
	
	public void Setup()
	{
		System.setProperty("webdriver.ie.driver","C:\\Kripa\\Softwares\\IEdriver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get("https://qa.doverbayadmin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
		
	
/*	//@DataProvider(name="userdata")
	public  Object[][] Userdata() throws Exception
	{
 		Object[][] data=testdata("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx","Sheet1");
	    return data;
	}

	public  Object[][] testdata(String path,String SheetName) throws Exception{
		Object[][] testObjArray=null;
	    er=new ExcelRead(path);
	    rowcount=er.getrowcount(SheetName);
	    columncount=er.getcolumncount(SheetName);
	    testObjArray = new Object [rowcount][columncount];
	    for (int i=1 ;i<=rowcount;i++) {  		   		 
			 for (int j=0;j<columncount;j++) {  				
 				 testObjArray[i-1][j]=er.getCelldata(SheetName, i, j); }		
	  		 }return testObjArray;
		}
	*/
	
  @Test
  public void verifyvalidlogin() throws IOException{
	 	  //l.logintoApplication(er.getCelldata("Sheet1", i, 0);
	  ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx");
	   
	  for (int i=1;i<=er.getrowcount(0);i++)
	  {
	  l=new Login(driver);
	  l.setUsername(er.getCelldata(0, i, 0));
	  l.setPassword(er.getCelldata(0, i, 1));
	  l.clickLogin();
	  hp=new HomePage(driver);
	  boolean verifyText=hp.verifyText();
	  Assert.assertTrue(verifyText);
	  hp.logout();
	  }
	  }
  
  @AfterTest
  
  public void CloseBrowser()
  {
  	driver.close();
  }
}
