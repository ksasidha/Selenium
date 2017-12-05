package com.MMP.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientLogin {
	private WebDriver driver;

	public PatientLogin(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By username=By.id("username");
	By password=By.id("password");
	By submit=By.name("submit");
	
	public void setUsername(String userName)
	{
		
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(userName);
		
	}
	
	public void setPassword(String pass)
	{
		
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		
	}
	
	public void clickSubmit()
	{
		
		driver.findElement(submit).click();
	}
	
	public NavigationPanel loginPatient(String userName,String pass)
	{
		
		setUsername(userName);
		setPassword(pass);
		clickSubmit();
		return new NavigationPanel(driver);
	}
	
}
