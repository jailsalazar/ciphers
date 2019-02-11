package decryption;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import decryption.IndexCoinc;

public class FrequencyAnalysis {
	public LinkedHashMap<String, Double> freqMap;
	public LinkedHashMap<String, Double> bigramFreqMap;
	public LinkedHashMap<String, Double> trigramFreqMap;
	public LinkedHashMap<String, Double> normalFreq = new LinkedHashMap<String, Double>();
	public IndexCoinc IC;
	
	public FrequencyAnalysis() {
		freqMap = new LinkedHashMap<String, Double>();
		bigramFreqMap = new LinkedHashMap<String, Double>();
		trigramFreqMap = new LinkedHashMap<String, Double>();
		normalFreq = getNormalFrequencies();
		IC = new IndexCoinc();
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
	public LinkedHashMap<String, Double> getNormalDiagram() {
		LinkedHashMap<String, Double> FREQDIA = new LinkedHashMap<String, Double>();
		FREQDIA.put("TH", 0.0271);
		FREQDIA.put("HE", 0.0233);
		FREQDIA.put("IN", 0.0203);
		FREQDIA.put("ER", 0.0178);
		FREQDIA.put("AN", 0.0161);
		FREQDIA.put("RE", 0.0141);
		FREQDIA.put("ES", 0.0132);
		FREQDIA.put("ON", 0.0132);
		FREQDIA.put("ST", 0.0125);
		FREQDIA.put("NT", 0.0117);
		FREQDIA.put("EN", 0.0113);
		FREQDIA.put("AT", 0.0112);
		FREQDIA.put("ED", 0.0108);
		FREQDIA.put("ND", 0.0107);
		FREQDIA.put("TO", 0.0107);
		FREQDIA.put("OR", 0.0106);
		FREQDIA.put("EA", 0.0100);
		FREQDIA.put("TI", 0.0099);
		FREQDIA.put("AR", 0.0098);
		FREQDIA.put("TE", 0.0098);
		FREQDIA.put("NG", 0.0089);
		FREQDIA.put("AL", 0.0089);
		FREQDIA.put("IT", 0.0088);
		FREQDIA.put("AS", 0.0087);
		FREQDIA.put("IS", 0.0086);
		FREQDIA.put("HA", 0.0083);
		FREQDIA.put("ET", 0.0076);
		FREQDIA.put("SE", 0.0073);
		FREQDIA.put("OU", 0.0072);
		FREQDIA.put("OF", 0.0071);
		
		return FREQDIA;
	}
	public LinkedHashMap<String, Double> getNormalTrigram() {
		LinkedHashMap<String, Double> FREQTRI = new LinkedHashMap<String, Double>();
		FREQTRI.put("THE", 0.00181);
		FREQTRI.put("AND", 0.0073);
		FREQTRI.put("ING", 0.0072);
		FREQTRI.put("ENT", 0.0042);
		FREQTRI.put("ION", 0.0042);
		FREQTRI.put("HER", 0.0036);
		FREQTRI.put("FOR", 0.0034);
		FREQTRI.put("THA", 0.0033);
		FREQTRI.put("NTH", 0.0033);
		FREQTRI.put("INT", 0.0032);
		FREQTRI.put("ERE", 0.0031);
		FREQTRI.put("TIO", 0.0031);
		FREQTRI.put("TER", 0.0030);
		FREQTRI.put("EST", 0.0028);
		FREQTRI.put("ERS", 0.0028);
		FREQTRI.put("ATI", 0.0026);
		FREQTRI.put("HAT", 0.0026);
		FREQTRI.put("ATE", 0.0025);
		FREQTRI.put("ALL", 0.0025);
		FREQTRI.put("ETH", 0.0024);
		FREQTRI.put("HES", 0.0024);
		FREQTRI.put("VER", 0.0024);
		FREQTRI.put("HIS", 0.0024);
		FREQTRI.put("OFT", 0.0022);
		FREQTRI.put("ITH", 0.0021);
		FREQTRI.put("FTH", 0.0021);
		FREQTRI.put("STH", 0.0021);
		FREQTRI.put("OTH", 0.0021);
		FREQTRI.put("RES", 0.0021);
		FREQTRI.put("ONT", 0.0020);
		
		return FREQTRI;
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
		
		IC.calculateIC(freqMap, data.length());
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
	
	public void bigramFrequency(String data) {
		
		for(int i = 0; i < data.length()-1; i++) {
			String tempString = Character.toString(data.charAt(i)) + Character.toString(data.charAt(i+1));
			Double value = bigramFreqMap.get(tempString);
			
			if(value != null) {
				bigramFreqMap.put(tempString, new Double(value + 1));
			}
			else {
				bigramFreqMap.put(tempString, 1.0);
			}
		}
		
		bigramFreqMap = sortMap(bigramFreqMap);
		
		System.out.println("Bigram: " + Arrays.asList(bigramFreqMap)); 
	}
	
	public void trigramFrequency(String data) {
		
		for(int i = 0; i < data.length() - 2; i++) {
			String tempString = Character.toString(data.charAt(i)) + Character.toString(data.charAt(i+1)) + Character.toString(data.charAt(i+2));
			Double value = trigramFreqMap.get(tempString);
			
			if(value != null) {
				trigramFreqMap.put(tempString, new Double(value + 1));
			}
			else {
				trigramFreqMap.put(tempString, 1.0);
			}
		}
		
		trigramFreqMap = sortMap(trigramFreqMap);
		
		System.out.println("Trigram: " + Arrays.asList(trigramFreqMap)); 
	}
}
