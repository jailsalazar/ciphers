package decryption;

import java.util.LinkedHashMap;

public class IndexCoinc {
	public double IC;
	public String possibleCipher;
	
	public IndexCoinc() {
		IC = 0.0;
		possibleCipher = "";
	}
	
	public void calculateIC(LinkedHashMap<String, Double> frequencies, int length, String cipher) {
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
		
		determinePossibleCipher(frequencies, IC, cipher);
	}
	
	public void calculateShiftIC(LinkedHashMap<String, Double> frequencies, int length) {
//		double den = 0.0;
//		double num = 0.0;
//		double len = (double)(length);
//		double freqMap = 0.0;
//		
//		
//		
//		den = len * (len -1);
//		
//		for(int i = 0; i < 26; i++) {
//			double shifting = (i + 3) modulo 26;
//			freqMap = frequencies.get(i);
//			num += freqMap * normFreq.(i) - 1;
//			
//		}
//		
	}
	
	public void determinePossibleCipher(LinkedHashMap<String, Double> frequencies, double IC, String cipher) {
		//shift cipher = 0.065
		// vignere cipher < 0.065
		//one time pad = 0.038
		//permutation = 0.065
		
		if (IC < 0.06 && IC > 0.07 ) {
			//recommend shift
			Shift attemptShift = new Shift();
			attemptShift.shiftCipher(frequencies, cipher);
		}
		
		
		
		
		
	}
}
