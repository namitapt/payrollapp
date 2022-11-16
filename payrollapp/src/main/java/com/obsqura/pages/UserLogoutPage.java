package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogoutPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/a")
	WebElement userProfile;
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/ul/div/li[2]/a")
	WebElement logoutButton;
	
	public UserLogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loggingOut() {
		this.userProfile.click();
		this.logoutButton.click();
	}

}
