package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.ClientDetailsPage;
import com.obsqura.pages.ClientView;
import com.obsqura.pages.CreateClientPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.SearchClientPage;
import com.obsqura.pages.UserLoginPage;


public class ClientTest extends TestHelper{
	UserLoginPage userloginpage;
	HomePage homepage;
	CreateClientPage createclientpage ;
	SearchClientPage searchclientpage;
	ClientView clientview;
	ClientDetailsPage clientdetailspage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	
	//@Test
	public void verifyUserIsAbleToCreateNewClient() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		createclientpage = homepage.navigateToCreateClient();
		createclientpage.scrollCreateClientPage();
		createclientpage.enterClientInfo("Alpha_new", "NewAlpha", "Ann", "zxcvb, PO qazwsx", "789456", "a1b2c3112233", "sheryl", 
				"9876543210", "a1b2c3@gmail.com", "California", "Multi timesheet per client", "Paper", "PDF", "30", "Zero Rated 0.00%");
		
		clientview = createclientpage.submitClientInfo();
		Assert.assertTrue(clientview.getClientName().contains("Ann"));
		Reporter.log("Client Creation Success", true);
	}

	//@Test
	public void verifyUserIsAbleToViewClientDetails() {
		userloginpage = new UserLoginPage(driver);
		userloginpage.login("carol", "1q2w3e4r");
		
		homepage = new HomePage(driver);
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		searchclientpage = homepage.navigateToSearchClient();
		String NameToBeSearched = "Sid";
		searchclientpage.clickViewClientDetails(NameToBeSearched);
		
		clientdetailspage = new ClientDetailsPage(driver);
		Assert.assertTrue(clientdetailspage.getClientName().contains(NameToBeSearched));
		Reporter.log("Client Name Found", true);
	}
	
	//@Test
	public void verifyUserIsAbleToEditClientDetails() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		searchclientpage = homepage.navigateToSearchClient();
		String nameToBeSearched = "Sid";
		searchclientpage.clickEditClientDetails(nameToBeSearched);
		
		clientdetailspage = new ClientDetailsPage(driver);
		String newNumber = "123456789";
		clientdetailspage.editClientDetails(newNumber);
		Assert.assertTrue(clientdetailspage.getPNumber().contains(newNumber));
		Reporter.log("Edit Success", true);
	}
	
	@Test
	public void verifyErrorMessageIsDisplayedForInvalidClientSearch() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		searchclientpage = homepage.navigateToSearchClient();
		searchclientpage.enterSearchClientInfo("Namita","");
		
		clientdetailspage = new ClientDetailsPage(driver);
		Assert.assertTrue(clientdetailspage.getNoResultMsg().contains("No results found."));
		Reporter.log("No Result Message Found", true);
	}

	//@Test
	public void verifyUserIsAbleToDoValidClientSearch() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		searchclientpage = homepage.navigateToSearchClient();
		String name = "Rinu";
		String id = "697";
		searchclientpage.enterSearchClientInfo(name,id);
		System.out.println("Search done");
		
		clientview = new ClientView(driver);
		Assert.assertTrue(clientview.getSearchedClientName().contains(name));	
		Reporter.log("Search Success", true);
	}
	
	//@Test
	public void testingResetClientSearch() {
		userloginpage = new UserLoginPage(driver);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		String actualMessage = homepage.welcomeMsg();
		Assert.assertEquals("Welcome to Payroll Application", actualMessage);
		Reporter.log("Login Success", true);
		
		searchclientpage = homepage.navigateToSearchClient();
		searchclientpage.enterClientNameForSearch("Namita");
		searchclientpage.clickClientSearchReset();
		String searchBarText = searchclientpage.getValueFromSearch();
		String nullValue = "";
		Assert.assertEquals(searchBarText, nullValue);
		Reporter.log("Reset Search Bar Success for Client Page", true);
		
	}	
}
