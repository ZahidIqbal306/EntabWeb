package Entab.ERP.TestComponents;
import java.io.IOException;
import java.util.Map;
import Entab.ERP.Resources.Constant;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Entab.ERP.Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentReports extent =  ExtentReporterNG.getExtentReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // To handle the multiple test
	
	@Override
	public void onTestStart(ITestResult result) {
		
		//extent.createTest("TestCaseName");
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// Assign the test id for each test
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test case is : Pass");
		// Map Constant into the Extent Report
		Map<String,String> functionality=Constant.getFuncnctionlity(result.getName());	
				
		for(String key:functionality.keySet())
			{
				test.log(Status.PASS, key+"-"+functionality.get(key)); 
			}

	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		//test.log(Status.FAIL, "Test Case : Fail");
		extentTest.get().fail(result.getThrowable());
		
		// Map Constant into the Extent Report
		Map<String,String> functionality=Constant.getFuncnctionlity(result.getName());		
		 for(String key:functionality.keySet())
		  {
			 test.log(Status.FAIL, key+"-"+functionality.get(key)); 
		  }
		
		// For screenshot to initialize driver
		  try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) 
		  {
			e.printStackTrace();
		}
		
		// Take Screenshot, 
		String screeshotPath = null;
		try {
			screeshotPath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Attach Screenshot into the report
		extentTest.get().addScreenCaptureFromPath(screeshotPath, result.getMethod().getMethodName());
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.get().log(Status.SKIP, "Testcase Skip");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush(); // Complete the test

	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}
	
	@Override
	public void onStart(ITestContext context) {

	}
	




}
