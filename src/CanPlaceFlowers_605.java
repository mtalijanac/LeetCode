

/**
 * You have a long flowerbed in which some of the plots are planted, 
 * and some are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means 
 * empty and 1 means not empty, and an integer n, return true if n 
 * new flowers can be planted in the flowerbed without violating 
 * the no-adjacent-flowers rule and false otherwise.
 * 
 */
public class CanPlaceFlowers_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	return zeroCounting(flowerbed, n);
    }
    
    boolean zeroCounting(int[] flowerbed, int n) {
    	int zeroCount = 1;
    	int sum = 0;
    	for (int i = 0; i < flowerbed.length; i++) {
    		if (flowerbed[i] == 1) {
    			// -                      0:0
    			// 0 -                    1:0
    			// 0, 0 ->                2:0
    			// 0, x, 0 ->             3:1
    			// 0, x, 0, 0 ->          4:1
    			// 0, x, 0, x, 0 ->       5:2
    			// 0 ,x, 0, x, 0, 0 ->    6:2
    			// 0, x, 0, x, 0, x, 0 -> 7:3
    			//                        8:3
    			//                        9:4
    			
    			int flowerCount = (zeroCount - 1) / 2;
                sum += flowerCount;
    			zeroCount = 0;
    		}
    		else {
    			zeroCount++;
    		}
    	}
    	zeroCount++;
    	int flowerCount = (zeroCount - 1) / 2;
        sum += flowerCount;
        
        boolean res = n <= sum;
        return res;
    }
    
    
    boolean recursiveDescent(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
        	int plot = flowerbed[i];
        	if (plot == 1) continue;
        	
        	int plotLeft = i == 0 ? 0 : flowerbed[i - 1];
        	if (plotLeft == 1) continue;
        	
        	int plotRight = i + 1 == flowerbed.length ? 0 : flowerbed[ i + 1];
        	if (plotRight == 1) continue;
        	
        	flowerbed[i] = 1;
        	boolean res = recursiveDescent(flowerbed, n - 1);
        	if (res) return true;
        	flowerbed[i] = 0;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	CanPlaceFlowers_605 solution = new CanPlaceFlowers_605();
    	System.out.println(-1 / 2);
    	
    	test_66: {
	    	int[] flowerbed = {0,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0};
	    	int n = 24;
	    	
	    	boolean res = solution.canPlaceFlowers(flowerbed, n);
	    	System.out.println(res);
    	}
	}
    
}
