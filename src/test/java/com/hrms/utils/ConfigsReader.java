package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {  
/*
 * @method - to read the property file from src/test/resources/configs/configuration.properties 
 */
static Properties prop;    // object of properties 
	
	public static void readProperties(String filePath) {   //public and static to be read everywhere and belong to the class
	                                                      
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * @method - will be getting back the value of the specified key
	 *           key is the url of value applicationUrl from property file from src/test/resources/configs/configuration.properties
	 */
	public static String getPropValue(String key) { 
		return prop.getProperty(key);                  
	}
	
}
