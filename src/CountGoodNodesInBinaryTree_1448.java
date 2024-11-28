public class CountGoodNodesInBinaryTree_1448 {
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
	
    public int goodNodes(TreeNode root) {
    	int[] path = new int[512];
    	int pathLen = 0;
    	walkTree(root, path, pathLen);
    	return goodCounter;
    }

	void walkTree(TreeNode root, int[] path, int pathLen) {
		checkForGood(root, path, pathLen);		
		path[pathLen] = root.val;
		if (root.left != null) walkTree(root.left, path, pathLen + 1);
		if (root.right != null) walkTree(root.right, path, pathLen + 1);
	}
	
	void checkForGood(TreeNode root, int[] path, int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			int v = path[i];
			if (v > root.val) return;
		}
		goodCounter++;		
	}
    
	public static void main(String[] args) {
		CountGoodNodesInBinaryTree_1448 prog = new CountGoodNodesInBinaryTree_1448();
		
		testCase_1: {
			TreeNode t25 = new TreeNode(5);
			TreeNode t21 = new TreeNode(1);
			TreeNode t23 = new TreeNode(3);
			TreeNode t14 = new TreeNode(4, t21, t25);
			TreeNode t11 = new TreeNode(1, t23, null);
			TreeNode t03 = new TreeNode(3, t11, t14);
			
			int goodNodes = prog.goodNodes(t03);
			int expected = 4;
			System.out.println(goodNodes + " == " + expected + ", " + (goodNodes == expected));
		}
	}
}
