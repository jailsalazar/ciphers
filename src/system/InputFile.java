package system;

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

import decryption.FrequencyAnalysis;

public class InputFile {
	public String readData;
	FrequencyAnalysis cipher;
	public int cipherLength;
	
	public InputFile() {
		readData = "";
		cipher = new FrequencyAnalysis();
		cipherLength = 0;
	}
	
	public void setCipherLength() {
		cipherLength = readData.length();
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
		setCipherLength();
		cipher.characterFrequency(readData);
	}

}