package com.krishagni.csvsum;

import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class Sum {
	public static void main(String[] args) throws IOException
	{
		try {
	        String csvFile = "/home/krishagni/Desktop/python/stock.csv";
	        @SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(new FileReader(csvFile), ',');
	        String[] col;
	        float res = 0;
	        while ((col = csvReader.readNext()) != null) {
	            try {
	            	if(!col[1].contains("products")) {
	                res = res + Float.parseFloat(col[2]);
	                System.out.println(col[1]+" "+res);}
	            } catch (NumberFormatException e) { }
	        }
	        System.out.println(res);
	    }
		catch (IOException ex) { ex.printStackTrace();}
	}	
}
