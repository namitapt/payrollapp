package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class CreateWorkerBankDetailsPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility(); 
	PageUtility pageutility = new PageUtility();
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[2]/div[1]/div/select")
	WebElement paymentMethod;
	@FindBy(id="worker-start_date")
	WebElement workerStartDate;
	@FindBy(id="worker-ac_type")
	WebElement workerAccountType;
	@FindBy(id="worker-ac_name")
	WebElement workerAccountName;
	@FindBy(id="worker-ac_no")
	WebElement workerAccountNumber;
	@FindBy(id="worker-sort_code")
	WebElement workerSortCode;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[4]/div/button")
	WebElement save;
	
	public CreateWorkerBankDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterStartDate(String sDate) {
		workerStartDate.sendKeys(sDate);
	}
	public void selectAccountType(String accType) {
		Select selectAccType = new Select(workerAccountType);
		selectAccType.selectByVisibleText(accType);
	}
	public void enterAccountName(String accName) {
		workerAccountName.sendKeys(accName);
	}
	public void enterAccountNumber(String accNum) {
		workerAccountNumber.sendKeys(accNum);
	}
	public void enterSortCode(String sortCode) {
		workerSortCode.sendKeys(sortCode);
	}
	public void clickSaveButton() {
		save.click();
	}
	
	public WorkerViewPage selectPayMethod(String strPaymentMethod, String strAccountType, String strAccountName, String strAccountNumber, String strSortCode, String date) {
		waitutility.waitforanelement(paymentMethod, driver);
		Select selectPayMeth = new Select(paymentMethod);
		selectPayMeth.selectByVisibleText(strPaymentMethod);
		WebElement element = selectPayMeth.getFirstSelectedOption();
		String p = element.getText();
		if(p.equalsIgnoreCase("BACS")) {
			this.selectAccountType(strAccountType);
			this.enterAccountName(strAccountName);
			this.enterAccountNumber(strAccountNumber);
			this.enterSortCode(strSortCode);
		}
		else {
			this.enterStartDate(date);
		}
		this.clickSaveButton();
		return new WorkerViewPage(driver);
	}

}
