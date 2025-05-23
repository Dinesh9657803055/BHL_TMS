package com.BHL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom_Pages.login_Page;
import report.ExtentManager;

public class TC001_LoginPageTest extends BeforeAfterMethods {

	login_Page login ;
	//SoftAssert soft ;
	//SideBarMenu Side;

	@BeforeClass
	public void setUp() {
		login  = new login_Page();
		//soft = new SoftAssert();
		//setup(); // driver 
		//Side = new SideBarMenu();
	}
	
	@Test(priority = 1)
	public void TC_001_verify_WelcomeText_On_LoginPage() {
		String ActualText= login.Verify_Welcome_Text();
		String ExpectedText = "Welcome to\r\n"
				+ "BHL GROUP’S";
		System.out.println(ActualText);

		// Normalize line breaks (convert to consistent format)
		String normalizedExpected = ExpectedText.replace("\r\n", "\n");
		String normalizedActual = ActualText.replace("\r\n", "\n");
		
		// Now compare the normalized text
		soft.assertEquals(ActualText, normalizedExpected, normalizedActual);
		//Assert.assertEquals(normalizedActual, normalizedExpected, "Welcome text is incorrect");
	//	ExtentManager.onTestPass("Verified Welcome text is Correct");
	}

	@Test(priority = 2)
	public void TC_002_verify_Login_Button_Clickable() throws InterruptedException {
		login.clickLoginButtonOnWelcomeScreen();
		String ActualText= login.LoginScreenText();
		String ExpectedText = "Please enter your email address and password to log in and gain access to the platform.";
		
		System.out.println("Login Screen Actual Text :- " + ActualText);

		// Now compare the normalized text
		soft.assertEquals(ActualText, ExpectedText, "Welcome text is incorrect");
	//	ExtentManager.onTestPass("Verified LoginScreen text is Correct");
		
	}

	@Test(priority = 3)
	public void TC003_verify_ErrorMessageForEmailField() throws InterruptedException {
		String ActualError =login.verifyErrorMessageForEmailId();
		System.out.println("Error message for emial id : " + login.verifyErrorMessageForEmailId());
		String ExpectedError ="Email is required";		
		soft.assertEquals(ActualError, ExpectedError);
	//	ExtentManager.onTestPass("Verified Error Message is present for the Email field if it left blank");
	}

	@Test(priority = 4)
	public void TC004_verify_ErrorMessageForPasswordField() throws InterruptedException {
		String ActualError =login.verifyErrorMessageForPassword();
		System.out.println("Error message for emial id : " + login.verifyErrorMessageForPassword());
		String ExpectedError ="Password is required";		
		soft.assertEquals(ActualError, ExpectedError);
	//	ExtentManager.onTestPass("Verified Error Message is present for the Email field if it left blank");
	}

	@Test(priority = 5)
	public void TC_005_verify_Login() {			
		login.LoginFlow("chitra@mailinator.com","Test@123");		
	//	ExtentManager.onTestPass("Logged in succesflly With Valid Credentials");
		//System.out.println(login.NameOfTheUSer());
		String ExpectedText="Chitra Patil";
		
		// Normalize line breaks (convert to consistent format)
		String normalizedExpected = ExpectedText.replace("\r\n", "\n");
		//String normalizedActual = ActualText.replace("\r\n", "\n");	
		soft.assertNotEquals(normalizedExpected,login.NameOfTheUSer(),"The user name does not match" );
	//	ExtentManager.onTestPass("Verified UserName text is Correct with the which is logged in");
	}
	
	@Test(priority = 6)
	public void TC_006_Logout() throws InterruptedException {
		String ExpectedAccInfoTExt = "Account Information";
		String ActualTExt = login.verifyAccountInfo();	
		soft.assertEquals(ActualTExt, ExpectedAccInfoTExt);
		
	}

	@Test(priority = 7)
	public void TC_007_LogoutFlow() throws InterruptedException {
		String ActualText = login.Logout();
		String expectedText = "TRANSPORT MANAGEMENT SYSTEM";	
		System.out.println("Login Screen Text after logout : " + login.afterLogoutText.getText());
		soft.assertEquals(ActualText, expectedText);
//		ExtentManager.onTestPass("Verified Logout is working fine and navigating user to the Login Screen");
	}

	@Test(priority = 8)
	public void TC_008_reloginToBHL() throws InterruptedException{
		login.Relogin("chitra@mailinator.com","Test@123");
	//	ExtentManager.onTestPass(" Re - Logged in successfully With Valid Credentials of User");		
		System.out.println(login.NameOfTheUSer());
		String ExpectedText="Chitra Patil";
		String ActualText =login.NameOfTheUSer();
		// Normalize line breaks (convert to consistent format)
		String normalizedExpected = ExpectedText.replace("\r\n", "\n");
		String normalizedActual = ActualText.replace("\r\n", "\n");	
		soft.assertEquals(normalizedActual, normalizedExpected);
	//	ExtentManager.onTestPass("Verified Username text is Correct with the which is logged in again after the logout");
	}
	
	
}
