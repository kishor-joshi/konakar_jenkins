package com.konakart.testscenarios;

import java.io.IOException;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.konakart.script.SortingByRating;
/**
 * validation of specific product details and sorting.
 * 
 * @author kishor.joshi
 *
 */
public class SpecificProductValidationScenario {
	
SortingByRating validationObject=new SortingByRating();
/**
 *launching of specific Browser.type of browser is taking as parameter 
 * 
 * @param browserType
 * @throws IOException
 */
@Parameters({"browserType"})
@BeforeClass
public void setBrowser(String browserType) throws IOException {
	validationObject.openBrowser(browserType);
}

/**
 * validation of specific product details and sorting order.
 * 	
 * @throws Exception
 */
	
@Test
public void navigateToProductDetails() throws Exception {
	validationObject.naviateToSpecificProductDetailPage();
	validationObject.navigateToProductDescription();
	validationObject.navigateToProductSpecification();
	validationObject.validateSortingByMostRecent();
	validationObject.validateSortingByOldest();
	validationObject.validateRatingHighToLow();
	validationObject.validateRatingLowToHigh();
	
}

}
