package Testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.Login;
import Utils.ExcelRead;

public class TestLogin {
	WebDriver driver=null;
	Login l;
	HomePage hp;
	@BeforeTest
	
	public void Setup()
	{
		driver=new ChromeDriver();
		driver.get("https://qa.doverbayadmin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
		
	
 	@DataProvider(name="userdata")
  	public  Object[][] Userdata() throws Exception
  	{
   		Object[][] data=testdata("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx",0);
  	    return data;
  	}

  	public  Object[][] testdata(String path,int SheetNum) throws Exception{
  		Object[][] testObjArray=null;
  	    ExcelRead er=new ExcelRead(path);
  	    int rowcount=er.getrowcount(SheetNum);
  	    int columncount=er.getcolumncount(SheetNum);
  	    testObjArray = new Object [rowcount][columncount];
  	    for (int i=1 ;i<=rowcount;i++) {  		   		 
  			 for (int j=0;j<columncount;j++) {  				
   				 testObjArray[i-1][j]=er.getCelldata(SheetNum, i, j); }		
  	  		 }return testObjArray;
  		}
	
 	
    @Test(dataProvider="userdata")
    public void verifyvalidlogin(String email,String pass){
	  l=new Login(driver);
	  l.logintoApplication(email, pass);
	  hp=new HomePage(driver);
	  boolean verifyText=hp.verifyText();
	  Assert.assertTrue(verifyText);
	  hp.logout();
	  }
    
    @AfterTest
    
    public void CloseBrowser()
    {
    	driver.close();
    }
}
