package com.obsqura.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListener implements ITestListener{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter spark;

	public void onTestStart(ITestResult Result) {
		extent.createTest("MyFirstTest").log(Status.PASS, "This is a logging event for "+Result.getName()+", and it passed!");

	}
	public void onFinish(ITestContext Result) {
		extent.flush();
		System.out.println(Result.getName()+" is finished");
	}
	
	public void onStart(ITestContext Result) {
        try {
            spark = new ExtentSparkReporter(System.getProperty("user.dir") +"/DemoReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.createTest("MyFirstTest").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println(Result.getName()+" is started");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
		System.out.println(Result.getName());
	}
	
	public void onTestFailure(ITestResult Result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(Result.getName(), ExtentColor.RED));
		System.out.println("The name of the testcase failed is: "+Result.getName());
	}

	public void onTestSkipped(ITestResult Result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(Result.getName(), ExtentColor.ORANGE));
		System.out.println("The name of the testcase Skipped is: "+Result.getName());		
	}

	public void onTestSuccess(ITestResult Result) {
		test = extent.createTest("from reports"+Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(Result.getName(), ExtentColor.GREEN));
		System.out.println("The name of the testcase passed is: "+Result.getName());
	}

}
