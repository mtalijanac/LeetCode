
/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
*/		
public class FindPivotIndex_742 {
    public int pivotIndex(int[] nums) {
    	int sum = 0;
    	for (int n: nums) sum += n;
    	
    	int leftSum = 0;
    	int rightSum = sum;
    	
    	for (int idx = 0; idx < nums.length; idx++) {
    		leftSum += idx > 0 ? nums[idx - 1] : 0;
    		rightSum -= nums[idx];
    		if (leftSum == rightSum) return idx;
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	FindPivotIndex_742 prog = new FindPivotIndex_742();
    	
		testcase_1: {
			int[] nums = {1,7,3,6,5,6};
			int pivotIndex = prog.pivotIndex(nums);
			System.out.println(pivotIndex + " == 3, " + (pivotIndex == 3) );
		}
		
		testcase_656: {
			int[] nums = {-1,-1,-1,1,1,1};
			int pivotIndex = prog.pivotIndex(nums);
			System.out.println(pivotIndex + " == -1, " + (pivotIndex == -1) );
		}
	}
}
