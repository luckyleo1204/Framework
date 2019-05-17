package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
	
	public static WebDriver startApp(WebDriver driver,String browser,String url)
	{
		
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions option=new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver(option);
			
			
		}else if(browser.equalsIgnoreCase("FireFox"))
		{
			
		}else if(browser.equalsIgnoreCase("IE"))
		{
			
		}else
		{
			System.out.println("Browser is not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
		
		
	}
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
