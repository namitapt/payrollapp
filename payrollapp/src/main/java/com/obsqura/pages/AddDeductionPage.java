package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.WaitUtility;

public class AddDeductionPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/form/div[1]/div/span/span[1]/span/span[1]")
	WebElement workerField;
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement workerName;
	@FindBy(id="deduction-type")
	WebElement deductionType;
	@FindBy(id="deduction-amount")
	WebElement deductionAmount;
	@FindBy(id="deduction-effective_from")
	WebElement effectiveFrom;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/form/div[5]/div/button")
	WebElement saveButton;
	
	public AddDeductionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWorkerField() {
		workerField.click();
	}
	public void enterWorkerName(String wName) {
		workerName.sendKeys(wName);
		workerName.sendKeys(Keys.ENTER);
	}
	public void enterDeductionType(String type) {
		Select s1 = new Select(deductionType);
		s1.selectByVisibleText(type);
	}
	public void enterDeductionAmount(String amount) {
		deductionAmount.clear();
		deductionAmount.sendKeys(amount);
	}
	public void enterEffectiveFrom(String effectiveDate) {
		effectiveFrom.clear();
		effectiveFrom.sendKeys(effectiveDate);
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public DeductedInfoPage enterDeductionInfo(String strWorkerName, String strDeductionType, String strDeductionAmount, String strEffectiveFrom) {
		this.clickOnWorkerField();
		this.enterWorkerName(strWorkerName);
		this.enterDeductionType(strDeductionType);
		this.enterDeductionAmount(strDeductionAmount);
		this.enterEffectiveFrom(strEffectiveFrom);
		this.clickSaveButton();
		return new DeductedInfoPage(driver);
	}
	public DeductedInfoPage enterEditDeductionInfo(String strDeductAmount) {
		this.enterDeductionAmount(strDeductAmount);
		this.clickSaveButton();
		return new DeductedInfoPage(driver);
	}
}
