package Entab.ERP.Tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.InventoryMenu;
import Entab.ERP.Pages.LocationMaster;
import Entab.ERP.TestComponents.BaseTest;

public class LocationMasterPageVerifcation extends BaseTest {
	
	@Test (priority=1)
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
	
	@Test(priority=2, enabled = false)
	public void verifyAddLocationMandatoryField() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String text = lm.addLocationPage();
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
	
	@Test(priority=3, enabled = false)
	public void addNewLocationVerification() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
	    String addedToast = lm.addNewLocation("Automation M");	
	    boolean flag = addedToast.contains("Successfully");
	    Assert.assertEquals(flag, true);
	}
	
	@Test(priority=4, enabled = false)
	public void updateLocationPageVeification() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String headertext = lm.updateLocationPage();
		boolean flag = headertext.contains("Update");
		Assert.assertEquals(flag, true);		
	}
	
	@Test(priority=5, enabled = false)
	public void updateLocationVerfication() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String updatePagetext = lm.updateLocation();
		boolean flag = updatePagetext.contains("Updated Successfully");
		Assert.assertEquals(flag, true);		
	}
	
	@Test(priority=6, enabled = false)
	public void duplicateLocationVerification() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
	    String existToast = lm.addDuplicateLocation();
	    boolean flag = existToast.contains("already exists");
	    Assert.assertEquals(flag, true);
	}
	
	@Test(priority=7, enabled = false)
	public void deleteLocationVerification() throws InterruptedException
	{		
		LocationMaster lm = new LocationMaster(driver);
		String deletedText = lm.deleteLocation();
		boolean flag = deletedText.contains("Deleted successfully");
	    Assert.assertEquals(flag, true);
	}
	
	@Test(priority=8, enabled = false)
	public void deteteUsedLocation() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String alertText = lm.deleteUsedLocation("Biological Lab Equipment");
		boolean flag = alertText.contains("Already In Used");
	    Assert.assertEquals(flag, true);
	}
	
	@Test(priority=9)
	public void deactivateLocationVerfication() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String status = lm.activeDeactiveStatus();
		boolean flag;
		flag = status.contains("deactivated");
		//Assert.assertTrue(true, "Location is activated successfully.");
		if(flag == false)
		{
			String status1 = lm.activeDeactiveStatus();
			flag = status1.contains("deactivated");
		}
		
		Assert.assertEquals(flag, true);
		System.out.println("Location is deactivated successfully.");
	}	
	
	@Test(priority=10)
	public void activateLocationVerfication() throws InterruptedException
	{
		LocationMaster lm = new LocationMaster(driver);
		String status = lm.activeDeactiveStatus();
		boolean flag;
		flag = status.contains("activated");
		//Assert.assertTrue(true, "Location is activated successfully.");
		if(flag == false)
		{
			String status1 = lm.activeDeactiveStatus();
			flag = status1.contains("activated");
		}
		
		Assert.assertEquals(flag, true);
		System.out.println("Location is aeactivated successfully.");
	}


}
