
public class PathSumIII_437 {
	// Definition for a binary tree node.
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
	
	int goodCounter = 0;
	int targetSum = 0;
	
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		this.targetSum = targetSum;
    	int[] path = new int[512];
    	int pathLen = 0;
    	walkTree(root, path, pathLen);
    	return goodCounter;
    }

	void walkTree(TreeNode root, int[] path, int pathLen) {
		path[pathLen] = root.val;
		checkForPathSum(root, path, pathLen + 1);		
		if (root.left != null) walkTree(root.left, path, pathLen + 1);
		if (root.right != null) walkTree(root.right, path, pathLen + 1);
	}
	
	void checkForPathSum(TreeNode root, int[] path, int pathLen) {
		long sum = 0;
		for (int i = pathLen - 1; i >= 0; i--) {
			sum += path[i];
			if (sum == targetSum) 
				goodCounter++;
		}
	}
	
    
	public static void main(String[] args) {
		PathSumIII_437 prog = new PathSumIII_437();
		
		testCase_1: {
			// [10,
			// 5,-3,
			// 3,2,null,11,
			// 3,-2,null,1]
			
			TreeNode t3_1 = new TreeNode(1);
			TreeNode t3_m2 = new TreeNode(-2);
			TreeNode t3_3 = new TreeNode(3);
			TreeNode t2_11 = new TreeNode(11, null, null); 
			TreeNode t2_2 = new TreeNode(2, null, t3_1);
			TreeNode t2_3 = new TreeNode(3, t3_3, t3_m2);
			TreeNode t1_m3 = new TreeNode(-3, null, t2_11);
			TreeNode t1_5 = new TreeNode(5, t2_3, t2_2);
			TreeNode t0_10 = new TreeNode(10, t1_5, t1_m3);
			
			
			int goodNodes = prog.pathSum(t0_10, 8);
			int expected = 3;
			System.out.println(goodNodes + " == " + expected + ", " + (goodNodes == expected));
		}
	}
}
