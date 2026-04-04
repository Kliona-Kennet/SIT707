package sit707_week2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author klionakennet*
 */

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);
		sleep(3);

		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage,
		 * Step 2: locate the input field,
		 * Step 3: Find out how to identify it, by id/name/...
		 */

		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);

		// Send first name
		element.sendKeys("Kliona");

		/*
		 * Find following input fields and populate with values
		 */
		driver.findElement(By.name("lastname")).sendKeys("Kennet");
		driver.findElement(By.name("phoneNumber")).sendKeys("0469346067");
		driver.findElement(By.name("email")).sendKeys("klionakennet2002@testmail.com");

		// Weak password to show validation error only
		driver.findElement(By.name("password")).sendKeys("weakpassword");
		driver.findElement(By.name("confirmPassword")).sendKeys("weakpassword");

		sleep(2);

		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		driver.findElement(By.xpath("//button[contains(.,'Create account')]")).click();

		sleep(4);

		/*
		 * Take screenshot using selenium API.
		 */
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(
				src.toPath(),
				new File("officeworks.png").toPath(),
				StandardCopyOption.REPLACE_EXISTING
			);
			System.out.println("Officeworks screenshot has been saved.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Sleep a while
		sleep(2);

		// close chrome driver
		driver.quit();
	}

	public static void demo_registration_form_test(String url) {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);
		sleep(3);

		// Enter First Name
		WebElement firstName = driver.findElement(
				By.xpath("//input[contains(@placeholder,'First Name')]"));
		firstName.clear();
		firstName.sendKeys("Kliona");

		// Enter Last Name
		WebElement lastName = driver.findElement(
				By.xpath("//input[contains(@placeholder,'Last Name')]"));
		lastName.clear();
		lastName.sendKeys("Kennet");

		// Enter Address
		WebElement address = driver.findElement(
				By.xpath("//textarea[@ng-model='Adress']"));
		address.clear();
		address.sendKeys("Melbourne");

		// Enter Email
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.clear();
		email.sendKeys("kliona.test2026@mail.com");

		// Enter Phone
		WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
		phone.clear();
		phone.sendKeys("0422334455");

		// Select Gender
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();

		// Select Hobby
		driver.findElement(By.id("checkbox1")).click();

		// Select Skill
		driver.findElement(By.id("Skills")).sendKeys("Java");

		sleep(2);

		// Take Screenshot
		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(
				screenshotFile.toPath(),
				new File("demo_registration_output.png").toPath(),
				StandardCopyOption.REPLACE_EXISTING
			);
			System.out.println("Demo registration screenshot saved.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}