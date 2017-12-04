package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {
 	@FindBy(xpath=".//*[@id='navbarmenu']/ul/li[3]/a[@href='/auth/logout']")
  	WebElement logoutButton;
 	
 	@FindBy(xpath="//div[contains(@id,'sidebar-wrapper')]")
 	WebElement verifyNavBar;
 	
 	@FindBy(xpath="//div[contains(@id,'sidebar-wrapper')]")
 	WebElement startClientButton;
 
 	
 	
 	
 	//div[contains(@id,'ClientModal')]/child::div/child::div/child::div/following-sibling::div/a[contains(text(),'Start A New Client')]
 	//*[@id='ClientModal']/div/div/div[2]/a[contains(text(),'"+buttonName+"')]
 	

	WebDriver driver;
 	
 	public HomePage(WebDriver driver) {
 		this.driver=driver;
 		PageFactory.initElements(driver, this);
 	}
 	
 	
    @Test
    public void logout(){
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(logoutButton));
	 logoutButton.click();
    }
    
    public void clickNavigationBar(String menuName) {
    	driver.findElement(By.xpath("//div[contains(@id,'sidebar-wrapper')]/child::ul/child::li/child::a[contains(text(),'"+menuName+"')]")).click();    	    	
    	
    }
    
    public boolean verifyText() {
    	boolean TT=verifyNavBar.isDisplayed();
    	return TT;
    }
    
    public void Start_SearchClient(String buttonName)
    		
    {       
        WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ClientModal']/div/div/div[2]/a[contains(text(),'"+buttonName+"')]"))));
    	driver.findElement(By.xpath(".//*[@id='ClientModal']/div/div/div[2]/a[contains(text(),'"+buttonName+"')]")).click();    	
    }

}

