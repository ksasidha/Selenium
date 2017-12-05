package com.MMP.project;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MMP.project.Pages.CurrentAppointmentPage;
import com.MMP.project.Pages.HomePage;
import com.MMP.project.Pages.LoginPage;
import com.MMP.project.Pages.NavigationPanel;
import com.MMP.project.Pages.PatientDetails;
import com.MMP.project.Pages.PatientLogin;
import com.MMP.project.Pages.RegisterPage;
import com.MMP.project.TestBase.TestBase;
import com.MMP.project.Utils.ExcelReader;

public class PatientPortal extends TestBase {
//changes made
	//Added new changes 
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser","url"})
	public void set(String browser,String url)
	{
		try
		{selectBrowser(browser);
		geturl(url);
		}
		catch(Exception e)
		{
			
			System.out.println("not set up");
		}
	}

	@Test(priority=0 ,description="Register Patient",groups= {"regression"})
	public void TC_001_register()
	{      
		try

		{ExcelReader er=new ExcelReader();
		er.ExcelRead(System.getProperty("user.dir")+"\\src\\main\\java\\com\\MMP\\project\\Utils\\TestData.xlsx");
		for (int i=1;i<=er.getrowcount(0);i++)
		{

			LoginPage login=new LoginPage(driver);
			//how to assigne th epage?
			login.pLogin();
			//Click on the Patient Register
			RegisterPage register=login.patientRegister();
			//RegisterPage register=new RegisterPage(driver);
			//Enter Patient details
			login=register.registerPatient(er.getCelldata(0,i,0), er.getCelldata(0,i,1), er.getCelldata(0,i,2), er.getCelldata(0,i,3),
					er.getCelldata(0,i,4), er.getCelldata(0,i,5), er.getCelldata(0,i,6), 
					er.getCelldata(0,i,7), er.getCelldata(0,i,8), er.getCelldata(0,i,9),
					er.getCelldata(0,i,10), er.getCelldata(0,i,11),	er.getCelldata(1,i,6), er.getCelldata(1,i,7), er.getCelldata(1,i,0),
					er.getCelldata(1,i,1), er.getCelldata(1,i,2), er.getCelldata(1,i,3), er.getCelldata(1,i,4), er.getCelldata(1,i,5));

			//Verify the Homelink is present on the Login page for successful registration
			Boolean actual=login.verifyHomelink();
			if (actual )
			{
				Assert.assertTrue(true);

			}
		}


		}
		catch(Exception e)
		{

			Assert.fail("TC_001_Register Failed"+e.getMessage());
		}
	}
	
	
	
    @Test(priority=1 ,description="Patient Login",groups= {"sanity"})
	public void TC_002_login()
	{
		try {

			ExcelReader er=new ExcelReader();
			er.ExcelRead(System.getProperty("user.dir")+"\\src\\main\\java\\com\\MMP\\project\\Utils\\TestData.xlsx");
			for(int i=1;i<=er.getrowcount(0);i++)
			{
				//click on th elogin link
				LoginPage login=new LoginPage(driver);
				login.pLogin();
				login.patientLogin();
				//Enter Login info
				PatientLogin loginPatient=new PatientLogin(driver);
				loginPatient.loginPatient(er.getCelldata(1, i, 2),er.getCelldata(1, i, 1));
				
				//To check successful Login check the presence of the profile link

				NavigationPanel np=new NavigationPanel(driver);
				Boolean actual=np.verifyLogin();
				Assert.assertTrue(actual);

				
			}
		}
		catch(Exception e)
		{

			Assert.fail("TC_002_login Failed");
		}

	}
     @Test(priority=2,description="Edit PAtientProfile" ,dependsOnMethods="TC_002_login")
	public void TC_004_editProfile() 
	{

		try {
			
			ExcelReader er=new ExcelReader();
			er.ExcelRead(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\mmp\\Utils\\TestData.xlsx");
			for (int i=1;i<=er.getrowcount(0);i++)
			{
			NavigationPanel np=new NavigationPanel(driver);
			np.selectProfile();
			PatientDetails ptDetails=new PatientDetails(driver);
			ptDetails.editPatientProfile(er.getCelldata(3, i, 0), er.getCelldata(3, i, 1));			
			Boolean actual=ptDetails.verifyEditButtonPresent();			
			Assert.assertTrue(actual);

			}
		}
		catch(Exception e)
		{

			Assert.fail("TC_004_editProfile Failed");
		}
	
	}

	//@Test(priority=3,description="Schedule an appointment",enabled=true,dependsOnMethods="TC_002_login",groups= {"regression"})
	public void TC_003_scheduleAppoinment() throws IOException, Exception
	{   

		try
		{
			
			ExcelReader er=new ExcelReader();
		er.ExcelRead(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\mmp\\Utils\\TestData.xlsx");

		/*LoginPage login=new LoginPage(driver);
		login.Login();
		PatientLogin patientLogin=new PatientLogin(driver);
		patientLogin.loginPatient(username, password);*/

		for (int i=1;i<=er.getrowcount(2);i++)
		{
			NavigationPanel dboard=new NavigationPanel(driver);
			dboard.selectScheduleAppointment();
			CurrentAppointmentPage appointmentPage= new CurrentAppointmentPage(driver);
			appointmentPage.clickonCreateAppoinment();
			appointmentPage.chooseDoctor(er.getCelldata(2, i, 0));
			appointmentPage.BookAppointment(er.getCelldata(2, i, 1), er.getCelldata(2, i, 2),er.getCelldata(2, i, 3));
			HomePage hPage=new HomePage(driver);
			Boolean actual=hPage.verifyPatientPresent(er.getCelldata(2, i, 1), er.getCelldata(2, i, 2),er.getCelldata(2, i, 3),er.getCelldata(2, i, 0));
			
			if(actual)
			{
				Assert.assertTrue(true);
				
			}
		}
		}
		catch(Exception e)
		{

			Assert.fail("TC_003_scheduleAppoinment Failed");
		}

	}
	@AfterTest(alwaysRun=true)
	public void closeBrowser()
	{

		driver.quit();
	}

}
