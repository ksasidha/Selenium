package com.MMP.project.TestBase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	 protected static WebDriver driver;
	 

	
	public static void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();		  
		}
		else if(browser.equalsIgnoreCase("CH"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();		  
		}

	}
	public static void geturl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	
	
}
