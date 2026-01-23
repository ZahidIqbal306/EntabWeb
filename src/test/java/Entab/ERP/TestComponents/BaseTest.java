package Entab.ERP.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Entab.ERP.Pages.HomePage;
import Entab.ERP.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public static LoginPage loginPage;
	public WebDriver intializeWebDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Entab\\ERP\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			
			HashMap<String, Object> prefs = new HashMap<>();
	        prefs.put("download.default_directory", "C:\\Users\\Guncha\\Downloads");
	        prefs.put("download.prompt_for_download", false);

	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);

	        driver = new ChromeDriver(options);
			
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;		
	}
	
	@BeforeClass
	public LoginPage lauchApplication() throws IOException, InterruptedException
	{
		driver = intializeWebDriver();
		loginPage = new LoginPage(driver);
		loginPage.loadUrl();
		return loginPage;
	}
	
	@AfterClass
	public void logOut() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.logOut();	
	}
	
	@AfterSuite
	public void tearDown() 
	{
	    driver.quit();
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws  IOException
	{
		 File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File src = new File(System.getProperty("user.dir")+"//report//" + testcaseName+ ".png");
		 FileUtils.copyFile(file, src);	
		 return System.getProperty("user.dir")+ "//report//" + testcaseName+ ".png";

	}	
	

}
