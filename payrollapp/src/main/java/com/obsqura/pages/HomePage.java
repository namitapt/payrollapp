package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	@FindBy(xpath="/html/body/section/div/div/div/p[1]")
	WebElement message;
	
	@FindBy(xpath="//*[@id=\"w1\"]/li[3]/a")
	WebElement clientLink;
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement createClientLink;
	
	@FindBy(xpath="/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[5]/a")
	WebElement deductionLink;
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement addDeductionLink;
	
	@FindBy(xpath="/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[4]/a")
	WebElement workerLink;
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement createWorkerLink;
	
	@FindBy(xpath="/html/body/header/div[2]/div/div/nav/div/div[2]/ul/li[6]/a")
	WebElement timesheetLink;
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[3]/a")
	WebElement createTimesheetLink;
	
	@FindBy(xpath="/html/body/div")
	WebElement resetEmailSentMessage;
	
	@FindBy(xpath="/html/body/header/div[1]/div/div[1]")
	WebElement pageLogo;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String welcomeMsg() {
		waitutility.waitforanelement(message, driver);
		String msg = message.getText();
		return msg;
	}
	
	public CreateClientPage navigateToCreateClient() {
		clientLink.click();
		createClientLink.click();
		return new CreateClientPage(driver);
	}
	public SearchClientPage navigateToSearchClient() {
		clientLink.click();
		return new SearchClientPage(driver);
	}
	
	public SearchDeductionPage navigateToDeduction() {
		deductionLink.click();
		return new SearchDeductionPage(driver);
	}
	public AddDeductionPage navigateToAddDeduction() {
		deductionLink.click();
		addDeductionLink.click();
		return new AddDeductionPage(driver);
	}
	
	public CreateWorkerPage navigateToCreateWorker() {
		workerLink.click();
		createWorkerLink.click();
		return new CreateWorkerPage(driver);
	}
	public SearchWorkerPage navigateToSearchWorker() {
		workerLink.click();
		return new SearchWorkerPage(driver);
	}
	
	public String getEmailSentMsg() {
		waitutility.waitforanelement(resetEmailSentMessage, driver);
		return resetEmailSentMessage.getText();
	}
	
	public boolean isLogoPresent() {
		waitutility.waitforanelement(pageLogo, driver);
		return pageLogo.isDisplayed();
	}
	
	public CreateTimesheetPage navigateToTimesheet() {
		timesheetLink.click();
		return new CreateTimesheetPage(driver);
	}
	public CreateTimesheetPage navigateToCreateTimesheet() {
		timesheetLink.click();
		createTimesheetLink.click();
		return new CreateTimesheetPage(driver);
	}
	
}
