
/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
    	if (s.length() == 0) return true;
    	
    	int sIdx = 0;
    	char chs = s.charAt(sIdx);
    	
    	for (int tIdx = 0; tIdx < t.length(); tIdx++) {
    		char cht = t.charAt(tIdx);
    		if (cht == chs) {
    			sIdx += 1;
    			if (sIdx >= s.length())
    				return true;
    			chs = s.charAt(sIdx);
    		}
    	}
    	return false;
    }
}
