package com.hrms.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import org.testng.Assert;

public class AddEmployeeTest extends CommonMethods{

	@DataProvider 
	public Object[][] employeesData() {
		Object[][] data = { { "AnneSS", "AnneS123#%&@", "Anne", "Smithh" },
				{ "AndrewLL", "AndrewL123#%&@*", "Andrew", "Locksmithh" },
				{ "BenjaminMM", "Ben123#%&$@", "Benjamin", "Matherss" },
				{ "BeyonceCC", "BeyonceC123#%&@", "Beyonce", "Carterr" },
				{ "JessieRoE", "JessieR0123#%&//@", "Jessie", "Rodriguess" } };
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
		sendText(addEmp.firstNameField, firstnameText);
		sendText(addEmp.lastName,lastnameText);
		click(addEmp.createLoginDetailsCheckbox);
		sendText(addEmp.userName,usernameText);
		sendText(addEmp.userPassword,passwordText);
		sendText(addEmp.confirmPassword,passwordText);
		click(addEmp.saveButton);
		waitForVisibility(perDetails.progilePicText);
		Assert.assertEquals(perDetails.progilePicText.getText(), firstnameText + " "+ lastnameText );
	//	System.out.println(perDetails.progilePicText.getText());
	}
	
	
}
