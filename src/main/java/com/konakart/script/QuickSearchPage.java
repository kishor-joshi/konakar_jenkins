package com.konakart.script;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openqa.selenium.WebElement;

import com.konakart.helper.PageManager;

import com.konakart.utility.BaseClass;
import com.konakart.utility.Constants;
import com.konakart.utility.KonakartExtendReport;
import com.konakart.validationHelper.ItemMessageValidation;
/**
 * validation of search result scenario.
 * 
 * @author kishor.joshi
 *
 */
public class QuickSearchPage extends BaseClass{
	
 public  String dropDownLocator, actualResult,expectedResult;
 public  List<WebElement>itemList;
	/**
	 * enter the data in search bar and search for perticular product.
	 * @param dropDownText
	 * @param productName
	 * @param message
	 * @throws Exception
	 */
 
public void searchProduct(String dropDownText,String productName,String searchResult) throws Exception {
	property=PageManager.loadpropertyFile(Constants.SearchPagePropertiesFilePath);
	
	//selecte dropdown text.
	PageManager.selectDropDownText(dropDownText,helper.getElement(driver, property, "dropdown"));
	helper.getElement(driver, property, "input").sendKeys(productName);
	
	this.expectedResult=searchResult;
	log.info("product Name is: "+productName+" dropDownText is: "+dropDownText);
	helper.getElement(driver, property, "searchbutton").click();
	KonakartExtendReport.reportLog("search product", "failed");
}

/**
 * validates the outcome of search.
 * @throws Exception
 */
public void getItemMessage() throws Exception {
	property=PageManager.loadpropertyFile(Constants.SearchPagePropertiesFilePath);
	
	//get the item message, store in itemlist.
	itemList= helper.getElements(driver, property, "itemMessage");
	
	//for negative scenario item message will appear.its siz()>0.
	if(itemList.size()>0) {
		//get the message from system.
		actualResult=itemList.get(0).getText();
		
		//validates error mesage.
		ItemMessageValidation.validateItemMessage(actualResult, expectedResult);
		
	}
	//for positive scenario item message will not appear.its siz()=0.product name result page.
	else
	{
		
		actualResult=helper.getElement(driver, property, "productList").getText();
		
		//validates appeared product.
		ItemMessageValidation.searchResultValidation(actualResult, expectedResult);
	}
	
}
}
