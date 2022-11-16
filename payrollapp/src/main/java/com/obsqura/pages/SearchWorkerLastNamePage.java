package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWorkerLastNamePage {
	WebDriver driver;
	
	@FindBy(id="workersearch-last_name")
	WebElement workerLastName;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/form/div[5]/button[1]")
	WebElement workerSearchButton;
	
	public SearchWorkerLastNamePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterWorkerLastNameForSearch(String strWorkerLastName) {
		workerLastName.sendKeys(strWorkerLastName);
	}
	public void clickWorkerSearch() {
		workerSearchButton.click();
	}
	public WorkerViewPage enterSearchWorkerInfo(String strWorkerLastName) {
		this.enterWorkerLastNameForSearch(strWorkerLastName);
		this.clickWorkerSearch();
		return new WorkerViewPage(driver);
	}
}
