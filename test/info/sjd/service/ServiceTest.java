package info.sjd.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ServiceTest {

	@Test
	public void testWebDriver() {
		WebDriver web_driver = Service.getChromeDriver();
		
		assertNotNull(web_driver);
		
		web_driver.quit();
	}
}
