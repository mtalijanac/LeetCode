// FIXME - this isn't a very good solution..

public class ContainerWithMostWater_11 {
	
	public int maxArea(int[] height) {
		int arrLen = height.length; 
		
		int[] lHeightsIdexes = new int[arrLen];
		int lhLength = 0;
		
		int[] rHeightsIndexes = new int[arrLen];
		int rhLength = 0;
		
		{
			int maxRIdx = -1;
			int maxRHeight = -1;
			
			int maxLIdx = -1;
			int maxLHeight = -1;
			
			for (int i = 0; i < arrLen; i++) {
				int lh = height[i];
				if (lh > maxLHeight) {
					maxLHeight = lh;
					maxLIdx = i;
					lHeightsIdexes[lhLength++] = maxLIdx;
				}
			
				int j = height.length - 1 - i;
				int rh = height[j];
				if (rh > maxRHeight) {
					maxRHeight = rh;
					maxRIdx = j;
					rHeightsIndexes[rhLength++] = maxRIdx;
				}
			}
		}
		
		int maxArea = 0;
		for (int i = 0; i < lhLength; i++) {
			int lhIdx = lHeightsIdexes[i];
			int lh = height[lhIdx];
			
			for (int j = 0; j < rhLength; j++) {
				int rhIdx = rHeightsIndexes[j];
				if (lhIdx >= rhIdx) break;
				
				int rh = height[rhIdx];
				
				int distance = rhIdx - lhIdx;
				int h = Math.min(lh, rh);
				int area = h * distance;
				if (area > maxArea) maxArea = area;
			}
		}
		
		return maxArea;
	}
	
 
    public static void main(String[] args) {
    	ContainerWithMostWater_11 prog = new ContainerWithMostWater_11();
    	
    	testCase1: {
    		int[] height = {1,8,6,2,5,4,8,3,7};
	        int res = prog.maxArea(height);
	        int expected = 49;
	        System.out.println(res + " = " + expected + ", " + (res == expected));
    	}
    	
    	testCase58: {
    		int[] height = {2,3,4,5,18,17,6};
    		int res = prog.maxArea(height);
    		int expected = 17;
    		System.out.println(res + " = " + expected + ", " + (res == expected));
    	}
	}
}
