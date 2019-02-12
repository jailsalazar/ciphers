package decryption;

import java.util.LinkedHashMap;
import decryption.Vigenere;
import decryption.Substitution;

public class IndexCoinc {
	public double IC;
	public String possibleCipher;
	
	public IndexCoinc() {
		IC = 0.0;
		possibleCipher = "";
	}
	
	public void calculateIC(LinkedHashMap<String, Double> frequencies, LinkedHashMap<String, Double> tri, LinkedHashMap<String, Double> normFreq, int length, String cipher) {
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
		
		determinePossibleCipher(frequencies, tri, normFreq, IC, cipher);
	}
	
	public void determinePossibleCipher(LinkedHashMap<String, Double> frequencies, LinkedHashMap<String, Double> tri, LinkedHashMap<String, Double> normFreq, double IC, String cipher) {
		//shift cipher = 0.065
		// vignere cipher < 0.065
		//one time pad = 0.038
		//permutation = 0.065
		
		if(IC > 0.65) {
			Substitution attemptSubstitution = new Substitution();
			attemptSubstitution.basicSubstitution(frequencies, normFreq);
		}
		else if (IC > 0.06 && IC < 0.065 ) {
			//recommend shift
			Shift attemptShift = new Shift();
			attemptShift.shiftCipher(frequencies, cipher);
		}
		
		else if(IC < 0.6) {
			Vigenere attemptVigenere = new Vigenere();
			attemptVigenere.calculateKasiski(tri, cipher);
		}
		else {
			System.out.print("The cipher maybe undecryptable");
		}
	}
}
