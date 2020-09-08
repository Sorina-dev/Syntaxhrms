package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewPersonalDetailsPageElements extends BaseClass{

	@FindBy(xpath="//div[@id='profile-pic']/child::h1")
	public WebElement progilePicText;
	
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement empFirstName;
	
	@FindBy(id="personal_txtEmpLastName")
	public WebElement empLastName;
	
	@FindBy(id="personal_txtEmpMiddleName")
	public WebElement empMiddleName;
	
	@FindBy(css="input#personal_txtEmployeeId")
	public WebElement empID;
	
	@FindBy(id="personal_txtOtherID")
	public WebElement empOtherID;
	
	@FindBy(css="input#personal_txtLicenNo")
	public WebElement empDriverLicense;
	
	@FindBy(id = "personal_txtLicExpDate")
	public WebElement driverLicenseExpDate;
	
	@FindBy(css="img[class='ui-datepicker-trigger']")
	public WebElement calendarLicenseExpDate;
	
	@FindBy(css="input#personal_txtNICNo")
	public WebElement ssnNumber;
	
	@FindBy(xpath="//input[@id='personal_txtSINNo']")
	public WebElement sinNumber;
	
	@FindBy(xpath="//input[@name='personal[optGender]']")
	public List<WebElement> checkBoxesGender;
	
	@FindBy(id="personal_cmbMarital")
	public WebElement maritalStatusDropDown;  
	
	@FindBy(xpath="//select[@id='personal_cmbNation']")
	public WebElement nationalityDropDown;
	
	@FindBy(id="personal_DOB")
	public WebElement dateOfBirth;  
	
	@FindBy(css="img[class='ui-datepicker-trigger']")
	public WebElement calendarDateOfBirth;  
	
	@FindBy(id="personal_txtEmpNickName")
	public WebElement nickName ;  
	
	@FindBy(id="personal_chkSmokeFlag")
	public WebElement smokerCheckBox;
	
	@FindBy(id="personal_txtMilitarySer")
	public WebElement militaryService;
	
	@FindBy(xpath="//input[@value='Edit']")
	public WebElement editButton;
	
	@FindBy(id="btnAddAttachment")
	public WebElement addAtachmentsButton;
	
	@FindBy(id="btnSave")
	public WebElement saveButton;
	
	
	
	public ViewPersonalDetailsPageElements() {
	PageFactory.initElements(driver, this);
	}
}
