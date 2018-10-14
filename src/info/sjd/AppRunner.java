package info.sjd;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import info.sjd.model.Account;
import info.sjd.pass.Pass;
import info.sjd.service.Service;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

public class AppRunner {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		logger.log(Level.INFO, "Start");

		String email = "-Vitaliy.Tima@gmail.com";
		String first_name = "Vitaliy";
		String last_name = "Tyma";
		Account account = new Account(email, Pass.getPassArray(), first_name, last_name);

		try {
//			String proxy_ip = "127.0.0.1";
//			String proxy_port = "22222";
//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("--proxy-server=http://"+proxy_ip+":"+proxy_port);
//			TO BE CHECKED
//			option.addArguments("C:\\Users\\profile\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
//			WebDriver driver = Service.getChromeDriver(option);

			WebDriver driver = Service.getChromeDriver();
			driver = Service.registerAccount(driver, account);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "WebDriver error: " + e.getMessage());
		}

		logger.log(Level.INFO, "Finish");
	}

}
