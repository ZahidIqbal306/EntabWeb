package Entab.ERP.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Entab.ERP.CommonComponents.CommonComponents;

public class LocationMaster extends CommonComponents
{	
	WebDriver driver;
	
	public LocationMaster(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//a[@href=\"/Inventory/LocationMaster\"])[1]")
	WebElement locationMasterSubMenu;
	
	@FindBy(xpath = "//a[@class='btn btn-header-link']")
	WebElement pageHeaderText;
	
	public String clickLocationMaster()
	{
		locationMasterSubMenu.click();
		visibilityOfWebElement(pageHeaderText);
		String headerText= pageHeaderText.getText();
		System.out.println("Open Page name is : " +headerText);
		return headerText;		
	}
	
	@FindBy(xpath = "//a[@title='Add Location']")
	WebElement addLocationButton;
	
	@FindBy(xpath = "//span[@id='headerName']")
	WebElement addLocationText;
	
	public String addLocation()
	{
		addLocationButton.click();	
		visibilityOfWebElement(addLocationText);
		String text = addLocationText.getText();
		System.out.println("Open Page name is : " +text);
		return text;		
	}
	
	@FindBy(xpath = "//input[@id='locationName']")
	WebElement locationName;
	
	@FindBy(xpath = "//input[contains(@style, 'border: 1px solid red')]")
	WebElement locationHighlighted;
		
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement saveButton;
	
	public String mandatoryFieldLocation()
	{
		locationName.clear();
		saveButton.click();
		String borderColor = locationName.getCssValue("border-color");
		System.out.println("Location field code is : "+borderColor);
		return borderColor;
	}	
	
	public boolean mandatoryFieldLocation1()
	{
		locationName.clear();
		saveButton.click();
		String borderColor = locationName.getCssValue("border-color");
		boolean flag = borderColor.contains("255");
		System.out.println("Location field is highlighted : "+flag);
		return flag;
	}
	
	// 2nd way to verify the mandatory field
	public boolean mandatoryFieldLocation2()
	{
		locationName.clear();
		saveButton.click();
		boolean flag = locationHighlighted.isDisplayed();
		System.out.println("Location field is highlighted : "+flag);
		return flag;
	}
	
	@FindBy(xpath = "//span[contains(@class,'select2-container')]")
	WebElement companyName;
	
	@FindBy(xpath = "//span[contains(@class,'select2-container') and contains(@style,'width: 100%; border: 1px solid red')]")  
	WebElement companyHighlighted;
	
	public boolean mandatoryFieldCompany() throws InterruptedException
	{
		threadSleep(2000);
		saveButton.click();
		boolean color = companyHighlighted.isDisplayed();
		System.out.println("company field is highlighted : " +color);
		return color;
	}
	

}
