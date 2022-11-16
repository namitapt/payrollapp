package com.obsqura.testscripts;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CreateTimesheetPage;
import com.obsqura.pages.CreateWorkerBankDetailsPage;
import com.obsqura.pages.CreateWorkerPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.SearchWorkerByNiNumber;
import com.obsqura.pages.SearchWorkerLastNamePage;
import com.obsqura.pages.SearchWorkerPage;
import com.obsqura.pages.SearchWorkerPinCode;
import com.obsqura.pages.UserLoginPage;
import com.obsqura.pages.WorkerDetailsPage;
import com.obsqura.pages.WorkerViewPage;


public class WorkerTest extends TestHelper{
	HomePage homepage;
	UserLoginPage userloginpage;
	CreateWorkerPage createworkerpage;
	SearchWorkerPage searchworkerpage;
	CreateWorkerBankDetailsPage createworkerbankdetailsPage;
	WorkerViewPage workerviewpage;
	WorkerDetailsPage workerdetailspage;
	SearchWorkerByNiNumber searchworkerbyninumber;
	SearchWorkerLastNamePage searchworkerlastnamepage;
	SearchWorkerPinCode searchworkerpinCode;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	
	//@Test
	public void verifyUserIsAbleToCreateWorker() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		createworkerpage = homepage.navigateToCreateWorker();
		createworkerbankdetailsPage = createworkerpage.enterWorkerInfo("Ms", "Alei", "John","123456789", "demo@gmail.com","Female", "01/01/2001", "Karnataka", 
				"123456", "Alpha_new", "NewAlpha", "Paye", "Paper", "0123");
		
		workerviewpage = createworkerbankdetailsPage.selectPayMethod("Cheque", "BANK", "Alei", "Bank0009", "Alei010", "05/05/2005");
		Assert.assertTrue(workerviewpage.savedFirstName().contains("Alei"));
		Reporter.log("FirstName found", true);
		Assert.assertTrue(workerviewpage.savedLastName().contains("John"));
		Reporter.log("Worker Creation Success", true);
	}
	
	//@Test
	public void verifyUserIsAbleToEditWorkerDetails() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		searchworkerpage = homepage.navigateToSearchWorker();
		String firstNameToBeSearched = "Jose";
		String lastNameToBeSearched = " Gallop";
		String name = firstNameToBeSearched+lastNameToBeSearched;
		
		workerdetailspage = searchworkerpage.clickEditWorkerDetails(name);
		String newNum="9517532846";
		workerdetailspage.editWorkerDetails(newNum);
		workerdetailspage.editWorkerBankDetails();
		Assert.assertTrue(workerdetailspage.getPhoneNumber().contains(newNum));
		Reporter.log("Edit Success", true);
	}
	
	//@Test
	public void verifyUserIsAbleToViewWorkerDetails() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		searchworkerpage = homepage.navigateToSearchWorker();
		String firstNameToBeSearched = "Jose";
		String lastNameToBeSearched = " Gallop";
		String name = firstNameToBeSearched+lastNameToBeSearched;
		
		workerdetailspage = searchworkerpage.clickViewWorkerDetails(name);
		Assert.assertTrue(workerdetailspage.getFirstName().contains(firstNameToBeSearched));
		Reporter.log("First Name Found", true);
		Assert.assertTrue(workerdetailspage.getLastName().contains(lastNameToBeSearched));
		Reporter.log("Last Name Found", true);
	}
	
	//@Test
	public void verifyUserIsAbleToResetWorkerSearch() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		searchworkerpage = homepage.navigateToSearchWorker();
		searchworkerpage.enterWorkerNameForSearch("Namita");
		searchworkerpage.clickWorkerSearchReset();
		String searchBarText = searchworkerpage.getValueFromSearch();
		String nullValue = "";
		Assert.assertEquals(searchBarText, nullValue);
		Reporter.log("Reset Search Bar Success for Worker Page", true);
	}
	
	//@Test
	public void verifyUserIsAbleToSearchWorkerByNiNumber() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		homepage.navigateToSearchWorker();
		
		searchworkerbyninumber = new SearchWorkerByNiNumber(driver);
		String workerNiNumberForSearching = "PB780652A";
		System.out.println("NiNUmber to be searched is: "+workerNiNumberForSearching);
		
		workerviewpage = searchworkerbyninumber.enterSearchWorkerInfo(workerNiNumberForSearching);
		Assert.assertTrue(workerviewpage.getSearchedWorkerNiNumber().contains(workerNiNumberForSearching));
		Reporter.log("NiNumber Search Success", true);
	}
	
	//@Test
	public void verifyUserIsAbleToSearchWorkerByPostCode() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		homepage.navigateToSearchWorker();
		
		searchworkerpinCode = new SearchWorkerPinCode(driver);
		String workerPinCodeForSearching = "PL48QF";
		System.out.println("PinCode to be searched is: "+workerPinCodeForSearching);
		
		workerviewpage = searchworkerpinCode.enterSearchWorkerInfo(workerPinCodeForSearching);
		Assert.assertTrue(workerviewpage.getSearchedWorkerPostCode().contains(workerPinCodeForSearching));
		Reporter.log("PostCode Search Success", true);
	}
	
	//@Test
	public void verifyUserIsAbleToSearchWorkerByLastName() {
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		homepage.navigateToSearchWorker();
		
		searchworkerlastnamepage = new SearchWorkerLastNamePage(driver);
		String workerLastNameForSearching = "Gallop";
		System.out.println("Last Name to be searched is: "+workerLastNameForSearching);
		
		workerviewpage = searchworkerlastnamepage.enterSearchWorkerInfo(workerLastNameForSearching);
		Assert.assertTrue(workerviewpage.getSearchedWorkerName().contains("Gallop"));
		Reporter.log("Last Name Search Success", true);
	}
	
	//@Test
	public void verifyUserIsAbleToSearchWorkerByFirstName() {
		userloginpage = new UserLoginPage(driver);	
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		searchworkerpage = homepage.navigateToSearchWorker();
		String workerNameForSearching = "Ioan ";
		System.out.println("Name to be searched is: "+workerNameForSearching);
		
		workerviewpage = searchworkerpage.enterSearchWorkerInfo(workerNameForSearching);
		Assert.assertTrue(workerviewpage.getSearchedWorkerName().contains(workerNameForSearching));
		Reporter.log("Search Success", true);
	}
	@Test
	public void verifyErrorMessageIsDisplayedForInvalidWorkerSearch() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		searchworkerpage = homepage.navigateToSearchWorker();
		String workerNameForSearching = "Nikhitha ";
		System.out.println("Name to be searched is: "+workerNameForSearching);
		
		workerdetailspage = new WorkerDetailsPage(driver);
		Assert.assertTrue(workerdetailspage.getNoResultMsg().contains("No results found."));
		Reporter.log("No Result Message Found", true);
		
	}
	


	
}
