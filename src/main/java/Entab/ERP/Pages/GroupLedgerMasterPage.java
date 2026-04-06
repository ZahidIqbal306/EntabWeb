package Entab.ERP.Pages;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Entab.ERP.CommonComponents.CommonComponents;

public class GroupLedgerMasterPage extends CommonComponents{

	WebDriver driver;
	public GroupLedgerMasterPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 		
	}
	
	// Choose Location
	@FindBy(xpath = "//ul[@class='lg-sub-menu2 lg-sub-menuclickopen open-down']//li//span[contains(text(),'Group Ledger Master')]")
	WebElement groupLedgerMasterSubmenu;
	
	@FindBy(xpath="//a[@class='btn btn-header-link']")
	WebElement groupLedgerHeaderText;
	
	@FindBy(xpath="//th[@aria-label='Group Name']")
	WebElement groupNameHeaderText;
	
	public String openGroupLedgerMaster() throws InterruptedException
	{
		groupLedgerMasterSubmenu.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		visibilityOfWebElement(groupNameHeaderText);
		String headertext = groupLedgerHeaderText.getText();
		headertext.trim();
		System.out.println(headertext);
		return headertext;
	}
	
	@FindBy(xpath="//img[@src='/Images/Add.png']")
	WebElement addGL;
	
	@FindBy(xpath="//button[@onclick='Save();']")
	WebElement saveGL;
	
	@FindBy(xpath="//span[contains(@class,'select2 select2-container select2-container--default')]")
	WebElement natureOfGroup;
	
	@FindBy(xpath = "//span[contains(@class,'select2 select2-container select2-container--default') and contains(@style,'width: 100%; border: 1px solid red')]")  
	WebElement natureOfGroupHighlighted;
	
	@FindBy(xpath="//*[@id='natureID']")
	WebElement natureOfGroup1;
	
	@FindBy(xpath="//select[@id='natureID']")
	WebElement natureOfGroup2;	
	
	@FindBy(xpath="//input[@id='groupName']")
	WebElement groupName;
	
	@FindBy(xpath="//input[@id='priorityNo']")
	WebElement priority;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-sm']")
	WebElement cancelButton;
	
	public boolean mandatFieldGroupLedger() throws InterruptedException
	{
		visibilityOfWebElement(addGL);
		addGL.click();
		visibilityOfWebElement(groupName);
		groupName.clear();
		priority.clear();
		visibilityOfWebElement(saveGL);
		saveGL.click();	
		boolean natureFlag = isFieldMarkedMandatory(natureOfGroup);
		boolean groupFlag = isFieldMarkedMandatory(groupName);
		boolean priorityFlag = isFieldMarkedMandatory(priority);

		System.out.println("Nature Of Group is mandatroy field : " +natureFlag);
		System.out.println("Group Name is mandatroy field : " +groupFlag);
		System.out.println("Priority is mandatroy field : " +priorityFlag);
		
		cancelButton.click();
		return natureFlag && groupFlag && priorityFlag;			
	}
	
	@FindBy(xpath ="//span[@id='headerLabel' and text()='Add Group Ledger']")
	WebElement addLocPage;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement addLedgerToast;
	
	@FindBy(xpath ="//option[text()='Others']")
	WebElement selectGroupLedger;
	
	public String addLedger() throws InterruptedException
	{
		visibilityOfWebElement(addGL);
		addGL.click();
		threadSleep(5000);
		//visibilityOfWebElement(saveGL);
		natureOfGroup.click();
		selectGroupLedger.click();
		natureOfGroup.click();
		
		groupName.clear();
		String ledgerName = incrementValue("Automation Ledger ");
		groupName.sendKeys(ledgerName);
		
		priority.clear();
		String priorityValue = incrementValue("110");
		priority.sendKeys(priorityValue);
		
		visibilityOfWebElement(saveGL);
		saveGL.click();	
		return ledgerName;
	}	
	
	public String addLedgerMessgae()
	{
		visibilityOfWebElement(addLedgerToast);
		String toastText = addLedgerToast.getText();
		System.out.println(toastText);
		invisibilityOfWebElement(addLedgerToast);
		return 	toastText;
	}

	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchLedger;
	
	@FindBy(xpath="//i[@title='Edit']")
	WebElement editLedger;
	
	@FindBy(xpath="//span[@id='lblSaveBtn']")
	WebElement updateLedger;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement updateLedgerToast;
	
	public String updateLedger(String ledgerName) throws InterruptedException
	{
		invisibilityOfWebElement(updateLedgerToast);
		visibilityOfWebElement(searchLedger);
		searchLedger.sendKeys(ledgerName);
		visibilityOfWebElement(editLedger);
		editLedger.click();		
		priority.clear();
		priority.sendKeys("901");
		updateLedger.click();
		
		visibilityOfWebElement(updateLedgerToast);
		String updateToast = updateLedgerToast.getText();
		System.out.println(updateToast);
		return 	updateToast;		
	}
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement duplicateLedgerToast;
	
	@FindBy(xpath ="//button[@class='btn btn-danger btn-sm']")
	WebElement canButton;
	
	public String addDuplicateLedger(String ledgerName) throws InterruptedException
	{
		invisibilityOfWebElement(duplicateLedgerToast);
		addGL.click();
		visibilityOfWebElement(natureOfGroup);
		natureOfGroup.click();
		selectGroupLedger.click();
		natureOfGroup.click();
		visibilityOfWebElement(groupName);
		groupName.clear();
		System.out.println(ledgerName);
		groupName.sendKeys(ledgerName);
		
		priority.clear();
		String priorityValue = incrementValue("130");
		priority.sendKeys(priorityValue);
		visibilityOfWebElement(saveGL);
		saveGL.click();
		visibilityOfWebElement(duplicateLedgerToast);
		String duplicateText = duplicateLedgerToast.getText();
		System.out.println(duplicateText);
		
		canButton.click();
		searchLedger.clear();
		
		return 	duplicateText;		
	}
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteLedger;
	
	@FindBy(xpath ="//div[@class='e-toast-content']")
	WebElement deleteLedgerToast;
	
	public String deleteLedger(String ledgerName) throws InterruptedException
	{
		invisibilityOfWebElement(deleteLedgerToast);
		visibilityOfWebElement(searchLedger);
		searchLedger.sendKeys(ledgerName);
		visibilityOfWebElement(deleteLedger);
		deleteLedger.click();
		driver.switchTo().alert().accept();
		
		visibilityOfWebElement(deleteLedgerToast);
		String deleteToast = deleteLedgerToast.getText();
		System.out.println(deleteToast);
		invisibilityOfWebElement(deleteLedgerToast);
		return 	deleteToast;		
	}	
	
	@FindBy(xpath ="//button[@class='dt-button buttons-csv buttons-html5']")
	WebElement exportCSVButton;
	
	String currentDate = currentDateFormat();
	
	public boolean exportCSV() throws InterruptedException
	{
		invisibilityOfWebElement(deleteLedgerToast);
		visibilityOfWebElement(exportCSVButton);
		exportCSVButton.click();
		
		String path = "C:\\Users\\Guncha\\Downloads";
		File file = new File (path + "\\Group Ledger Master_"+currentDate+".csv");
		System.out.println("Today date is :" +currentDate);

		int count = 0;
		while(count < 20)
		{
			if(file.exists())
			{
				return true;
			}
			count++;
		}
		return false;
	}
	
	@FindBy(xpath ="//button[@class='dt-button buttons-excel buttons-html5']")
	WebElement exportExcelButton;
	public boolean exportExcel() throws InterruptedException
	{
		visibilityOfWebElement(exportExcelButton);
		exportExcelButton.click();
		
		String path1 = "C:\\Users\\Guncha\\Downloads";
		File file1 = new File (path1 + "\\Group Ledger Master_"+currentDate+".xlsx");

		int count = 0;
		while(count < 20)
		{
			if(file1.exists())
			{
				return true;
			}
			count++;
		}
		return false;
	}
	
	@FindBy(xpath ="//button[@class='dt-button buttons-print']")
	WebElement exportPdfButton;
	
	public boolean exportPdf() throws InterruptedException
	{
	    String parentWindow = driver.getWindowHandle();
	    exportPdfButton.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(d -> d.getWindowHandles().size() > 1);

	    Set<String> allWindows = driver.getWindowHandles();
	    System.out.println("Window size is : " + allWindows.size());

	    if (allWindows.size() > 1) 
	    {
	        for (String window : allWindows) 
	        {
	            if (!window.equals(parentWindow)) 
	            {
	                driver.switchTo().window(window);
	                driver.close();     // close print preview
	            }
	        }
	        driver.switchTo().window(parentWindow);
	        return true;
	    }
	    return false; 	
	}


}
