package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientManagement {
	
	//adding comment to code to
	// changing the doo
	@FindBy(id="firstName")
	WebElement fName;
	
	
	@FindBy(id="lastName")
	WebElement lName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(id="PAddress1")
	WebElement pAddress1;
	
	@FindBy(id="PAddress2")
	WebElement pAddress2;
	
	@FindBy(id="PCity")
	WebElement pCity;
	
	@FindBy(id="PZip")
	WebElement pZip;

	@FindBy(id="MAddress1")
	WebElement mAddress1;
	
	@FindBy(id="MAddress2")
	WebElement mAddress2;
	
	@FindBy(id="MCity")
	WebElement mCity;
	
	@FindBy(id="MZip")
	WebElement mZip;
	
	@FindBy(id="contactValue")
	WebElement contact;
	
	@FindBy(id="saveAndNewQuoteNew")
	WebElement CreateQuote;
	
	@FindBy(id="saveNew")
	WebElement saveclient;
	
	@FindBy(id="phyAddressModal")
	public
	WebElement pAddressmodal; 
	
	@FindBy(id="mailAddressModal")
	public
	WebElement mAddressmodal; 
	
	@FindBy(id="dupesModal")
	public
	WebElement cdupesModal; 
	
	

	WebDriver driver;
	
	public ClientManagement(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 
	}
	public void setFirstName(String fname)
	{
		
		fName.clear();
		fName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		
		lName.clear();
		lName.sendKeys(lname);
	}
	
	public void setEmail(String cEmail)
	{
		
		email.clear();
		email.sendKeys(cEmail);
		System.out.println("do it");
	}
	public void setDOB(String dateob)
	{
		
		dob.clear();
		dob.sendKeys(dateob);
	}
	
	public void setPAddress1(String paddress1)
	{
		
		pAddress1.clear();
		pAddress1.sendKeys(paddress1);
	}
	public void setPAddress2(String paddress2)
	{
		
		pAddress2.clear();
		pAddress2.sendKeys(paddress2);
		
	}
	public void setPcity(String pcity)
	{
		
		pCity.clear();
		pCity.sendKeys(pcity);
		
	}
    public void setPState(String state)
    {
       //driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")))).click();;
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));    	   	
       
       List<WebElement> PState= (driver.findElements(By.tagName("li")));

         for (WebElement State:PState)
             {
              if (State.getText().equals(state))
                {
            	  State.click();
            	  break;
                 }
              }    
  
      }
	
    public void setMzip(String mzip)
    {
    	mZip.clear();
    	mZip.sendKeys(mzip);
    	
    }
    
	public void setMAddress1(String maddress1)
	{
		
		mAddress1.clear();
		mAddress1.sendKeys(maddress1);
	}
	public void setMAddress2(String maddress2)
	{
		
		mAddress2.clear();
		mAddress2.sendKeys(maddress2);
		
	}
	public void setMcity(String mcity)
	{
		
		mCity.clear();
		mCity.sendKeys(mcity);
		
	}
    public void setMState(String state)
    {
       driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[15]/div[2]/span/span[1]/span[1]")).click();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));

       List<WebElement> PState= (driver.findElements(By.tagName("li")));

         for (WebElement State:PState)
             {
              if (State.getText().equals(state))
                {
            	  State.click();
            	  break;
                 }
              }    
  
      }
	
    public void setPzip(String pzip)
    {
    	pZip.clear();
    	pZip.sendKeys(pzip);
    }	
    public void setContact(String Contact)
    {
    	contact.clear();
    	contact.sendKeys(Contact);
    }	
 
    
    public void createNewQuote() throws Exception
    {
    	CreateQuote.click();
    	
    	Boolean paddressvalidation=checkPAValidation();
   	 if (paddressvalidation)
	  {
		  paddressValidation();
	  }
   	 
   	Boolean maddressvalidation=checkMAValidation();
		  if (maddressvalidation)
		  {
			 maddressValidation();

		  }
		 Boolean dupesmodal=checkdupesmodal();
		 
		 if (dupesmodal)
		 {selectDupesModal();}
		 	 
		    
		 
		/* WebDriverWait wait = new WebDriverWait(driver, 60);
    	wait.until(ExpectedConditions.visibilityOf(pAddressmodal));
    	if (pAddressmodal.isDisplayed())
    	{pAddressValidation();}
    	wait.until(ExpectedConditions.visibilityOf(mAddressmodal));
    	if (mAddressmodal.isDisplayed())
    	{mAddressValidation();}
    	wait.until(ExpectedConditions.visibilityOf(cdupesModal));
    	if (cdupesModal.isDisplayed())
    	{selectDupesModal();}*/
			
    }
    
    
       
   public Boolean checkPAValidation() throws Exception {
	   /* WebDriverWait wait = new WebDriverWait(driver, 60);
    	wait.until(ExpectedConditions.visibilityOf(pAddressmodal));*/
	   Thread.sleep(500);
	    try
	    {if (pAddressmodal.isDisplayed()) {
	    	 return true;}
	     }	 
	    catch(Exception e) {}
	     return false;
   }
   public Boolean checkMAValidation() throws Exception {
	    /*WebDriverWait wait = new WebDriverWait(driver, 60);
   	   wait.until(ExpectedConditions.visibilityOf(mAddressmodal));*/
	   Thread.sleep(500);
	     try{
	    	 if (mAddressmodal.isDisplayed())
	    	 {
	    	 return true;
	         }
	     } 
	     catch (Exception e)
	     {}
	     
		return false;
  }
   public boolean checkdupesmodal() throws Exception
   {
	   /*WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(cdupesModal));*/
	   Thread.sleep(500);
	  	   if (cdupesModal.isDisplayed()) {
		   
         return true;}
	   
	   else
	     return false;}
   
   public void paddressValidation()
   {   WebDriverWait wait = new WebDriverWait(driver, 30);
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useUSPSPhys"))));
	   if (driver.findElement(By.id("useUSPSPhys")).isDisplayed())
 	   {
 		   driver.findElement(By.id("useUSPSPhys")).click();
 	   }
 	   else 
 	   {
 		   driver.findElement(By.id("useEnteredPhys")).click();
 	   }
   }
   public void maddressValidation()
   {   WebDriverWait wait = new WebDriverWait(driver, 30);
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useUSPSMail"))));
	   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
 	   {
 		   driver.findElement(By.id("useUSPSMail")).click();
 	   }
 	   else 
 	   {
 		   driver.findElement(By.id("useEnteredMail")).click();
 	   }
   }
   
    /*public void pAddressValidation()
    {  WebDriverWait wait = new WebDriverWait(driver, 60);
    	if (wait.until(ExpectedConditions.visibilityOf(pAddressmodal)).isDisplayed())
        {
     	   //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useUSPSPhys"))));
     	   if (driver.findElement(By.id("useUSPSPhys")).isDisplayed())
     	   {
     		   driver.findElement(By.id("useUSPSPhys")).click();
     	   }
     	   else 
     	   {
     		   driver.findElement(By.id("useEnteredPhys")).click();
     	   }
        }
        
    	
    }*/
    /*public void mAddressValidation() {
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	if (wait.until(ExpectedConditions.visibilityOf(mAddressmodal)).isDisplayed())
        {
     	   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
     	   {
     		   driver.findElement(By.id("useUSPSMail")).click();
     	   }
     	   else 
     	   {
     		   driver.findElement(By.id("useEnteredMail")).click();
     	   }
        }
        */
    
    public void selectDupesModal()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finalSubmit")))).isDisplayed())
   	 {
   		 
   		 driver.findElement(By.id("finalSubmit")).click();
   	 }
   	 
    }
  
    
    public void saveClient()
    {
    	saveclient.click();
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	wait.until(ExpectedConditions.visibilityOf(pAddressmodal));
    	if (pAddressmodal.isDisplayed())
    	{paddressValidation();}
    	wait.until(ExpectedConditions.visibilityOf(mAddressmodal));
    	if (mAddressmodal.isDisplayed())
    	{maddressValidation();}
    	wait.until(ExpectedConditions.visibilityOf(cdupesModal));
    	if (cdupesModal.isDisplayed())
    	{selectDupesModal();}
    }
	
    
}
