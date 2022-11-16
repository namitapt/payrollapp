package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWorkerPage {
	WebDriver driver;
	
	@FindBy(id="workersearch-first_name")
	WebElement workerFirstName;

	@FindBy(id="workersearch-ni_number")
	WebElement workerNiNumber;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/form/div[5]/button[1]")
	WebElement workerSearchButton;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[1]/form/div[5]/button[2]")
	WebElement workerSearchResetButton;
	
	@FindBy(xpath="//*[text()='Marina Zirbo']/..//a[1]")
	WebElement viewMarinaZirbo;
	
	@FindBy(xpath="//*[text()='Benedict Odoh']/..//a[1]")
	WebElement viewBenedicOdoh;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/ul/li[8]/a")
	WebElement skipToPage7;
	
	public SearchWorkerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterWorkerNameForSearch(String strWorkerFirstName) {
		workerFirstName.sendKeys(strWorkerFirstName);
	}
	public void clickWorkerSearch() {
		workerSearchButton.click();
	}
	public WorkerViewPage enterSearchWorkerInfo(String strWorkerFirstName) {
		this.enterWorkerNameForSearch(strWorkerFirstName);
		this.clickWorkerSearch();
		return new WorkerViewPage(driver);
	}
	public void clickWorkerSearchReset() {
		workerSearchResetButton.click();
	}
	public String getValueFromSearch() {
		String value = workerFirstName.getText();
		return value;
	}
	
	public WebElement xpathForWorkerView(String workerNameView)
	{
	    return driver.findElement(By.xpath("//*[text()='"+workerNameView+"']/..//a[1]"));
	}
	public WorkerDetailsPage clickViewWorkerDetails(String strWorkerName) {
		WebElement viewWorker = this.xpathForWorkerView(strWorkerName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewWorker);
		viewWorker.click();
		return new WorkerDetailsPage(driver);
	}
	
	public WebElement xpathForWorkerEdit(String workerNameEdit)
	{
	    return driver.findElement(By.xpath("//*[text()='"+workerNameEdit+"']/..//a[2]"));
	}
	public WorkerDetailsPage clickEditWorkerDetails(String strWorkerName) {
		WebElement viewWorker = this.xpathForWorkerEdit(strWorkerName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewWorker);
		viewWorker.click();
		return new WorkerDetailsPage(driver);
	}
	

	
	
	
}
