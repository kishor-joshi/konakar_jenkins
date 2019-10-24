package com.konakart.script;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.PageManager;
import com.konakart.utility.Constants;
import com.konakart.utility.KonakartExtendReport;

/**
 * validation of sorting by rating
 * @author kishor.joshi
 *
 */

public class SortingByRating extends CustomerReviewSorting{
	
	List<WebElement>allRatings;
	int[] actualRatingList,expectedRatingList,actualRating;
	
/**
 * 	validation of sorting of rating by high to low
 * @throws Exception
 */
public void validateRatingHighToLow() throws Exception {
	
	//wait for pageloading and implict wait.
	PageManager.manageTimeOuts(driver);
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	dropDownText=property.getProperty("highToLow");
	
	//selects dropdowntext
	PageManager.selectDropDownText(dropDownText,helper.getElement(driver, property, "sortingDropDown"));
	Thread.sleep(Constants.sleepingTime);
	
	allRatings= helper.getElements(driver, property, "date");
	
	//get all rating in the from of int array.
	actualRatingList=validation.getRating(driver, property,allRatings.size());	
	
	//varifies the rating array in descending order.returns boolean value.
	isSortedDesceding=validation.isSortedDescending(actualRatingList);	
	Assert.assertTrue(isSortedDesceding, "sorting by high to low failed");
	log.info(" High to Low Rating, sorting order passed ");
	KonakartExtendReport.reportLog("validateRatingHighToLow", "failed");
	
}
/**
 * validation of sorting of rating by low to high
 * @throws Exception
 */

public void validateRatingLowToHigh() throws Exception {
	
	//wait for pageloading and implict wait.
	PageManager.manageTimeOuts(driver);
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	dropDownText=property.getProperty("lowToHigh");
	
	//selects dropdowntext
	PageManager.selectDropDownText(dropDownText,helper.getElement(driver, property, "sortingDropDown"));
	Thread.sleep(Constants.sleepingTime);

	allRatings= helper.getElements(driver, property, "date");
	
	//get all rating in the from of int array.
	actualRating=validation.getRating(driver, property,allRatings.size());	
	
	//varifies the rating array in ascending order.returns boolean value.
	isSortedAscending=validation.isSortedAscending(actualRating);
	Assert.assertTrue(isSortedAscending, "sorting by low to high failed");
	log.info(" Low to High Rating, sorting order passed ");
	KonakartExtendReport.reportLog("validateRatingLowToHigh", "failed");
	
}
}
