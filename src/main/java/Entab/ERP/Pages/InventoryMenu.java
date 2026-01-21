package Entab.ERP.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Entab.ERP.CommonComponents.CommonComponents;

public class InventoryMenu extends CommonComponents {
	
	WebDriver driver;
	
	public InventoryMenu(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[contains(text(),'Inventory Setting')]")
	WebElement inventorySetting;
	
	public void clickInventorySetting()
	{
		visibilityOfWebElement(inventorySetting);
		inventorySetting.click();
	}
	
	//span[contains(text(),'Entry')]  
	
	@FindBy(xpath= "//li[@class='active']//span[text()='Entry ']")
	WebElement inventoryEntry;
	
	public void clickInventoryEntry()
	{
		visibilityOfWebElement(inventoryEntry);
		inventoryEntry.click();
	}
	
	@FindBy(xpath= "//li[@class='active']//ul[@class='lg-sub-menu1']//li//a[@class='lg-dropdown-menu2']//span[contains(text(),'Reports')]")
	WebElement inventoryReports;
	
	public void clickInventoryReports()
	{
		visibilityOfWebElement(inventoryReports);
		inventoryReports.click();
	}
	

}
