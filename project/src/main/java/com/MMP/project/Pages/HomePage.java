package com.MMP.project.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.MMP.project.Library.Library;

public class HomePage {

	
	
	private WebDriver driver;
	
	By patientList=By.xpath("//table//tr");
	By patientDetails=By.xpath("//table//tr/td");

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public boolean verifyPatientPresent(String date,String time,String appt,String doc)
	{
	    Library.waitforelementstobevisible(driver, patientList, 60);
		List<WebElement> pList=driver.findElements(patientList);
		List<WebElement> pDetails=driver.findElements(patientDetails);
		
		
		for (int i=0;i<=pList.size();i++)
		  { 
			  
			if(pDetails.get(0).getText().contains(date) && pDetails.get(1).getText().contains(time) && pDetails.get(2).getText().contains(appt) && pDetails.get(3).getText().contains(doc.substring(3)) )
			  {
				  return true;
			  }
			
		  }
		return false;
		
	}
}
