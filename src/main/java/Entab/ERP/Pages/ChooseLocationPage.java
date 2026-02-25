package Entab.ERP.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Entab.ERP.CommonComponents.CommonComponents;

public class ChooseLocationPage extends CommonComponents {
	
	WebDriver driver;
	public ChooseLocationPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[text()='Choose Location'])[2]")
	WebElement selectChooseLocSubMenu;
	
	@FindBy(xpath="//select[@data-select2-id='groupCompanySelect']")
	WebElement selectGroupCompany;
	
	@FindBy(xpath="//select[@data-select2-id='companySelect']")
	WebElement selectCompany;
	
	@FindBy(xpath="//select[@data-select2-id='locationSelect']")
	WebElement selectLocation;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	WebElement submitLocation;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement locMappedToast;
	
	@FindBy(xpath="//h3[text()='Select Location']")
	WebElement chooseLocHeader;
	
	public String mapChooseLocSubMenu()
	{
		visibilityOfWebElement(selectChooseLocSubMenu);
		selectChooseLocSubMenu.click();
		visibilityOfWebElement(chooseLocHeader);
		String headerText = chooseLocHeader.getText();
		System.out.println("Open Page Name is : "+headerText);
		visibilityOfWebElement(selectGroupCompany);
		selectByVisibleText(selectGroupCompany, "Inventory Group");
		selectByVisibleText(selectCompany, "Inventory Managment Test School");
		selectByVisibleText(selectLocation, "Biological Lab Equipment");
		submitLocation.click();
		visibilityOfWebElement(locMappedToast);
		String alertText = locMappedToast.getText();		
		System.out.println(alertText);
		invisibilityOfWebElement(locMappedToast);
		return alertText;		
	}


	


}
