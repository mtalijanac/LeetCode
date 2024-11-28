/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*/
public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
    	int zeroIndex = -1;
    	for (int i = 0; i < nums.length; i++) {
    		int n = nums[i];
    		if (n == 0) {
    			if (zeroIndex == -1) 
    				zeroIndex = i;
    			continue;
    		}
    		else if (zeroIndex == -1) continue;
    		else {
    			nums[i] = 0;
    			i = zeroIndex;
    			nums[zeroIndex] = n;
    			zeroIndex = -1;
    		}
    	}
    	
    }
}


// 1 2 0 0 3 4 0 5 6 0
