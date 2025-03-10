package pom_Pages;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test_base.BaseClass;
import test_utility.ReusableMethods;

public class SideBarMenu extends BaseClass {
	@FindBy(xpath = "//div[@role=\"button\"]//div[@class=\"MuiListItemText-root css-16j75na\"]") private List<WebElement> SideMenuListing;
	@FindBy(xpath = "//div[text()=\"User Groups\"]") private WebElement UserGroupDropdown;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]") private List<WebElement> UserGroupsListing;
	@FindBy(xpath = "//div[text()=\"Databases\"]") private WebElement DatabasesDropdown;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]") private List<WebElement> DatabasesListing;
	@FindBy(xpath = "//div[text()=\"User Databases\"]") private WebElement UserDataBases;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]") private List<WebElement> UserDataBaseListing;
	@FindBy(xpath = "//div[text()=\"Completed Trips\"]") private WebElement CompletedTripText;
	@FindBy(xpath = "//div[text()=\"DB approvals\"]") private WebElement DB_Approval;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-wrapper MuiCollapse-vertical css-hboir5\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]") private List<WebElement> DB_ApprovalListing;
	@FindBy(xpath = "//div[text()=\"Module approvals\"]") private WebElement ModuleApproval;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-wrapper MuiCollapse-vertical css-hboir5\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]") private List<WebElement> Module_Approval_Listing;
	@FindBy(xpath = "//div[text()=\"Alert Dashboard\"]") private WebElement AlertDasboard;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-wrapperInner MuiCollapse-vertical css-8atqhb\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]")private List<WebElement> AlertDashboardListing;
	@FindBy(xpath = "//div[text()=\"Reports\"]") private WebElement Reports;
	@FindBy(xpath = "//div[@class=\"MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr\"]//div[@class=\"MuiListItemText-root css-1tsvksn\"]") private List<WebElement> ReportListing;

	public  SideBarMenu( ) {
		PageFactory.initElements(driver,this);
	}

	// Method to verify the Side menu bar listing which have 7 Main options
	public List<String> verifySideMenuBarListing() {
		List<String> sideMenuListing = new ArrayList<String>();
		ReusableMethods.explicitWait(UserDataBases); // provided any element from the side bar listing to wait for can use anyone of 7
		List<WebElement> SideMenu  = SideMenuListing;
		for(WebElement ele :SideMenu) {
			sideMenuListing.add(ele.getText());
		}
		return sideMenuListing;
	}

	//Verify the USer Group Drop down Sub listing - which have 1 option
	public List<String> VerifyUserGroupDropdownListing() throws InterruptedException {
		List<String> UserGroupList = new ArrayList<String>();
		ReusableMethods.explicitWait(UserGroupDropdown);
		UserGroupDropdown.click();
		Thread.sleep(2000);
		List<WebElement> UserGroup = UserGroupsListing;
		for(WebElement ele : UserGroup) {
			UserGroupList.add(ele.getText());
		}
		UserGroupDropdown.click();
		return UserGroupList;
	}

	//verify the User Databases Drop down Listing which have 4 Options 
	public  List<String> VerifyUserDatabasesListing() throws InterruptedException {
		List<String> UserDatabasesText = new ArrayList<String>();
		ReusableMethods.explicitWait(UserDataBases);
		UserDataBases.click();
		Thread.sleep(3000);
		List<WebElement> UserDatabaseElements = UserDataBaseListing;
		for(WebElement element :UserDatabaseElements) { 
			UserDatabasesText.add(element.getText());
		}
		UserDataBases.click();
		return UserDatabasesText;
	}

	//verify the Databases Drop down Listing which have 23 Options 
	public List<String> VerifyDatabasesListing() throws InterruptedException {
		List<String> DatabasesText = new ArrayList<String>();
		ReusableMethods.explicitWait(DatabasesDropdown);
		Thread.sleep(2000);
		DatabasesDropdown.click();
		ReusableMethods.scrollDown(CompletedTripText);
		Thread.sleep(4000);		
		List<WebElement> DatabaseElement = DatabasesListing;
		for(WebElement ele : DatabaseElement) {
			DatabasesText.add(ele.getText());
		}
		DatabasesDropdown.click();
		return DatabasesText;
	}

	//verify the DB approval Listing having 4 options;

	public List<String> VerifyDB_ApprovalListing() throws InterruptedException {
		List<String> DB_ApprovalListText = new ArrayList<String>();
		ReusableMethods.explicitWait(DB_Approval);
		Thread.sleep(2000);
		DB_Approval.click();
		Thread.sleep(2000);
		List<WebElement> DB_ApprovalElement = DB_ApprovalListing; 
		for(WebElement ele : DB_ApprovalElement) {
			DB_ApprovalListText.add(ele.getText());
		}
		DB_Approval.click();
		return DB_ApprovalListText;
	}
	//verify the Module Approval listing Its having 6 options

	public List<String> Verify_Module_Approval_Listing() throws InterruptedException {
		List<String> ModuleApprobalText = new ArrayList<String>();
		ReusableMethods.explicitWaitForClick(ModuleApproval);
		Thread.sleep(2000);
		ModuleApproval.click();
		Thread.sleep(2000);
		List<WebElement> ModuleApprovalListing = Module_Approval_Listing;
		for (WebElement ele :ModuleApprovalListing ){
			ModuleApprobalText.add(ele.getText());
		}
		ModuleApproval.click();
		return ModuleApprobalText;
	}

	public List<String> Verify_AlertDasboardListing() throws InterruptedException {
		List<String> AlertDashboardList = new ArrayList<String>();
		ReusableMethods.explicitWait(AlertDasboard);
		Thread.sleep(2000);
		AlertDasboard.click();
		Thread.sleep(2000);
		
		List<WebElement> AlertListing = AlertDashboardListing;
		for(WebElement ele : AlertListing) {
			AlertDashboardList.add(ele.getText());
		}
		AlertDasboard.click();
		return AlertDashboardList;
	}
	
	public List<String> VerifyReportListing() throws InterruptedException {
		List<String> ReportListingText = new ArrayList<String>();
		ReusableMethods.explicitWait(Reports);
		Thread.sleep(2000);
		Reports.click();
		Thread.sleep(2000);
		List<WebElement> ReportsList = ReportListing;
		for (WebElement ele : ReportsList) {
			ReportListingText.add(ele.getText());
		}
		Reports.click();
		return ReportListingText;
	}
}
