package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class WorkerDetailsPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[6]")
	WebElement firstNameOfWorker;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[8]")
	WebElement lastNameOfWorker;
	
	@FindBy(id="worker-phone")
	WebElement workerPhoneNumber;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[18]")
	WebElement savedWorkerNumber;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[4]/div/button")
	WebElement next;
	@FindBy(id="worker-roll_no")
	WebElement workerRollNum;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[4]/div/button")
	WebElement save;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td")
	WebElement noResultMessage;
	
	public WorkerDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstName() {
		String firstName = firstNameOfWorker.getText();
		return firstName;
	}
	public String getLastName() {
		String lastName = lastNameOfWorker.getText();
		return lastName;
	}
	public String getNoResultMsg() {
		waitutility.hardWait(driver);
		String msg = noResultMessage.getText();
		return msg;
	}
	
	public void editWorkerDetails(String phoneNum) {
		workerPhoneNumber.clear();
		workerPhoneNumber.sendKeys(phoneNum);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
		next.click(); 
	}
	public void editWorkerBankDetails() {
		waitutility.waitforanelement(workerRollNum, driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		save.click();
	}
	public String getPhoneNumber() {
		waitutility.waitforanelement(savedWorkerNumber, driver);
		String pNum = savedWorkerNumber.getText();
		return pNum;
	}

}
