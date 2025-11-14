package Entab.ERP.Resources;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constant {
	
	static Map<String,String> defaultFun=new LinkedHashMap<String, String>();	

//======================1st Part =================================================================
	
	// verify Login Functionality
	static Map<String,String> verifyLogin=new LinkedHashMap<String, String>();
	
	// Verify FAQ Page
	static Map<String,String> verifyFAQPage=new LinkedHashMap<String, String>();
	static Map<String,String> validateFAQPage=new LinkedHashMap<String, String>();

//======================2nd Part=================================================================

	static
	{
		defaultFun.put("default","");
		defaultFun.put("default-2","");
	
	// verify Login Functionality
		verifyLogin.put("Step 1 : ","Open the Browser and Enter the site url.");
		verifyLogin.put("Step 2 : ","Enter Valid UserName");
		verifyLogin.put("Step 3 : ","Enter Valid Password");
		verifyLogin.put("Step 4 : ","Click Login button");
		verifyLogin.put("Step 5 : ","User has logged in successfully.");

   // --------------- FAQ Page --------------------------------------------------------
		//Verify FAQ Page
		verifyFAQPage.put("Step 1 : ","Login with Valid Credential");
		verifyFAQPage.put("Step 2 : ","Open the FAQ page");
		verifyFAQPage.put("Step 3 : ","FAQ Page is opening successfully.");
		
		//Validate FAQ Page Data
		validateFAQPage.put("Step 1 : ","Login with Valid Credential");
		validateFAQPage.put("Step 2 : ","Open the FAQ page");
		validateFAQPage.put("Step 3 : ","Select HRMS 2.0 Module");
		validateFAQPage.put("Step 4 : ","Select Employee Creation Transaction");
		validateFAQPage.put("Step 5 : ","Click on the Get Details");
		validateFAQPage.put("Step 6 : ","Data is showing correctly according to filter.");
	}
	
 // ===========================3rd Part===========================================================================
	
		// verify Login Functionality
		public static Map<String,String> getFuncnctionlity(String key)
		{
			System.out.println("getFuncnctionlity-key : "+key);
			// verify Login Functionality
			if(key.equalsIgnoreCase("verifyLogin"))
			{
				return verifyLogin;
			}
	// ------------------------------ FAQ Mgmt -------------------------------------------------------			
			
			else if(key.equalsIgnoreCase("verifyFAQPage"))
			{
				return verifyFAQPage;
			}
			else if(key.equalsIgnoreCase("validateFAQPage"))
			{
				return validateFAQPage;
			}
			
		return defaultFun;
	}

}
