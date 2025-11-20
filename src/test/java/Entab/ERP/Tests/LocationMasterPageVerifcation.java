package Entab.ERP.Tests;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.InventoryMenu;
import Entab.ERP.Pages.LocationMaster;
import Entab.ERP.TestComponents.BaseTest;

public class LocationMasterPageVerifcation extends BaseTest {
	
	@Test
	public void verifyLocationMasterPage() throws IOException, InterruptedException
	{
		loginPage.loginApplication();
		HomePage homePage = new HomePage(driver);
		homePage.selectInventoryModule();
		InventoryMenu im = new InventoryMenu(driver);
		im.clickInventorySetting();
		LocationMaster lm = new LocationMaster(driver);
		String text = lm.clickLocationMaster();
		Assert.assertEquals(text, "Location Master");
	}
	
	@Test(dependsOnMethods = {"verifyLocationMasterPage"})
	public void verifyAddLocationMandatoryField() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String text = lm.addLocation();
		Assert.assertEquals(text, "Add Location");
		String locationborderColor = lm.mandatoryFieldLocation();
		Assert.assertTrue(locationborderColor.contains("255"), "Location mandatory filed is not highlighted.");	
//		boolean flag = lm.mandatoryFieldLocation1();
//		Assert.assertTrue(flag, "Location mandatory filed is not highlighted.");		
//		boolean flag1 = lm.mandatoryFieldLocation2();
//		Assert.assertTrue(flag1, "Location mandatory filed is not highlighted.");
		boolean companyBorderColor = lm.mandatoryFieldCompany();
		Assert.assertTrue(companyBorderColor, "Company mandatory filed is not highlighted.");		
	}

}
