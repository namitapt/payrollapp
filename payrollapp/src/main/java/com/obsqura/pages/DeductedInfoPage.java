package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class DeductedInfoPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[1]")
	WebElement nameOfWorker;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[3]")
	WebElement amountDeducted;
	
	public DeductedInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getWorkerName() {
		waitutility.waitforanelement(nameOfWorker, driver);
		String name = nameOfWorker.getText();
		return name;
	}
	public String getAmountDeducted() {
		waitutility.waitforanelement(amountDeducted, driver);
		String amount = amountDeducted.getText();
		return amount;
	}
}
