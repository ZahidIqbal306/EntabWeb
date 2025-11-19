package Entab.ERP.Pages;
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
	
	@FindBy(xpath = "//span[@id='teacherName']")
	WebElement userProfile;
	
	public String loginUserName() throws InterruptedException
	{
		visibilityOfWebElement(userProfile);
		String userName = userProfile.getText();
		System.out.println("Login username is : "+userName);
		return userName;
	}
	
	@FindBy(xpath = "//a[@class='logout']")
	WebElement logout;
	
	public void logOut() throws InterruptedException
	{
		if(invisibilityOfWebElement(logout)==true)
		{
			userProfile.click();
			visibilityOfWebElement(logout);
			logout.click();
			System.out.println("User is logged out successfully.");
			driver.close();
			System.out.println("Closed the browser.");
		}
		else
		{
			visibilityOfWebElement(logout);
			logout.click();
			System.out.println("User is logged out successfully.");
			driver.close();
			System.out.println("Closed the browser.");
		}
	}
	
	@FindBy(xpath = "//a[@class='profile']")
	WebElement profile;
	
	public String profileText()
	{
		//hoverText(driver,userProfile);
		if(invisibilityOfWebElement(logout)==true)
		{
			userProfile.click();
			visibilityOfWebElement(profile);
			String prText = profile.getText();
			System.out.println(prText);
			return prText;
		}
		else
		{
			visibilityOfWebElement(profile);
			String prText = profile.getText();
			System.out.println(prText);
			return prText;
		}
	}
	
	@FindBy(xpath = "//a[contains(., 'Change Password')]")
	WebElement passText;
	
	public String changePasswordText() throws InterruptedException
	{
		threadSleep(2000);
		//hoverText(driver,userProfile);
		if(invisibilityOfWebElement(logout)==true)
		{
			userProfile.click();
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
	
}
