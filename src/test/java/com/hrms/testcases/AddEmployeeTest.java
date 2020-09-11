package com.hrms.testcases;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods{

	@DataProvider 
	public Object[][] employeesData() {
		Object[][] data = { { "Ana", "AnneS123#%&)", "Anna", "Smit" },//next time the username can be changed only in order to add another employees on the web site
				{ "Andrey", "AndrewL123#%(**", "Bibby", "Locks" },
				{ "Benja", "Ben123#%&*@", "Ben", "Math" },
				{ "Beyo", "BeyonceC123#%#)", "Chabby", "Car" },
				{ "Jesep", "JessieR0123#%%%)", "Emi", "Rodrig" } };
		return data;
	}

	@Test (groups="regression",dataProvider="employeesData")
	public void addEmployeesData(String usernameText, String passwordText, String firstnameText, String lastnameText) {
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username")); 
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);
		
		click(dash.pimLinkBtn);
		waitForVisibility(dash.addEmployeeBtn);
		click(dash.addEmployeeBtn);
		
		//or javascript method to be sure it clicks
		//jsClick(dash.pimLinkBtn);
		//jsClick(dash.addEmployeeBtn);
		
		sendText(addEmp.firstNameField, firstnameText);
		sendText(addEmp.lastName,lastnameText);
		click(addEmp.createLoginDetailsCheckbox);
		sendText(addEmp.userName,usernameText);
		sendText(addEmp.userPassword,passwordText);
		sendText(addEmp.confirmPassword,passwordText);
		click(addEmp.saveButton);
		waitForVisibility(persDetails.progilePicText);
		Assert.assertEquals(persDetails.progilePicText.getText(), firstnameText + " "+ lastnameText ); //validation of employee
	//	System.out.println(perDetails.progilePicText.getText());
	}
	
	@Test(groups="regression")
	public void addMultipleEmployees(){
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);

//		click(dash.pimLinkBtn);
//		waitForVisibility(dash.addEmployeeBtn);
//		click(dash.addEmployeeBtn);
		jsClick(dash.pimLinkBtn);
	//	jsClick(dash.addEmployeeBtn);
   
   /*
    * excelToListMap() method from ExcelUtility class(utils) with parameters: filepath-> TESTDATA_FILEPATH from Constants class(utils);
    * and paramenter: name of the sheet we need from the excel file "AddEmployee"
    * gets data and stores in list of maps
    * 
    */
	
		List<Map<String, String>> employeeList = ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH,
				"AddEmployee");
		SoftAssert soft = new SoftAssert();   // in order to be outside of the loop
		for (Map<String, String> map : employeeList) {
			
			jsClick(dash.addEmployeeBtn);     //to click on add employee button for the new employee
//			waitForVisibility(dash.addEmployeeBtn);
//			click(dash.addEmployeeBtn);
			String firstName = map.get("FirstName");
			String middleName = map.get("MiddleName");
			String lastName = map.get("LastName");
            
			waitForVisibility(addEmp.firstNameField);
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastName, lastName);
			jsClick(addEmp.saveButton);
			soft.assertEquals(persDetails.progilePicText.getText(), firstName + " " + middleName + " " + lastName); //validation of employee
	   //   CommonMethods.takeScreenshot("addMultipleEmployees");
		}
		soft.assertAll();   //outside of the loop 
	}
	
}
