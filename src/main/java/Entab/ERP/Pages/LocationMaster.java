package Entab.ERP.Pages;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	

	// ---------- Verify Location Master Page --------------
	@FindBy(xpath = "(//a[@href='/Inventory/LocationMaster'])[2]")
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
	
	// ---------- Verify Add Location Page --------------
	@FindBy(xpath = "//button[@title='Add Location']")
	WebElement addLocationButton;
	
	@FindBy(xpath = "//span[@id='headerName']")
	WebElement addLocationText;
	
	public String addLocationPage()
	{
		addLocationButton.click();	
		visibilityOfWebElement(addLocationText);
		String text = addLocationText.getText();
		System.out.println("Open Page name is : " +text);
		return text;		
	}
	
	// ---------- Verify Location Page - Mandatory Field --------------
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
	
	// 2nd way to verify the mandatory field
	public boolean mandatoryFieldLocation1()
	{
		locationName.clear();
		saveButton.click();
		String borderColor = locationName.getCssValue("border-color");
		boolean flag = borderColor.contains("255");
		System.out.println("Location field is highlighted : "+flag);
		return flag;
	}
	
	// 3rd way to verify the mandatory field
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
		closeButton.click();
		return color;
	}
	
	// ---------- Verify Add New Location --------------
	@FindBy(xpath="//select[@id='companyID']")
	WebElement companyDd;
	
	@FindBy(xpath="//input[@id='size']")
	WebElement size;
	
	@FindBy(xpath="//input[@id='storeManagerName']")
	WebElement storeManagerName;	
	
	@FindBy(xpath="//input[@id='managerphoneno']")
	WebElement storeManagerNumber;	
	
	@FindBy(xpath="//input[@id='storeInchargeName']")
	WebElement storeInchargeName;	
	@FindBy(xpath="//input[@id='storeInchargeNo']")
	WebElement storeInchargeNumber;	
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	
	@FindBy(xpath="//div[@class='e-toast-content']")
	WebElement toast;
	

	static String addLocationName ="";
	
	public String addNewLocation(String locatioName) throws InterruptedException
	{
		threadSleep(2000);
		String toastText;
		addLocationButton.click();
		addLocationName = incrementValue(locatioName);
		locationName.sendKeys(addLocationName);
		threadSleep(3000);
		driver.findElement(By.xpath("//span[@id='select2-companyID-container']")).click();
		driver.findElement(By.xpath("//option[text()='Inventory Managment Test School']")).click();
		size.sendKeys("100");
		storeManagerName.sendKeys("Store Manager 1");
		storeManagerNumber.sendKeys("1111111111");
		storeInchargeName.sendKeys("Store Incharge 1");
		storeInchargeNumber.sendKeys("2222222222");
		address.sendKeys("This is a test record " +addLocationName);
		saveButton.click();
		visibilityOfWebElement(toast);
		toastText = toast.getText();
		
		System.out.println("Add Location Toast Text is - :" +toastText);
		return toastText;
	}

	// ---------- Verify Update Location Page --------------
	@FindBy(xpath ="//i[@title='Edit']")
	WebElement editLocation;
	
	@FindBy(xpath ="//span[@id='headerName']")
	WebElement updateLocation;
	
	public String updateLocationPage() throws InterruptedException
	{
		threadSleep(3000);
		editLocation.click();
		threadSleep(3000);
		String text = updateLocation.getText();
		System.out.println("Update Location Header text is : " +text);
		closeButton.click();
		return text;
	}
	
	// ---------- Verify Update Location --------------	
	@FindBy(xpath ="//input[@type='search']")
	WebElement searchBox;
	
	@FindBy(xpath ="//button[.//span[text()='Update']]")
	WebElement updateButton;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement updateToast;
	
	public String updateLocation() throws InterruptedException
	{
		threadSleep(5000);
		searchBox.sendKeys(addLocationName);
		editLocation.click();
		size.clear();
		size.sendKeys("150");
		storeManagerName.clear();
		storeManagerName.sendKeys("Store Manager 11");
		storeManagerNumber.clear();
		storeManagerNumber.sendKeys("1111122222");
		storeInchargeName.clear();
		storeInchargeName.sendKeys("Store Incharge 11");
		storeInchargeNumber.clear();
		storeInchargeNumber.sendKeys("2222211111");
		address.clear();
		address.sendKeys("This is a Updated record " +addLocationName);
		updateButton.click();
		visibilityOfWebElement(updateToast);
		String toastText = updateToast.getText();
		System.out.println("Update Toast text is - : "+toastText);
		return toastText;		
	}	
	
	// ---------- Verify Add Duplicate Location --------------
	@FindBy(xpath="//button[@title='Close']")
	WebElement closeButton;
	
	public String addDuplicateLocation() throws InterruptedException
	{
		threadSleep(3000);
		addLocationButton.click();
		locationName.sendKeys(addLocationName);
		threadSleep(3000);
		driver.findElement(By.xpath("//span[@id='select2-companyID-container']")).click();
		driver.findElement(By.xpath("//option[text()='Inventory Managment Test School']")).click();
		saveButton.click();
		visibilityOfWebElement(toast);
		String toastText = toast.getText();
		windowScroll(-700);
		//threadSleep(5000);
		closeButton.click();
		System.out.println("Duplicate Toast Text is - :" +toastText);
		return toastText;
	}
	
	
	// ---------- Verify Delete Location --------------	
    @FindBy(xpath ="//i[@title='Delete']")
	WebElement deleteloc;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement deleteToast;
	
	public String deleteLocation() throws InterruptedException
	{
		threadSleep(5000);
		visibilityOfWebElement(searchBox);
		searchBox.sendKeys(addLocationName);
		deleteloc.click();
		driver.switchTo().alert().accept();
		visibilityOfWebElement(deleteToast);
		String toastText = deleteToast.getText();
		System.out.println("Deleted Toast text is - : "+toastText);
		return toastText;
	}
	
	// ---------- Verify delete Used Location  --------------
	@FindBy(xpath ="//i[@onclick='Delete(1)']")
	WebElement deleteUsedLoc;
	
	public String deleteUsedLocation(String usedloc) throws InterruptedException
	{
		threadSleep(5000);
		visibilityOfWebElement(searchBox);
		searchBox.sendKeys(usedloc);
		threadSleep(5000);
		deleteloc.click();
		driver.switchTo().alert().accept();
		visibilityOfWebElement(deleteToast);
		String toastText = deleteToast.getText();
		System.out.println("Deleted Toast text is - : "+toastText);
		driver.navigate().refresh();
		return toastText;
	}
	
	// ---------- Verify Activate / Deactivate Location  --------------
