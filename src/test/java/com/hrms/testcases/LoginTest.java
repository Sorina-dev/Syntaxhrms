package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	/**
	 * method to sendText() from CommonMethods class(utils), 
	 * pass the parameters: 1. userNametextBox from LoginPageElements class(pages) initialized object in PageInitializer class(testbase)
	 * 2. passing the username value from configs folder / configuration.properties file; by calling the method getPropValue() from the 
	 * ConfigsReader class(utils)
	 * 
	 * click() from CommonMethods class
	 * 
	 * assertion for element from DashboardPageElement class(pages) initialized object in PageInitializer class(testbase)
	 */
	@Test(groups = "smoke") //1 test
	public void validLogin() {
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username")); 
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);
		Assert.assertTrue(dash.welcome.isDisplayed());
	}

	@Test(groups="regression", dataProvider="invalidCredentials") // 3 tests as there is dataProvider with 3 rows
	public void invalidLogin(String username, String password, String errorMessage) {
		sendText(login.userNametextBox, username);
		sendText(login.passwordTextBox, password);
		click(login.btnLogin);
		Assert.assertEquals(login.spanMessage.getText(), errorMessage); //when we need to do several validations in one test we need to use softAssert
	}
	
	@DataProvider
	public String[][] invalidCredentials() {
		String[][] data = { 
				{ "", "SyntaxAdmin123!", "Username cannot be empty" },
				{ "SyntaxAdmin", "", "Password cannot be empty" }, 
				{ "SyntaxAdmin", "Hum@nhrm12", "Invalid credentials" }, 
				};
		return data;
	}
	
	
	
}
