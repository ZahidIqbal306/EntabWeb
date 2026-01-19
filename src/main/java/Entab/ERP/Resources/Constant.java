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
	static Map<String,String> verifyUserId=new LinkedHashMap<String, String>();
	static Map<String,String> verifyChangePasswordText=new LinkedHashMap<String, String>();

	// Verify Location Master Page
	static Map<String,String> verifyLocationMasterPage=new LinkedHashMap<String, String>();
	static Map<String,String> verifyAddLocationMandatoryField=new LinkedHashMap<String, String>();
	static Map<String,String> verifyAddNewLocationion=new LinkedHashMap<String, String>();
	static Map<String,String> verifyUpdateLocationPage=new LinkedHashMap<String, String>();
	static Map<String,String> verifyUpdateLocation=new LinkedHashMap<String, String>();
	static Map<String,String> verifyDuplicateLocationName=new LinkedHashMap<String, String>();
	static Map<String,String> verifyDeleteLocation=new LinkedHashMap<String, String>();
	static Map<String,String> verifyDetetedUsedLocation=new LinkedHashMap<String, String>();
	static Map<String,String> verifyDeactivateLocation=new LinkedHashMap<String, String>();
	static Map<String,String> verifyActivateLocation=new LinkedHashMap<String, String>();




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
		verifyUserId.put("Step 1 : ","Login with Valid Credential.");
		verifyUserId.put("Step 2 : ","Verify the Login user Id.");
		verifyUserId.put("Step 3 : ","User Id is showing correctly.");
		
		//Verify Login User Name
		verifyChangePasswordText.put("Step 1 : ","Login with Valid Credential.");
		verifyChangePasswordText.put("Step 2 : ","Click on the Employee Name.");
		verifyChangePasswordText.put("Step 3 : ","Verify the Change Password Submenu.");
		verifyChangePasswordText.put("Step 4 : ","Change Password Submenu is showing.");
		
   // --------------- Location Master Page --------------------------------------------------------

		//Verify Location Master Page
		verifyLocationMasterPage.put("Step 1 : ","Login with Valid Credential.");
		verifyLocationMasterPage.put("Step 2 : ","Click on the Menu Button.");
		verifyLocationMasterPage.put("Step 3 : ","Go to the Inventory Module.");
		verifyLocationMasterPage.put("Step 4 : ","Open the Location Master page - Setting > Location Master Page.");
		verifyLocationMasterPage.put("Step 5 : ","Location Master page is opened successfully.");
		
		//Verify Add Location Mandatory Fields
		verifyAddLocationMandatoryField.put("Step 1 : ","Login with Valid Credential.");
		verifyAddLocationMandatoryField.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyAddLocationMandatoryField.put("Step 3 : ","Click on the add new Location button.");
		verifyAddLocationMandatoryField.put("Step 4 : ","Verify the mandatory field.");
		verifyAddLocationMandatoryField.put("Step 5 : ","Company and Location mandatory fields are highlighted with red color border.");

		//Verify Add New Location 
		verifyAddNewLocationion.put("Step 1 : ","Login with Valid Credential.");
		verifyAddNewLocationion.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyAddNewLocationion.put("Step 3 : ","Click on the add new Location button.");
		verifyAddNewLocationion.put("Step 4 : ","Fill the all mandatory field.");
		verifyAddNewLocationion.put("Step 5 : ","Click on the save button");
		verifyAddNewLocationion.put("Step 6 : ","Location has been added successfully.");
		
		//Verify Update Location Page
		verifyUpdateLocationPage.put("Step 1 : ","Login with Valid Credential.");
		verifyUpdateLocationPage.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyUpdateLocationPage.put("Step 3 : ","Edit any Location.");
		verifyUpdateLocationPage.put("Step 4 : ","Validate the Update Location Heder Text.");
		verifyUpdateLocationPage.put("Step 5 : ","Update location page is opened successfully.");
		
		//Verify Update Location 
		verifyUpdateLocation.put("Step 1 : ","Login with Valid Credential.");
		verifyUpdateLocation.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyUpdateLocation.put("Step 3 : ","Edit any Location.");
		verifyUpdateLocation.put("Step 4 : ","Update the location field.");
		verifyUpdateLocation.put("Step 5 : ","Click on the update button");
		verifyUpdateLocation.put("Step 6 : ","Location has been updated successfully.");
		
		//Verify Duplicate Location Name
		verifyDuplicateLocationName.put("Step 1 : ","Login with Valid Credential.");
		verifyDuplicateLocationName.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyDuplicateLocationName.put("Step 3 : ","Click on the add new Location button.");
		verifyDuplicateLocationName.put("Step 4 : ","Enter the exist location name and saved it.");
		verifyDuplicateLocationName.put("Step 5 : ","This location is already exist, alert is getting.");
		
		//Verify Delete Location - Which are not in used.
		verifyDeleteLocation.put("Step 1 : ","Login with Valid Credential.");
		verifyDeleteLocation.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyDeleteLocation.put("Step 3 : ","Delete any location which is not in used.");
		verifyDeleteLocation.put("Step 4 : ","Location has been deleted successfully.");

		//Verify Delete Location - Which are in used.
		verifyDetetedUsedLocation.put("Step 1 : ","Login with Valid Credential.");
		verifyDetetedUsedLocation.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyDetetedUsedLocation.put("Step 3 : ","Delete any location which is already in used.");
		verifyDetetedUsedLocation.put("Step 4 : ","Getting an Alert - Location Is Already In Used.");
		
		//Verify Deactivate Location
		verifyDeactivateLocation.put("Step 1 : ","Login with Valid Credential.");
		verifyDeactivateLocation.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyDeactivateLocation.put("Step 3 : ","Now deactivate the active location.");
		verifyDeactivateLocation.put("Step 4 : ","Location has been deactivated successfully.");
		
		//Verify Activate Location
		verifyActivateLocation.put("Step 1 : ","Login with Valid Credential.");
		verifyActivateLocation.put("Step 2 : ","Open the Inventory > Location Master Page");
		verifyActivateLocation.put("Step 3 : ","Now Activate the deactive location.");
		verifyActivateLocation.put("Step 4 : ","Location has been Activated successfully.");	
	
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
			else if(key.equalsIgnoreCase("verifyUserId"))
			{
				return verifyUserId;
			}
			else if(key.equalsIgnoreCase("verifyChangePasswordText"))
			{
				return verifyChangePasswordText;
			}
	
	// ------------------------------ Location Master Page -------------------------------------------------------			
			else if(key.equalsIgnoreCase("verifyLocationMasterPage"))
			{
				return verifyLocationMasterPage;
			}
			else if(key.equalsIgnoreCase("verifyAddLocationMandatoryField"))
			{
				return verifyAddLocationMandatoryField;
			}
			else if(key.equalsIgnoreCase("verifyAddNewLocationion"))
			{
				return verifyAddNewLocationion;
			}
			else if(key.equalsIgnoreCase("verifyUpdateLocationPage"))
			{
				return verifyUpdateLocationPage;
			}
			else if(key.equalsIgnoreCase("verifyUpdateLocation"))
			{
				return verifyUpdateLocation;
			}
			else if(key.equalsIgnoreCase("verifyDuplicateLocationName"))
			{
				return verifyDuplicateLocationName;
			}
			else if(key.equalsIgnoreCase("verifyDeleteLocation"))
			{
				return verifyDeleteLocation;
			}
			else if(key.equalsIgnoreCase("verifyDetetedUsedLocation"))
			{
				return verifyDetetedUsedLocation;
			}
			else if(key.equalsIgnoreCase("verifyDeactivateLocation"))
			{
				return verifyDeactivateLocation;
			}
			else if(key.equalsIgnoreCase("verifyActivateLocation"))
			{
				return verifyActivateLocation;
			}
			
		return defaultFun;
	}

}
