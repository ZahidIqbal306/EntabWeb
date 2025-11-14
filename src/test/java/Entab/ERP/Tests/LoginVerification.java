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
		String text = loginPage.loginApplication();
		boolean flag = text.contains("Dashboard");
		Assert.assertEquals(flag, true);
		System.out.println("User is logged in successfuly.");
	}

}
