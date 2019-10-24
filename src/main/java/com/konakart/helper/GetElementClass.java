package com.konakart.helper;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElementClass {
	
/**
 * this method returns list of elements with spe	
 * @param driver
 * @param locators
 * @return
 * @throws Exception
 */
	
public  List<WebElement> getElements(WebDriver driver,String locators) throws Exception{
		
		String[] locatorArray=locators.split("%", 2);
		String objectType=locatorArray[0].toUpperCase();
		String locator=locatorArray[1];
	   
		switch(objectType) {
		 //Find by xpath
		case "XPATH" :        
	        return driver.findElements(By.xpath(locator));
	      
	    
	    //Find by css
		case "CSS":          
	        return driver.findElements(By.cssSelector(locator));
	        
	       //find by class
		case "CLASSNAME" :
	        return driver.findElements(By.className(locator));
	       
	    
	    //find by name
		case "NAME" :
	        return driver.findElements(By.name(locator));
	       
	  
	   
	    //find by link
		case "LINK": 
	        return driver.findElements(By.linkText(locator));
	      
	   
	    //find by partial link
		case "PARTIALLINK" :
	        return driver.findElements(By.partialLinkText(locator));
	     
	   default:
		   return driver.findElements(By.xpath(locator));
	       
	 
		}
	}
	public static  List<String> convertToString(List<WebElement> listOfElement) throws Exception{
		List<String>listOfString=new LinkedList<String>();
		for(int i=0;i<listOfElement.size();i++) 
			listOfString.add(i, listOfElement.get(i).getText());
			return listOfString;
	}
	public  boolean isErrorMessageShowing(WebElement element,String browserType) {
		String errorMessage=element.getAttribute("validationMessage");
		if(browserType.equalsIgnoreCase("ie")) {
			if(errorMessage.equalsIgnoreCase("This is the required filled."))
				return true;
			else
				return false;
		}
		else {
			if(errorMessage.equalsIgnoreCase("Please fill out this field."))
				return true;
			else
				return false;
		}
			
	}
}
