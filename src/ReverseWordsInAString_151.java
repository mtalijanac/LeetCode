
/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single spac
*/
public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        String[] results = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = results.length - 1; i >= 0; i--) {
        	sb.append(results[i]);
        	if (i > 0) sb.append(" ");
        }
        String res = sb.toString().strip();
        return res;
    }
    
}
