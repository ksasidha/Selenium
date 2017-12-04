package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewQuotePAge {
  /*@FindBy(id=".//*[@id='ContactsDropDown-list']/div/child::ul/child::li")
  WebElement contact;*/
  
 /* @FindBy(id="SecondaryPolicyHolder")
  WebElement coapp;*/
  
  @FindBy(id="FName")
	  WebElement fName;
  
  @FindBy(id="LName")
  WebElement lName; 

  
  @FindBy(id="EmailAddress")
  WebElement emailAddress;
  
  @FindBy(id="ClientDOB")
  WebElement clientDOB;
	 
  @FindBy(id="SFName")
  WebElement coappFname;
  
  @FindBy(id="SLName")
  WebElement coappLname;
  
  @FindBy(id="SDob")
  WebElement coappDob;
  
  @FindBy(id="insurance")
  WebElement SFAuto;
    
  @FindBy(id="AutoPolicy")
  WebElement SFPNAuto;
  
  @FindBy(id="Flood")
  WebElement flood;
  
  @FindBy(id="DoverBayClient")
  WebElement DBClient;
  
  @FindBy(id="DoverBayPolNum")
  WebElement DBPNum;
  
  @FindBy(id="PriorCarrier")
  WebElement DBPCarr;
  
  @FindBy(id="bNextFake")
  WebElement nextButton;

 WebDriver driver;
  
  public NewQuotePAge(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
}
  
  public void setApplicanttype() {
	  
	  List <WebElement> coapplicant=driver.findElements(By.xpath(".//*[@id='AppType_listbox']/child::li"));	
	  
	 
	  if (!coapplicant.get(0).isSelected())
  {
		  coapplicant.get(0).isSelected();
  }
  }
  public boolean checkclientInfo(String fname,String lname,String email,String dob)
  {
	  String ActualFname = fName.getAttribute("value");
	  String ActualLname =lName.getAttribute("value");
	  String ActualEmail=emailAddress.getAttribute("value");
	  String Actualdob=clientDOB.getAttribute("value");
	  
	  if (ActualFname.equals(fname)&&(ActualLname.equals(lname))&&(ActualEmail.equals(email))&&(Actualdob.equals(dob)))
	      return true;
	  else
		  return false;
	  
  }
	  
 
public void setContact(String contact)

  {   driver.findElement(By.xpath(".//*[@id='frmAppPolicyHolder']/div[2]/div[7]/div/span/span/span[1]")).click();
	  driver.findElement(By.xpath(".//*[@id='ContactsDropDown-list']/div/child::ul/child::li[contains(text(),'"+contact+"')]")).click();	
		  
  }
public void setCoapp(String coApp) {
	     
	  List <WebElement> coapplicant=driver.findElements(By.xpath(".//*[@id='SecondaryPolicyHolder']"));	  
	   
	  	 if (coApp.equalsIgnoreCase("true"))
	  		coapplicant.get(0).click();
	  	 else
	  		coapplicant.get(1).click();	 
  }
  
  public void setCoappDetails(String coAppFname,String coAppLname,String coAppdob) {
	  
	  List <WebElement> coapplicant=driver.findElements(By.xpath(".//*[@id='SecondaryPolicyHolder']"));	 
	  if (coapplicant.get(0).isSelected())
	     {
  	 		coappFname.sendKeys(coAppFname);
  	 		coappLname.sendKeys(coAppLname);
  	 		coappDob.sendKeys(coAppdob);  	 		 
  	 	 }
}
  
  public void setSFAutoPolicy(String sfAuto)
  {
	  List <WebElement> sfAutoPolicy=driver.findElements(By.xpath(".//*[@id='Insurance']"));
  
       if (sfAuto.equalsIgnoreCase("Yes"))
    	   sfAutoPolicy.get(0).click();
       else
    	   sfAutoPolicy.get(1).click();
  
  }
  public void setSFAutoNumber(String autoNum)
  {
	  
	  SFPNAuto.sendKeys(autoNum);
  }
  public void  setFlood(String flood)
  {
	  List<WebElement>Flood=driver.findElements(By.xpath(".//*[@id='Flood']"));
	  if(flood.equalsIgnoreCase("Yes"))
			  {
		      Flood.get(0).click();
			  }
	  else
		  Flood.get(1).click();
  }
  public void setExDoverBayClient(String dbClient)
  {
	  List<WebElement>DBClient=driver.findElements(By.xpath(".//*[@id='DoverBayClient']"));
	     if(dbClient.equalsIgnoreCase("true"))
	     {
	    	 
	    	 DBClient.get(0).click();
	    	 
	     }
	     else
	    	 DBClient.get(1).click();
  }
  public void setPriorCarrier(String Pcarrier)
  {
	  DBPCarr.sendKeys(Pcarrier);
  }
  public void setDBPolicyNum(String DBPOlicy)
  {
	  DBPNum.sendKeys(DBPOlicy);
  }
  public void clickNext()
  {
	  nextButton.click();
	  
  }
  
}
