package test_utility;


import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test_base.BaseClass;

public class ReusableMethods extends BaseClass {

	public static void explicitWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void explicitWaitForClick(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}


	public static void scrollDown(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static String ExcellDataFetching(int rowIndex, int colIndex) throws EncryptedDocumentException, Throwable {
		FileInputStream fis = new FileInputStream("./Data/SellingoData.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet("Data");
		String data = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return data;
	}

	public static String screenShot() {
		String screenShotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenShotBase64;
	}
}
