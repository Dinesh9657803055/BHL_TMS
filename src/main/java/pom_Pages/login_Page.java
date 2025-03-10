package pom_Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_base.BaseClass;
import test_utility.ReusableMethods;

public class login_Page extends BaseClass {

	@FindBy(xpath = "//h3[@class=\"MuiTypography-root MuiTypography-h3 css-29k346\"]") private WebElement WelcomeText;
	@FindBy(id = ":r0:") private WebElement LoginButton;
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-1qw1d3q\"]") private WebElement LoginScreenText;
	@FindBy(id = ":r1:") private WebElement Email_Id;
	@FindBy(id = ":r2:") private WebElement Password;
	@FindBy(id = ":r3:") private WebElement ClickLoginButton;
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ewjb64\"]") private WebElement NameOfUSer;
	@FindBy(xpath = "//p[text()='Log out']") private WebElement LogoutButton;
	@FindBy(xpath ="//button[text()='Yes, Logout!']")private WebElement LogoutConfirmation;
	@FindBy(xpath = "//h6[text()=\"TRANSPORT MANAGEMENT SYSTEM\"]") public WebElement afterLogoutText;
	@FindBy(xpath = "//p[text()=\"© 2024. BHL Group. All rights reserved.\"]//preceding::button") private WebElement AfterLogoutNewLoginButton;
	@FindBy(name ="email") private WebElement EnterEmailForRelogin;
	@FindBy(name = "password") private WebElement EnterPasswordForRelogin;
	@FindBy(xpath = "//div[@class=\"MuiBox-root css-ou2fs7\"]//following::button")private WebElement ClickLoginButtonAfterLogout;
	@FindBy(xpath = "//p[text()=\"Email is required\"]") private WebElement ErrorMessageEmail;
	@FindBy(xpath = "//p[text()=\"Password is required\"]") private WebElement ErrorMessagePassword;

	public login_Page() {
		PageFactory.initElements(driver, this);	 
	}

	public String Verify_Welcome_Text() {
		return WelcomeText.getText();		
	}

	public void clickLoginButtonOnWelcomeScreen() throws InterruptedException {
		ReusableMethods.explicitWaitForClick(LoginButton);
		//Thread.sleep(3000);
		LoginButton.click();		
	}

	public String LoginScreenText() {
		ReusableMethods.explicitWait(LoginScreenText);
		return LoginScreenText.getText();		
	}

	public void EnterEmailId(String Enter_Email_Id) {
		ReusableMethods.explicitWait(Email_Id);
		Email_Id.click();
		Email_Id.sendKeys(Enter_Email_Id);
	}
	public void EnterEmailIdForRelogin(String Enter_Email_Id_2) {
		ReusableMethods.explicitWait(EnterEmailForRelogin);
		EnterEmailForRelogin.click();
		EnterEmailForRelogin.sendKeys(Enter_Email_Id_2);
	}

	public void EnterPassword(String Enter_Password) {
		ReusableMethods.explicitWait(Password);
		Password.click();
		Password.sendKeys(Enter_Password);
	}

	public void EnterPasswordForRelogin(String Enter_Password2) {
		ReusableMethods.explicitWait(EnterPasswordForRelogin);
		EnterPasswordForRelogin.click();
		EnterPasswordForRelogin.sendKeys(Enter_Password2);
	}

	public void clickLoginButonOnMainLoginScreen() {
		ReusableMethods.explicitWait(ClickLoginButton);
		ReusableMethods.scrollDown(ClickLoginButton);
		ClickLoginButton.click();
	}

	public void clickLoginButtonAfterLogoutonWelcomeScreen() {
		ReusableMethods.explicitWait(AfterLogoutNewLoginButton);
		AfterLogoutNewLoginButton.click();
	}

	public String NameOfTheUSer() {
		ReusableMethods.explicitWait(NameOfUSer);
		return NameOfUSer.getText();
	}


	public void LoginFlow (String Enter_Email_Id , String Enter_Password) {		
		EnterEmailId(Enter_Email_Id);
		EnterPassword(Enter_Password);
		clickLoginButonOnMainLoginScreen();		
	}


	public String Logout() throws InterruptedException {
		Thread.sleep(3000);
		ReusableMethods.explicitWait(LogoutButton);
		LogoutButton.click();
		ReusableMethods.explicitWait(LogoutConfirmation);
		LogoutConfirmation.click();
		return afterLogoutText.getText();
	}

	public void Relogin(String Enter_Email_Id_2 , String Enter_Password2) throws InterruptedException {
		clickLoginButtonAfterLogoutonWelcomeScreen() ;
		EnterEmailIdForRelogin(Enter_Email_Id_2);
		EnterPasswordForRelogin(Enter_Password2);
		ReusableMethods.scrollDown(ClickLoginButtonAfterLogout);
		ReusableMethods.explicitWaitForClick(ClickLoginButtonAfterLogout);
		ClickLoginButtonAfterLogout.click();
	}

	public String verifyErrorMessageForEmailId() throws InterruptedException {
		clickLoginButonOnMainLoginScreen();
		ReusableMethods.explicitWait(ErrorMessageEmail);
		return ErrorMessageEmail.getText();
	}

	public String verifyErrorMessageForPassword() throws InterruptedException {
		//clickLoginButton();
		ReusableMethods.explicitWait(ErrorMessagePassword);
		return ErrorMessagePassword.getText();
	}
}
