package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.PageUtility;

public class CreateWorkerPage {
	WebDriver driver;
	
	PageUtility pageutility = new PageUtility();
	
	@FindBy(id="worker-title")
	WebElement workerTitle;
	@FindBy(id="worker-first_name")
	WebElement workerFirstName;
	@FindBy(id="worker-last_name")
	WebElement workerLastName;
	@FindBy(id="worker-phone")
	WebElement workerPhoneNumber;
	@FindBy(id="worker-email")
	WebElement workerEmail;
	@FindBy(id="worker-gender")
	WebElement workerGender;
	@FindBy(id="worker-dob")
	WebElement workerDOB;
	@FindBy(id="worker-address1")
	WebElement workerAddress;
	@FindBy(id="worker-postcode")
	WebElement workerPostCode;
	@FindBy(id="worker-branch_id")
	WebElement workerBranchID;
	@FindBy(id="worker-division_id")
	WebElement workerDivisionID;
	@FindBy(id="worker-employment_type")
	WebElement workerEmployementType;
	@FindBy(id="worker-payslip_method")
	WebElement workerPaySlipMethod;
	@FindBy(id="worker-ni_number")
	WebElement workerNiNumber;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[4]/div/button")
	WebElement nextButton;
	
	public CreateWorkerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterWorkerTitle(String title) {
		Select s = new Select(workerTitle);
		s.selectByVisibleText(title);
	}
	
	public void enterWorkerFirstName(String fname) {
		workerFirstName.sendKeys(fname);
	}
	public void enterWorkerLastName(String lname) {
		workerLastName.sendKeys(lname);
	}
	public void enterWorkerPhoneNumber(String phone) {
		workerPhoneNumber.sendKeys(phone);
	}
	public void enterWorkerEmail(String email) {
		workerEmail.sendKeys(email);
	}
	public void enterWorkerGender(String gender) {
		Select s2 = new Select(workerGender);
		s2.selectByVisibleText(gender);
	}
	public void enterWorkerDOB(String dob) {
		workerDOB.clear();
		workerDOB.sendKeys(dob);
	}
	public void enterWorkerAddress(String address) {
		workerAddress.sendKeys(address);
	}
	public void enterWorkerPostCode(String postcode) {
		workerPostCode.sendKeys(postcode);
	}
	public void selectWorkerBranchID(String branch) {
		Select s = new Select(workerBranchID);
		s.selectByVisibleText(branch);
	}
	public void selectWorkerDivision(String division) {
		Select s2 = new Select(workerDivisionID);
		s2.selectByVisibleText(division);
	}
	public void selectWorkerEmplyementType(String employementType) {
		Select s3 = new Select(workerEmployementType);
		s3.selectByVisibleText(employementType);
	}
	public void selectWorkerPaySlipMethod(String paySlipMethod) {
		Select s4 = new Select(workerPaySlipMethod);
		s4.selectByVisibleText(paySlipMethod);
	}
	public void enterWorkerNiNumber(String niNumber) {
		workerNiNumber.sendKeys(niNumber);
	}
	public void clickNextButton() {
		nextButton.click();
	}
	
	public CreateWorkerBankDetailsPage enterWorkerInfo(String strWorkerTitle, String strWorkerFirstName, String strWorkerLastName, String strWorkerPhoneNumber, 
			String strWorkerEmail, String strWorkerGender, String strDOB, String strAddress, String strPostCode, String strBranchID, 
			String strDivisionID, String strEmployementType, String strPaySlipMethod, String strNiNumber) {
		this.enterWorkerTitle(strWorkerTitle);
		this.enterWorkerFirstName(strWorkerFirstName);
		this.enterWorkerLastName(strWorkerLastName);
		this.enterWorkerPhoneNumber(strWorkerPhoneNumber);
		this.enterWorkerEmail(strWorkerEmail);
		this.enterWorkerGender(strWorkerGender);
		this.enterWorkerDOB(strDOB);
		this.enterWorkerAddress(strAddress);
		this.enterWorkerPostCode(strPostCode);
		this.selectWorkerBranchID(strBranchID);
		this.selectWorkerDivision(strDivisionID);
		this.selectWorkerEmplyementType(strEmployementType);
		this.selectWorkerPaySlipMethod(strPaySlipMethod);
		this.enterWorkerNiNumber(strNiNumber);
		this.clickNextButton();
		return new CreateWorkerBankDetailsPage(driver);
	}
}
