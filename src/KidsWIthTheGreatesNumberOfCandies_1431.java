import java.util.ArrayList;
import java.util.List;

/**
 * There are n kids with candies. You are given an integer array candies, 
 * where each candies[i] represents the number of candies the ith kid has, 
 * and an integer extraCandies, denoting the number of extra candies that you have.
 * 
 * Return a boolean array result of length n, where result[i] is true if, 
 * after giving the ith kid all the extraCandies, they will have the greatest 
 * number of candies among all the kids, or false otherwise.
 * 
 * Note that multiple kids can have the greatest number of candies.
 */
public class KidsWIthTheGreatesNumberOfCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    	int max = candies[0];
    	for (int c: candies) if (c > max) max = c;
        
        int goal = max - extraCandies;
        
        ArrayList<Boolean> result = new ArrayList<>(candies.length);
        for (int c: candies) result.add(c > goal);
        
        return result;
    }
    
}
