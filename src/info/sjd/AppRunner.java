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

		String email = "Vitaliy.Tima@gmail.com";
		String first_name = "Vitaliy";
		String last_name = "Tyma";

		String file_name = email + ".txt";

		/**
		 * Example how to create the new password.
		 * 
		 * Pass.saveUserPassToFile(file_name);
		 */

		char[] pass = Pass.readUserPassFromFile(file_name);
		
		Account account = new Account(email, pass, first_name, last_name);
		

		try {
			WebDriver web_driver = Service.getChromeDriver();
			web_driver = Service.registerAccount(web_driver, account);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "WebDriver error: " + e.getMessage());
		}

		Arrays.fill(pass, '\u0000');
		logger.log(Level.INFO, "Finish");
	}
}
