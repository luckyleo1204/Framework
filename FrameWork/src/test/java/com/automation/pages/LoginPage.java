package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(how=How.ID, using= "email")
	WebElement email;
	
	@FindBy(how=How.ID,using ="password")
	WebElement pass;
	
	@FindBy(how=How.XPATH,using="//input[@id='u_0_8']")
	WebElement LoginButton;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void login(String username, String password)
	{
		email.sendKeys(username);
		pass.sendKeys(password);
		LoginButton.click();
		System.out.println(driver.getTitle());
	}
	
	

}
