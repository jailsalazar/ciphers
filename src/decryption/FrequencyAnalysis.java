package decryption;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import decryption.Key;

public class FrequencyAnalysis {
	public LinkedHashMap<String, Double> freqMap;
	public LinkedHashMap<String, Double> normalFreq = new LinkedHashMap<String, Double>();
	public Key encryptionKey;
	
	public FrequencyAnalysis() {
		freqMap = new LinkedHashMap<String, Double>();
		normalFreq = getNormalFrequencies();
		encryptionKey = new Key();
	}
	
	public LinkedHashMap<String, Double> getNormalFrequencies() {
		LinkedHashMap<String, Double> FREQ = new LinkedHashMap<String, Double>();
		FREQ.put("e", 0.12702);
		FREQ.put("t", 0.09056);
		FREQ.put("a", 0.08167);
		FREQ.put("o", 0.07507);
		FREQ.put("i", 0.06966);
		FREQ.put("n", 0.06749);
		FREQ.put("s", 0.06327);
		FREQ.put("h", 0.06094);
		FREQ.put("r", 0.05987);
		FREQ.put("d", 0.04253);
		FREQ.put("l", 0.04025);
		FREQ.put("c", 0.02782);
		FREQ.put("u", 0.02758);
		FREQ.put("m", 0.02406);
		FREQ.put("w", 0.02360);
		FREQ.put("f", 0.02228);
		FREQ.put("g", 0.02015);
		FREQ.put("y", 0.01974);
		FREQ.put("p", 0.01929);
		FREQ.put("b", 0.01492);
		FREQ.put("v", 0.00978);
		FREQ.put("k", 0.00772);
		FREQ.put("j", 0.00153);
		FREQ.put("x", 0.00150);
		FREQ.put("q", 0.00095);
		FREQ.put("z", 0.00074);
		
		return FREQ;
	}
	
	public void characterFrequency(String data) {
		
		for(int i = 0; i < data.length(); i++) {
			char tempChar = data.charAt(i);
			Double value = freqMap.get(Character.toString(tempChar));
			
			if(value != null) {
				freqMap.put(Character.toString(tempChar), new Double(value + 1));
			}
			else {
				freqMap.put(Character.toString(tempChar), 1.0);
			}
		}
		
		freqMap = sortMap(freqMap);
				
		System.out.println(Arrays.asList(freqMap)); 
		System.out.println(Arrays.asList(normalFreq));
	}
	
	public LinkedHashMap<String, Double> sortMap(LinkedHashMap<String, Double> unsortedMap) {
        
		//System.out.println("Unsorted Map : " + unsortedMap);
		 
		//LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();
		 
		//Use Comparator.reverseOrder() for reverse ordering
		unsortedMap.entrySet()
		    .stream()
		    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
		    .forEachOrdered(freq -> reverseSortedMap.put(freq.getKey(), freq.getValue()));
		 
		//System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
		return reverseSortedMap;
	}
}
