package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWorkerByNiNumber {
	WebDriver driver;
	
	@FindBy(id="workersearch-ni_number")
	WebElement workerNiNumber;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/form/div[5]/button[1]")
	WebElement workerSearchButton;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/form/div[5]/button[2]")
	WebElement workerSearchResetButton;
	
	public SearchWorkerByNiNumber(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterWorkerNiNumberForSearch(String strWorkerNiNumber) {
		workerNiNumber.sendKeys(strWorkerNiNumber);
	}
	public void clickWorkerSearch() {
		workerSearchButton.click();
	}
	public WorkerViewPage enterSearchWorkerInfo(String strWorkerNiNumber) {
		this.enterWorkerNiNumberForSearch(strWorkerNiNumber);
		this.clickWorkerSearch();
		return new WorkerViewPage(driver);
	}
}
