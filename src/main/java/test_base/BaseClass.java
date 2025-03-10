package test_base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	

	public static void driverSetup() {
		    ChromeOptions c = new ChromeOptions();
		    
		    c.addArguments("start-maximized"); // screen maximization
			c.addArguments("--disable-notifications"); // disabling all notifications
			c.addArguments("--no-sandbox");
			c.addArguments("--disable-dev-shm-usage");
			c.addArguments("--remote-allow-origins=*");// local exceptions
			driver = new ChromeDriver(c);
		    driver.get("https://staging.bhlgroupint.com/"); // Your URL
		    
		}
	}
		

