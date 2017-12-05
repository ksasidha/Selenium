package com.MMP.project.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.MMP.project.Library.Library;

public class CurrentAppointmentPage {

	private WebDriver driver;
	
	By createappoitnmentButton=By.xpath("//a/input");
	By doctorsList=By.xpath("//table//tr/td//h4");
	By bookAppoinmentButton=By.xpath("(.//*[@id='opener'])");
	By bookAppt=By.id("ui-id-2");
	By date=By.id("datepicker");
	By time=By.id("time");
	By continueButton=By.id("ChangeHeatName");
	By symptom=By.id("sym");
	By submit=By.xpath("(//input)[6]");
	By mframe=By.id("myframe");
	
	
	
	public CurrentAppointmentPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void clickonCreateAppoinment()
	{
		driver.findElement(createappoitnmentButton).click();
		
	}
	
	public void chooseDoctor(String data)
	{
		
		List <WebElement> doctors=driver.findElements(doctorsList);
		List <WebElement> bookButton=driver.findElements(bookAppoinmentButton);
		  for (int i=0;i<=doctors.size();i++)
		  {
			  if(doctors.get(i).getText().contains(data))
			  {
				  bookButton.get(i).click();
				  break;
			  }
		  }
	}
	
	public void selectAppointmentDate(String apptDate)
	{
		/* Date dt= new Date();
		 SimpleDateFormat sm = new SimpleDateFormat("MM/dd/yyyy");
		 Library.waitforelementtobeclickable(driver,date,30);*/
		 driver.findElement(date).sendKeys(apptDate);
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[1].value=arguments[0];",sm.format(dt),apptDate);
		*/
	}
	
	public void selectAppoinmentTime(String apptTime)
	{
		Select time = new Select(driver.findElement(By.id("time")));
		time.selectByVisibleText(apptTime);
		
		
	}
	
	public void clickonContinueButton()
	{
		driver.findElement(continueButton).click();
		
	}
	public void enterSymptoms(String symptoms)
	{
		driver.findElement(symptom).sendKeys(symptoms);
		
	}
	
	public void clickSubmit()
	{
				
		driver.findElement(submit).click();
		
	}
	
		
	
	public void BookAppointment(String date,String time,String symp) throws InterruptedException
	{    
		//Library.waitforelementtobevisible(driver, mframe, 60);
		if(driver.findElement(bookAppt).isDisplayed())
		{
			
			driver.switchTo().frame("myframe");
		}
		
		selectAppointmentDate(date);
		selectAppoinmentTime(time);
		clickonContinueButton();
		enterSymptoms(symp);
		clickSubmit();
	}
}
