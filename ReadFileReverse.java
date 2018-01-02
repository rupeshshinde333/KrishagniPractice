package com.krishagni.assignmnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

class ReadFileReverse {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException,FileNotFoundException  {      
		
    	 BufferedReader in = new BufferedReader (new InputStreamReader (new ReverseLineInputStream("/home/krishagni/Desktop/java_assignmnet_test_1GB.ods")));
    	 PrintWriter pwriter =new PrintWriter("/home/krishagni/Desktop/JAVA_output.txt");
    	 
    	 final  long startTime = System.currentTimeMillis();	
		 long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		 
    	 while(true) {
    	    String line = in.readLine();
    	    
    	    if (line == null) {
    	        break;
    	    }
    	    
    	    StringBuffer buffer = new StringBuffer(line);
    	   	buffer=buffer.reverse();
    	    String rs=buffer.toString();
    	    pwriter.println(rs); 
    	    
    	}
    	 
    	pwriter.close();
    	
    	final  long endTime = System.currentTimeMillis();
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();  
		long actualMemUsed=afterUsedMem-beforeUsedMem;
		long sizeInMb = actualMemUsed / (1024 * 1024);
		long millis = endTime - startTime ;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

		System.out.println();
		System.out.println("Total execution time: " + seconds + " sec");
		System.out.println("Memory used "+ sizeInMb + " MB");
 
    }
}

class ReverseLineInputStream extends InputStream {

	RandomAccessFile in;

	long currentLineStart = -1;
	long currentLineEnd = -1;
	long currentPos = -1;
	long lastPosInFile = -1;

	public ReverseLineInputStream( String fileName ) throws FileNotFoundException {
		this(new File(fileName));
	}

	public ReverseLineInputStream(File file) throws FileNotFoundException {
		in = new RandomAccessFile(file, "r");
		currentLineStart = file.length();
		currentLineEnd = file.length();
		lastPosInFile = file.length() -1;
		currentPos = currentLineEnd;
	}

	public void findPrevLine() throws IOException {

		currentLineEnd = currentLineStart;

		if (currentLineEnd == 0) {
			currentLineEnd = -1;
			currentLineStart = -1;
			currentPos = -1;
			return;
		}

		long filePointer = currentLineStart -1;

		while ( true) {
			filePointer--;

			
			if (filePointer < 0) {
				break;
			}

			in.seek(filePointer);
			int readByte = in.readByte();

			if (readByte == 0xA && filePointer != lastPosInFile ) {
				break;
			}
		}
		
		currentLineStart = filePointer + 1;
		currentPos = currentLineStart;
	}

	public int read() throws IOException {

		if (currentPos < currentLineEnd ) {
			in.seek(currentPos++);
			int readByte = in.readByte();
			return readByte;

		}
		else if (currentPos < 0) {
			return -1;
		}
		else {
			findPrevLine();
			return read();
		}
	}
}
