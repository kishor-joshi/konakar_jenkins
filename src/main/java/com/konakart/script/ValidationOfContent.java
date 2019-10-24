package com.konakart.script;


import org.openqa.selenium.WebElement;
import com.konakart.helper.ExcelReader;
import com.konakart.helper.PageManager;
import com.konakart.utility.BaseClass;
import com.konakart.utility.Constants;
import com.konakart.utility.KonakartExtendReport;
import com.konakart.validationHelper.ValidationOfEachContentPage;
/**
 * navigation to all content and validaes the content text.
 * @author kishor.joshi
 *
 */
public class ValidationOfContent extends BaseClass {
	
	
  ValidationOfEachContentPage eachContentObj=new ValidationOfEachContentPage();
  WebElement galleryElement;
  public  String pageTitle,description,specification;
  public  int titleIndex;
  public  String[][] getProductDetail;
  
/**
 * navigate to product by clicking on product image link.
 * @throws Exception
 */
  public void naviateToSpecificProductDetailPage() throws Exception {
		property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
		
		//clicks on perticular product image link.
		helper.getElement(driver, property, "imageLink").click();
		KonakartExtendReport.reportLog("naviateToSpecificProductDetailPage", "failed");
	}
  

	/**
	 * navigate to product description page and validaates contents.
	 * @throws Exception
	 */
  public void navigateToProductDescription() throws Exception {
		property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
		pageTitle=helper.getElement(driver, property, "pagetitle").getText();
		log.info("selected product is "+pageTitle);
		
		//scroll perticular element upto top.
		PageManager.scrollAndViewAtTop(driver, helper.getElement(driver, property, "gallery"));
		
		//get Ecel data from given file path for validation
		getProductDetail=ExcelReader.getUserData(Constants.productDetailDataPath);
		
		
		//assign index comparing with page title
		if(pageTitle.equalsIgnoreCase(getProductDetail[0][0]))
			titleIndex=0;
		else
			titleIndex=1;
		
		//PageManager.scrollAndViewAtTop(driver, helper.getElement(driver, property, "gallery"));
		helper.getElement(driver, property, "productdescription").click();
		
		//get the content text from description page.
		description=helper.getElement(driver, property, "descriptioncontent").getText();
		
		//validation of content text comparing data from excel sheet.
		ValidationOfEachContentPage.validateProductDetails(description, getProductDetail[titleIndex][1]);
		
		
		log.info("Validation of Description part is passed ");
		KonakartExtendReport.reportLog("navigateToProductDescription", "failed");
	}
	
	
/**
 * 	validates specification content text comparing data from excel sheet.
 * @throws Exception
 */
  public void navigateToProductSpecification() throws Exception {
		property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);			
		helper.getElement(driver, property, "productspecification").click();
		
		//get the content text from specification page.
		description=helper.getElement(driver, property, "specificationcontent").getText();
		
		//validates specification content text comparing data from excel sheet.
		ValidationOfEachContentPage.validateProductDetails(description, getProductDetail[titleIndex][2]);
		log.info("Validation of specification is passed ");
		helper.getElement(driver, property, "reviewtab").click();
		KonakartExtendReport.reportLog("navigateToProductSpecification", "failed");
	}
}
