package system;
import decryption.Substitution;
import decryption.Shift;

import java.util.LinkedHashMap;

public class Driver {
	
	public static void main(String[] args) {
		InputFile fileToOpen = new InputFile();
		LinkedHashMap<String, String> key;
		
		fileToOpen.readFile("./ciphertext/cipher2.txt");
		
		Substitution subMethod = new Substitution();
		key = subMethod.basicSubstitution(fileToOpen.cipher.freqMap, fileToOpen.cipher.normalFreq);
		
		Shift attemptShift = new Shift();
		attemptShift.shiftCipher(fileToOpen.cipher.freqMap, fileToOpen.readData);
		
		
		OutputFile plaintext = new OutputFile();
		//plaintext.convertToPlaintext("nothing", fileToOpen.readData, key);
		
	}
}
