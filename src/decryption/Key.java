package decryption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Key {
	public LinkedHashMap<String, String> key;
	
	public Key() {
		key = new LinkedHashMap<String, String> ();
	}
	
	public void createKey(LinkedHashMap<String, Double> cipher, LinkedHashMap<String, Double> toPair) {
		ArrayList<String> cipherKeyList = new ArrayList<String>(cipher.keySet());
		ArrayList<String> toPairList = new ArrayList<String>(toPair.keySet());
		
		//cipher.forEach(character -> encryptionKey.put(character.getKey(), ));
		for(int i = 0; i < cipherKeyList.size(); i++) {
			key.put(cipherKeyList.get(i), toPairList.get(i));
		}
		
		System.out.println(Arrays.asList(key)); 
	}
}
