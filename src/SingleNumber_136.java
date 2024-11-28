
/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
*/
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        byte[] flags = new byte[6002];
        for (int n: nums) {
        	byte v = flags[n + 3000];
        	v = (byte) ((v == 0) ? 1 : 0);
        	flags[n + 3000] = v;
        }
        
        for (int idx = 0; idx < flags.length; idx++) 
        	if (flags[idx] != 0) 
        		return idx - 3000;
        
        return -1;
    }
}
