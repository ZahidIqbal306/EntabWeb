package Entab.ERP.Tests;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.LoginPage;
import Entab.ERP.TestComponents.BaseTest;

public class HomePageVerification extends BaseTest
{
	String name = "ZAHID IQBAL";
	
	@Test (priority=1)
	public void verifyLoginUserName() throws IOException, InterruptedException
	{
		loginPage.verifyLoginPage();
		loginPage.loginApplication();		
		HomePage homePage = new HomePage(driver);
		String actualName = homePage.loginUserName();		
		Assert.assertEquals(actualName, name);
	}
	
	@Test(priority=2)
	public void verifyProfile() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		String actualName = homePage.profileText();
		Assert.assertEquals(actualName, "Profile");
	}
	
	@Test(priority=3, enabled= false)
	public void verifyChangePasswordText() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);		
		String actualName = homePage.changePasswordText();	
		Assert.assertEquals(actualName, "Change Password");
	}

}
