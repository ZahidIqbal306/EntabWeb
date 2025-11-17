package Entab.ERP.Pages;
import java.io.IOException;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Entab.ERP.CommonComponents.CommonComponents;

public class LoginPage extends CommonComponents{
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//p[@class='loginbtn']")
	WebElement enterLogin;
	
	public void loadUrl() throws IOException, InterruptedException
	{
		String url = getPropertyFileData("url");
		driver.get(url);
		System.out.println("Url is loaded successfully : " + url);
		threadSleep(2000);
		enterLogin.click();
		threadSleep(3000);		
	}
	
	@FindBy(xpath = "//div[@class='login-form-blk login-blk']//p[contains(text(),'Enter the registered mobile no. with school')]")
	WebElement loginPageText;
	
	public String verifyLoginPage()
	{
		String actualtext = loginPageText.getText();
		System.out.println(actualtext);
		return actualtext;
		
	}
	@FindBy (xpath = "//input[@id='txtUserID']")
	WebElement userId;
	@FindBy (xpath ="//input[@id='userPassword']")
	WebElement pass;
	@FindBy(xpath = "//button[@id='btnLogin']")
	WebElement loginButton;
	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	WebElement dasboardText;
	
	public String loginApplication() throws IOException, InterruptedException
	{
		
		String userName = getPropertyFileData("userName");
		String password = getPropertyFileData("password");
		threadSleep(3000);
		userId.sendKeys(userName);
		pass.sendKeys(password);
		loginButton.click();
		threadSleep(4000);
		String dashoabrd = dasboardText.getText();
		System.out.println(dashoabrd);
		return dashoabrd;
	}	

}
