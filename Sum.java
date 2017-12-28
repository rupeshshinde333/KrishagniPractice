package com.krishagni.csvsum;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import au.com.bytecode.opencsv.CSVReader;

public class Sum {
	
	public static void main(String[] args) throws IOException
	{
	        Map<String , Integer> m = new LinkedHashMap<String , Integer>();
		try {
	        String csvFile = "/home/krishagni/Desktop/python/stock.csv";
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
		
		String eol = System.getProperty("line.separator");

		try (Writer writer = new FileWriter("/home/krishagni/Desktop/python/test.csv")) {
		  for (Map.Entry<String, Integer> entry : m.entrySet()) {
		    writer.append(entry.getKey())
		          .append(',')
		          .append(entry.getValue().toString());
		          //.append(eol);
		  }
		} catch (IOException ex) {
		  ex.printStackTrace(System.err);
		}
		
	}	
}
