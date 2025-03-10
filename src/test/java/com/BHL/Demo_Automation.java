package com.BHL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Demo_Automation {

	public static WebDriver driver;
	public static Select s;
	public static void main(String[] args) throws InterruptedException {

		// Browser setting before launching
		ChromeOptions c = new ChromeOptions();
		c.addArguments("start-maximized"); // screen maximization
		c.addArguments("--disable-notifications"); // disabling all notifications
		c.addArguments("--no-sandbox");
		c.addArguments("--disable-dev-shm-usage");
		c.addArguments("--remote-allow-origins=*");// local exceptions
		driver = new ChromeDriver(c);		 // providing the variable of the setting as parameter while launching the browser so that it will directly adopt the setting which we are passing in the Chromeoptions class
		driver.get("https://demo.automationtesting.in/Register.html"); // Your URL
		
		System.out.println("BROWSER LAUNCHED SUCCESSFULLY");

		//firstly scrolling down the page and hit the REFRESH button
		WebElement element1=driver.findElement(By.xpath("//*[text()=\"Confirm Password\"]")); 
		JavascriptExecutor jse =  (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element1);
		// Clicking Refresh button locator we are doing refresh operation first as after refresh the form progress will be lost
		driver.findElement(By.xpath("//*[text()=\"Refresh\"]")).click();

		//Enter First Name
		driver.findElement(By.xpath("//label[text()=\"Full Name* \"]//following-sibling::div/input[@placeholder=\"First Name\"]")).sendKeys("Dinesh");
		//Enter Last Name
		driver.findElement(By.xpath("//label[text()=\"Full Name* \"]//following-sibling::div/input[@placeholder=\"Last Name\"]")).sendKeys("Kadam");
		//Enter Address
		driver.findElement(By.xpath("//textarea[@ng-model=\"Adress\"]")).sendKeys("3 ,3rd floor, Gayatrinagar Apartment, Near Adani CNG , Naranpura, Ahmedabad 380013");
		//Enter Email
		driver.findElement(By.xpath("//input[@ng-model=\"EmailAdress\"]")).sendKeys("dineshkadam0311@gmail.com");
		//Enter Phone Number
		driver.findElement(By.xpath("//input[@ng-model=\"Phone\"]")).sendKeys("9657803055");
		//Enter Gender
		driver.findElement(By.xpath("//input[@value=\"Male\"]")).click();
		//Select Hobbie - Cricket
		driver.findElement(By.id("checkbox1")).click();
		//Select Hobbie - Movies
		driver.findElement(By.id("checkbox2")).click();
		//Select Hobbie - Hockey
		driver.findElement(By.id("checkbox3")).click();

		//Scroll down the page till the bottom
		WebElement element=driver.findElement(By.xpath("//*[text()=\"Confirm Password\"]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

		//Select languages Hindi and Greek by using For each loop and FindElements (list<Webelements>)
		driver.findElement(By.id("msdd")).click();
		List<WebElement> ListOfLanguage = driver.findElements(By.xpath("//div[@style=\"display: block;\"]//ul//li//a"));
		System.out.println( "The List of languages avaiable in the Dropdown are as below : ");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		for(WebElement language :ListOfLanguage ) {
			System.out.println(language.getText());
			if(language.getText().equals("Hindi")) {
				language.click();
			}
			if(language.getText().equals("Greek")) {
				language.click();
			}
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		
		//click on language text for exiting the dropdown
		driver.findElement(By.xpath("//label[text()=\"Languages\"]")).click();

		//Select Skillsas MySQL using For each loop and FindElements (list<Webelements>)
		driver.findElement(By.id("Skills")).click();
		List<WebElement> ListOfSkills=driver.findElements(By.xpath("//select[@id=\"Skills\"]//option"));
		
		System.out.println( "The List of Skills avaiable in the Dropdown are as below : ");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		for(WebElement Skills :ListOfSkills ) {
			System.out.println(Skills.getText());
			if(Skills.getText().equals("MySQL")) {
				Skills.click();
				break;
			}
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		
		//click on the Skills text again for exiting the drpdown
		driver.findElement(By.xpath("//*[text()=\"Skills\"]")).click();

		//click on the Country dropwon 2 times for exiting the drpdown
		driver.findElement(By.id("countries")).click();
		driver.findElement(By.id("countries")).click();

		//select country as INDIA from all the countries
		driver.findElement(By.xpath("//span[@class=\"select2-selection select2-selection--single\"]")).click();
		System.out.println( "The List of Countries avaiable in the Dropdown are as below : ");
		List<WebElement> ListOfCountry=driver.findElements(By.xpath("//*[@class=\"select2-results\"]//ul//li"));
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();

		for(WebElement SelectCountry  :ListOfCountry) {
			System.out.println(SelectCountry.getText());
		}

		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();

		for(WebElement SelectCountry2  :ListOfCountry) {
			if(SelectCountry2.getText().equals("India")) {
				SelectCountry2.click();
				break;
			}
		}

		//selecting Date of birth by using the Select class and by Values method
		WebElement year = driver.findElement(By.id("yearbox"));
		s= new Select(year);
		s.selectByValue("1995");
		WebElement month = driver.findElement(By.xpath("//*[@placeholder=\"Month\"]"));
		s= new Select(month);
		s.selectByValue("November");
		WebElement day = driver.findElement(By.id("daybox"));
		s= new Select(day);
		s.selectByValue("3");

		// enter password
		driver.findElement(By.id("firstpassword")).sendKeys("Test@123");

		//confirm password
		driver.findElement(By.id("secondpassword")).sendKeys("Test@123");
		
		//click on Submit Button 
		driver.findElement(By.xpath("//*[text()=\" Submit \"]")).click();
		
		//Exiting the browser
		System.out.println("Form Submitted successfully");
		driver.close();
	}
}

