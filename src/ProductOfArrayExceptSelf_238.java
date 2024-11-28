
/*
Given an integer array nums, return an array answer such that answer[i] 
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed 
to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time 
and without using the division operation.
 */
public class ProductOfArrayExceptSelf_238 {
	
    public int[] productExceptSelf(int[] nums) {
    	int mul = 1;
    	for (int n: nums) if (n != 0) mul *= n;
    	
    	int[] answer = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != 0) answer[i] = mul / nums[i];
    		else answer[i] = mul;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == 0) {
    			for (int j = 0; j < answer.length; j++) {
    				if (i != j) answer[j] = 0;
    			}
    		}
    	}
    	return answer;
    }
    
}
