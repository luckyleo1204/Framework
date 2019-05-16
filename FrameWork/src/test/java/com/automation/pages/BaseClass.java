package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void suiteSetup()
	{
		Reporter.log("Setting up the Report Configuration and Test Started",true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter  extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+Helper.getCurrentDateTime()+"_FreeCrm.hml"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting setup is done", true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser and application ready",true);
		driver=BrowserFactory.startApp(driver, config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser and application setup is done",true);

	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		Reporter.log("Please flusing up some resources",true);
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.fail("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		Reporter.log("All done, Validate your reports , See you again", true);
		
	}

}
