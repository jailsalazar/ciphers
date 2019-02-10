package system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays; 


public class InputFile {
	public String readData;
	
	public InputFile() {
		readData = "";
	}
	
	//Method to read text from file
	public void readFile(String filePath) {
		try {
		Scanner scanFile = new Scanner(new FileReader(filePath));
		String data = "";

		while(scanFile.hasNextLine()) {
			data = scanFile.nextLine();
			readData = readData + data;
		}
		//System.out.println(readData);
		
		scanFile.close();
		} catch (IOException err) {
	        System.err.println("Error :"+ err);
	    }
		characterFrequency(readData);
	}
	
	public void characterFrequency(String data) {
		HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
		
		for(int i = 0; i < data.length(); i++) {
			char tempChar = data.charAt(i);
			Integer value = freqMap.get(tempChar);
			
			if(value != null) {
				freqMap.put(tempChar, new Integer(value + 1));
			}
			else {
				freqMap.put(tempChar, 1);
			}
		}
		
		System.out.println(Arrays.asList(freqMap)); 
	}

}

//reading files
//read in to string line by line
//convert letters in to hex 
//parse string and turn it in to an array for each letter counting the number of occurances.
//lowercase all letters
//Character.valueOf() gives number vaule of letter
//once have number of occurences of each letter. create frequency analysis
//freq[letterValue - 96] = freq.length((freq[letterValue - 96] + 1)/freq.length)
//match the frequency with the known frequencies. 
//use max() to find the max vaule of freq analysis and add that letter to string to create a key.
//once have key use subsitutions