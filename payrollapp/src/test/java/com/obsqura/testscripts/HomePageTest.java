package com.obsqura.testscripts;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.UserLoginPage;
import com.obsqura.pages.UserLogoutPage;
import com.obsqura.utilities.ExcelDataProvider;

public class HomePageTest extends TestHelper{
	UserLoginPage userloginpage;
	HomePage homepage;
	UserLogoutPage userlogoutpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	
	@DataProvider(name="Logindata")
		public Object[][]getData(){
			String excelpath = "C:\\Users\\LENOVO\\Desktop\\Obsqura\\Maven\\usernameAndPassword.xlsx";
			ExcelDataProvider exceldataprovider = new ExcelDataProvider();
			Object data[][] = exceldataprovider.testData(excelpath, "Sheet2");
			return data;
	}	
	
	//@Test(priority=0, dataProvider="Logindata")
	public void testingLogin(String username, String password){
		userloginpage = new UserLoginPage(driver);
		homepage = userloginpage.login(username, password);
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
	}
	
	
	@Test
	public void verifyUserIsAbleToLogout(){
		userloginpage = new UserLoginPage(driver);
		String titleLogin = userloginpage.pageTitle();
		Assert.assertEquals("Login", titleLogin);
		
		homepage = userloginpage.login("carol", "1q2w3e4r");
		Assert.assertTrue(homepage.welcomeMsg().contains("Welcome to Payroll Application"));
		Reporter.log("Login Successful", true);
		
		userlogoutpage = new UserLogoutPage(driver);
		userlogoutpage.loggingOut(); 
		Assert.assertEquals("Login", titleLogin);
		Reporter.log("LogOut Success", true);
	}

}
