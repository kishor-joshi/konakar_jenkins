package com.konakart.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.konakart.helper.ExcelReader;
/**
 * 
 * @author kishor.joshi
 *
 */

public class DataProviderClass {
	
	@DataProvider(name="userData")
	public  String[][] getdata() throws IOException {

	   return ExcelReader.getUserData(Constants.productNameDataPath);
	}
}
