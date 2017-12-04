package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Testcases.TestBase;

public class LoginPage extends TestBase{
	
	
	
	@FindBy(id="Email")
	WebElement Email;
	@FindBy(id="Password")
	WebElement Password;
	@FindBy(id="btnEnter")
	WebElement LoginButton;
		
	
	public void Loginpage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	public void Login()
	{
	
         Email.sendKeys("ksasidha@hotmail.com");
         Password.sendKeys("Avittom12");
         LoginButton.click();
	}
	
	

}
