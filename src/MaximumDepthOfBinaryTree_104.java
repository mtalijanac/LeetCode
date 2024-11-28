
// Given the root of a binary tree, return its maximum depth.
public class MaximumDepthOfBinaryTree_104 {
	
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
	 
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return walk(root, 1);
    }
	
	int walk(TreeNode n, int level) {
		return Math.max(
				n.left  == null ? level : walk(n.left,  level + 1),
				n.right == null ? level : walk(n.right, level + 1)
		);
	}
}
