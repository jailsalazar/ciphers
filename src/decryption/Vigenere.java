package decryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import decryption.FrequencyAnalysis;
import decryption.IndexCoinc;

public class Vigenere {
//public void trigramFrequency(String data) {
	FrequencyAnalysis frequency;
	IndexCoinc shiftIC;
	LinkedHashMap<String, Double> englishFreq;
	
	public Vigenere() {
		frequency = new FrequencyAnalysis();
		shiftIC = new IndexCoinc();
		englishFreq = frequency.getNormalFrequencies();
	}

	public void calculateKasiski(LinkedHashMap<String, Double> trigrams, String cipher) {
		ArrayList<String> cipherKeyList = new ArrayList<String>(trigrams.keySet());
		ArrayList<Integer> locations = new ArrayList<Integer>();
		ArrayList<String> splitCipher = new ArrayList<String>();
		String keyword = "";
		
		String mostFrequentTri = cipherKeyList.get(0);
			
		locations = findLocations(cipher, mostFrequentTri);
		//System.out.println(locations);
		Double keyLength = findKeyLength(locations);
		//System.out.println(keyLength);
		splitCipher = splitCipher(cipher, keyLength);
		//System.out.println(Arrays.asList(splitCipher));
		keyword = getKeyWord(splitCipher, cipher.length(), keyLength);
		System.out.println(keyword); 
			
	}
	
	public ArrayList<String> splitCipher(String cipher, Double keyLength) {
		ArrayList<String> segments = new ArrayList<String>();
		String temp = "";
		
		for (int i = 0; i < keyLength.intValue(); i++) {
			
			for(int cipherIndex = i; cipherIndex < cipher.length()-6; cipherIndex=cipherIndex+6) {				
				temp += Character.toString(cipher.charAt(cipherIndex));
			}
			segments.add(temp);
			temp = "";
		}
		
		return segments;
	}
	
	public String getKeyWord(ArrayList<String> segments, int cipherLength, Double keyLength) {
		LinkedHashMap<String, Double> segFreq = new LinkedHashMap<String, Double> ();
		String list = "";
		double tempIC = 0;
		
		for(int i = 0; i < segments.size(); i++) {
			segFreq = frequency.getMonoFreq(segments.get(i));
			for(int cipherIndex = 0; cipherIndex < segments.get(i).length(); cipherIndex++) {
				String currCipher = segments.get(i);
				tempIC = calculateShiftIC(segFreq, cipherLength, keyLength, currCipher.length(), currCipher.charAt(cipherIndex));
				
				if(tempIC > 0.06) {
					list += getLetter(cipherIndex);
					break;
				}
			}
		}
		return list;
	}
	
	public double calculateShiftIC(LinkedHashMap<String, Double> segFreq, int cipherLength, double keyLength, int sLength, char currLetter) {
		Double den = 0.0;
		Double freq = 0.0;
		Double num = 0.0;
		Double normFreq = 0.0;
		Double cLength = new Double(cipherLength);
		Double tempIC = 0.0;
		int shift = 0;
		
		den = (cLength / keyLength);
		
		normFreq = englishFreq.get(Character.toString(currLetter).toLowerCase());
				
		for(int i = 0; i < 26; i++) {
			freq = segFreq.get(getShiftedKey(currLetter, i));
			//normFreq = englishFreq.get((getShiftedKey(currLetter, i)).toLowerCase());
				
			if(freq != null) {
				num += (freq * normFreq);
			}
			else {
				num += 0;
			}
		}
		
		tempIC = num / den;

		return tempIC;
	}
	
	public String getShiftedKey(char key, int shift) {
		int shifted;
		int keyInt = (int) key;
		
        	shifted = keyInt + shift;
        //ASCII value for A=65, Z=90
        	if(shifted > 90){
     		shifted = shifted - 26;
    		}
		
		return Character.toString((char) shifted);
	}
	
	public String getLetter(int key) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		return Character.toString(alphabet[key]);
	}
	
	public ArrayList<Integer> findLocations(String cipher, String currentTrigram) {
			ArrayList<Integer> trigramLocations = new ArrayList<Integer>();
			
			for(int i = 0; i < cipher.length() - 2; i++) {
				String tempString = Character.toString(cipher.charAt(i)) + Character.toString(cipher.charAt(i+1)) + Character.toString(cipher.charAt(i+2));
				
				if(tempString.equals(currentTrigram)) {
					trigramLocations.add(i);
				}
			}
			
			return trigramLocations;
	}

	public Double findKeyLength(ArrayList<Integer> locations) {
		int tempGCD = 0;
		Double maxGCD = 0.0;
		LinkedHashMap<Integer, Double> gcdMap = new LinkedHashMap<Integer, Double>();
		
		for(int i = 0; i < locations.size() - 2; i++) {
			tempGCD = GCDCalculator(locations.get(i), locations.get(i+1));
			
			Double value = gcdMap.get(tempGCD);
			
			if(value != null) {
				gcdMap.put(tempGCD, new Double(value + 1));
			}
			else {
				gcdMap.put(tempGCD, 1.0);
			}
		}
		
		gcdMap.entrySet()
	    		.stream()
	    		.sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
	    		.forEachOrdered(freq -> gcdMap.put(freq.getKey(), freq.getValue()));
		
		ArrayList <Integer> temp = new ArrayList<Integer>(gcdMap.keySet());
		
		maxGCD = temp.get(0).doubleValue();
		
		return maxGCD;
	}
	
	static int GCDCalculator(int a, int b) {
	      if (b == 0) {
	          return a;
	      }
	      
	      return GCDCalculator(b, a % b);
	}
}

