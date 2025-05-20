package com.BHL;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pom_Pages.Add_UserGroup;
import pom_Pages.SideBarMenu;
import pom_Pages.login_Page;
import report.ExtentManager;

@Listeners(ExtentManager.class)
public class TC003_UserGroupAdd extends BeforeAfterMethods {

	login_Page login;
	SideBarMenu Side;
	Add_UserGroup addUG;

	@BeforeClass
	public void setUp() {
		Side = new SideBarMenu();
		login = new login_Page();
		addUG = new Add_UserGroup();
	}
	public static List<String> ExpectedRoles (){
		List<String> ExpectedRoleList = new ArrayList<String>();
		ExpectedRoleList.add("Edits");
		ExpectedRoleList.add("View");
		ExpectedRoleList.add("No"); 	
		return ExpectedRoleList;
	}

	@Test(priority = 1)
	public void VerifyAddUserGroupPage() throws InterruptedException {
		System.out.println("in test case 3 ");
		String ExpectedUGT_Text = "Add User Group";
		String ActualUG_Text = addUG.clickOnUserGroup();
		soft.assertEquals(ActualUG_Text, ExpectedUGT_Text);
	}

	@Test(priority = 2)
	public void verifyErrorValidationForAddUserGroup() throws InterruptedException {
		System.out.println("validating the Error validation is present for the Add user group form");
		String Expectedtext = "Access Type is required";
		String actualText = addUG.verifyErrorValidation();
		System.out.println("error validation expected text : "+ actualText);	
		soft.assertEquals(actualText, Expectedtext);
		
	}
	@Test(priority = 3)
	public void verifyRoleOptions() throws InterruptedException {

	//	addUG.VerifyDropdownListingOptionsForUserManagement();
		List<String> ActualRoles = addUG.VerifyDropdownListingOptionsForUserManagement().stream().map(String::toLowerCase).toList();
		List<String> ExpectedRoles= ExpectedRoles().stream().map(String::toLowerCase).toList();
			
		
		System.out.println("Actual roled are " + ActualRoles);
		System.out.println("expected roled are " + ExpectedRoles);
		
		soft.assertEquals(ActualRoles, ExpectedRoles);
	}
		
	
	//@Test(priority = 3)
	public void AddUserGroup() {
		System.err.println("Adding a new user group");
		addUG.addUser();
	}
}
