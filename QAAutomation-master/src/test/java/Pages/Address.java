package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ksasidharan
 *
 */
public class Address {
    WebDriver driver;

@FindBy(id="LAddress1")
WebElement  rAddress1;

@FindBy(id="LAddress2")
WebElement  rAddress2;

@FindBy(id="LCity")
WebElement  rCity;

@FindBy(id="LCode1")
WebElement  rzip;

@FindBy(id="MAddress1")
WebElement  mAddress1;

@FindBy(id="MAddress2")
WebElement  mAddress2;

@FindBy(id="MCity")
WebElement  mCity;

@FindBy(id="MCode1")
WebElement  mzip;

@FindBy(id="DiffMailingAddressReason")
WebElement  diffMailingAddress;

@FindBy(xpath=".//*[@class='sweet-alert showSweetAlert visible']")
WebElement sweetAlert;

@FindBy(xpath="//button[@class='confirm']")
WebElement confirm;

  
public Address(WebDriver driver) {
	  
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  
  }

public void setriskAddress1(String address1) throws Exception
{
	rAddress1.clear();
	rAddress1.sendKeys(address1);
	

}
public Boolean checkAddressExists() throws InterruptedException 
{
	Thread.sleep(500);
	try{
	if (sweetAlert.isDisplayed())
					{return true;
	}}
	catch(Exception e){}
	return false;
	}
public void clicksweetalert()
{
	confirm.click();
}

public void setriskaddress2(String address2) throws Exception 
{  
	
	rAddress2.clear();
	Boolean dupaddress=checkAddressExists();
	   if (dupaddress)
	   {
		  clicksweetalert();
	   }
	rAddress2.sendKeys(address2);

}
public void setriskCity(String city)
{
	rCity.clear();
	rCity.sendKeys(city);

}

public void setriskZip(String zip)
{
	rzip.clear();
	rzip.sendKeys(zip);

}

public void setmAddress1(String address1)
{
	mAddress1.clear();
	mAddress1.sendKeys(address1);

}
public void setmaddress2(String address2)
{
	mAddress2.clear();
		mAddress2.sendKeys(address2);

}
public void setmCity(String city)
{
	mCity.clear();
	mCity.sendKeys(city);

}

public void setmZip(String zip)
{
	mzip.clear();
	mzip.sendKeys(zip);

}
public void setMailingAddressDiff(String diff) {
	diffMailingAddress.clear();
	diffMailingAddress.sendKeys(diff);
}


public void setPState(String state)
{
   //driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
   WebDriverWait wait = new WebDriverWait(driver, 10);
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='LAddress']/div[4]/div[2]/span/span/span[1]")))).click();;
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
public void setMState(String state)
{
   //driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
   WebDriverWait wait = new WebDriverWait(driver, 10);
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmAppAddress']/div[2]/div[7]/div[2]/span/span/span[1]")))).click();;
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

public void setCounty_Parish(String county)
{
	//driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmAppAddress']/div[2]/div[12]/div/span/span/span[1]")))).click();;
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));

	   List<WebElement> county1= (driver.findElements(By.tagName("li")));

	     for (WebElement parish:county1)
	         {
	          if (parish.getText().equals(county))
	            {
	        	  parish.click();
	        	  break;
	             }
	          }    

}


}
