package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class ClientView {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/table/tbody/tr[3]")
	WebElement clientNameSubmitted;
	@FindBy(xpath="/html/body/section/div/div/div[2]/table/tbody/tr[8]")
	WebElement clientPhoneNumberSubmitted;

	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td[2]")
	WebElement clientNameSearched;
	
	public ClientView(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getClientNumber() {
		String cPhoneNumber = clientPhoneNumberSubmitted.getText();
		return cPhoneNumber;
	}
	
	public String getClientName() {
		waitutility.waitforanelement(clientNameSubmitted, driver);
		String cName = clientNameSubmitted.getText();
		return cName;
	}
	
	public String getSearchedClientName() {
		waitutility.hardWait(driver);
		String searchedName = clientNameSearched.getText();
		return searchedName;
	}
	
	public WebElement xpathForClientName(String clientName)
	{
	    return driver.findElement(By.xpath("//*[text()='"+clientName+"']/.."));
	}
	public String getName(String strClientName) {
		WebElement clientNameXpath = this.xpathForClientName(strClientName);
		System.out.println("Got xpath");
		waitutility.waitforanelement(clientNameXpath, driver);
		System.out.println("Waiting for display");
		String name = clientNameXpath.getText();
		return name;
	}
	
	
}
