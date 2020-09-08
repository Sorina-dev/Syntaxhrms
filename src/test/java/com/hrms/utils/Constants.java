package com.hrms.utils;

public class Constants { 

	public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"\\src\\test\\resources\\configs\\configuration.properties";
	
	public static final String TESTDATA_FILEPATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\HrmsTestData.xlsx";//windows users /and .exe
	
	public static final String CHROMEDRIVER_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
	
	public static final String GECKODRIVER_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe";
	
	public static final String EDGE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe";
	
	public static final int IMPLICIT_WAIT_TIME=10;
	
	public static final int EXPLICIT_WAIT_TIME=20;
	
}
