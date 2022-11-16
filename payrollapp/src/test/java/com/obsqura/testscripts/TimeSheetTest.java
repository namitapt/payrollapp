package com.obsqura.testscripts;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CreateTimesheetPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.UserLoginPage;

public class TimeSheetTest extends TestHelper{
	UserLoginPage userloginpage;
	HomePage homepage;
	CreateTimesheetPage createtimesheetpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
		
	//@Test
	public void verifyUserIsAbleToGeneratePayslip() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		createtimesheetpage = homepage.navigateToTimesheet();
		Assert.assertTrue(createtimesheetpage.clickGeneratePayslipButton().contains("Are you sure you want to generate payslip?"));
		Reporter.log("Generate Click Success", true);
		
		Assert.assertTrue(createtimesheetpage.checkingForPaySlipGerneration().contains("Payslip generated!!!"));
		Reporter.log("PaySlip Generation Success", true);
	}
	
	//@Test
	public void verifyUserIsAbleToGenerateInvoice() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		createtimesheetpage = homepage.navigateToTimesheet();
		Assert.assertTrue(createtimesheetpage.clickGenerateInvoiceButton().contains("Are you sure you want to generate invoice?"));
		Reporter.log("Generate Click Success", true);
		
		Assert.assertTrue(createtimesheetpage.checkingForInvoiceGeneration().contains("Invoice generated!!!"));
		Reporter.log("Invoice Generation Success", true);
	}
	
	@Test
	public void verifyUserIsAbleToSkipFileUploadInTimeSheet() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		createtimesheetpage = homepage.navigateToCreateTimesheet();
		createtimesheetpage.clickSkipToCreate();
		Assert.assertTrue(createtimesheetpage.timesheetPageTitle().contains("CREATE TIMESHEET"));
		Reporter.log("Skip Success", true);
	}
}
