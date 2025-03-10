package report;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import test_base.BaseClass;

public class ScreenshotUtil extends BaseClass {

	//private static WebDriver driver;

	// Constructor to initialize WebDriver
	public ScreenshotUtil(WebDriver driver) {
		ScreenshotUtil.driver = driver;
	}

	// Capture Screenshot and return Base64 String
	public static String captureScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}

