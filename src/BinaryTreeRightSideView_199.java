import java.util.ArrayList;
import java.util.List;


public class BinaryTreeRightSideView_199 {
	
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
	
	
    public List<Integer> rightSideView(TreeNode root) {
    	ArrayList<Integer> viewFromRight = new ArrayList<>(105);
    	if (root == null) return viewFromRight; 
    	walkTree(root, viewFromRight, 0);
    	return viewFromRight;
    }
    
    void walkTree(TreeNode n, ArrayList<Integer> viewFromRight, int depth) {
    	if (depth == viewFromRight.size()) viewFromRight.add(n.val);
    	if (n.right != null) walkTree(n.right, viewFromRight, depth + 1);
	    if (n.left != null) walkTree(n.left, viewFromRight, depth + 1);
    }

}
