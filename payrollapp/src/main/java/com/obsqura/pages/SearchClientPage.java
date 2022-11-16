package com.obsqura.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class SearchClientPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	@FindBy(id="clientsearch-client_name")
	WebElement clientName;
	
	@FindBy(id="clientsearch-id")
	WebElement clientID;
	
	@FindBy(css="#w0 > div.col-lg-2.col-sm-4.payslip-btn-search > button.btn.btn-primary")
	WebElement clientSearchearchButton;
	@FindBy(css="#w0 > div.col-lg-2.col-sm-4.payslip-btn-search > button.btn.btn-default")
	WebElement clientResetButton;
	
	public SearchClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterClientNameForSearch(String searchClientName) {
		clientName.sendKeys(searchClientName);
	}
	public void enterClientIdForSearch(String searchClientID) {
		clientID.sendKeys(searchClientID);
	}
	public void clickWorkerSearchButton() {
		clientSearchearchButton.click();
	}
	public void enterSearchClientInfo(String strSearchClientName, String strSearchClientID) {
		this.enterClientNameForSearch(strSearchClientName);
		this.enterClientIdForSearch(strSearchClientID);
		this.clickWorkerSearchButton();	
	}
	
	public void clickClientSearchReset() {
		clientResetButton.click();
	}
	public String getValueFromSearch() {
		String value = clientName.getText();
		return value;
	}

	public WebElement xpathForClientView(String clientNameView)
	{
	    return driver.findElement(By.xpath("//*[text()='"+clientNameView+"']/..//a[1]"));
	}
	public void clickViewClientDetails(String strClientName) {
		WebElement viewClient = this.xpathForClientView(strClientName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewClient);
		viewClient.click();
	}
	public WebElement xpathForClientEdit(String clientNameEdit)
	{
	    return driver.findElement(By.xpath("//*[text()='"+clientNameEdit+"']/..//a[2]"));
	}
	public void clickEditClientDetails(String strClientName) {
		WebElement editClient = this.xpathForClientEdit(strClientName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editClient);
		editClient.click();
	}


}
