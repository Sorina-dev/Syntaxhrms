package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LoginPageElements extends BaseClass{
	
	
	@FindBy(xpath = "//div[@id='divUsername']/child::input")
	public WebElement userNametextBox;
	
	@FindBy(css = "input#txtPassword")
	public WebElement passwordTextBox;
	
	@FindBy(xpath = "//div[@id='divLoginButton']/child::input")
    public WebElement btnLogin;
	
	@FindBy(id = "divLogo")
	public WebElement syntaxLogo;
	
	@FindBy(id = "spanMessage")
	public WebElement spanMessage;
	
	@FindBy(id = "logInPanelHeading")
	public WebElement loginPanelHeading;
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
}


