package com.MMP.project.Library;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {

	
	public static void captureScreenshot(WebDriver driver) throws IOException
	{//change
		TakesScreenshot tsh=(TakesScreenshot)driver;
		
		//Strore in temp location
		File fs=tsh.getScreenshotAs(OutputType.FILE);
		
		//Copy the file from one location to another 
		
		Calendar cal= Calendar.getInstance();
		
		File destFile=new File("C:\\ScreenShot\\opemmrs"+cal.getTimeInMillis()+".jpg");
		FileUtils.copyFile(fs, destFile);
		
		
	}
	public static void  waitforelementtobeclickable(WebDriver driver,By locator,long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));


	}
	
	public static void  waitforalert(WebDriver driver,long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.alertIsPresent());


	}
	
	
	public static void waitforelementtobevisible(WebDriver driver,By locator,long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


	}
	
	public static void waitforframetobevisible(WebDriver driver,By mframe,long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mframe));


	}
	
	public static void waitforelementstobevisible(WebDriver driver,By element,long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));


	}
	
	
	
	public static  WebElement findElement(WebDriver driver, WebElement locator,long timeinsecs)
	{
	     Wait wait = new FluentWait(driver).withTimeout(timeinsecs, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).
	    		 ignoring(NoSuchElementException.class);
	     WebElement  e=(WebElement)  wait.until(ExpectedConditions.visibilityOf( locator));
	     return e;
	     
	}
	public static List <WebElement> findElement(WebDriver driver, List<WebElement> locator,long timeinsecs)
	{
	     Wait wait = new FluentWait(driver).withTimeout(timeinsecs, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).
	    		 ignoring(NoSuchElementException.class);
	     List <WebElement>  e=(List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements( locator));
	     return e;
	     
	}
}
