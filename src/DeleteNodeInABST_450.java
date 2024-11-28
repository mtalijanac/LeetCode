public class DeleteNodeInABST_450 {
	
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
	
    public TreeNode deleteNode(TreeNode root, int key) {
    	if (root == null) return root;
    	if (root.val == key && (root.left == null && root.right == null)) return null;
    	if (root.val == key) {
    		if (root.left == null) return root.right;
    		if (root.right == null) return root.left;
    		
    		TreeNode leafToAdd = findNullLeaf(root.left);
    		if (leafToAdd.right == null) leafToAdd.right = root.right;
            else leafToAdd.left = root.right;
    		return root.left;
    	}
    	
    	
        TreeNode parent = findParentNode(root, key);
        if (parent == null) return root;
        
        TreeNode forDeletion = parent.left;
        if (forDeletion == null || parent.left.val != key) {
        	forDeletion = parent.right;
        }
        if (forDeletion == null) return root;
        
        
        TreeNode grandchildLeft = forDeletion.left;
        TreeNode grandchildRight = forDeletion.right;
        
        if (forDeletion.left == null && forDeletion.right == null) {
        	if (parent.left == forDeletion) parent.left = null;
        	else parent.right = null;
        	return root;
        }
        
        if (grandchildLeft != null && grandchildRight == null) {
        	if (parent.left == forDeletion) parent.left = grandchildLeft;
        	else parent.right = grandchildLeft;
        	return root;
        }
        
        if (grandchildLeft == null && grandchildRight != null) {
        	if (parent.left == forDeletion) parent.left = grandchildRight;
        	else parent.right = grandchildRight;
        	return root;
        }
        
        
        TreeNode toAdd = findNullLeaf(grandchildLeft);
        if (toAdd.right == null) toAdd.right = grandchildRight;
        else toAdd.left = grandchildRight;
        
        if (parent.left == forDeletion) parent.left = grandchildLeft;
    	else parent.right = grandchildLeft;
        
        return root;
    }

	TreeNode findParentNode(TreeNode root, int key) {
		if (root.left != null && root.left.val == key)
			return root;
		
		if (root.right != null && root.right.val == key)
			return root;
		
		if (root.left != null) {
			TreeNode res = findParentNode(root.left, key);
			if (res != null) return res;
		}
		
		if (root.right != null) {
			TreeNode res = findParentNode(root.right, key);
			if (res != null) return res;
		}
		
		return null;
	}
	
	TreeNode findNullLeaf(TreeNode root) {
		if (root.right == null) return root;
		if (root.left == null) return root;
		return findNullLeaf(root.right);
	}

	public static void main(String[] args) {
		
		DeleteNodeInABST_450 prog = new DeleteNodeInABST_450();
		
		testCase1: {
			TreeNode t7 = new TreeNode(7);
			TreeNode t4 = new TreeNode(4);
			TreeNode t2 = new TreeNode(2);
			TreeNode t6 = new TreeNode(6, null, t7);
			TreeNode t3 = new TreeNode(3, t2, t4);
			TreeNode t5 = new TreeNode(5, t3, t6);
			
			TreeNode sol = prog.deleteNode(t5, 3);
			System.out.println(sol);
			
		}
	}
    
}
