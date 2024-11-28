import java.util.ArrayList;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    	byte[] flags1 = new byte[2001];
    	for (int n: nums1) flags1[1000 + n] = 1;
    	
    	byte[] flags2 = new byte[2001];
    	for (int n: nums2) flags2[1000 + n] = 1; 
    	
    	ArrayList<Integer> a1 = new ArrayList<>(nums1.length);
    	ArrayList<Integer> a2 = new ArrayList<>(nums2.length);
    	
    	for (int i = 0; i < flags1.length; i++) {
    		int f1 = flags1[i];
    		int f2 = flags2[i];
    		if (f1 == 1 && f2 == 0) a1.add(i - 1000);
    		if (f1 == 0 && f2 == 1) a2.add(i - 1000);
    	}
    	
    	List<List<Integer>> res = new ArrayList<>(2);
    	res.add(a1);
    	res.add(a2);
    	return res;
    }
}
