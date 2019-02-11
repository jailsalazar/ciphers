package decryption;

import java.util.LinkedHashMap;

public class IndexCoinc {
	public double IC;
	
	public IndexCoinc() {
		IC = 0.0;
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
			//System.out.println(frequencies.get(Character.toString(i)));
		}
		
		IC = num / den;
		System.out.println("IC: " + IC);	
	}
//	double num = 0.0;
//	double den = 0.0;
//	double IC = 0.0;
//	
//	den = cipher.length*(ciper.length-1);
//	
//	for (i = 0; i < 25; i++) {
//		
//		num += freqNum.value(i)(freqNum.value.(i) - 1);
//		
//		
//	}
//	
//	IC = num/den;

}
