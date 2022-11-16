package com.obsqura.pages;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class CreateTimesheetPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[1]/div[1]/div[3]/div[2]/div")
	WebElement browse;
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[1]/div[1]/div[3]/div[2]/div/input")
	WebElement pathOfTheFile;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/button[1]")
	WebElement generatePayslipButton;
	@FindBy(xpath="/html/body/section/div/div/div[2]/button[2]")
	WebElement generateInvoiceButton;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[2]/button")
	WebElement skipToCreatePage;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement createTimesheetPageTitle;
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public CreateTimesheetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void browseFile(String path) {
		waitutility.waitforanelement(browse, driver);
		//browse.click();
		pathOfTheFile.sendKeys(path);	
	}
	
	public String clickGeneratePayslipButton() {
		generatePayslipButton.click();
		String msg = pageutility.AlertHandleing(driver);
		return msg;
		
	}
	public String checkingForPaySlipGerneration() {
		waitutility.waitForAnAlert(driver);
		String msg = pageutility.AlertHandleing(driver);
		return msg;
	}
	
	public String clickGenerateInvoiceButton() {
		generateInvoiceButton.click();
		String msg = pageutility.AlertHandleing(driver);
		return msg;
	}
	public String checkingForInvoiceGeneration() {
		waitutility.waitForAnAlert(driver);
		String msg = pageutility.AlertHandleing(driver);
		return msg;
	}
	
	public String clickSkipToCreate() {
		skipToCreatePage.click();
		String msg = pageutility.AlertHandleing(driver);
		return msg;
	}
	public String timesheetPageTitle() {
		waitutility.waitforanelement(createTimesheetPageTitle, driver);
		String title =createTimesheetPageTitle.getText();
		return title;
	}
	

	public void fileUpload()throws AWTException{
		Robot rb = new Robot();
		StringSelection str = new StringSelection("C:\\\\Users\\\\LENOVO\\\\Pictures\\\\72415f8c-3e06-40fc-b5a6-32fd76c7b567-shutterstock-1270572721.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	}


	
	
}
