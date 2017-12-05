package com.MMP.project.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.MMP.project.Library.Library;

public class NavigationPanel {



	private WebDriver driver;


	By patientlist=By.xpath("//table//tr");
	By patientDetails=By.xpath("//table//tr/td");

	By profile=By.xpath("(//a/span)[4]");
	By scheduleAppt=By.xpath("(//a/span)[5]");
	By searchSymp=By.xpath("(//a/span)[8]");








	public NavigationPanel(WebDriver driver)
	{

		this.driver=driver;
	}
    
	
	public void selectProfile()
	{
		
		driver.findElement(profile).click();
	}

	public void selectScheduleAppointment()
	{   Library.waitforelementtobeclickable(driver, scheduleAppt, 30);
		driver.findElement(scheduleAppt).click();
	}
	
	public void selectSearchSymptoms()
	{
		
		driver.findElement(searchSymp).click();
	}
	
	
	public boolean verifyLogin()
	{
		
		if(driver.findElement(profile).isDisplayed())
		{
			
			return true;
		}
		else return false;
	}

	public void  viewPatientdetails(String date,String time,String symptom,String doc)
	{
		List<WebElement> patient= driver.findElements(patientlist);

		for(int i=0;i<=patient.size();i++)
		{
			List<WebElement> patientdetails= driver.findElements(patientDetails);

			if(patientdetails.get(0).getText().contains(date)&&patientdetails.get(0).getText().contains(time)&&patientdetails.get(0).getText().contains(symptom)&&patientdetails.get(0).getText().contains(doc))
			{

				System.out.println("Viewed patient details");
			}

		}

	}



}
