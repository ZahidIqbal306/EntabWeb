package Entab.ERP.Tests;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Entab.ERP.Pages.LoginPage;
import Entab.ERP.TestComponents.BaseTest;

public class LoginVerification extends BaseTest
{
	@Test
	public void verifyLogin() throws IOException, InterruptedException
	{
		String actualLogintext = loginPage.verifyLoginPage();
		Assert.assertEquals(actualLogintext, "Enter the registered mobile no. with school");		
		String dashboardText = loginPage.loginApplication();		
		boolean flag = dashboardText.contains("Dashboard");
		Assert.assertEquals(flag, true);
		System.out.println("User is logged in successfuly.");
	}

}
