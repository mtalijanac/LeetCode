import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class MaximumLevelSumOfABinaryTree_1161 {
	
	/**
	 * Definition for a binary tree node.
	 */
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	final HashMap<Integer /*level*/, AtomicInteger /* sum */> sums = new HashMap<>();
	
    public int maxLevelSum(TreeNode root) {
    	if (root == null) return 0;
    	
    	walkTree(root, 1);
    	
    	int minLevel = 1;
    	int maxSum = sums.get(1).intValue();
    	
    	for (HashMap.Entry<Integer, AtomicInteger> e: sums.entrySet()) {
    		int sum = e.getValue().get();
    		if (sum == maxSum) {
    			minLevel = Math.min(minLevel, e.getKey());
    		}
    		else if (sum > maxSum) {
    			maxSum = sum;
    			minLevel = e.getKey();
    		}
    	}
    	return minLevel;
    }
	
    
    void walkTree(TreeNode n, int depth) {
    	sums.computeIfAbsent(depth, k -> new AtomicInteger(0))
    	    .addAndGet(n.val);
    	
    	if (n.right != null) walkTree(n.right, depth + 1);
	    if (n.left  != null) walkTree(n.left,  depth + 1);
    }

}
