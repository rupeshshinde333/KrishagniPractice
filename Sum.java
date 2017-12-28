package com.krishagni.csvsum;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import com.csvreader.CsvWriter;
import au.com.bytecode.opencsv.CSVReader;

public class Sum {
	
	public static void main(String[] args) throws IOException
	{
		 Map<String , Integer> m = new LinkedHashMap<String , Integer>();
		try {
	        String csvFile = "/home/krishagni/Desktop/python/stock_input.csv";
	        @SuppressWarnings("resource")
	        CSVReader csvReader = new CSVReader(new FileReader(csvFile), ',');
	        String[] col;
	    
	        
	        while ((col = csvReader.readNext()) != null) {
	            try {
	            	String product = col[1];
	            	String delta = col[2];
	            	int result = Integer.parseInt(delta);
	              
	            	if(m.containsKey(product))
	            	{
	            		m.put(product, m.get(product) + result);
	            	}
	            	else
	            	{
	            		m.put(product, result);
	            	} 
	            	
	            } catch (NumberFormatException e) { }
	        }
	    }
		catch (IOException ex) { ex.printStackTrace();}

		System.out.println(m);
		try {
		String csv = "/home/krishagni/Desktop/python/test.csv";
		CsvWriter csvOutput = new CsvWriter(new FileWriter(csv, false), ',');
		for (Map.Entry<String, Integer> entry : m.entrySet()) {
			
			csvOutput.write(entry.getKey());
			csvOutput.write(entry.getValue().toString());
			csvOutput.endRecord();
			
		  }csvOutput.close();}
		
		catch(Exception e) {}		
	}	
}
