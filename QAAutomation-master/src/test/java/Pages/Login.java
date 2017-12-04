
  package Pages;

  import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




  public class Login {
	  WebDriverWait  wait = null;
	  WebDriver driver;
  	
  	@FindBy(id="Email")
  	 WebElement Email;
  	
  	@FindBy(id="Password")
  	 WebElement Pass;
  	
  	@FindBy(id="btnEnter")
  	 WebElement logButton;
  	
  	@FindBy(xpath=".//*[@id='navbarmenu']/ul/li/a/span[@title='Logout']")
  	WebElement logoutButton;
 


  	
  	public Login(WebDriver driver)
  	{ 	this.driver=driver;
  	    PageFactory.initElements(driver, this);
  	}
  	
 


	public Login() {
		// TODO Auto-generated constructor stub
	}
    
	public void setUsername(String email) {
		Email.clear();
		Email.sendKeys(email);
	}
	public void setPassword(String pass) {
		Pass.clear();
		Pass.sendKeys(pass);
		
	}
    public void clickLogin() {
    
    	logButton.click();
    }


	public  void logintoApplication(String email,String pass)
  	{
		setUsername(email);
		setPassword(pass);
  		clickLogin(); 		
  		
  	}
  

}
