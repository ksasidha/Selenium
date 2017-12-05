package com.MMP.project.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.MMP.project.Library.Library;

public class LoginPage {

	
	private WebDriver driver;
	By homelink=By.linkText("Home");
	By loginLink=By.linkText("Patient Login");

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By registerButton=By.linkText("Register");
	By patientLogin=By.linkText("Login");
	
	public LoginPage pLogin()
	{   Library.waitforelementtobeclickable(driver, loginLink, 90);
		driver.findElement(loginLink).click();
		try {
			Library.captureScreenshot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
		
	}
	public RegisterPage patientRegister()
	{  Library.waitforelementtobeclickable(driver, registerButton, 90);
		driver.findElement(registerButton).click();
		try {
			Library.captureScreenshot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RegisterPage(driver);
	}
	
	public PatientLogin patientLogin()
	{
		driver.findElement(patientLogin).click();
		return new PatientLogin(driver);
	}
	
	public void adminLogin()
	{
		
		
	}
	
	public Boolean verifyHomelink()
	{
		 Library.waitforelementtobeclickable(driver, homelink, 90);
		if(driver.findElement(homelink).isDisplayed())
		{
			
			return true;
		}
		return false;
	}
	

	
}
