package com.BHL;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom_Pages.SideBarMenu;
import pom_Pages.login_Page;
import report.ExtentManager;

@Listeners(ExtentManager.class)
public class TC002_DashboardPageTest extends BeforeAfterMethods {
	login_Page login;

	SideBarMenu Side;
	@BeforeClass
	public void setUp() {		
		Side = new SideBarMenu();
		login = new login_Page();
		/*login.isUserLoggedIn();
		login.loginIfRequired("chitra@mailinator.com", "Test@123");*/
	}

	//@BeforeMethod
	public void assertion() {
		//	soft = new SoftAssert();
	}

	//@AfterClass
	public void assertionAll() {
		//	soft.assertAll();
	}

	// Arraylist for Expected Side Bar Menu List 
	public static List<String> ExpectedSideBarMenuListText (){
		List<String> ExpectedSideBarMenuList = new ArrayList<String>();
		ExpectedSideBarMenuList.add("User Groups");
		ExpectedSideBarMenuList.add("User Databases");
		ExpectedSideBarMenuList.add("Databases"); 
		ExpectedSideBarMenuList.add("DB Approvals");
		ExpectedSideBarMenuList.add("Module Approvals");
		ExpectedSideBarMenuList.add("Alert Dashboard"); 
		ExpectedSideBarMenuList.add("Reports");		
		return ExpectedSideBarMenuList;
	}

	// Arraylist for Expected User Group List 

	public static List<String> ExpectedUserGroupListText(){
		List<String> ExpectedUserGroupList = new ArrayList<String>();
		ExpectedUserGroupList.add("Operations Portal");
		return ExpectedUserGroupList;
	}

	// Arraylist for Expected User Databases List 

	public static List<String> ExpectedUserDatabasesText (){
		List<String> ExpectedUserDatabasesList = new ArrayList<String>();
		ExpectedUserDatabasesList.add("Operations Portal");
		ExpectedUserDatabasesList.add("Fuel Attendants");
		ExpectedUserDatabasesList.add("User Audit Logs"); 
		ExpectedUserDatabasesList.add("Site Representatives");
		return ExpectedUserDatabasesList;
	}

	// Arraylist for Expected  Databases List  

	public static List<String> ExpectedDatabasesText() {
		List<String> ExpectedDatabasesList = new ArrayList<String>();
		ExpectedDatabasesList.add("Active Trips");
		ExpectedDatabasesList.add("BHL Companies");
		ExpectedDatabasesList.add("Buckets");
		ExpectedDatabasesList.add("Completed Trips");
		ExpectedDatabasesList.add("Container Models");
		ExpectedDatabasesList.add("Contracts");
		ExpectedDatabasesList.add("Countries");
		ExpectedDatabasesList.add("Currency");	
		ExpectedDatabasesList.add("Customers");
		ExpectedDatabasesList.add("Drivers");
		ExpectedDatabasesList.add("Fleets");
		ExpectedDatabasesList.add("Fuel Stations");
		ExpectedDatabasesList.add("Materials");
		ExpectedDatabasesList.add("Orders");
		ExpectedDatabasesList.add("Planned Trips");
		ExpectedDatabasesList.add("Refueling Logs");
		ExpectedDatabasesList.add("Rest Points");
		ExpectedDatabasesList.add("Routes");	
		ExpectedDatabasesList.add("SubContractors");
		ExpectedDatabasesList.add("Trailer Models");
		ExpectedDatabasesList.add("Trailers");
		ExpectedDatabasesList.add("Vehicle Models");
		ExpectedDatabasesList.add("Vehicles");
		return ExpectedDatabasesList;
	}

	// Arraylist for Expected User Databases List 
	public static List<String> ExpectedDB_Approvals_Text() {
		List<String> ExpectedDB_Approval_List = new ArrayList<String>();
		ExpectedDB_Approval_List.add("Customers");
		ExpectedDB_Approval_List.add("Drivers");
		ExpectedDB_Approval_List.add("Trailers");
		ExpectedDB_Approval_List.add("Vehicles");	
		return ExpectedDB_Approval_List;
	}

	// Arraylist for Expected Module Approval List
	public static List<String> Expected_Module_Approval_Text() {
		List<String> Expected_Moudle_Approval_List =new ArrayList<String>();
		Expected_Moudle_Approval_List.add("Activate Trips");
		Expected_Moudle_Approval_List.add("Complete Trips");
		Expected_Moudle_Approval_List.add("Deactivate Trips");
		Expected_Moudle_Approval_List.add("POD Documents");
		Expected_Moudle_Approval_List.add("Reactivate Trips");	
		Expected_Moudle_Approval_List.add("Refueling Log");
	
		return Expected_Moudle_Approval_List;
	}

	public static List<String> Expected_TripAlert_Text() {
		List<String> Expected_Trip_Alert_List =new ArrayList<String>();
		Expected_Trip_Alert_List.add("Trip Alerts");
		return Expected_Trip_Alert_List;
	}

