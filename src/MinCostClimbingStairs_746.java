import java.util.Arrays;

public class MinCostClimbingStairs_746 {
	
	int[] prices;
	
    public int minCostClimbingStairs(int[] cost) {
    	prices = new int[cost.length];
    	Arrays.fill(prices, -1);
    	int price = climbStair(cost, -1);
    	return price;
    }

    
    int climbStair(int[] cost, int pos) {
    	if (pos >= cost.length) return 0;
    	
    	if (pos >= 0 && pos < cost.length) {
    		int price = prices[pos];
    		if (price > -1) return price;
    	}
    	
    	int price1 = climbStair(cost, pos + 1);
    	int price2 = climbStair(cost, pos + 2);

    	int currentCost = Math.min(price1, price2);
    	if (pos >= 0) currentCost += cost[pos];
    	if (pos >= 0 && pos < cost.length) prices[pos] = currentCost;
    	return currentCost;
    }
}
