package com.konakart.validationHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.konakart.helper.ElementHelper;
import com.konakart.helper.GetElementClass;
import com.konakart.helper.PageManager;
import com.konakart.utility.Constants;
import com.konakart.utility.MonthConvertion;

/**
 * 
 * @author kishor.joshi
 *
 */

public class SortingValidationHelper {
	GetElementClass getElementObject=new GetElementClass();
	
	
Logger log=Logger.getLogger(SortingValidationHelper.class);
MonthConvertion monthObj=new MonthConvertion();
String date,differenceOfDate,getClassName,eachRatingLocator;
String[] dateArray,actualDateList;
int totalproduct,index,count;


/**
 * 
 * @param allDates
 * @return
 */
public String[] sortDate(List<WebElement>allDates) {
	String listOfDayDifference[]=new String[allDates.size()/2];
	
	
	for(int index=0;index<allDates.size()/2;index++) {
		date=allDates.get(index).getText();
		dateArray=allDates.get(index).getText().split("\\s+", 2);
		differenceOfDate=monthObj.monthDifference(dateArray[1]);
		listOfDayDifference[index]=differenceOfDate;
		log.info("date is "+date+" difference in date is "+differenceOfDate);
	}
	
	log.info(Arrays.toString(listOfDayDifference)+" list of day difference compared with current day");
    return listOfDayDifference;
}


/**
 * 
 * @param driver
 * @param property
 * @param totalProductNumber
 * @return
 * @throws IOException
 */

public int[] getAllRating(WebDriver driver,Properties property,int totalProductNumber) throws IOException {
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	
	totalproduct=(totalProductNumber*5)/2;
	int listOfRating[]=new int[totalProductNumber/2];
	index=0;
	count=0;
	
	for(int indexOfRating=0;indexOfRating<totalproduct;indexOfRating++) {
			eachRatingLocator=property.getProperty("productRatingList")+"["+(indexOfRating+1)+"]";
			getClassName=driver.findElement(By.xpath(eachRatingLocator)).getAttribute("class");
			
			if(getClassName.contains("full"))
				count++;
			if(indexOfRating%5==4) {
				listOfRating[index++]=count;
				count=0;
			}
			
	}
	log.info(Arrays.toString(listOfRating)+" list of Rating");
	
	return listOfRating;
}

/**
 * returns all the rating as int array.
 * @param driver
 * @param property
 * @param totalProductNumber
 * @return
 * @throws Exception
 */
public int[] getRating(WebDriver driver,Properties property,int totalProductNumber) throws Exception {
	
	int listOfRating[]=new int[totalProductNumber/2];
	List<WebElement>ratingList;
	for(int indexRating=1;indexRating<=totalProductNumber/2;indexRating++) {
		String ratingLocator=property.getProperty("ratinglist").replace("###", indexRating+"");
		
		ratingList=getElementObject.getElements(driver,ratingLocator);
		
		listOfRating[indexRating-1]=ratingList.size()/2;
	}
	log.info(Arrays.toString(listOfRating)+" list of Rating");
	return listOfRating;
}

public  boolean isSortedDescending(final int[] data) {
    for(int Arrindex = 1; Arrindex < data.length; Arrindex++) {
        if(data[Arrindex-1] < data[Arrindex]) {
            return false;
        }
    }
    return true;
}
public  boolean isSortedAscending(final int[] data) {
    for(int Arrindex = 1; Arrindex < data.length; Arrindex++) {
        if(data[Arrindex-1] > data[Arrindex]) {
            return false;
        }
    }
    return true;
}
}


