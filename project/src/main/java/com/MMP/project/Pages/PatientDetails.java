package com.MMP.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MMP.project.Library.Library;

public class PatientDetails {

	
	private WebDriver driver;

	
	By provider=By.id("proinfo");
	By insurance=By.id("Insinfo");
	By saveButton=By.id("Sbtn");
	By editButton=By.id("Ebtn");
	
	public PatientDetails(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void clickEditButton()
	{   
		Library.waitforelementtobeclickable(driver,editButton,30);
		driver.findElement(editButton).click();
		
	}
	public void setProvider(String prov)
	{
		driver.findElement(provider).clear();
		driver.findElement(provider).sendKeys(prov);
	}
	public void setInsurance(String ins)
	{
		driver.findElement(insurance).clear();
		driver.findElement(insurance).sendKeys(ins);
		
	}
	public void clickSaveButton()
	{
		Library.waitforelementtobeclickable(driver, saveButton, 60);
		driver.findElement(saveButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String  getAlertText()
	{ 
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	public void acceptAlert()
	{  
		driver.switchTo().alert().accept();
		
	}
	
	public boolean verifyEditButtonPresent()
	{
		if(driver.findElement(editButton).isDisplayed())
		{
			return true;
		}
		return false;
	}
	public PatientDetails editPatientProfile(String prov,String ins)
	{   clickEditButton();
		setProvider(prov);
		setInsurance(ins);
		clickSaveButton();
		acceptAlert();
		getAlertText();
		acceptAlert();
		return new PatientDetails(driver);
	}
	
}
