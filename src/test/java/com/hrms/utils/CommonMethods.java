package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	/**
	 * Method that sends text to any given element
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method return Object of JavaScript Executor type
	 * 
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * Method performs click using JavaScript executor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click();", element);
	}

	/**
	 * Methods scrolls up using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0, -" + pixel + ")");
	}

	/**
	 * Methods scrolls down using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");
	}
	
	/**
	 * Method create the WebDriverWait object
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	}
	
	/**
	 * method to wait until is element visible
	 * @param element
	 */
	public static void waitForVisibility(WebElement element) {
	getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * method to wait until is element clickable
	 * @param element
	 */
	
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * method to click on the element when is clickable
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * method to switch to simple alert and accept it
	 */
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
	}
	/**
	 * method to switch to confirm alert and dismiss it
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
	}
	/**
	 * method to switch to alert and get and return the alert text
	 * @return
	 */
	public static String getAlertText() {
		String alertText=null;
		try {
			Alert alert=driver.switchTo().alert();
			alertText=alert.getText();
		}catch(NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
		return alertText;
	}
	/**
	 * method to switch to frame by string
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e){
			System.out.println("Frame is not present");
		}
	}
	
	/**
	 * method to switch to frame by web element
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e){
			System.out.println("Frame is not present");
		}
	}
	/**
	 * method to switch to frame by index
	 * @param index
	 */
	
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e){
			System.out.println("Frame is not present");
		}
	}
	/**
	 * takes screenshots and giving the time stamp
	 * @param fileName
	 */
	public static void takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {                                                                          //below method
			FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH + fileName +getTimeStamp()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this returns number of milliseconds since January 1, 1970/ we don't need it
	 */
	public void getTimeStamp1() {
		Date date = new Date();
		date.getTime(); 
	}
	
	/**
	 * This method will generate timeStamp
	 * @return
	 */
	public static String getTimeStamp() {//had to add it to CommonMethods class takeScreenshot() above method^
		//class
		Date date=new Date();
		//class extends DateFormat                 //years-month-day- hours -min - sec
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");//we changed ":" into "_" cuz it doesn't support 
		           //method that returns String date
		return sdf.format(date);
	}
	
	
}
