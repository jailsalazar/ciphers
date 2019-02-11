package decryption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import system.OutputFile;
import java.util.Scanner;

import decryption.Key;

public class Shift {
	public Key encryptionKey;
	public OutputFile outputPlain;
	Scanner reader = new Scanner(System.in);  // Reading from System.in
	String response = "";
	
	public Shift() {
		encryptionKey = new Key();
		outputPlain = new OutputFile();
	}
	
	public void shiftCipher(LinkedHashMap<String, Double> cipher, String ciphertext) {
		ArrayList<String> cipherKeyList = new ArrayList<String>(cipher.keySet());
		LinkedHashMap<String, String> shiftKey = new LinkedHashMap<String, String>();
		
		for(int i = 1; i < 26; i++) {
 				shiftKey = shiftCipher(cipherKeyList, i);
 				outputPlain.convertToPlaintext("none", ciphertext, shiftKey);
 			
 			if(!askForUser()) {	
 				reader.close();
 				break;
 			}
		}
	}
	
	public LinkedHashMap<String, String> shiftCipher(ArrayList<String> cipher, Integer shift) {				
		//cipher.forEach(character -> encryptionKey.put(character.getKey(), ));
		
		String keyString = "";
		LinkedHashMap<String, String> shiftKey = new LinkedHashMap<String, String>();
		
		for(int i = 0; i < cipher.size(); i++) {
			
			char key = (cipher.get(i).charAt(0));
			keyString = getShiftedKey(key, shift);
	      
			shiftKey.put(cipher.get(i), keyString.toLowerCase());
		}
		
		//System.out.println("Shifted: " + shift + " " + Arrays.asList(shiftKey)); 
		
		return shiftKey;
		
	}
	
	public String getShiftedKey(char key, int shift) {
		int shifted;
		int keyInt = (int) key;
		
        	shifted = keyInt - shift;
        //ASCII value for A=65, Z=90
        	if(shifted < 65){
     		shifted = shifted + 26;
    		}
		
		return Character.toString((char) shifted);
	}
	
	public Boolean askForUser() {
		System.out.println("Does this look like English (Y or N)? ");
		if(reader.hasNextLine()){
			response = reader.nextLine();
		}
		else {
			response = null;
        }
		//once finished
		if (response.equals("Y")) {
			reader.close();
			return false;
		}
		else {
			return true;
		}
	}
}
