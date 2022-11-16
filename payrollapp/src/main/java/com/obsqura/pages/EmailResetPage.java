package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class EmailResetPage {
	WebDriver driver;
	
	
	@FindBy(xpath="/html/body/section/div/div/div[3]/h1")
	WebElement titleOfPage;
	@FindBy(id="passwordresetrequestform-email")
	WebElement email;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/button")
	WebElement submitEmailButton;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[1]/p")
	WebElement wrongEmailMsg;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/a")
	WebElement cancelButton;
	
	WaitUtility waitUtility = new WaitUtility();
	
	public EmailResetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String pageTitle() {
		return titleOfPage.getText();
	}
	public void enterEmailID(String emailID) {
		email.sendKeys(emailID);
	}
	public void clickSubmitButton() {
		submitEmailButton.click();
	}
	public HomePage enterResetInfo(String strEmail) {
		this.enterEmailID(strEmail);
		this.clickSubmitButton();
		return new HomePage(driver);
	}
	public String getWrongEmailMsg() {
		waitUtility.waitforanelement(wrongEmailMsg, driver);
		return wrongEmailMsg.getText();
	}
	public void clickCancelButton() {
		cancelButton.click();
	}
	
	
}
