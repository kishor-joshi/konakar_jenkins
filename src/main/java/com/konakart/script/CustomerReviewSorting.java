package com.konakart.script;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.PageManager;
import com.konakart.utility.Constants;
import com.konakart.utility.KonakartExtendReport;
import com.konakart.validationHelper.SortingValidationHelper;

/**
 * validation of soring by date.
 * 
 * @author kishor.joshi
 *
 */

public class CustomerReviewSorting extends ValidationOfContent {
	SortingValidationHelper validation=new SortingValidationHelper();
	String sortingDropDownXpath,dropDownText;
 List<WebElement>dateList;
	
	public  String[] actualDateSorting,expectedDateSorting;
	boolean isSortedAscending,isSortedDesceding;
	int[] dateArray;
/**
 * validation of sorting by most recent.
 * 	
 * @throws Exception
 */
	
public void validateSortingByMostRecent() throws Exception {
	
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);	
	dropDownText=property.getProperty("mostrecent");	
	dateList= helper.getElements(driver, property, "date");
	
	//get the date in the string Array.
	actualDateSorting=validation.sortDate(dateList);
	
	//converts converts String array into int Array.
	dateArray = Arrays.stream(actualDateSorting).mapToInt(Integer::parseInt).toArray();
	
	//validates int array is in desceding order.returns boolean value.
	isSortedAscending=validation.isSortedAscending(dateArray);		
	Assert.assertTrue(isSortedAscending, "failed: sorted my most Recent");
	log.info("Most recent sorting order passed ");
	KonakartExtendReport.reportLog("validateSortingByMostRecent", "failed");
}

/**
 *
 * validation of sorting by oldest.
 * @throws Exception
 */

public void validateSortingByOldest() throws Exception {
	
	//manages the loading time implicit wait.
	PageManager.manageTimeOuts(driver);
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	dropDownText=property.getProperty("oldest");
	
	//selects dropdown text
	PageManager.selectDropDownText(dropDownText, helper.getElement(driver, property, "sortingDropDown"));
	Thread.sleep(Constants.sleepingTime);
	dateList= helper.getElements(driver, property, "date");
	
	//get the date in the string Array.
	actualDateSorting=validation.sortDate(dateList);
	
	//converts converts String array into int Array.
	dateArray = Arrays.stream(actualDateSorting).mapToInt(Integer::parseInt).toArray();	
	
	//validates int array is in desceding order.returns boolean value.
	isSortedDesceding=validation.isSortedDescending(dateArray);
	Assert.assertTrue(isSortedDesceding, "failed:sorted by oldest");
	log.info("Oldest is first sorting order passed ");
	KonakartExtendReport.reportLog("validateSortingByOldest", "failed");
}

}