	public static List<String> Expected_ReportListing_Text() {
		List<String> ExpectedReportListing = new ArrayList<String>();		
		ExpectedReportListing.add("Assets Reports");
		ExpectedReportListing.add("Compliance Reports");
		ExpectedReportListing.add("Refueling Reports");
		ExpectedReportListing.add("Trip Reports");
		
		return ExpectedReportListing;
	}


	@Test(priority = 1)
	public void TC001_VerifySideBarMenuList() throws InterruptedException {
		List<String> ActualSideMenuBarListing = Side.verifySideMenuBarListing().stream().map(String::toLowerCase).toList();
		List<String> ExpectedSideMenuBarListing = ExpectedSideBarMenuListText().stream().map(String::toLowerCase).toList();		
		soft.assertEquals(ActualSideMenuBarListing, ExpectedSideMenuBarListing);		
		//BeforeAfterMethods.soft.assertEquals(ActualSideMenuBarListing, ExpectedSideMenuBarListing);
		//ExtentManager.onTestPass("Verified Successfully - Side Menu Bar Listing");

	}

	@Test(priority = 2)
	public void TC002_VerifyUserGroupList() throws InterruptedException {
		List<String> ActualUserGroupListing = Side.VerifyUserGroupDropdownListing().stream().map(String::toLowerCase).toList();
		List<String> ExpectedUserGroupListing = ExpectedUserGroupListText().stream().map(String::toLowerCase).toList();		
		soft.assertEquals(ActualUserGroupListing, ExpectedUserGroupListing);
		//BeforeAfterMethods.soft.assertEquals(ActualUserGroupListing, ExpectedUserGroupListing); 
		//	ExtentManager.onTestPass("Verified Successfully - Side Menu Bar Listing");
	}

	@Test(priority = 3)
	public void TC003_VerifyUSerDatabasesListing() throws InterruptedException {
		List<String> ActualListUserDatabases = Side.VerifyUserDatabasesListing().stream().map(String::toLowerCase).toList();
		List<String> ExpectedListUserDatabases = ExpectedUserDatabasesText().stream().map(String::toLowerCase).toList();		
		soft.assertEquals(ActualListUserDatabases, ExpectedListUserDatabases);
		//	ExtentManager.onTestPass("Verified Successfully - UserDatabasesListing");
	}

	@Test(priority = 4)
	public void TC004_VerifyDatabasesListing() throws InterruptedException {
		List<String> ActualDatabsesListing = Side.VerifyDatabasesListing().stream().map(String::toLowerCase).toList();
		List<String> ExpectedDatabasesListing = ExpectedDatabasesText().stream().map(String::toLowerCase).toList();
		soft.assertEquals(ActualDatabsesListing, ExpectedDatabasesListing);
		//	ExtentManager.onTestPass("Verified Successfully - Databases");
	}

	@Test(priority = 5)
	public void TC005_Verify_DB_Approval() throws InterruptedException {
		List<String> Expected_DB_ApprovalT_List = ExpectedDB_Approvals_Text().stream().map(String::toLowerCase).toList();
		List<String> Actual_DB_Approval_List = Side.VerifyDB_ApprovalListing().stream().map(String::toLowerCase).toList();
		soft.assertEquals(Actual_DB_Approval_List, Expected_DB_ApprovalT_List);
		//	ExtentManager.onTestPass("Verified Successfully - DB Approval Listing");
	}

	@Test(priority = 6)
	public void TC006_Verify_Module_Approval() throws InterruptedException {
		List<String> Expected_Module_Approval_List = Expected_Module_Approval_Text().stream().map(String::toLowerCase).toList();
		List<String> Actual_Module_Approval_List = Side.Verify_Module_Approval_Listing().stream().map(String::toLowerCase).toList();
		soft.assertEquals(Actual_Module_Approval_List, Expected_Module_Approval_List);
		//	ExtentManager.onTestPass("Verified Successfully  - Module Approval Listing");
	}

	@Test(priority = 7)
	public void TC007_Verify_Trip_Alert() throws InterruptedException {
		List<String> Expected_Trip_Alert = Expected_TripAlert_Text().stream().map(String::toLowerCase).toList();
		List<String> Actual_Trip_Alert =Side.Verify_AlertDasboardListing().stream().map(String::toLowerCase).toList();
		soft.assertEquals(Actual_Trip_Alert, Expected_Trip_Alert);
		//	ExtentManager.onTestPass("Veridfied Successfully - Trip Alert Listing");
	}

	@Test(priority = 8)
	public void TC008_Verify_Report() throws InterruptedException {
		List<String> Expected_Report_Listing = Expected_ReportListing_Text().stream().map(String::toLowerCase).toList();
		List<String> Actual_Report_Listing =  Side.VerifyReportListing().stream().map(String::toLowerCase).toList();
		soft.assertEquals(Actual_Report_Listing, Expected_Report_Listing);
		//	ExtentManager.onTestPass("Verified Report Listing - Successfully");
	}
}
