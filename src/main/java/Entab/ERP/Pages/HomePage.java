package Entab.ERP.Pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Entab.ERP.CommonComponents.CommonComponents;

public class HomePage extends CommonComponents {
	
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@class='profileImg'])[1]")
	WebElement imageIcon;
	
	@FindBy(xpath = "(//li[@class='profile_li']/p)[1]")
	WebElement profileUserId;
	
	public String loginUserId() throws InterruptedException
	{
		String Id = "";
		if(invisibilityOfWebElement(profileUserId)==true)
		{
			threadSleep(6000);
			imageIcon.click();
			visibilityOfWebElement(profileUserId);
			String profileId = profileUserId.getText();
			String[] userName = profileId.split(":");
			Id = userName[1].trim();
		}
		else
		{
			String profileId = profileUserId.getText();
			String[] userName = profileId.split(":");
			Id = userName[1].trim();
		}
		
		System.out.println("UserId is : "+Id);
		return Id;
	}
	
	@FindBy(xpath = "(//li[@class='profile_li']/p)[2]")
	WebElement profileUserName;
	
	public String loginUserName() throws InterruptedException
	{
		String name = "";
		if(invisibilityOfWebElement(profileUserName)==true)
		{
			threadSleep(6000);
			imageIcon.click();
			visibilityOfWebElement(profileUserName);
			String profileList = profileUserName.getText();
			String[] userName = profileList.split(":");
			name = userName[1].trim();
		}
		else
		{
			String profileList = profileUserName.getText();
			String[] userName = profileList.split(":");
			name = userName[1].trim();
		}
		
		System.out.println("Username is : "+name);
		return name;
	}

	@FindBy(xpath = "//a[@class='logout']")
	WebElement logout;
	
	public void logOut() throws InterruptedException
	{
		if(invisibilityOfWebElement(logout)==true)
		{
			threadSleep(6000);
			imageIcon.click();
			visibilityOfWebElement(logout);
			logout.click();
			System.out.println("User is logged out successfully.");
			driver.close();
			System.out.println("Closed the browser.");
		}
		else
		{
			logout.click();
			System.out.println("User is logged out successfully.");
			driver.close();
			System.out.println("Closed the browser.");
		}
	}
	
	
	@FindBy(xpath = "//a[contains(., 'Change Password')]")
	WebElement passText;
	
	public String changePasswordText() throws InterruptedException
	{
		threadSleep(2000);
		//hoverText(driver,userProfile);
		if(invisibilityOfWebElement(passText)==true)
		{
			imageIcon.click();
			visibilityOfWebElement(passText);
			String cpText = passText.getText();
			System.out.println(cpText);
			return cpText;
		}
		else
		{
			visibilityOfWebElement(passText);
			String cpText = passText.getText();
			System.out.println(cpText);
			return cpText;
		}
	}
	
	
	@FindBy(xpath ="//img[@class='selectMenuTab']")
	WebElement selectMenu;
	
	@FindBy(xpath ="//a[@class='lg-dropdown-menu menu-title mainmenulst']")
	WebElement mainmenulst;
	
	@FindBy(xpath ="(//a[contains(text(),'Inventory')])[1]")
	WebElement inventoryModule;
	
	
	
	// Open the Inventory Module
	public void selectInventoryModule() throws InterruptedException
	{
		selectMenu.click();	
		threadSleep(2000);
		mainmenulst.click();
		visibilityOfWebElement(inventoryModule);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inventoryModule);
		inventoryModule.click();		
	}
	
}
