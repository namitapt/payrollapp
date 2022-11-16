package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class UserLoginPage {
	WebDriver driver;
	@FindBy(id="loginform-username")
	WebElement username;
	@FindBy(id="loginform-password")
	WebElement password;
	@FindBy(id="loginform-rememberme")
	WebElement checkBox;
	@FindBy(xpath="//*[@id=\"login-form\"]/div[5]/button")
	WebElement loginButton;
	@FindBy(xpath="/html/body/section/div/div/div[3]/h1")
	WebElement titleOfPage;
	
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[4]/a")
	WebElement resetLink;
	
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/p")
	WebElement invalidUserMessage;
	
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[1]/p")
	WebElement usernameBlankMessage;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/p")
	WebElement passwordBlankMessage;
	
	WaitUtility waitUtility = new WaitUtility();
	
	public UserLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String strUN) {
		username.sendKeys(strUN);
	}
	
	public void enterPassword(String strPSWD) {
		password.sendKeys(strPSWD);
	}
	
	public void checkBoxClick() {
		checkBox.click();
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public String pageTitle() {
		return titleOfPage.getText();
	}
	public EmailResetPage clickReset() {
		resetLink.click();
		return new EmailResetPage(driver);
	}
	
	public HomePage login(String strUN, String strPSWD) {
		this.enterUserName(strUN);
		this.enterPassword(strPSWD);
		this.checkBoxClick();
		this.clickLogin();
		return new HomePage(driver);
	}
	
	public String getInvalidUserMessage() {
		waitUtility.waitforanelement(invalidUserMessage, driver);
		return invalidUserMessage.getText();
	}
	public String getUsernameBlankMessage() {
		waitUtility.waitforanelement(usernameBlankMessage, driver);
		return usernameBlankMessage.getText();
	}
	public String getPasswordBlankMessage() {
		waitUtility.waitforanelement(passwordBlankMessage, driver);
		return passwordBlankMessage.getText();
	}
}
