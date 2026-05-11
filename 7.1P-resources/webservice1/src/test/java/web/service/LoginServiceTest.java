package web.service;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class LoginServiceTest {

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		return new ChromeDriver();
	}

	private void openLoginPage(WebDriver driver) {
		driver.navigate().to("file:///Users/klionakennet/Downloads/7.1P-resources/webservice1/pages/login.html");
		sleep(2);
	}

	private void performLogin(WebDriver driver, String username, String password, String dob) {
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys(username);

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys(password);

		ele = driver.findElement(By.id("dob"));
		((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", ele, dob);

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(2);
	}

	@Test
	public void testLoginSuccess() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "kliona", "kliona_pass", "2002-03-04");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("success", title);

		driver.close();
	}

	@Test
	public void testLoginFailWrongUsername() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "wrong", "kliona_pass", "2002-03-04");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}

	@Test
	public void testLoginFailWrongPassword() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "kliona", "wrong_pass", "2002-03-04");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}

	@Test
	public void testLoginFailWrongDob() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "kliona", "kliona_pass", "2000-01-01");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}

	@Test
	public void testLoginFailEmptyUsername() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "", "kliona_pass", "2002-03-04");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}

	@Test
	public void testLoginFailEmptyPassword() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "kliona", "", "2002-03-04");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}

	@Test
	public void testLoginFailEmptyDob() {
		WebDriver driver = createDriver();

		openLoginPage(driver);
		performLogin(driver, "kliona", "kliona_pass", "");

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("fail", title);

		driver.close();
	}
}