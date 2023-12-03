package com.po_solution.apipatient.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

public class PatientUtil {
	
	private static PatientUtil util;
	
	private PatientUtil()
	{
		
	}
	
	public static PatientUtil getInstance()
	{
		if(util == null)
		{
			util = new PatientUtil();
			
			return util;
		}
		else {
			return util;
		}
	}
	
	
	public Date convertToDate(String dateString)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 try {
	            // Parse the string to obtain a java.util.Date object
	            java.util.Date utilDate = dateFormat.parse(dateString);

	            // Convert the java.util.Date to java.sql.Date
	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	            // Print the result
	            System.out.println("Original String: " + dateString);
	            System.out.println("Converted java.sql.Date: " + sqlDate);
	            
	            return sqlDate;

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 
		 return new Date(0);
	}
	
	

}
