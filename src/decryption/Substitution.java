package decryption;

import decryption.Key;

import java.util.LinkedHashMap;

public class Substitution {
	public Key encryptionKey;
		
	public Substitution() {
		encryptionKey = new Key();
	}
	
	public LinkedHashMap<String, String> basicSubstitution(LinkedHashMap<String, Double> cipher, LinkedHashMap<String, Double> frequencies) {
		LinkedHashMap<String, String> key = encryptionKey.createKey(cipher, frequencies);
		
		return key;
		
	}
}
