package com.konakart.utility;

import java.io.IOException;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.konakart.helper.ElementHelper;
import com.konakart.helper.PageManager;


public class BaseClass  {
	
public 	ElementHelper helper=new ElementHelper();
public  Logger log=Logger.getLogger(BaseClass.class);
public  WebDriver driver;
public Properties property;

/**
 * select driver class type
 * 
 * @param browserType
 * @throws IOException
 */	
	public void openBrowser(String browserType) throws IOException {
	
	switch (browserType) {
	
		case "chrome":
			
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
			System.out.println("chrome "+Thread.currentThread().getId());
			driver = new ChromeDriver(optionschrome);
			break;
			
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", Constants.fireFoxDriverPath);			
			driver = new FirefoxDriver();
			
			break;
			
		case "ie":		
			
			System.setProperty("webdriver.ie.driver", Constants.IEDriverPath);
			driver = new InternetExplorerDriver();
			System.out.println("IE "+Thread.currentThread().getId());
			break;
	
		}
		
		driver.manage().window().maximize();
		PageManager.manageTimeOuts(driver);
		property=PageManager.loadpropertyFile(Constants.configPropertiesFilePath);
		driver.get(property.getProperty("url"));		
		
	}
}
