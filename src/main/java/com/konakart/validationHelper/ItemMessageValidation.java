package com.konakart.validationHelper;



import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.utility.BaseClass;

/**
 * 
 * @author kishor.joshi
 *
 */

public class ItemMessageValidation extends BaseClass{
	public static Logger log=Logger.getLogger(ItemMessageValidation.class);
	public static String itemName;

	
	/**
	 * 
	 * @param actualMessage
	 * @param expectedMessage
	 */
	
public static void validateItemMessage(String actualMessage,String expectedMessage) {
	if(actualMessage.equalsIgnoreCase(expectedMessage)) {
	log.info("displayed error message is correct and message is: "+actualMessage);
	
	}	
	else
		Assert.assertEquals(false, "displayed message is wrong");
}
public static void searchResultValidation(String actualResult,String expectedResult) {
	Assert.assertEquals(actualResult, expectedResult,"reuslt not matched");
	log.info("search result passed:displayed product nameis : "+actualResult);
}

/**
 * 
 * @param itemList
 */
public static void getItems(List<WebElement>itemList) {
	for(int i=0;i<itemList.size();i++) {
		itemName=itemList.get(i).getText();
		log.info("item name is "+itemName);
	}
}
}
