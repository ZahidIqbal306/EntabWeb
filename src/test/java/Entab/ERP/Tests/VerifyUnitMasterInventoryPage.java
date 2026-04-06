package Entab.ERP.Tests;
import java.io.IOException;
import org.testng.annotations.Test;
import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.InventoryMenu;
import Entab.ERP.Pages.UnitMaster;
import Entab.ERP.TestComponents.BaseTest;

public class VerifyUnitMasterInventoryPage extends BaseTest {
	
	@Test(priority=1)
	public void verifyUnitMasterInventory() throws IOException, InterruptedException {
		
		loginPage.loginApplication();
		HomePage hm = new HomePage(driver);
		hm.selectModuleName("Inventory");
		InventoryMenu im = new InventoryMenu(driver);
		im.clickInventorySetting();
		UnitMaster um = new UnitMaster(driver);
		
		
	}

}
