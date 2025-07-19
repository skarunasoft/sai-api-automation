package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
	
	
	public static String getCurrentDate()
	{
		String date = null;
		try {
			
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY_HH-mm-ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   date = dtf.format(now);  		   
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return date;
	}
	
	

}
