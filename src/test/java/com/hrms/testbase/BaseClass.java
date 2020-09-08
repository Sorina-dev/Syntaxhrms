package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {
	
	protected static WebDriver driver; //or public

	/*
	 * @method = to open the browser and to wait for it to be loaded and refresh it
	 * it uses the method readProperties(); from the ConfigsReader class; and reads CONFIGURATION_FILEPATH file from Constants class
	 * By calling method getPropValue(key); from the ConfigsReader class; we are getting the value of the key from configuration.properties file in the folder configs
	 * by passing the CONFIGURATION_FILEPATH from Constants class(utils)
	 */
	@BeforeMethod(alwaysRun=true)   
	public void setUp() {             
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		switch (ConfigsReader.getPropValue("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",Constants.CHROMEDRIVER_PATH );
		driver = new ChromeDriver();
		break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVER_PATH);
		driver = new FirefoxDriver();
		break;
		case "edge":
			System.setProperty("webdriver.edge.driver",Constants.EDGE_PATH );
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported"); //if pass some wrong value it will throw an exception
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.navigate().to(ConfigsReader.getPropValue("applicationUrl"));
		driver.navigate().refresh();
		PageInitializer.initializePageObjects(); //calling the method initializePageObjects() from the PageInitializer class(testbase), to initialize all the classes from (pages)
	}  
	
	/*
	 * @method - to quit the browser, it quits only if the page is open
	 */
	@AfterMethod(alwaysRun=true)   
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			
			
		}
	}
	
}
