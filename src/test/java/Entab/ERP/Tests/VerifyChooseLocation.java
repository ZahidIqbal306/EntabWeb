package Entab.ERP.Tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Entab.ERP.Pages.ChooseLocationPage;
import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.InventoryMenu;
import Entab.ERP.TestComponents.BaseTest;

public class VerifyChooseLocation extends BaseTest {
	
	@Test(priority=1)
	public void verifyChooseLocationPage() throws IOException, InterruptedException {
		
		loginPage.loginApplication();
		HomePage homePage = new HomePage(driver);
		homePage.selectModuleName("Inventory");
		InventoryMenu im = new InventoryMenu(driver);
		im.clickInventorySetting();
		ChooseLocationPage cp = new ChooseLocationPage(driver);
		String text = cp.mapChooseLocSubMenu();
		boolean loc =text.contains("selected");
		Assert.assertTrue(loc, "Location is no mapped.");
	}
	


}
