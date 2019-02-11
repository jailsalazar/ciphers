package system;
import decryption.FrequencyAnalysis;

import java.util.LinkedHashMap;

public class Driver {
	
	public static void main(String[] args) {
		InputFile fileToOpen = new InputFile();
		FrequencyAnalysis decryptCipher = new FrequencyAnalysis();
		//LinkedHashMap<String, String> key;
		
		fileToOpen.readFile("./ciphertext/cipher2.txt");
		
		decryptCipher.analyzeCipher(fileToOpen.readData);
		
		
		
		//Substitution subMethod = new Substitution();
		//key = subMethod.basicSubstitution(fileToOpen.cipher.freqMap, fileToOpen.cipher.normalFreq);
		
		//Shift attemptShift = new Shift();
		//attemptShift.shiftCipher(fileToOpen.cipher.freqMap, fileToOpen.readData);
		
		
		OutputFile plaintext = new OutputFile();
		//plaintext.convertToPlaintext("nothing", fileToOpen.readData, key);
		
	}
}
