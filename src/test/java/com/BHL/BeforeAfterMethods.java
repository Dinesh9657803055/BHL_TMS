package com.BHL;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import report.ExtentManager;
import test_base.BaseClass;

public class BeforeAfterMethods extends BaseClass {

	//public static SoftAssert soft ;
	SoftAssert soft ;
	@BeforeSuite
	public void beforeSuitMethod() {
		
	//	ExtentManager.onStart();
		soft = new SoftAssert();
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass 
	public  void setup() {	
		if (driver == null) {
			driverSetup(); 
		}		
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
	//	ExtentManager.onTestSuccess(result.getMethod().getMethodName());		
	}
	
	
	//@AfterClass
	public void teardown() {
		driver.close();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			//ExtentManager.onTestFailure(result.getMethod().getMethodName());
	//		ExtentManager.onTestFailure(result);
			Assert.fail(result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SKIP) {
	//		ExtentManager.onTestSkipped(result.getMethod().getMethodName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
		}	
	
		//driver.close();
	}

	@AfterSuite
	public void afterSuite() {
			soft.assertAll();
		/*try {
			soft.assertAll();
		}
		
		catch (AssertionError e) {
			ExtentManager.test.log(Status.FAIL, "Test Failed ❌: " + e.getMessage()); // Log failure in Extent Reports
	            throw e; // Re-throw to mark test as failed in TestNG
		}		*/
	//	ExtentManager.onFlush();
		
	}

}