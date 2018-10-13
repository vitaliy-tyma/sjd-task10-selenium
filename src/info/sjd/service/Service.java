package info.sjd.service;

import java.util.concurrent.TimeUnit;
import info.sjd.model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Service {
	private static final String URL = "https://www.amazon.com";
	private static String user_dir = System.getProperty("user.dir");
	private static final String SEP = System.getProperty("file.separator");

	public static WebDriver getChromeDriver() {

		String driverPath = user_dir + SEP + "lib" + SEP + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
		Timer.delay(3);
		return driver;
	}

	public static WebDriver registerAccount(WebDriver driver, Account account) {

		driver.get(URL);
		Timer.delay(6);

		WebElement registerDivElement = driver.findElement(By.id("nav-flyout-ya-newCust"));
		WebElement registerLinkElement = registerDivElement.findElement(By.tagName("a"));
		String registerLink = registerLinkElement.getAttribute("href");

		driver.get(registerLink);
		Timer.delay(6);

		WebElement inputNameElement = driver.findElement(By.id("ap_customer_name"));
		inputNameElement.sendKeys(account.getFirst_name() + " " + account.getSecond_name());
		Timer.delay(6);

		WebElement inputEmailElement = driver.findElement(By.id("ap_email"));
		inputEmailElement.sendKeys(account.getEmail());
		Timer.delay(6);

		WebElement inputPasswordElement = driver.findElement(By.id("ap_password"));
		inputPasswordElement.sendKeys(account.getPassword());
		Timer.delay(6);

		WebElement inputCheckElement = driver.findElement(By.id("ap_password_check"));
		inputCheckElement.sendKeys(account.getPassword());
		Timer.delay(6);

		WebElement inputSubmitElement = driver.findElement(By.id("continue"));
		//inputSubmitElement.submit();

		Timer.delay(6);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);

		if (driver.getPageSource().contains("Hello, ")) {

			return driver;
		}

		driver.quit();
		return null;
	}

	public static WebDriver addGoodToCart(WebDriver driver, String asin) {
		///////

		return driver;
	}

}
