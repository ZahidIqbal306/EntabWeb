package Entab.ERP.Resources;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constant {
	
	static Map<String,String> defaultFun=new LinkedHashMap<String, String>();	

//======================1st Part =================================================================
	
	// verify Login Functionality
	static Map<String,String> verifyLogin =new LinkedHashMap<String, String>();
	
	// Verify Home Page
	static Map<String,String> verifyLoginUserName=new LinkedHashMap<String, String>();
	static Map<String,String> verifyProfile=new LinkedHashMap<String, String>();
	static Map<String,String> verifyChangePasswordText=new LinkedHashMap<String, String>();


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

   // --------------- Home Page --------------------------------------------------------
		//Verify Login User Name
		verifyLoginUserName.put("Step 1 : ","Login with Valid Credential.");
		verifyLoginUserName.put("Step 2 : ","Verify the Login username.");
		verifyLoginUserName.put("Step 3 : ","Username is showing correctly.");
	
		//Verify Profile Menu
		verifyProfile.put("Step 1 : ","Login with Valid Credential.");
		verifyProfile.put("Step 2 : ","Click on the Employee Name.");
		verifyProfile.put("Step 3 : ","Verify the Profile Submenu.");
		verifyProfile.put("Step 4 : ","Profile menu is showing.");
		
		//Verify Login User Name
		verifyChangePasswordText.put("Step 1 : ","Login with Valid Credential.");
		verifyChangePasswordText.put("Step 2 : ","Click on the Employee Name.");
		verifyChangePasswordText.put("Step 3 : ","Verify the Change Password Submenu.");
		verifyChangePasswordText.put("Step 4 : ","Change Password Submenu is showing.");
		

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
	// ------------------------------ Home Page -------------------------------------------------------			
			
			else if(key.equalsIgnoreCase("verifyLoginUserName"))
			{
				return verifyLoginUserName;
			}
			else if(key.equalsIgnoreCase("verifyProfile"))
			{
				return verifyProfile;
			}
			else if(key.equalsIgnoreCase("verifyChangePasswordText"))
			{
				return verifyChangePasswordText;
			}
			
		return defaultFun;
	}

}
