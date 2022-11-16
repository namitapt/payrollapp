package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class WorkerViewPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td[2]")
	WebElement workerNameSearched;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td[5]")
	WebElement workerPostcodeSearched;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td[7]")
	WebElement workerNiNumberSearched;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[6]")
	WebElement createdWorkerFirstName;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[8]")
	WebElement createdWorkerLastName;
	
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	
	public WorkerViewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getSearchedWorkerName() {
		waitutility.hardWait(driver);
		String name = workerNameSearched.getText();
		return name;
	}
	public String getSearchedWorkerPostCode() {
		waitutility.hardWait(driver);
		String postcode = workerPostcodeSearched.getText();
		return postcode;
	}
	public String getSearchedWorkerNiNumber() {
		waitutility.hardWait(driver);
		String postcode = workerNiNumberSearched.getText();
		return postcode;
	}
	
	public String savedFirstName() {
		waitutility.waitforanelement(createdWorkerFirstName, driver);
		String firstName = createdWorkerFirstName.getText();
		return firstName;
	}
	public String savedLastName() {
		String lastName = createdWorkerLastName.getText();
		return lastName;
	}
	
	
	

}
