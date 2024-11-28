
/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
*/
public class MaximumNumberOfVowelsInASubstringOfGivenLength_1456 {
	
    public int maxVowels(String s, int k) {
    	int winVowels = 0;
    	
    	for (int i = 0; i < k; i++) {
    		char ch = s.charAt(i);
    		switch(ch) {
    			case 'a', 'e', 'i', 'o', 'u' -> winVowels++;
    		}
    	}
    	
    	int maxVowels = winVowels;
    	
    	for (int i = 1; i + k - 1< s.length(); i++) {
    		char outChar = s.charAt(i - 1);
    		switch(outChar) {
    			case 'a', 'e', 'i', 'o', 'u' -> winVowels--;
    		}
    		
			char inChar = s.charAt(i + k - 1);
    		switch(inChar) {
    			case 'a', 'e', 'i', 'o', 'u' -> winVowels++;
    		}
    		
    		if (winVowels > maxVowels)
    			maxVowels = winVowels; 
    	}
    	
    	return maxVowels;
    }

    public static void main(String[] args) {
		MaximumNumberOfVowelsInASubstringOfGivenLength_1456 prog = new MaximumNumberOfVowelsInASubstringOfGivenLength_1456();
		
		testcase_1: {
			String s = "abciiidef";
			int k = 3;
			int expected = 3;
			int res = prog.maxVowels(s, k);
			System.out.println(res + " == " + expected + ", " + (expected == res));
		}
		
		testcase_105: {
			// len: 12, k: 7
			String s = "weallloveyou";
			int k = 7;
			int expected = 4;
			int res = prog.maxVowels(s, k);
			System.out.println(res + " == " + expected + ", " + (expected == res));
		}
	}
}
