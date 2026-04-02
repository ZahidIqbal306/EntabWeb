package Entab.ERP.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Entab.ERP.CommonComponents.CommonComponents;

public class UnitMaster extends CommonComponents {

	public UnitMaster(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
// verify Unit Master Page
	
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1erbx20' and contains(text(),'Unit Master')]")
	WebElement unitMasterSubmenu;
	
	@FindBy(xpath = "//a[contains(text(),'Unit') and (@class='btn btn-header-link')]")
	WebElement unitMasterHeaderText;
	
	public boolean verifyUnitMasterPage() {
		
		visibilityOfWebElement(unitMasterSubmenu);
		unitMasterSubmenu.click();
		visibilityOfWebElement(unitMasterHeaderText);
		String headerText = unitMasterHeaderText.getText();
		System.out.println(headerText);
		boolean flag = headerText.contains("Unit");
		return flag;		
	}
	
// verify Unit Master Mandatory Field	
	
	@FindBy(xpath = "//a[contains(text(),'Unit') and (@class='btn btn-header-link')]")
	WebElement addButton;
	
	@FindBy(xpath = "//span[@id='headerLabel']")
	WebElement addUnitHeaderText;
	
	@FindBy(xpath = "//input[@id='unitName']")
	WebElement unitName;
	
	@FindBy(xpath = "//input[@id='abbreviation']")
	WebElement abbrevation;
	
	@FindBy(xpath = "//span[@id='lblSaveBtn']")
	WebElement saveButton;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelButton;
	
	public String verifymandatoryField() {
		
		visibilityOfWebElement(addButton);
		addButton.click();
		visibilityOfWebElement(addUnitHeaderText);
		saveButton.click();
		
		String borderColor = unitName.getCssValue("border-color");
		System.out.println("Unit Name border color is : "+borderColor);
		return borderColor;
	}

}
