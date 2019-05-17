package com.automation.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.utils.FileUtil;

public class Helper {
	
	//screenshot, alerts, window, sync, js executor, 
	
	public static String  captureScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenShotPath=System.getProperty("user.dir")+"/screenshot/FreeCRM_"+getCurrentDateTime()+".png";
		try {
		FileUtils.copyFile(src,new File(ScreenShotPath));
		System.out.println("Captured Screen shot");
		}catch(Exception e){System.out.println("unable to get screenshot"+e.getMessage());};
		return ScreenShotPath;
	}
	
	
	public static String getCurrentDateTime()
	{
		SimpleDateFormat customformat=new SimpleDateFormat("MM_dd_yyy_HH_mm_ss");
		Date date=new Date();
		return customformat.format(date);
	}
	public void handlFrames()
	{
		
	}
	
	public void handleAlert()
	{
		
	}
	
	public static void verifyTitleContains(WebDriver driver,String expectedTitle)
	{
		Assert.assertTrue(new WebDriverWait(driver, 30)
				.until(ExpectedConditions.titleContains(expectedTitle)));
	}
	
	public static void verifyUrlContains(WebDriver driver,String expectedURL)
	{
		Assert.assertTrue(new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(expectedURL)));
	}
	
	public static void verifyUrlContainsSoftAssert(WebDriver driver,String expectedURL)
	{
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(expectedURL)));
		softAssert.assertAll();
	}
	
	public static WebElement waitForWebElement(WebDriver driver, String xpath,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public static WebElement waitForWebElementUsingCSS(WebDriver driver, String css,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
	}

	public static WebElement waitForWebElement(WebDriver driver, By by,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	// This is only required when you want to highlight the webelement
	public static WebElement syncWebElement(WebDriver driver,WebElement element)
	{
	
	 WebElement ele= waitForWebElement(driver, element, 20);
		
	 WebElement ele1=highLightElement(driver, ele);
	 
	 return ele1;
	 
	}
	
	// use this always if you dont want to highlight the elements
	public static WebElement waitForWebElement(WebDriver driver, WebElement element,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static WebElement dummy(WebDriver driver, WebElement element,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement highLightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

		return element;
	}

}
