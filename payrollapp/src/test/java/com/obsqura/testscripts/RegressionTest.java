package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.AddDeductionPage;
import com.obsqura.pages.DeductedInfoPage;
import com.obsqura.pages.EmailResetPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.SearchDeductionPage;
import com.obsqura.pages.UserLoginPage;

@Listeners(ExtentListener.class)	
public class RegressionTest extends TestHelper{
	
	HomePage homepage;
	UserLoginPage userloginpage;
	EmailResetPage emailresetpage;
	AddDeductionPage adddeductionpage;
	DeductedInfoPage deductedinfopage;
	SearchDeductionPage searchdeductionpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	
	@Test
	public void testingInvalidLogin() {
		userloginpage = new UserLoginPage(driver);
		userloginpage.login("username", "password");
		String invalidMsg = userloginpage.getInvalidUserMessage();
		Assert.assertEquals(invalidMsg, "Incorrect username or password.");
		Reporter.log("UserName or Password is invalid", true);
	}
	
	@Test
	public void testingInvalidLoginBlank() {
		userloginpage = new UserLoginPage(driver);
		userloginpage.login("", "");
		Assert.assertTrue(userloginpage.getUsernameBlankMessage().contains("Username cannot be blank."));
		Reporter.log("UserName Blank Message", true);
		Assert.assertTrue(userloginpage.getPasswordBlankMessage().contains("Password cannot be blank."));
		Reporter.log("Password Blank Message", true);
	}
	
	@Test
	public void testingResetForCorrectEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String titleLogin = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", titleLogin);
		
		homepage = emailresetpage.enterResetInfo("carol@caredirectrecruitment.co.uk");
		Assert.assertTrue(homepage.getEmailSentMsg().contains("Check your email for further instructions."));
		Reporter.log("Reset email sent", true);	
	}
	
	//@Test
	public void testingResetForWrongEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String titleLogin = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", titleLogin);
		emailresetpage.enterResetInfo("namita@gmail.com");
		
		Assert.assertTrue(emailresetpage.getWrongEmailMsg().contains("There is no user with this email address."));
		Reporter.log("Reset Unsuccessful", true);
	}
	
	@Test
	public void testingResetForBlankEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String titleLogin = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", titleLogin);
		emailresetpage.enterResetInfo("");
		
		Assert.assertTrue(emailresetpage.getWrongEmailMsg().contains("Email cannot be blank."));
		Reporter.log("Reset Unsuccessful", true);
	}
	
	@Test
	public void verifyCancelForCorrectEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String title = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", title);
		emailresetpage.clickCancelButton();
		
		String titleLogin = userloginpage.pageTitle();
		Assert.assertEquals("Login", titleLogin);
	}
	
	@Test
	public void verifyLogoPresence() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		Boolean logo = homepage.isLogoPresent();
		Assert.assertTrue(logo);
		Reporter.log("Logo Present", true);
	}
	
	@Test
	public void verifyIfUserIsAbleToAddDeduction() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		adddeductionpage = homepage.navigateToAddDeduction();
		deductedinfopage = adddeductionpage.enterDeductionInfo("Marina  Zirbo", "Locker Keys", "50", "01-01-2000");
		Assert.assertTrue(deductedinfopage.getWorkerName().contains("Marina"));
		Assert.assertTrue(deductedinfopage.getAmountDeducted().contains("50"));
		Reporter.log("Deduction Success", true);
	}
	
	@Test
	public void verifyUserCanViewDeductionDetails() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		searchdeductionpage = homepage.navigateToDeduction();
		String deductionName = "Lidiya";
		
		deductedinfopage = searchdeductionpage.clickViewDeductionDetails(deductionName);
		Assert.assertTrue(deductedinfopage.getWorkerName().contains(deductionName));
		Reporter.log("Deduction View Success", true);
	}
	
	@Test
	public void verifyUserCanEditDeductionDetails() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		searchdeductionpage = homepage.navigateToDeduction();
		String deductionName = "Lidiya";
		
		adddeductionpage = searchdeductionpage.clickEditDeductionDetails(deductionName);
		String dAmount = "100";
		
		deductedinfopage = adddeductionpage.enterEditDeductionInfo(dAmount);
		Assert.assertTrue(deductedinfopage.getAmountDeducted().contains(dAmount));
		Reporter.log("Deduction Edit Success", true);
	}
	
}
