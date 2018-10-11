package info.sjd.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Service {
	private static final String URL = "https://www.amazon.com";
	private static String mainDir = System.getProperty("user.dir");
	private static final String SEP = System.getProperty("file.separator");
	
	
	public static WebDriver getChromeDriver() {
		
		
		String driverPath = mainDir + SEP + "lib" + SEP + "chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
		
		waitSec(3);
				
		return driver;
	}
	
	public static void waitSec(int sec) {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
