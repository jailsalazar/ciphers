package decryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Vigenere {
//public void trigramFrequency(String data) {


	public void calculateKasiski(LinkedHashMap<String, Double> trigrams) {
		ArrayList<String> cipherKeyList = new ArrayList<String>(trigrams.keySet());
		String mostFrequentTri = cipherKeyList.get(0);
		
		System.out.println(mostFrequentTri);
	}
	
	//public HashMap<String, Location>
		
//	mostTri = trigramFreqMap.get(0);
//	Array kasasik+
//	
//	for(int j = 0; j < data.lenght(); i++) {
//		String tempString = Character.toString(data.charAt(i)) + Character.toString(data.charAt(i+1)) + Character.toString(data.charAt(i+2));
//		if(mostTri == tempString) {
//			//location of tempstring
//			//into hash maps!???
//		}
//		
//	}
		
		//System.out.println("Trigram: " + Arrays.asList(trigramFreqMap)); 
	//}
}
