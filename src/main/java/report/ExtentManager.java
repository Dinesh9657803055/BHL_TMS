package report;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize Extent Report before tests start
    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
        String repName = "Test-Report " + timeStamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./ExtentReport/" + repName);
        sparkReporter.config().setDocumentTitle("BHL Automation Report");
        sparkReporter.config().setReportName("Test Execution Results");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "BHL");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        System.out.println("Extent Report initialized.");
    }

    // On Test Start
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // On Test Success
    @Override
    public void onTestSuccess(ITestResult result) {
        Markup m = MarkupHelper.createLabel(result.getMethod().getMethodName() + " PASSED", ExtentColor.GREEN);
        test.log(Status.PASS, m);
    }

    // On Test Failure
    @Override
    public void onTestFailure(ITestResult result) {
        Markup m = MarkupHelper.createLabel(result.getMethod().getMethodName() + " FAILED", ExtentColor.RED);
        test.log(Status.FAIL, m);
        
     // Capture Base64 Screenshot & Attach it Directly to the Report
        String base64Screenshot = ScreenshotUtil.captureScreenshot();
        test.addScreenCaptureFromBase64String(base64Screenshot, "Screenshot on Failure");

        // Log the exception details
        if (result.getThrowable() != null) {
            test.fail(result.getThrowable());
        }      
    }

    @Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	// On Test Skip
    @Override
    public void onTestSkipped(ITestResult result) {
        Markup m = MarkupHelper.createLabel(result.getMethod().getMethodName() + " SKIPPED", ExtentColor.ORANGE);
        test.log(Status.SKIP, m);
    }

    // After All Tests are Done
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Extent Report generated.");
    }
}


/*import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import test_utility.ReusableMethods;

public class ExtentManager  {
	
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void onStart() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
		String repName = "Test-Report " + timeStamp + ".html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./ExtentReport/" + repName);
		sparkReporter.config().setDocumentTitle("WebAutomation");
		sparkReporter.config().setReportName("OpenXcell Technolabs");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "BHL");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Dinesh");
	}

	public static void onTestSuccess(String methodName) {
		test = extent.createTest(methodName).createNode(methodName);
	}

	public static void onTestPass(String msg) {
		Markup m = MarkupHelper.createLabel(msg, ExtentColor.GREEN);
		test.log(Status.PASS, m);
	}


	/*public static void onTestFailure(String msg) {
		test.addScreenCaptureFromBase64String(ReusableMethods.screenShot());
		Markup m = MarkupHelper.createLabel(msg + " is failed due to below reason", ExtentColor.RED);
		test.log(Status.FAIL, m);
	
	}/*
	
	 public static void onTestFailure(ITestResult result) {
	        String methodName = result.getName(); // Get failed test method name
	        test = extent.createTest(methodName).createNode(methodName);
	        
	        // Capture the exception
	        Throwable throwable = result.getThrowable();
	        if (throwable != null) {
	            test.fail(throwable); // Logs full stack trace in Extent Report
	        }

	        // Attach Screenshot (Assuming ReusableMethods.screenShot() returns Base64 Screenshot)
	        test.addScreenCaptureFromBase64String(ReusableMethods.screenShot());

	        Markup m = MarkupHelper.createLabel(methodName + " failed due to below reason:", ExtentColor.RED);
	        test.log(Status.FAIL, m);
	    }

	public static void onTestSkipped(String msg) {
		Markup m = MarkupHelper.createLabel(msg + " is skipped", ExtentColor.ORANGE);
		test.log(Status.SKIP, m);
	}

	public static void onFlush() {
		extent.flush();
	}

}*/
