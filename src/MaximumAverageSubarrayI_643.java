
/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*/
public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {
    	long lastSum = 0;
    	for (int i = 0; i < k; i++) {
    		lastSum += nums[i];
    	}
    	
    	long maxSum = lastSum;
    	
        for (int i = 1; i + k - 1< nums.length; i++) {
        	long toRemove = nums[i-1];
        	long toAdd = nums[i+k-1];
        	long sum = lastSum - toRemove + toAdd;
        	if (sum > maxSum) maxSum = sum;
        	lastSum = sum;
        }
        
        double res = (double) maxSum / k;
        return res;
    }
    
    public static void main(String[] args) {
    	MaximumAverageSubarrayI_643 prog = new MaximumAverageSubarrayI_643();
    	
		testcase_1: {
			int[] nums = {1, 12, -5, -6, 50, 3};
			int k = 4;
			double res = prog.findMaxAverage(nums, k);
			System.out.println(res);
		}
		
		testcase_16: {
			int[] nums = {0,1,1,3,3};
			int k = 4;
			double res = prog.findMaxAverage(nums, k);
			System.out.println(res);
		}
		
		testcase_21: {
			int[] nums = {0,4,0,3,2};
			int k = 1;
			double res = prog.findMaxAverage(nums, k);
			System.out.println(res);
		}
	}
}
