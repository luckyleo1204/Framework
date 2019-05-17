package com.automation.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestNGException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.Helper;

public class LoginCRMTest  extends BaseClass{
	LoginPage lp;
	
	@Test
	public void loginApp() 
	{
		logger =report.createTest("loginApp");
		 lp=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		
		lp.login(excel.getStringData(0, 0, 0),excel.getStringData(0, 0, 1));
		logger.fail("Test Failed");
		
	}
	
	

}