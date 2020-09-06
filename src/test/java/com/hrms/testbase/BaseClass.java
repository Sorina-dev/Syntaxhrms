package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;

public class BaseClass {
	
	public static WebDriver driver;

	@BeforeMethod(alwaysRun=true)   //we ant it to be executed before each test and always to run
	public void setUp() {            //method to open the browser for every browser from the property file from resources configs
		//call the method readProperties from the class ConfigsReader and put the path of the file by System.getProperty();...
		ConfigsReader.readProperties(System.getProperty("user.dir"+"\\src\\test\\resources\\configs\\configuration.properties"));
		// call the getPropValue method from ConfigsReader class, and System.setProperty();...by using switch cases 
		switch (ConfigsReader.getPropValue("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir"+"\\src\\test\\resources\\drivers\\chromedriver.exe"));
		driver = new ChromeDriver();
		break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir"+"\\src\\test\\resources\\drivers\\geckodriver.exe"));
		driver = new FirefoxDriver();
		break;
		case "edge":
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir"+"\\src\\test\\resources\\drivers\\msedgedriver.exe"));
			driver = new FirefoxDriver();
			break;
		//edge driver add
		default:
			throw new RuntimeException("Browser is not supported"); //if pass some wrong value it will throw an exception
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getPropValue("applicationUrl")); //the url from method getPropValue from class ConfigsReader
	}                                                             //returning back the key from applicationUrl from configuration.properties file in configs folder
	@AfterMethod(alwaysRun=true)   //method to quit the browser
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
