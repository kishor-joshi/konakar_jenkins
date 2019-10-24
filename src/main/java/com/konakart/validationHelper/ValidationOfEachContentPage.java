package com.konakart.validationHelper;

import java.io.IOException;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.ExcelReader;
import com.konakart.utility.Constants;


public class ValidationOfEachContentPage {
	static Logger log=Logger.getLogger(ValidationOfEachContentPage.class);
	static String currentContent,expetedContent;
	int titleIndex;
	
	String[][] getContent,getProductDetails;
	/**
	 * 
	 * @param contentList
	 * @param pageTitle
	 * @throws IOException
	 */
	
public void ValidateContent(List<WebElement>contentList,String pageTitle) throws IOException {
	
	getContent=ExcelReader.getUserData(Constants.contentDataPath);
	getProductDetails=ExcelReader.getUserData(Constants.productDetailDataPath);
	if(pageTitle.equalsIgnoreCase(getProductDetails[0][0]))
		titleIndex=0;
	else 
		titleIndex=1;
		
	for(int index=0;index<contentList.size();index++) {
		contentList.get(index).click();
		currentContent=contentList.get(index).getText();
		expetedContent=getContent[index][0];
		validateContent(currentContent, expetedContent);
		
	}
}
/**
 * 
 * @param actualContent
 * @param expectedContent
 */
public static void validateContent(String actualContent,String expectedContent) {
	if(actualContent.contains(expetedContent))
		 log.info("passed: selected content is "+currentContent +" & current content is "+currentContent);
	 else
		 Assert.assertEquals(false,"content are different ");
	}

public static void validateProductDetails(String  actualDescription,String  expectedDescription) {
	if(!actualDescription.contains(expectedDescription))
		Assert.assertEquals(false,"content are different ");	
		
   }
}

