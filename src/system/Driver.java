package system;
import decryption.Substitution;

public class Driver {
	String filePath = "../../ciphertext/cipher1.txt";
	
	public static void main(String[] args) {
		InputFile fileToOpen = new InputFile();
		
		fileToOpen.readFile("./ciphertext/cipher1.txt");
		
		Substitution subMethod = new Substitution();
		subMethod.basicSubstitution(fileToOpen.cipher.freqMap, fileToOpen.cipher.normalFreq);
		
	}
}
