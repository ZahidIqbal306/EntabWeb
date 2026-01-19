package Entab.ERP.CommonComponents;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	// Explicit wait - Visibility Of WebElemnt	
	public void visibilityOfWebElement(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	// Explicit Wait - Visibility of Element by locator
	public void visibityOfElementByLocator(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}
	
	// Explicit wait - Visibility Of WebElemnt	
	public boolean invisibilityOfWebElement(WebElement ele)
	{
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        return wait.until(ExpectedConditions.invisibilityOf(ele));
		     } 
		 catch (Exception e) 
		    {
		        return false;
		    }
	}
	
	// Hover the Mouse with 1 element - Overloading
	public void hoverText(WebDriver driver, WebElement ele1)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele1).click().build().perform();		
	}
	
	// Select drop down via Value
	public void selectByValue(WebElement ele, String value)
	{
		Select a = new Select(ele);
		a.selectByValue(value);		
	}
	
	// Window Scroll
	public void windowScroll(int no)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,'"+no+"')");
	}
	
	// incremental value
    public static int count = 1;
	public String incrementValue(String value)
	{
		
		String newValue = value + count;
		count++;
		return newValue;		
	}	
	
}
