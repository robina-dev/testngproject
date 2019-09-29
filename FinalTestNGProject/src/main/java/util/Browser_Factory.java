package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser_Factory {
	
	//Create Global driver used by all methods
	static WebDriver driver;
	
	public static WebDriver startBrowser() {
		
		//Set Chromedriver properties
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Create a ChromeDriver class that implements WebDriver interface
		WebDriver driver = new ChromeDriver();
		
		//Test window maximize or minimize
		driver.manage().window().maximize();
		
		//Using Implicit wait time on all the Elements in sec
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Deleting all the info stored in browser cookie or the text file
		driver.manage().deleteAllCookies();
		
		//Return the driver to the Test class
		return driver;
		
		
		
		
	}

}

