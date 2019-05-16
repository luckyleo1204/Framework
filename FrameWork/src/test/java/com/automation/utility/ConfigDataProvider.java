package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	public ConfigDataProvider()
	{
		File f=new File("./config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(f.getAbsoluteFile());
			prop=new Properties();
			prop.load(fis);
				} catch (Exception e) {
			// TODO Auto-generated catch block
					System.out.println("Error while loading Config file"+e.getMessage());
			
		}
		
	}
	public String  getConfigData(String key)
	{
		return prop.getProperty(key);
		
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	public String getStagingURL()
	{
		return prop.getProperty("QA");
	}
	

}
