package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {  // to read the files from src/test/resources

	static Properties prop;
	
	public static void readProperties(String filePath) { //public and static to be read everywhere
		                                                 //  a method to read the property file from  configuration.properties
		try {
			FileInputStream fis = new FileInputStream(filePath); 
			Properties prop = new Properties();
				prop.load(fis);
			    fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
	}
	                                                     // another method will be getting back the value of the specified key
	public static String getPropValue(String key) {     //   applicationUrl=http://166.62.36.207/humanresources/symfony/web/index.php
                                                        // key is the url of value applicationUrl
		return prop.getProperty(key);
	}
	
	
}
