package system;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;


public class InputFile {
	public ArrayList<String> readData;
	
	public InputFile() {
		readData = new ArrayList<String>();
	}
	
	//Method to read text from file
	public void readFile(String filePath) {
		try {
		//String filePath = "../../ciphertext/cipher1.txt";
		Scanner scanFile = new Scanner(new FileReader(filePath));
		
		//int lineNum = 0;
		while(scanFile.hasNextLine()) {
			//readData[lineNum] = scanFile.nextLine();
			//System.out.println(readData[lineNum]);
			System.out.println(scanFile.nextLine());
			//lineNum++;
		}
		
		scanFile.close();
		} catch (IOException err) {
	        System.err.println("Error :"+ err);
	    }
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