package com.konakart.testscenarios;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.konakart.script.QuickSearchPage;
import com.konakart.utility.DataProviderClass;

/**
 * this class is for validation of search result.
 * 
 * @author kishor.joshi
 *
 */

public class SearchProductScenario {

	
	QuickSearchPage page=new QuickSearchPage();
	
	/**
	 * launching of specific browser taking browser type as parameter.
	 * 		
	 * @param browserType
	 * @throws IOException
	 */
			
	@Parameters({"browserType"})
	@BeforeClass
	public void setBrowser(String browserType) throws IOException {
		page.openBrowser(browserType);
	}
	
		
	/**
	 * enters product in  search bar.taking dropdownText and product name from Excel 
	 * by using data provider concept.
	 * 
	 * @param dropDownText
	 * @param productName
	 * @param message
	 * @throws Exception
	 */
	@Test(dataProvider = "userData",dataProviderClass =DataProviderClass.class )
	public void OutComeOfSearch(String dropDownText,String productName,String message) throws Exception {
   page.searchProduct(dropDownText, productName,message);
			
	}
/**
 * 	validation of out of search.
 * 
 * @throws Exception
 */
	@AfterMethod()
	public void message() throws Exception {
		page.getItemMessage();
			
		}
}
