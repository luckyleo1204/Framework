package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class LoginPage {
	
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id="txtUsername") 
	WebElement uname;
	
	@FindBy(id= "email")
	WebElement email;
	
	@FindBy(id ="pass")
	WebElement pass;
	
	@FindBy(xpath="//input[@id='u_0_8']")
	WebElement LoginButton;
	
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	

	public void login(String uname, String pwd)
	{
		email.sendKeys(uname);
		pass.sendKeys(pwd);
		pass.click();
		System.out.println(driver.getTitle());

		
	}
	
	

}
