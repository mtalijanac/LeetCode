
/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', 
and they can appear in both lower and upper cases, more than once.
*/
public class ReverseVowelsOfAString_345 {
	
    public String reverseVowels(String s) {
    	StringBuilder vowels = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (isVowel(ch)) vowels.append(ch);
    	}
    	
    	StringBuilder res = new StringBuilder();
    	int vowelIdx = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (isVowel(ch)) {
    			int vIdx = (vowels.length() - ++vowelIdx);
    			char vow = vowels.charAt(vIdx);
    			res.append(vow);
    		}
    		else {
    			res.append(ch);
    		}
    	}
    	
    	return res.toString();
    }
    
    boolean isVowel(char ch) {
    	if (ch == 'a' || ch == 'A' ||
			ch == 'e' || ch == 'E' ||
			ch == 'i' || ch == 'I' ||
			ch == 'o' || ch == 'O' ||
			ch == 'u' || ch == 'U' ) return true;
    	return false;
    }
    
}
