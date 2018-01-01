package com.krishagni.assignmnet;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ReverseContent {
	
	public static void main(String[] args) throws IOException {
		try{
			final  long startTime = System.currentTimeMillis();	
			long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			
			File sourceFile=new File("/home/krishagni/Desktop/java_assignmnet_test_10GB.ods");
			Scanner content=new Scanner(sourceFile);
			PrintWriter pwriter =new PrintWriter("/home/krishagni/Desktop/JAVA_output.txt");			
  
			while(content.hasNextLine())
			{
				String s=content.nextLine();
				StringBuffer buffer = new StringBuffer(s);
				buffer=buffer.reverse();
				String rs=buffer.toString();
				pwriter.println(rs);
			}
			content.close();    
			pwriter.close();
			
			System.out.println("File is copied successful!");
  
			final  long endTime = System.currentTimeMillis();
			long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();  
			long actualMemUsed=afterUsedMem-beforeUsedMem;
			long sizeInMb = actualMemUsed / (1024 * 1024);
			long millis = endTime - startTime ;
			long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
  
			System.out.println();
			System.out.println("Total execution time: " + seconds + " sec");
			System.out.println("Memory used "+ (sizeInMb) + " MB");
			}  
		catch(Exception e){ e.printStackTrace();}
	}
 }
