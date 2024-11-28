
/*
 * For two strings s and t, we say "t divides s" if and only if 
 * s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides 
 * both str1 and str2.
 */
public class GreatestCommonDivisorOfStrings_1071 {

    public String gcdOfStrings(String str1, String str2) {        
        int max = Math.max(str1.length(), str2.length());
        int min = Math.min(str1.length(), str2.length());
        int gcd = findGCD(max, min);
        String strGcd = str1.substring(0, gcd);
        for (int i = 0; i < max; i++) {
            int ch1 = str1.charAt(i % str1.length()) ;
            int ch2 = str2.charAt(i % str2.length());
            int ch3 = strGcd.charAt(i % strGcd.length());
            if (ch1 != ch2) return "";
            if (ch1 != ch3) return "";
        }
        return strGcd;
    }

    // Method to find the GCD using Euclid's Algorithm
    public int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
}
