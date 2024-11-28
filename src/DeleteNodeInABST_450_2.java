public class DeleteNodeInABST_450_2 {
	
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
	
	
	TreeNode parentOfValue;
	TreeNode nodeWithValue; // here we will write new val
	
	TreeNode forDeletion;  // this will be removed
	TreeNode parentForDeletion; // by writing null ref in his parent	 
	
    public TreeNode deleteNode(TreeNode root, int key) {
    	// node to be deleted,
    	// we will write new value here 
    	TreeNode nodeWithValue = nodeWithValue(null, root, key);
    	
    	if (root.val == key) {
    		if (hasTwoChild(root)) {
    			
    		}
    	}
    	
    	/*
    	 * 
		    Leaf Node: If the node is a leaf, we can simply remove it.
		    Node with One Child: If the node has one child, we can bypass the node by connecting its parent directly to its child.
		    Node with Two Children: If the node has two children, we need to find 
		    the node's in-order successor (the smallest node in its right subtree) 
		    or in-order predecessor (the largest node in its left subtree) 
		    to replace the node's value and then delete that successor or predecessor node.
    	 */
    	
    	// 1. is leaf
    	if (isLeaf(nodeWithValue)) {
    		if (parentOfValue == null) return null;
    		if (parentOfValue.left == nodeWithValue) parentOfValue.left = null;
    		else parentOfValue.right = null;
    		return root;
    	}
    	
    	// 2. has one child
    	if (hasOneChild(nodeWithValue)) {
    		TreeNode child = nodeWithValue.left;
    		if (child == null) child = nodeWithValue.right;
    		if (parentOfValue == null) return child; // root has value
    		
    		if (parentOfValue.left == nodeWithValue) parentOfValue.left = child;
    		else parentOfValue.right = child;
    		return root; 
    	}
    	
    	
    	// 3. has two children
    	if (!hasTwoChild(nodeWithValue)) {
    		System.out.println("Illegal state");
    		return root;
    	}
    	
    	TreeNode inOrderSuccessor = inOrderSuccessor(nodeWithValue, nodeWithValue.right);
    	nodeWithValue.val = inOrderSuccessor.val;
    	
    	if (parentForDeletion.left == inOrderSuccessor) parentForDeletion.left = null;
    	else parentForDeletion.right = null;

    	return root;
	}
    
    TreeNode nodeWithValue(TreeNode parent, TreeNode root, int key) {
    	if (root == null) return null;
    	if (root.val == key) {
    		parentOfValue = parent;
    		return root;
    	}
    	
    	if (root.left != null) {
    		TreeNode n = nodeWithValue(root, root.left, key);
    		if (n != null) return n;
    	}
    	
    	if (root.right != null) {
    		TreeNode n = nodeWithValue(root, root.right, key);
    		if (n != null) return n;
    	}
    	
    	return null;
    }
    
    boolean isLeaf(TreeNode node) {
    	return node != null && node.left == null && node.right == null;
    }
    
    boolean hasOneChild(TreeNode node) {
    	if (node == null) return false;
    	if (node.left == null && node.right == null) return false;
    	if (node.left != null && node.right == null) return true;
    	if (node.left == null && node.right != null) return true;
    	return false;
    }
    
    boolean hasTwoChild(TreeNode node) {
    	if (node == null) return false;
    	return node.left != null && node.right != null;
    }
    
    // the smallest node in its right subtree
    // hodaj cijelo stablo, vrati uvijek manji val
    TreeNode inOrderSuccessor(TreeNode parent, TreeNode root) {
    	TreeNode best = root;
    	TreeNode bestParent = parent;
    	
    	if (root.right != null) { 
    		TreeNode bestRight = inOrderSuccessor(root, root.right);
    		TreeNode bestRightParent = parentForDeletion;
    		
    		if (bestRight.val < best.val) {
    			best = bestRight;
    			bestParent = bestRightParent;
    		}
    	}
    	
    	if (root.left != null) {
    		TreeNode bestLeft = inOrderSuccessor(root, root.left);
    		TreeNode bestLeftParent = parentForDeletion;
    		
    		if (bestLeft.val < best.val) {
    			best = bestLeft;
    			bestParent = bestLeftParent;
    		}
    	}
    	
    	parentForDeletion = bestParent;
    	return best;
    }

    
    
    
	public static void main(String[] args) {
		DeleteNodeInABST_450_2 prog = new DeleteNodeInABST_450_2();
		
		testCase70: {
			TreeNode t7 = new TreeNode(7);
			TreeNode t4 = new TreeNode(4);
			TreeNode t2 = new TreeNode(2);
			TreeNode t6 = new TreeNode(6, null, t7);
			TreeNode t3 = new TreeNode(3, t2, t4);
			TreeNode t5 = new TreeNode(5, t3, t6);
			
			TreeNode sol = prog.deleteNode(t5, 5);
			int expected = 6;
			System.out.println(sol.val + " == " + expected + ", " + (sol.val == expected));
		}
	}
    
}
