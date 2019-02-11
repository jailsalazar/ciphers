package decryption;

import java.util.LinkedHashMap;

public class IndexCoinc {
	public double IC;
	public String possibleCipher;
	
	public IndexCoinc() {
		IC = 0.0;
		possibleCipher = "";
	}
	
	public void calculateIC(LinkedHashMap<String, Double> frequencies, int length) {
		double den = 0.0;
		double num = 0.0;
		double len = (double)(length);
		double freq = 0.0;
		
		den = len * (len - 1);
		
		for(char i = 'A'; i <= 'Z'; i++) {
			freq = frequencies.get(Character.toString(i));
			num += freq * (freq-1);
		}
		
		IC = num / den;
		System.out.println("IC: " + IC);	
		
		determinePossibleCipher(IC);
	}
	
	public void calculateShiftIC(LinkedHashMap<String, Double> cipherFreq, LinkedHashMap<String, Double> commonFreq, int length) {
//		double den = 0.0;
//		double num = 0.0;
//		double shifting = 0.0;
//		double len = (double)(length);
//		double freq = 0.0;
//		
//		den = len * (len -1);
//		
//		for(int i = 0; i < 26; i++) {
//			shifting = (i+3)%26;
//			freq = commonFreq.get(i);
//			num += freq * freq - 1;
//		}
		
	}
	
	public void determinePossibleCipher(double IC) {
		
	}
}
