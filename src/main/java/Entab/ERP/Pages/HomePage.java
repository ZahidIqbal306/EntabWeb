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
	WebElement profileIcon;
	@FindBy(xpath = "//a[@class='logout']")
	WebElement logout;
	
	public void logOut() throws InterruptedException
	{
		threadSleep(2000);
		profileIcon.click();
		threadSleep(2000);
		hoverText(driver, logout);
		driver.close();
	}

}
