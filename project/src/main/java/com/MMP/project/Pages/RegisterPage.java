package com.MMP.project.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.MMP.project.Library.Library;

public class RegisterPage {

	private final WebDriver driver;



	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;

	}

	By firstname=By.id("firstname");
	By lastname=By.id("lastname");
	By dob=By.id("datepicker");
	By license=By.id("license");
	By ssn=By.id("ssn");
	By state=By.id("state");
	By city=By.id("city");
	By address=By.id("address");
	By zipcode=By.id("zipcode");
	By age=By.id("age");
	By height=By.id("height");
	By weight=By.id("weight");
	By pharmacy=By.id("pharmacy");
	By pharmaaddress=By.id("pharma_adress");
	By email=By.id("email");
	By password=By.id("password");
	By username=By.id("username");
	By confirmpassword=By.id("confirmpassword");
	By security=By.id("security");
	By answer=By.id("answer");
	By saveButton=By.name("register");



	public void setFirstName(String fname) throws IOException
	{  Library.waitforelementtobeclickable(driver, firstname, 90);

	driver.findElement(firstname).clear();
	driver.findElement(firstname).sendKeys(fname);
	Library.captureScreenshot(driver);


	}
	public void setLastName(String lname) throws IOException
	{driver.findElement(lastname).clear();
	driver.findElement(lastname).sendKeys(lname);
	Library.captureScreenshot(driver);
	}
	public void setDob(String dofb) throws IOException
	{	driver.findElement(dob).clear();
	driver.findElement(dob).sendKeys(dofb);
	Library.captureScreenshot(driver);
	}
	public void setLicense(String lic) throws IOException
	{	driver.findElement(license).clear();
	driver.findElement(license).sendKeys(lic);
	Library.captureScreenshot(driver);
	}
	public void setSSN(String social) throws IOException
	{	driver.findElement(ssn).clear();
	driver.findElement(ssn).sendKeys(social);
	Library.captureScreenshot(driver);
	}
	public void setState(String pState) throws IOException
	{
		driver.findElement(state).clear();
		driver.findElement(state).sendKeys(pState);
		Library.captureScreenshot(driver);
	}
	public void setCity(String pCity) throws IOException
	{	driver.findElement(city).clear();
	driver.findElement(city).sendKeys(pCity);
	Library.captureScreenshot(driver);
	}
	public void setAddress(String pAddress) throws IOException
	{ 	driver.findElement(address).clear();
	driver.findElement(address).sendKeys(pAddress);
	Library.captureScreenshot(driver);
	}
	public void setZipcode(String zip) throws IOException
	{	driver.findElement(zipcode).clear();
	driver.findElement(zipcode).sendKeys(zip);
	Library.captureScreenshot(driver);
	}

	public void setAge(String pAge) throws IOException
	{	driver.findElement(age).clear();
	driver.findElement(age).sendKeys(pAge);
	Library.captureScreenshot(driver);
	}
	public void setHeight(String ht) throws IOException
	{	driver.findElement(height).clear();
	driver.findElement(height).sendKeys(ht);
	Library.captureScreenshot(driver);
	}
	public void setWeight(String wt) throws IOException
	{	driver.findElement(weight).clear();
	driver.findElement(weight).sendKeys(wt);
	Library.captureScreenshot(driver);
	}
	public void setPharmacy(String pharm) throws IOException
	{	driver.findElement(pharmacy).clear();
	driver.findElement(pharmacy).sendKeys(pharm);
	Library.captureScreenshot(driver);
	}
	public void setPharmacyAddress(String pharmAddress) throws IOException
	{	driver.findElement(pharmaaddress).clear();
	driver.findElement(pharmaaddress).sendKeys(pharmAddress);
	Library.captureScreenshot(driver);
	}

	public void setEmail(String pEmail) throws IOException
	{
		Library.waitforelementtobeclickable(driver, email, 90);
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(pEmail);
		Library.captureScreenshot(driver);
	}

	public void setPassword(String pass) throws IOException
	{driver.findElement(password).clear();
	driver.findElement(password).sendKeys(pass);
	Library.captureScreenshot(driver);
	}

	public void setUsername(String user) throws IOException
	{
		Library.waitforelementtobeclickable(driver, username, 30);
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
		Library.captureScreenshot(driver);
	}
	public void setConfirmPassword(String confirm) throws IOException
	{Library.waitforelementtobeclickable(driver, confirmpassword, 30);
	driver.findElement(confirmpassword).clear();
	driver.findElement(confirmpassword).sendKeys(confirm);
	Library.captureScreenshot(driver);
	}
	public void setSecurityQ(String securityQ) throws IOException
	{
		Select securQ = new Select(driver.findElement(security));
		securQ.selectByVisibleText(securityQ);
		Library.captureScreenshot(driver);
	}
	public void setanswer(String ans) throws IOException
	{
		driver.findElement(answer).clear();
		driver.findElement(answer).sendKeys(ans);
		Library.captureScreenshot(driver);
	}
	public LoginPage clickSave() throws IOException
	{   Library.waitforelementtobeclickable(driver, saveButton, 90);
	driver.findElement(saveButton).click();
	//verifyRegisterAlert();
	Library.captureScreenshot(driver);
	try
	{
	Library.waitforalert(driver,90);
	driver.switchTo().alert().accept();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return new LoginPage(driver);
	}

	public String verifyRegisterAlert() throws IOException
	{
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Library.captureScreenshot(driver);
		return text;
	}

	public LoginPage registerPatient(String fname,String lname,String dofb,String lic,
			String social,String pState,String pCity,String pAddress,String zip,String pAge,
			String ht,String wt,String pharm,String pharmAddress,String pEmail,String pass,
			String user,String confirm,String securityQ,String ans) throws InterruptedException, IOException
	{
		setFirstName(fname);
		setLastName(lname);
		setDob(dofb);
		setLicense( lic);
		setSSN(social);
		setState(pState);
		setCity(pCity);
		setAddress(pAddress);
		setZipcode(zip);
		setAge(pAge);
		setHeight(ht);
		setWeight(wt);
		setPharmacy(pharm);
		setPharmacyAddress(pharmAddress);
		setEmail(pEmail);
		setPassword(pass);
		setUsername(user);
		setConfirmPassword(confirm);
		setSecurityQ(securityQ);
		setanswer(ans);
		return clickSave();

	}

}


















