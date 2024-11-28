/*
Given a binary array nums and an integer k, 
return the maximum number of consecutive 1's 
in the array if you can flip at most k 0's.
*/
public class MaxConsecutiveOnesIII_1004 {
	
	// FIXME this solution is very slow 
    public int longestOnes(int[] nums, int k) {
    	int maxCount = -1;
    	for (int i = 0; i < nums.length; i++) {
    		int count = countFil(nums, i, k);
    		if (count > maxCount) maxCount = count;
    	}
    	return maxCount;
    }

    int countFil(int[] nums, int off, int k) {
    	{
	    	int startDigit = nums[off];
	    	if (startDigit == 1 && off > 1) {
	    		if (nums[off - 1] == 1) return -1;
	    	}
    	}
    	
    	int idx = off;
    	int count = 0;
    	while (true) {
    		if (idx >= nums.length) break;
    		
    		int digit = nums[idx];
    		
	    	if (digit == 1) {
	    		int oneCount = count1s(nums, idx);
	    		count += oneCount;
	    		idx += oneCount;
	    	}
	    	
	    	else {
	    		if (k == 0) break;
	    		int zeroCount = countOs(nums, idx);
	    		int converted = Math.min(zeroCount, k);
	    		count += converted;
	    		k -= converted;
	    		idx += converted;
	    	}
    	}
    	return count;
    }
    
    int count1s(int[] nums, int off) {
    	return countDigits(1, nums, off);
    }
    
    int countOs(int[] nums, int off) {
    	return countDigits(0, nums, off);
    }
    
    int countDigits(int digit, int[] nums, int off) {
    	int count = 0;
    	for (int i = off; i < nums.length; i++) {
    		int val = nums[i];
    		if (val != digit) break;
    		count++;
    	}
    	return count;
    }
    
    public static void main(String[] args) {
    	MaxConsecutiveOnesIII_1004 prog = new MaxConsecutiveOnesIII_1004();
		testCase_1: {
			int[] data = {1,1,1,0,0,0,1,1,1,1,0};
			int k = 2;
			int res = prog.longestOnes(data, k);
			System.out.println(res);
		}
	}
}
