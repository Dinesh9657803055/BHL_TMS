package pom_Pages;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List.*;
import test_base.BaseClass;
import test_utility.ReusableMethods;

public class Add_UserGroup extends BaseClass {

	@FindBy(xpath = "//div[text()='User Groups']")
	private WebElement UserGroupPageText;
	@FindBy(xpath = "//div[text()='Operations Portal']")
	private WebElement OperationsPortalText;
	@FindBy(xpath = "//*[text()='Add User Group']")
	private WebElement AddUserGroupText;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement SaveButton;
	@FindBy(xpath = "//p[text()='Completed Trip Database']")
	private WebElement DummyText;
	@FindBy(xpath = "//p[text()='Access Type is required']")
	private WebElement ErrorValidationCheck;
	@FindBy(name = "accessType")
	private WebElement AccessTypeInput;
	@FindBy(name = "title")
	private WebElement RoleNameInput;
	@FindBy(xpath = "//em[text()='Select basic user']") private WebElement BasicUM;
	@FindBy(xpath = "//LI[@class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1dpxl35\"]")
	private java.util.List<WebElement>  RoleOptionsTextList;
	
	public Add_UserGroup() {
		PageFactory.initElements(driver, this);
	}

	public String clickOnUserGroup() {
		ReusableMethods.explicitWait(UserGroupPageText);
		UserGroupPageText.click();
		ReusableMethods.explicitWait(OperationsPortalText);
		OperationsPortalText.click();
		ReusableMethods.explicitWait(AddUserGroupText);
		String UGtext = AddUserGroupText.getText();
		AddUserGroupText.click();
		return UGtext;
	}

	public String verifyErrorValidation() throws InterruptedException {
		ReusableMethods.explicitWait(DummyText);
		Thread.sleep(3000);
		SaveButton.click();
		ReusableMethods.explicitWait(ErrorValidationCheck);
		String ErrorValidation = ErrorValidationCheck.getText();
		return ErrorValidation;
	}
	
	public java.util.List<String> VerifyDropdownListingOptionsForUserManagement() throws InterruptedException {
	    java.util.List<String> RoleOptionsList = new ArrayList<String>();
	    Thread.sleep(3000);
	    ReusableMethods.explicitWait(BasicUM);
	    BasicUM.click();
	    Thread.sleep(3000);
	    
	    java.util.List<WebElement> RoleOptions = RoleOptionsTextList;
	    
	    // Instead of printing the WebElement list, print after extracting text
	    for (WebElement ele : RoleOptions) {
	        RoleOptionsList.add(ele.getText());
	    }
	    
	    System.out.println("Role Values are: " + RoleOptionsList);  // This prints the list of text strings
	    
	    BasicUM.click();
	    return RoleOptionsList;
	}


	public void addUser() {
		ReusableMethods.explicitWait(AccessTypeInput);
		ReusableMethods.scrollDown(AccessTypeInput);
		AccessTypeInput.click();
		AccessTypeInput.sendKeys("Test User through Automation ");
		ReusableMethods.explicitWait(RoleNameInput);
		RoleNameInput.click();
		RoleNameInput.sendKeys("Test Role by Automation");
	}

}
