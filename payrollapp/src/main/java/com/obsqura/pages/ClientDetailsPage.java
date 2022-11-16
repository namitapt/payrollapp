package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class ClientDetailsPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/table/tbody/tr[3]")
	WebElement nameOfClient;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td")
	WebElement noResultMessage;
	@FindBy(id="client-phone")
	WebElement clientPhoneNum;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[4]/div/button")
	WebElement save;
	@FindBy(xpath="/html/body/section/div/div/div[2]/table/tbody/tr[8]")
	WebElement savedPNumber;
	
	WaitUtility waitutility = new WaitUtility();
	
	public ClientDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getClientName() {
		String cName = nameOfClient.getText();
		return cName;
	}
	public String getNoResultMsg() {
		waitutility.hardWait(driver);
		String msg = noResultMessage.getText();
		return msg;
	}
	public void editClientDetails(String cPhoneNum) {
		clientPhoneNum.clear();
		clientPhoneNum.sendKeys(cPhoneNum);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		save.click(); 
	}
	public String getPNumber() {
		waitutility.waitforanelement(savedPNumber, driver);
		String num = savedPNumber.getText();
		return num;
	}
	

}
