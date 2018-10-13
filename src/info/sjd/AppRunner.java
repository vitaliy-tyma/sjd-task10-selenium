package info.sjd;

import java.util.logging.Logger;
import info.sjd.model.Account;
import info.sjd.service.Service;
import org.openqa.selenium.WebDriver;

public class AppRunner {

	private static Logger logger = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args) {


		logger.info("Start");
		
		WebDriver driver = Service.getChromeDriver();
		
		Account account = new Account("-Vitaliy.Tima@gmail.com", "pass20181011", "Vit", "Tima");
		
		driver = Service.registerAccount(driver, account);
		

	}

}
