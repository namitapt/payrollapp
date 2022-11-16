package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchDeductionPage {
	WebDriver driver;
	
	public SearchDeductionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement xpathForDeductionView(String deductionNameView)
	{
	    return driver.findElement(By.xpath("//*[text()='"+deductionNameView+"']/..//a[1]"));
	}
	public DeductedInfoPage clickViewDeductionDetails(String strDeductionName) {
		WebElement deductView = this.xpathForDeductionView(strDeductionName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deductView);
		deductView.click();
		return new DeductedInfoPage(driver);
	}
	public WebElement xpathForDeductionEdit(String deductionNameEdit)
	{
	    return driver.findElement(By.xpath("//*[text()='"+deductionNameEdit+"']/..//a[2]"));
	}
	public AddDeductionPage clickEditDeductionDetails(String strDeductionName) {
		WebElement deductEdit = this.xpathForDeductionEdit(strDeductionName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deductEdit);
		deductEdit.click();
		return new AddDeductionPage(driver);
	}
}
