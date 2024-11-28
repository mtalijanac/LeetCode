
public class MergeStringAlternately_1768 {
	
	/*
	 * You are given two strings word1 and word2. 
	 * Merge the strings by adding letters in alternating order, 
	 * starting with word1. If a string is longer than the other, 
	 * append the additional letters onto the end of the merged string.
	 * Return the merged string.
	 */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
        	if (word1 != null && i < word1.length())
        		sb.append(word1.charAt(i));
        	if (word2 != null && i < word2.length())
        		sb.append(word2.charAt(i));
        }
        String res = sb.toString();
        return res;
    }
}
