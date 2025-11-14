package Entab.ERP.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports getExtentReportObject()
	{
		//String path = "D:\\Automation\\Inventory\\report\\index.html";
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(path);
		esp.config().setDocumentTitle("Automation Test Report");
		esp.config().setReportName("Inventory Automation Test Report");
		
		ExtentReports er = new ExtentReports();
		er.attachReporter(esp);
		er.setSystemInfo("Module", "Inventory");
		er.setSystemInfo("Environment", "QA-Dev");
		er.setSystemInfo("QA", "Mazhar");
		er.setSystemInfo("QA Lead", "Zahid Iqbal");
		return er;
		
	}

}
