import java.util.Arrays;

public class HouseRobber_198 {
	int[] loots;
	
    public int rob(int[] nums) {
    	loots = new int[nums.length];
    	Arrays.fill(loots, -1);
    	
    	int loot1 = robbingSpree(nums, -1);
    	int loot2 = robbingSpree(nums, 0);
    	int loot = Math.max(loot1, loot2);
    	return loot;
    }
    
    int robbingSpree(int[] stashes, int pos) {
    	if (pos >= stashes.length) return 0;
    	
    	if (pos >= 0 && pos < stashes.length) {
    		int loot = loots[pos];
    		if (loot > -1) return loot;
    	}
    	
    	int loot1 = robbingSpree(stashes, pos + 2);
    	int loot2 = robbingSpree(stashes, pos + 3);
    	
    	int loot = Math.max(loot1, loot2);
    	if (pos >= 0) loot += stashes[pos];
    	if (pos >= 0 && pos < stashes.length) loots[pos] = loot;
    	return loot;
    }
    
}
