package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class CreateClientPage {
	WebDriver driver;
	
	@FindBy(id="client-branch_id")
	WebElement branchID;
	@FindBy(id="client-division_id")
	WebElement divisionID;
	@FindBy(id="client-client_name")
	WebElement clientName;
	@FindBy(id="client-client_address")
	WebElement clientAddress;
	@FindBy(id="client-postcode")
	WebElement cilentPostCode;
	@FindBy(id="client-your_ref")
	WebElement cilentRef;
	@FindBy(id="client-invoice_contact")
	WebElement clientInvoiceContact;
	@FindBy(id="client-phone")
	WebElement clientPhone;
	@FindBy(id="client-email")
	WebElement clientEmail;
	@FindBy(id="client-company_reg")
	WebElement cilentCompReg;
	@FindBy(id="client-invoice_order")
	WebElement clientInvoiceOrder;
	@FindBy(id="client-invoice_delivery_method")
	WebElement invoiceDelivery;
	@FindBy(id="client-master_document")
	WebElement clientDocument;
	@FindBy(id="client-settilement_days")
	WebElement settlementDays;
	@FindBy(id="client-vat_rate")
	WebElement clientVatRate;
	@FindBy(xpath="//*[@id=\"w0\"]/div[4]/div/button") 
	WebElement clientSubmit;
	
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public CreateClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectBranchID(String branch) {
		
		Select s = new Select(branchID);
		s.selectByVisibleText("Alpha_new");
	}
	public void selectDivision(String division) {
		Select s2 = new Select(divisionID);
		s2.selectByVisibleText("NewAlpha");
	}
	public void enterName(String name) {
		clientName.sendKeys(name);
	}
	public void enterAddress(String address) {
		clientAddress.sendKeys(address);
	}
	public void enterPostCode(String postCode) {
		cilentPostCode.sendKeys(postCode);
	}
	public void enterClientRef(String ref) {
		cilentRef.sendKeys(ref);
	}
	public void enterClientInvoiceContact(String invoiceContact) {
		clientInvoiceContact.sendKeys(invoiceContact);
	}
	public void enterClientPhone(String phone) {
		clientPhone.sendKeys(phone);
	}
	public void enterClientEmail(String email) {
		clientEmail.sendKeys(email);
	}
	public void enterCompanyReg(String reg) {
		cilentCompReg.sendKeys(reg);
	}
	public void selectInvoiceOrder(String invoiceOrder) {
		Select s3 = new Select(clientInvoiceOrder);
		s3.selectByVisibleText(invoiceOrder);
	}
	public void selectDeliveryMethod(String delMethod) {
		Select s4 = new Select(invoiceDelivery);
		s4.selectByVisibleText(delMethod);
	}
	public void selectMasterDocument(String masDocument) {
		Select s5 = new Select(clientDocument);
		s5.selectByVisibleText(masDocument);
	}
	public void selectSettleDays(String settleDays) {
		settlementDays.sendKeys(settleDays);
	}
	public void selectVatRate(String vatRate) {
		Select s7 = new Select(clientVatRate);
		s7.selectByVisibleText(vatRate);
	}
	public void scrollCreateClientPage() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clientSubmit);
	}

	public void enterClientInfo(String strBranch, String strDivision, String strClientName, String strClientAddress, String strPostCode, 
			String strRef, String strInvoiceContact, String strPhone, String strEmail, String strReg, String strInvoiceOrder,
			String strInvoiceDelivery, String strMasDocument, String strSettelementDays, String strVatRAte) {
		this.selectBranchID(strBranch);
		this.selectDivision(strDivision);
		this.enterName(strClientName);
		this.enterAddress(strClientAddress);
		this.enterPostCode(strPostCode);
		this.enterClientRef(strRef);
		this.enterClientInvoiceContact(strInvoiceContact);
		this.enterClientPhone(strPhone);
		this.enterClientEmail(strEmail);
		this.enterCompanyReg(strReg);
		this.selectInvoiceOrder(strInvoiceOrder);
		this.selectDeliveryMethod(strInvoiceDelivery);
		this.selectMasterDocument(strMasDocument);
		this.selectSettleDays(strSettelementDays);
		this.selectVatRate(strVatRAte);
	}
	public ClientView submitClientInfo() {
		clientSubmit.click();
		return new ClientView(driver);
	}
	
}
