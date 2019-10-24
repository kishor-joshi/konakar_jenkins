package com.konakart.utility;
/**
 * this class having utility constants like file path,waitng time.
 * 
 * @author kishor.joshi
 *
 */
public class Constants {
public static final String chromeDriverPath="./libs/chromedriver.exe";
public static final String fireFoxDriverPath="./libs/geckodriver.exe";
public static final String IEDriverPath="./libs/IEDriverServer.exe";
public static final int    waitingTime=10;
public static final int    loadingTime=14;
public static final int    implicitTime=14;
public static final long    sleepingTime=4000;
public static final String gridNodeURL="http://55.55.52.108:2000/wd/hub";
public static final String extendReportPath="./extendReport/konakartExtendReport.html";
public static final String configPropertiesFilePath="./src/test/resources/locators/config.properties";
public static final String SearchPagePropertiesFilePath="./src/test/resources/locators/homelocators.properties";
public static final String userProductDataPath="./src/test/resources/testdata/productData.xlsx";
public static final String productPropertiesFilePath="./src/test/resources/locators/product.properties";
public static final String contentDataPath="./src/test/resources/testdata/productContent.xlsx";
public static final String productDetailDataPath="./src/test/resources/testdata/Details.xlsx";
public static final String productNameDataPath="./src/test/resources/testdata/productName.xlsx";

}
