/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
*/
public class CountingBits_338 {
	public int[] countBits(int n) {
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = Integer.bitCount(i);
		}
		return arr;
	}
	
    public int[] countBitsX(int n) {
    	int[] arr = new int[n + 1];
    	for (int i = 0; i <= n; i++) {
    		int bitCount = 0;
    		for (int off = 0; off < 32; off++) {
    			int mask = 1 << off;
    			if ((i & mask) != 0) bitCount++; 
    		}
    		arr[i] = bitCount;
    	}
    	return arr;
    }
}
