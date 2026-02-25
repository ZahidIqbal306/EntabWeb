package Entab.ERP.Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Entab.ERP.Pages.GroupLedgerMasterPage;
import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.InventoryMenu;
import Entab.ERP.TestComponents.BaseTest;

public class VerifyGroupLedgerMasterPage extends BaseTest {	
	
	@Test(priority=1)
	public void verifyGroupLedgerMasterPage() throws IOException, InterruptedException
	{
		loginPage.loginApplication();
		HomePage homePage = new HomePage(driver);
		homePage.selectModuleName("Inventory");
		InventoryMenu im = new InventoryMenu(driver);
		im.clickInventorySetting();
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		String text = gl.openGroupLedgerMaster();
		boolean flag = text.contains("Group Ledger");
		Assert.assertEquals(flag, true);
		System.out.println("Group Ledger Master page is opened.");		
	}
	
	@Test(priority=2, dependsOnMethods = {"verifyGroupLedgerMasterPage"},enabled = true)
	public void verifyMandatroyFieldGroupLedger() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		Assert.assertTrue(gl.mandatFieldGroupLedger(), "Mandatory field validation failed for Group Ledger");
	}

	String ledgerName = " ";
	@Test(priority=3,enabled = true)
	public void verifyAddGroupLedger() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		ledgerName = gl.addLedger();
		String alertText = gl.addLedgerMessgae();
		boolean flag = alertText.contains("added successfully!");
		Assert.assertTrue(flag, "Location is not added.");
	}
	
	@Test(priority=4,enabled = true)
	public void verifyUpdateGroupLedger() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		String alertText = gl.updateLedger(ledgerName);
		boolean flag1 = alertText.contains("updated successfully!");
		Assert.assertTrue(flag1, "Location is not updated.");
	}
	
	@Test(priority=5,enabled = true)
	public void verifyDuplicateGroupLedger() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		String alertText = gl.addDuplicateLedger(ledgerName);
		boolean flag = alertText.contains("Already Exists!");
		Assert.assertTrue(flag, "Duplicate Location is added.");
	}
		
	
	@Test(priority=6,enabled = true)
	public void verifydeleteGroupLedger() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		String alertText = gl.deleteLedger(ledgerName);
		boolean flag = alertText.contains("deleted successfully!");
		Assert.assertTrue(flag, "Location is not deleted.");
	}
	
	@Test(priority=7,enabled = true)
	public void verifyExportCSV() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		boolean alertText = gl.exportCSV();
		Assert.assertEquals(alertText, true);
		System.out.println("CSV file is downloaded successfully.");
	}
	
	@Test(priority=8,enabled = true)
	public void verifyExportExcel() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		boolean alertText = gl.exportExcel();
		Assert.assertEquals(alertText, true);
		System.out.println("Excel file is downloaded successfully.");
	}
	
	@Test(priority=8,enabled = true)
	public void verifyExportPdf() throws InterruptedException
	{
		GroupLedgerMasterPage gl = new GroupLedgerMasterPage(driver);
		boolean flag = gl.exportPdf();
		Assert.assertEquals(flag, true);
		System.out.println("Pdf file is downloaded successfully.");
	}
	

}
