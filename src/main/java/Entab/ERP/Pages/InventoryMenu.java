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

	
	// Choose Location
	@FindBy(xpath="(//span[contains(text(),'Choose Location')])[2]")
	WebElement chooseLocationSubmenu;
	
	@FindBy(xpath="//h3[text()='Select Location']")
	WebElement chooseLocationHeader;
	
	@FindBy(xpath="//select[@data-select2-id='groupCompanySelect']")
	WebElement selectGroupCompany;
	
	@FindBy(xpath="//select[@data-select2-id='companySelect']")
	WebElement selectCompany;
	
	@FindBy(xpath="//select[@data-select2-id='locationSelect']")
	WebElement selectLocation;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	WebElement submitLocation;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement locationToast;
	
	public void  chooseLocation() throws InterruptedException
	{
		visibilityOfWebElement(chooseLocationSubmenu);
		chooseLocationSubmenu.click();
		visibilityOfWebElement(chooseLocationHeader);
		String pageText = chooseLocationHeader.getText();
		System.out.println("Open Page name is : " +pageText);
		selectByVisibleText(selectGroupCompany, "Inventory Group");
		selectByVisibleText(selectCompany, "Inventory Managment Test School");
		selectByVisibleText(selectLocation, "Biological Lab Equipment");
		submitLocation.click();

		visibilityOfWebElement(locationToast);
		String toastText = locationToast.getText();
		System.out.println("Location Mapped text is - : " +toastText);
	}


}
