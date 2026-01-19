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
	String userId = "8287218191";

	@Test (priority=1)
	public void verifyLoginUserName() throws IOException, InterruptedException
	{
		loginPage.loginApplication();		
		HomePage homePage = new HomePage(driver);
		String actualName = homePage.loginUserName();		
		Assert.assertEquals(actualName, name);
	}
	
	// verifyProfile
	@Test(priority=2)
	public void verifyUserId() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		String actualName = homePage.loginUserId();
		Assert.assertEquals(actualName, "8287218191");
	}
	
	@Test(priority=3)
	public void verifyChangePasswordText() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);		
		String actualName = homePage.changePasswordText();	
		Assert.assertEquals(actualName, "Change Password");
	}
	
}
