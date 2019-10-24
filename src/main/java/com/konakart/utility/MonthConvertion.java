package com.konakart.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
/**
 * 
 * @author kishor.joshi
 *
 */
public class MonthConvertion {
	//Logger log=Logger.getLogger(MonthConvertion.class);
	
	public String monthDifference(String blogerDate) {
		
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		    Date date = new Date();  
		    String dayDifference="";
		    try {
		        //Dates to compare
		        String currentDate=  formatter.format(date); 
		        String blogDate= monthINFormate(blogerDate);
		        
		      //  log.info("Current date  "+currentDate+" blog date "+blogDate);

		        Date date1;
		        Date date2;

		        SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

		        //Setting dates
		        date1 = dates.parse(currentDate);
		        date2 = dates.parse(blogDate);

		        //Comparing dates
		        long difference = Math.abs(date1.getTime() - date2.getTime());
		        long differenceDates = difference / (24 * 60 * 60 * 1000);
		      

		        //Convert long to String
		         dayDifference = Long.toString(differenceDates);
		     // log.info("difference in date is "+dayDifference+" days");

		        
		    }
		    catch (Exception exception) {
		    //	log.info("this method not worked out"+ exception);
		    }
		    return dayDifference;
		
	}
	
	
	public String monthINFormate(String date) {
		String dateArr[]=date.replace(",", "").split("\\s+");
		int j=0;
		String MM="";
		String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i=0;i<monthArr.length;i++) {
			if(dateArr[1].equalsIgnoreCase(monthArr[i])) {
				j=i+1;
			break;
			}
		}
		if(j<10)
			MM="0"+j;
		else 
			MM=MM+j;
		
		String blogDate=MM+"/"+dateArr[0]+"/"+dateArr[2];
		return blogDate;
	}
	
}
