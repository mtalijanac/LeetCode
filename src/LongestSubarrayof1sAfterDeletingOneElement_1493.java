import java.util.Arrays;

public class LongestSubarrayof1sAfterDeletingOneElement_1493 {
	
    public int longestSubarray(int[] nums) {
    	int[] countArray = new int [nums.length * 2];
    	int caLen;
    	
    	init_countArray: {
	    	int caIdx = 0;
	    	int lastDigit = nums[0];
	    	countArray[caIdx++] = lastDigit;
	    	countArray[caIdx] = 1;
	    	
	    	for (int i = 1; i < nums.length; i++) {
	    		int d = nums[i];
	    		if (d == lastDigit) {
	    			countArray[caIdx]++;
	    		}
	    		else {
	    			lastDigit = d;
	    			countArray[++caIdx] = d;
	    			countArray[++caIdx]++;
	    		}
	    	}
	    	caLen = caIdx + 1;
    	}
    	
    	arrays_with_one_digit: {
	    	if (caLen == 2) {
	    		return countArray[0] == 0     ? 0 
	    		/* we have to delete one 1 */ : countArray[1] - 1;  
	    	}
    	}
    	
    	
    	int maxLen = -1;
    	for (int i = 0; i < caLen; i += 2) {
    		int digit = countArray[i];
    		if (digit == 0) continue;
    		
    		int oneLen = countArray[i + 1];
    		/* check if there is another subarray of ones, spaced with only one zero */
			if (i + 5 < caLen && countArray[i + 3] == 1) {
				oneLen += countArray[i + 5];
			}
			if (oneLen > maxLen) maxLen = oneLen;
    	}
        
    	return maxLen;
    }
    
    public static void main(String[] args) {
    	LongestSubarrayof1sAfterDeletingOneElement_1493 prog = new LongestSubarrayof1sAfterDeletingOneElement_1493();
    	
    	testCase_1: {
    		int[] n = {1, 1, 0, 1};
    		int sol = prog.longestSubarray(n);
    		int expected = 3;
    		System.out.println(sol + " == " + expected + ", " + (sol == expected));
    	}
    	
    	testCase_3: {
    		int[] n = {1, 1, 1};
    		int sol = prog.longestSubarray(n);
    		int expected = 2;
    		System.out.println(sol + " == " + expected + ", " + (sol == expected));
    	}
    	
    	testCase_78: {
    		int[] n = {0, 0, 0};
    		int sol = prog.longestSubarray(n);
    		int expected = 0;
    		System.out.println(sol + " == " + expected + ", " + (sol == expected));
    	}
    }
    
}
