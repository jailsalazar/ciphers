package system;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class OutputFile {
	public void convertToPlaintext(String filePath, String cipherText, LinkedHashMap<String, String> key) {
		//File newFile = new File(filePath);
		String plainText = "";
		
		for(int i = 0; i < cipherText.length(); i++) {
			String replacedString = "";
			replacedString = key.get(Character.toString(cipherText.charAt(i)));
			plainText = plainText + replacedString;
		}
		
		System.out.println(plainText);
		
	}
}
