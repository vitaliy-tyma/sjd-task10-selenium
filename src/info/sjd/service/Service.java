package info.sjd.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import info.sjd.model.*;
import info.sjd.pass.Pass;
import info.sjd.util.*;
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
	private static Logger logger = Logger.getLogger(Pass.class.getName());

	public static WebDriver getChromeDriver() {

		String driverPath = user_dir + SEP + "lib" + SEP + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		Timer.delay(3);

		return driver;
	}

	public static WebDriver registerAccount(WebDriver driver, Account account) {

		driver.get(URL);

		Timer.randomDelay(6);
		WebElement register_div_element = driver.findElement(By.id("nav-flyout-ya-newCust"));
		WebElement register_url_element = register_div_element.findElement(By.tagName("a"));
		String register_url = register_url_element.getAttribute("href");

		driver.get(register_url);

		Timer.randomDelay(6);
		WebElement input_name_element = driver.findElement(By.id("ap_customer_name"));
		String ap_customer_name = account.getFirst_name() + " " + account.getLast_name();
		input_name_element.sendKeys(ap_customer_name);

		Timer.randomDelay(6);
		WebElement input_email_element = driver.findElement(By.id("ap_email"));
		input_email_element.sendKeys(account.getEmail());

		Timer.randomDelay(6);
		WebElement input_password_element = driver.findElement(By.id("ap_password"));
		input_password_element.sendKeys(account.getPasswordString());

		Timer.randomDelay(6);
		WebElement input_pass_check_element = driver.findElement(By.id("ap_password_check"));
		input_pass_check_element.sendKeys(account.getPasswordString());

		Timer.randomDelay(6);
		WebElement input_submit_element = driver.findElement(By.id("continue"));
		input_submit_element.submit();

		/* What is I must verify e-mail after the very first registration. */
		Timer.randomDelay(6);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);

		boolean signed_in = driver.getPageSource().contains("Hello, " + account.getFirst_name());
		if (!signed_in) {
			driver.quit();
			logger.log(Level.SEVERE, "WebDriver creation error (including login)!");
			return null;
		}
		logger.log(Level.INFO, "WebDriver has been successfully created.");
		
		return driver;
	}
}
