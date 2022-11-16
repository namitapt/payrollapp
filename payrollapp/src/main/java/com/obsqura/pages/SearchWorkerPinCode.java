package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWorkerPinCode {
	WebDriver driver;
	
	@FindBy(id="workersearch-postcode")
	WebElement workerPostCode;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/form/div[5]/button[1]")
	WebElement workerSearchButton;
	
	public SearchWorkerPinCode(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterWorkerPinCodeForSearch(String strWorkerPinCode) {
		workerPostCode.sendKeys(strWorkerPinCode);
	}
	public void clickWorkerSearch() {
		workerSearchButton.click();
	}
	public WorkerViewPage enterSearchWorkerInfo(String strWorkerPinCode) {
		this.enterWorkerPinCodeForSearch(strWorkerPinCode);
		this.clickWorkerSearch();
		return new WorkerViewPage(driver);
	}
}