//	@FindBy(xpath="//td//span[@class='status-export']")
	@FindBy(xpath="//td//input[@class='slider-toggle']")
	WebElement locationStatus;

	
//	public String locationStatus() throws InterruptedException
//	{		
//		driver.navigate().refresh();
//		threadSleep(10000);
////		String locStatus = locationStatus.getText();
////		System.out.println("Location status is: " +locStatus);
////		return locStatus;
//		
//		String locationId = locationStatus.getAttribute("data-location_id");
//		if(locationId.equals("1"))
//		{
//			System.out.println("Location status id is: " +locationId +" - Deactivated(1)");
//			return "Deactivated";
//		}
//		else 
//		{ 
// 		System.out.println("Location status id is: " +locationId +" - Activated(2)");
//		return "Activated";
//		}
//		
//	}
	
	@FindBy(xpath ="(//td//span[@class='slider round'])[1]")
	WebElement changeStatus;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement statusToast;	
	
	public String activeDeactiveStatus() throws InterruptedException
	{
		threadSleep(5000);
		changeStatus.click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		visibilityOfWebElement(statusToast);
		String toastText = statusToast.getText();
		System.out.println(toastText);
		driver.navigate().refresh();
		return toastText;
	}
	
	public void changeStatusQuick()
	{
		changeStatus.click();
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
	}
	
	// Export CSV ----------------------------------------------------------------------------------
	
	@FindBy(xpath ="//button[@title='CSV']")
	WebElement exportCSV;	
	
	public boolean exportCSV() throws InterruptedException {

        exportCSV.click();

        String downloadPath = "C:\\Users\\Guncha\\Downloads";
        File file = new File(downloadPath + "\\Location Master_2026-01-21.csv");

        int waitTime = 0;
        while (waitTime < 20) 
        {
            if (file.exists()) 
            {
                return true;
            }
            Thread.sleep(1000);
            waitTime++;
        }
        return false;
    }
	
	// Export Excel ----------------------------------------------------------------------------------
	
		@FindBy(xpath ="//button[@title='Excel']")
		WebElement exportExcel;	
		
		public boolean exportExcel() throws InterruptedException {

			exportExcel.click();

	        String downloadPath = "C:\\Users\\Guncha\\Downloads";
	        File file = new File(downloadPath + "\\Location Master_2026-01-21.xlsx");

	        int waitTime = 0;
	        while (waitTime < 20) 
	        {
	            if (file.exists()) 
	            {
	                return true;
	            }
	            Thread.sleep(1000);
	            waitTime++;
	        }
	        return false;
	    }
		
	// Export PDF ----------------------------------------------------------------------------------
		
	@FindBy(xpath ="//button[@class='dt-button buttons-print']")
	WebElement exportPDF;	
		
		public boolean exportPDF() throws InterruptedException {

			exportPDF.click();
			Thread.sleep(3000);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			int count = windows.size();
			System.out.println("Window size is : "+count);
	        while (count > 1) 
	        {
	        	String parent = itr.next();
	 	        String child = itr.next();
	 	        driver.switchTo().window(child);
	 	        driver.close();
	 	        driver.switchTo().window(parent);
	 	        driver.switchTo().defaultContent();
	            return true;
	           
	        }
	       
	        return false;
	    }	
		
}
