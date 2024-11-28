
/*
Given an integer array nums, return true if there exists a triple of 
indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. 
If no such indices exists, return false.
*/

import java.util.TreeSet;

public class InvreasingTripletSubsequence_334 {
	
	public boolean increasingTriplet(int[] nums) {
		TreeSet<Integer> left = new TreeSet<>();
		TreeSet<Integer> right = new TreeSet<>();

		left.add(nums[0]);
		for (int k = 2; k < nums.length; k++)
			right.add(nums[k]);
		
		for (int j = 1; j < nums.length - 1; j++) {
			int v = nums[j];
			Integer minLeft = left.first();
			Integer maxRight = right.last();

			if (minLeft < v && v < maxRight) return true;
			left.add(v);
			int nextV = nums[j+1];
			right.remove(nextV);
			if (right.isEmpty()) return false;
		}
		return false;
	}
	
    public static void main(String[] args) {
    	InvreasingTripletSubsequence_334 prog = new InvreasingTripletSubsequence_334();
    	
    	testcase_71: {
    		int[] nums = new int[] {20,100,10,12,5,13};
    		boolean expected = true;
    		
    		boolean res = prog.increasingTriplet(nums);
    		System.out.println(expected == res);
    	}
	}
}
