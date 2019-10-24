package com.konakart.helper;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.konakart.utility.Constants;
/**
 * class contains helper methods.
 * 
 * @author kishor.joshi
 *
 */

public class PageManager {

	public static ElementHelper helper=new ElementHelper();

	/**
	 * manage page loading and implicit wait .
	 * @param driver
	 */
	public static void manageTimeOuts(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Constants.loadingTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.implicitTime, TimeUnit.SECONDS);
	}
	
	
	/**
	 * loads the property file located at specified path.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static Properties loadpropertyFile(String filePath) throws IOException {
		Properties property=new Properties();
		FileInputStream input = new FileInputStream(filePath);
		property.load(input);
		return property;
	}
	
	/**
	 * scroll the element upto bottom of the page.
	 * @param driver
	 * @param element
	 */
	public static void scrollAndView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		
	}
	
	/**
	 * select the dropdown text.
	 * 
	 * @param driver
	 * @param dropDownLocator
	 * @param dropDownText
	 * @param property
	 * @throws Exception
	 */
	public static  void selectDropDownText(WebDriver driver,String dropDownLocator, String dropDownText,Properties property) throws Exception {
		
		Select dropdown=new Select(helper.getElement(driver, property, dropDownLocator));
		
		dropdown.selectByVisibleText(dropDownText);
	}
	
	public static  void selectDropDownText(String dropDownText,WebElement dropdownElement) throws Exception {
		
		Select dropdown=new Select(dropdownElement);
		dropdown.selectByVisibleText(dropDownText);
	}
	public static void selectAndClickOnText(String dropDownText,WebElement dropdownElement,WebDriver driver) {
		Actions action =new Actions(driver);
		action.moveToElement(dropdownElement).build().perform();
		dropdownElement.click();
		Select dropdown=new Select(dropdownElement);
		dropdown.selectByVisibleText(dropDownText);
	}
	/**scroll the perticular element upto top of the page.
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollAndViewAtTop(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * mouse cursor move upto sepcifed element.
	 * 
	 * @param driver
	 * @param element
	 */
	public static void movieToPerticularElement(WebDriver driver,WebElement element) {
		Actions action =new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	
	
}
