package system;
import decryption.Substitution;

import java.util.LinkedHashMap;

public class Driver {
	
	public static void main(String[] args) {
		InputFile fileToOpen = new InputFile();
		LinkedHashMap<String, String> key;
		
		fileToOpen.readFile("./ciphertext/cipher1.txt");
		
		Substitution subMethod = new Substitution();
		key = subMethod.basicSubstitution(fileToOpen.cipher.freqMap, fileToOpen.cipher.normalFreq);
		
		OutputFile plaintext = new OutputFile();
		plaintext.convertToPlaintext("nothing", fileToOpen.readData, key);
		
	}
}
