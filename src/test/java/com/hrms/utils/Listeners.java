package com.hrms.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	//call the takeScreenshot() from CommonMethods(utils) and pass the name of the result and store it in separate folder passed
	public void onTestSuccess(ITestResult result) {
		CommonMethods.takeScreenshot("passed\\"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		CommonMethods.takeScreenshot("failed\\"+result.getName());
	}

}
