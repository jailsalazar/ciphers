package decryption;

import decryption.Key;

import java.util.LinkedHashMap;

public class Substitution {
	public Key encryptionKey;
		
	public Substitution() {
		encryptionKey = new Key();
	}
	
	public void basicSubstitution(LinkedHashMap<String, Double> cipher, LinkedHashMap<String, Double> frequencies) {
		encryptionKey.createKey(cipher, frequencies);
	}
}
