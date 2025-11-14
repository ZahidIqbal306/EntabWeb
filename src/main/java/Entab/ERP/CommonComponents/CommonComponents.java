package Entab.ERP.CommonComponents;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.reactivex.rxjava3.functions.Action;

public class CommonComponents 
{
	public WebDriver driver;
	public CommonComponents(WebDriver driver)
	{
		this.driver = driver;
	}

	// get the properties file data
	public String getPropertyFileData(String data) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Entab\\ERP\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String getData = prop.getProperty(data);
		return getData;	
	}
	
	// Set the thread time
	public void threadSleep(int time) throws InterruptedException
	{
		Thread.sleep(time);
	}
	
	// Hover the Mouse with 1 element - Overloading
	public void hoverText(WebDriver driver, WebElement ele1)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele1).click().build().perform();		
	}
	

}
