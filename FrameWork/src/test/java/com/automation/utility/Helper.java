package com.automation.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

}
