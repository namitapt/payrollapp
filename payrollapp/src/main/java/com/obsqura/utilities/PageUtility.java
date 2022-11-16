package com.obsqura.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	
	public WebElement xpathForView(String clientNameView)
	{
	    return driver.findElement(By.xpath("//*[text()='"+clientNameView+"']/..//a[1]"));
	}
	
	public String AlertHandleing(WebDriver driver) {
		String alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertMsg;
	}
	
	public void selectingByVisibleText(By element, String visibleText, WebDriver driver) {
		WebElement selecting = driver.findElement(element);
		Select s = new Select(selecting);
		s.selectByVisibleText(visibleText);
	}

}
